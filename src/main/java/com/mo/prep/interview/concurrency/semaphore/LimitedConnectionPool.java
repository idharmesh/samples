package com.mo.prep.interview.concurrency.semaphore;

import java.util.concurrent.Semaphore;

public class LimitedConnectionPool {
	
	private Semaphore semaphor;
	
	public LimitedConnectionPool(int permits) {
		this.semaphor = new Semaphore(permits);
	}
	
	public Connection aquireConnection() throws InterruptedException {
		semaphor.acquire();
		//some type of connection
		return new Connection(); 
	}
	
	public void relase(Connection connection) {
		try {
			connection.release();
		}
		finally{
			semaphor.release();
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException {

		LimitedConnectionPool conn = new LimitedConnectionPool(2);
		Connection con1 = conn.aquireConnection();
		Connection con2 = conn.aquireConnection();
		conn.relase(con2);
		Connection con3 =  conn.aquireConnection();
		
	}

}
class Connection {
	public Connection() {
		System.out.println("Aquiring connection..");
	}

	public void release() {
		System.out.println("release connection..");
		
	}
}