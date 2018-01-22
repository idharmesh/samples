package com.mo.prep.interview.addapar;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Main Class that implements recon functionality
 *   
 * @author 
 *
 */
public class Main {
	
	// Two point precision double number formatter.
	static DecimalFormat doubleFormater = new DecimalFormat("#0.##");
	
	public static void main(String[] args) {

		boolean isPosition = false;
		boolean isTransaction = false;
		Position position = null;
		Map<String, Position> previousDaypositionMap = new HashMap<>();
		Map<String, Position> eodPositionMap = new HashMap<>();
		
		Map<String, Transaction> transactionMap = new HashMap<>();
		
		Transaction transaction = null;
		int counter = 0;
		for(String line : getFileContent()) {
			//Build components
			//Below logic is to parse data setup as given, in real life this would be reading from file 
			// Or reading data from steams.
			if(line.equals("")) {
				isPosition = false;
				isTransaction = false;
				counter ++;
				continue;
			}
			if(line.contains("-POS")) {
				isPosition = true;
				isTransaction = false;
				continue;
			}
			
			if(line.contains("-TRN")) {
				isTransaction = true;
				isPosition = false;
				continue;
			}
			if(isPosition) {
				String[] inputPos = line.split(" ");
				if(inputPos != null && inputPos.length > 1) {
					position = new Position(inputPos[0], Double.parseDouble(inputPos[1]));
					//Assuming consolidated position. i.e. one distinct symbol in file
					if(counter < 2) 
						previousDaypositionMap.put(inputPos[0], position);
					else 
						eodPositionMap.put(inputPos[0], position);
				}
			}
			
			if(isTransaction && counter < 2) {
				String[] inputTx = line.split(" ");
				if(inputTx != null && inputTx.length > 2) {
					transaction = new Transaction(inputTx[0], inputTx[1], 
											Integer.parseInt(inputTx[2]), Double.parseDouble(inputTx[3]));
					//Key = Symbol+transaction type
					transactionMap.put(transaction.getKey(), transaction);
				}
			}
		}
		
		Map<String, Position> reconPosition = recon(previousDaypositionMap,eodPositionMap, transactionMap);
		System.out.println("recon.out\n--------");
		for (Position pos : reconPosition.values()) {
			System.out.println(pos.toString());
		}
		
	}
	
	/**
	 * Recon function
	 * 
	 * For all given EOD Position, check what are the transaction and check previous day position standing
	 * 
	 * @param previousDaypositionMap
	 * @param eodPositionMap
	 * @param transactionMap
	 * @return
	 */
	private static Map<String, Position> recon(Map<String, Position> previousDaypositionMap, Map<String, Position> eodPositionMap,
			Map<String, Transaction> transactionMap) {
		
		Map<String, Position> reconPosition = new HashMap<>();
		Set<String> prevKeys = previousDaypositionMap.keySet();
		Set<String> eodKeys = eodPositionMap.keySet();
		double amount = 0.0;
		if(transactionMap != null) {
			for (Transaction tx : transactionMap.values()) {
				if(plus.contains(tx.getTransactionType())){
					amount = amount - tx.getAmount();
				}
				else if(minus.contains(tx.getTransactionType())) {
					amount = amount + tx.getAmount();
				}
				//Assuming Cash is always there in position file
				if(!eodKeys.contains(tx.getSymbol()) && !prevKeys.contains(tx.getSymbol())) {
					double qty = 0.0;
					if(tx.getTransactionType().equals("BUY")){
						qty = qty - (double) tx.getQuantity();
					}
					reconPosition.put(tx.getSymbol(), new Position(tx.getSymbol(), qty));
				}
			}
		}
			
		for (Position pos : eodPositionMap.values()) {
			String key = pos.getSymbol();
			Double qty = pos.getQuantiry();
			Position prevPos = previousDaypositionMap.get(key);
			if (key.equals("Cash")) {
				amount = pos.getQuantiry() - amount - (prevPos!= null?prevPos.getQuantiry():0);  
				reconPosition.put(key, new Position(key, amount));
			}
			else {
				for (Transaction tx : transactionMap.values()) {
					if(tx.getSymbol().equals(key) && tx.getTransactionType().equals("BUY")) {
						qty = qty - tx.getQuantity();
					}
					if(tx.getSymbol().equals(key) && tx.getTransactionType().equals("SELL")) {
						qty = qty + tx.getQuantity();
					}
				}
				if(prevPos != null) {
					qty = qty - prevPos.getQuantiry();
				}
				if(qty != 0 ) {
					reconPosition.put(key, new Position(key, qty));
				}
			}
		}
		return reconPosition;
	}

	/**
	 * transaction modifiers 
	 */
	private static List<String> plus = new ArrayList<>();
	private static List<String> minus = new ArrayList<>();
	static{
		plus.add("BUY");
		plus.add("DIVIDEND");
		
		minus.add("SELL");
		minus.add("FEE");
		minus.add("DEPOSIT");
	}
	
	//Given - Dummy data source
	private static String[] getFileContent() {
		return new String[] {
	        "D0-POS",
	        "AAPL 100",
	        "GOOG 200",
	        "SP500 175.75",
	        "Cash 1000",
	        "",
	        "D1-TRN",
	        "AAPL SELL 100 30000",
	        "GOOG BUY 10 10000",
	        "Cash DEPOSIT 0 1000",
	        "Cash FEE 0 50",
	        "GOOG DIVIDEND 0 50",
	        "TD BUY 100 10000",
	        "",
	        "D1-POS",
	        "GOOG 220",
	        "SP500 175.75",
	        "Cash 20000",
	        "MSFT 10" 
	    };
	}
	
	/**
	 * Class represents the positions 
	 * @author 
	 *
	 */
	private static class Position{
		
		String symbol;
		Double quantiry;
		
		public Position(String symbol, Double amount) {
			this.symbol = symbol;
			this.quantiry = amount;
		}
		public String getSymbol() {
			return symbol;
		}
		
		public Double getQuantiry() {
			return quantiry;
		}
		
		public String getFormattedQuantiry() {
			return doubleFormater.format(quantiry);
		}
		
		@Override
		public String toString() {
			return getSymbol() + " " + getFormattedQuantiry();
		}
	}
	
	/**
	 * Class represents the transactions 
	 * @author 
	 *
	 */
	private static class Transaction{
		
		String symbol;
		String transactionType;
		Integer quantity;
		Double amount;
		public Transaction(String symbol, String transactionType, Integer quantity, Double amount) {
			this.symbol = symbol;
			this.transactionType = transactionType;
			this.quantity = quantity;
			this.amount = amount;
		}
		public String getSymbol() {
			return symbol;
		}
		public String getTransactionType() {
			return transactionType;
		}
		public Integer getQuantity() {
			return quantity;
		}
		public Double getAmount() {
			return amount;
		}
		public String getFormattedAmount() {
			return doubleFormater.format(amount);
		}
		
		
		public String getKey() {
			return  getSymbol() + "-" + getTransactionType();
		}
		
		@Override
		public String toString() {
			return  getSymbol() + " " + getTransactionType() + " " + getQuantity() + " " + getFormattedAmount();
		}
	}
}