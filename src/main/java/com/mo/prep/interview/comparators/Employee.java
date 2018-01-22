/**
 * 
 */
package com.mo.prep.interview.comparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author blossom
 *
 */
public class Employee implements Comparable<Employee> {
	
	int age;
	String fname;
	String lname;
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Employee o) {
		return this.age - o.age;
	}
	
	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}
	

	public Employee(int age, String fname, String lname) {
		super();
		this.age = age;
		this.fname = fname;
		this.lname = lname;
	}

	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}

	
	@Override
	public String toString() {
		return  age + " - " + fname + "- " + lname +"\n" ;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*Employee e2 = new Employee(12, "bnam", "hlastname");
		Employee e1 = new Employee(10, "bnam", "blastname");
		Employee e3 = new Employee(10, "dnam", "alastname");
		Employee e4 = new Employee(9, "cnam", "alastname");*/
		
		Employee e2 = new Employee(12, "bnam", "");
		Employee e1 = new Employee(10, "bnam", "");
		Employee e3 = new Employee(10, "dnam", "");
		Employee e4 = new Employee(9, "cnam", "");
		
		List<Employee> e = new ArrayList<>();
		e.add(e2);
		e.add(e1);
		e.add(e3);
		e.add(e4);
		System.out.println(e.toString());
		Collections.sort(e,byAge);
		System.out.println(e.toString());
		/*System.out.println(e.toString());
		System.out.println("============================");
		Collections.sort(e,compareByAgeAndFname);
		System.out.println(e.toString());
		System.out.println("============================");
		Collections.sort(e);
		System.out.println(e.toString());
		Collections.sort(e, compareByFName);
		System.out.println(e.toString());*/
	}
	public static final Comparator<Employee> byAge = new Comparator<Employee>() {
		@Override
		public int compare(Employee o1, Employee o2) {
			if(o1.age > o2.age)
				return o2.age - o1.age;
			else
				return o1.age - o2.age;
				
			
		}
	};
	
	public static final Comparator<Employee> compareByAgeAndFname = new Comparator<Employee>() {

		@Override
		public int compare(Employee o1, Employee o2) {
			if(o1.age == o2.age) {
				return o1.fname.compareTo(o2.fname);
			}
			else if(o1.age< o2.age){
				return o1.fname.compareTo(o1.fname);
			}
			else
				return 1;
		}
		
	};
	public static final Comparator<Employee> compareByFName = new Comparator<Employee>() {

		@Override
		public int compare(Employee o1, Employee o2) {
			return o1.fname.compareTo(o2.fname);
		}
	};

}
