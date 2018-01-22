package com.mo.prep.interview.comparators;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Player{
    String name;
    int score;
    
    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player> {
	@Override
	public int compare(Player o1, Player o2) {
		
		if(o1.score == o2.score) {
			return o1.name.compareTo(o2.name);
		}
		else {
			return o2.score - o1.score;
			
		}
	}
}


 

public class Solution {

	public static void main(String[] args) {
      
        Player[] player = new Player[5];
        Checker checker = new Checker();
        
        int j=0;
        player[j++] = new Player("amy", 100);
        player[j++] = new Player("david", 100);
		player[j++] = new Player("heraldo", 50);
		player[j++] = new Player("aakansha",75);
		player[j++] = new Player("aleksa", 150);
        
      

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}