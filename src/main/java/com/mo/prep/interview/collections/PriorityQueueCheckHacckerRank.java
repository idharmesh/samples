package com.mo.prep.interview.collections;

import java.util.PriorityQueue;
import java.util.Scanner;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Student{
   private int token;
   private String fname;
   private double cgpa;
   public Student(int id, String fname, double cgpa) {
      super();
      this.token = id;
      this.fname = fname;
      this.cgpa = cgpa;
   }
   public int getToken() {
      return token;
   }
   public String getFname() {
      return fname;
   }
   public double getCgpa() {
      return cgpa;
   }
}

public class PriorityQueueCheckHacckerRank { 
	
    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int totalEvents = Integer.parseInt(in.nextLine());
      
      PriorityQueue<Student> pQueue = new PriorityQueue<Student>(Comparator.comparing(Student::getCgpa).reversed()
    		  	.thenComparing(Student::getCgpa).thenComparing(Student::getFname));
      Student s = null;
      int servIndex = 0;
      
      while(totalEvents>0){
         String event = in.nextLine();
         if(event.contains("ENTER")){
             String[] arr = event.split(" ");
             s = new Student(Integer.parseInt(arr[3]), arr[1],Double.parseDouble(arr[2]));
             pQueue.add(s);
             
         }   
         else if(event.equals("SERVED")) {
        	 if(pQueue.isEmpty()) {
                 System.out.println("EMPTY");      
             }
        	 else { 
        		 servIndex++;
        	 }
         }
         totalEvents--;
      }
      if(pQueue.isEmpty()) {
          System.out.println("EMPTY");      
      }
      else {
    	  for (int i = 0; i < servIndex; i++) {
			System.out.println(pQueue.poll().getFname());
		}
      }
    }
    
    /*
    The student having the highest Cumulative Grade Point Average (CGPA) is served first.
    Any students having the same CGPA will be served by name in ascending case-sensitive alphabetical order.
    Any students having the same CGPA and name will be served in ascending token order.
    */
    //Add comparator for the Student to be returned in specified order
    static final Comparator<Student> orderBy = new Comparator<Student>() {

		@Override
		public int compare(Student o1, Student o2) {
			if (o1.getCgpa() == o2.getCgpa()) {
				// Condition#3
				if ((o1.getFname().compareTo(o2.getFname()) == 0)) {
					return o1.getToken() - o2.getToken();
				}
				// Condition#2
				return o1.getFname().compareTo(o2.getFname());
			}
			return (new Double(o2.getCgpa()).compareTo(new Double(o1.getCgpa())));
		}
	
	};
}

