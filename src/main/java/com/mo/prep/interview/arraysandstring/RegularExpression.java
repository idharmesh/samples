package com.mo.prep.interview.arraysandstring;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
	
	/*
	 * Note: [^<]+ is need.

	Pattern r = Pattern.compile("<(.+?)>([^<]+)</\\1>");
	
	--------------
	<(.+?)> 
	--------------
	
	match one or more char after "<" and before the 1st '>', assign to GROUP_ONE
	
	         // ?> stop before the 1st '<'
	
	--------------
	([^<]+) 
	--------------
	
	match one or more char(but not include '<')
	         assign to GROUP_TWO
	
	         //[^<] ^ means NOT '<'
	
	--------------
	</\\1>  
	--------------
	
	match the same pattern as group 1 within </ ...>
	 */

	public static void main(String[] args) {
		
		//Split Sting on space and spacial chars
		String pattern = "[' '',@!_.?]+";
		Pattern p = Pattern.compile(pattern);
		String [] token = p.split("He is a very very good boy, isn't he?");
		System.out.println(token.length);
		System.out.println(Arrays.toString(token));
		for (String str : token) {
			System.out.println(str);
		}
			
		//User name with - 8 to 3 apha numeric with no number to start and only _
		pattern = "^[A-Za-z][A-Za-z0-9\\_]{8,30}+$";
		p = Pattern.compile(pattern);
		Matcher m = p.matcher("1abac_1444");
		System.out.println(m.matches());
		
		String line = "<h1><h1>Sanjay has no watch</h1></h1><par>So wait  for a while</par>";
		int count=0;
        Pattern r = Pattern.compile("<(.+?)>([^<>]+)</\\1>");
        m = r.matcher(line);
        while(m.find()) {
            if (m.group(2).length() !=0) {
                System.out.println(m.group(2));
            count++;
            }
        }
        if (count == 0) System.out.println("None");
		
	}
	//	Quest Group
	//  
}
