package com.mo.prep.interview.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 Note:
 keyword orders matters
 
 Synchronization:
 1. Static methods can be synchronized. Methods always sync on class intrinsic object
 2. to synchronizing static block, you would need static object to lock on or can be lock on ClassName.class object
 
 3. Non static method can be sync on class object.
 4. Non static block can be sync using this object. or can be sync using class variable (some object)
 
 5. Synchronizing block gives you fine grain control using various locking object
 
 6. Can thread be static? Yes it can be.
 
 Synchronization is built around internal entity known as intrinsic lock or monitor lock.
 Lock enforces exclusive access to an object's state and establishing happens before relationship.
 Every object has an intrinsic lock, a thread that needs exclusive and consistent access to an object fields has to acquire the objects
 intrinsic lock before accessing them.
 
 
 When thread invokes a synchronized method, it acquires the intrinsic lock for that methods object. (release at end and even when there is an exception)
 
 In case of static synchronization method, thread acquires the intrinsic lock for the Class object associated with the class.(not the instance object) 
 
 For Synchronized block, synchronized statements must specify the object that provides the intrinsic lock.
 
 Final - Since final fields can't be change once initiated, it does not require synchronized access.
 
 Constructors can not be synchronized, it is actually a syntax error if you try so.
 Avoid doing any assignment in constructor as multple thread can read inconsistent value 
 
 */
public class StaticSyncronizedMethod {

	// static synchronization..
	
	static Object lock = new Object();
	public static synchronized void someStaticSyncMethod(int index) {
		System.out.println("Synchronized method printing this message! - " + index);
	}
	
	public static void anotherStaticSyncMethod(int index) {
		Object lock2 = new Object();
		synchronized (lock2) {
			System.out.println("Synchronized method printing this message! - " + index);	
		}
	}
	
	public static void anotherWayStaticSyncMethod(int index) {
		Object lock = new Object();
		synchronized (StaticSyncronizedMethod.class) {
			System.out.println("anotherWayStaticSyncMethod method printing this message! - " + index);
			
			
			//Static method can not call wait as it is non static method
			//while(true) {
				// wait();
			//}
		}
		synchronized (lock) {
			
		}

	}
	
	//Non static synchronization
	public synchronized void nonStaticSynMethod(int index) {
		System.out.println("Synchronized method printing this message! - " + index);
	}
	
	
	public  void nonStaticAnotherSynMethod(int index) {
		synchronized(this) {
			System.out.println("Synchronized method printing this message! - " + index);
		}
	}
	
	
	public static void main(String[] args) {
		t1.start();
		t2.start();
	}
	
	static Thread t1 = new Thread() {
		public void run() {
			someStaticSyncMethod(1);
			
		}
	};

	static Thread t2 = new Thread() {
		public void run() {
			someStaticSyncMethod(2);
			anotherStaticSyncMethod(3);
			anotherWayStaticSyncMethod(4);
			
		}
	};

	
}
