package com.easymorse.demo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MyTest {

	public static void main(String[] args) {
		Set set = new HashSet();
		set.add(1);
		set.add(2);
		set.add(3);
		Iterator<Integer> i = set.iterator();
		while(i.hasNext()){
			System.out.println(">>>"+i.next());
		}
		
	}
}
