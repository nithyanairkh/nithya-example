package com.nit.standalone;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FirstExample {

	public static void main(String[] args) {
		
		Map<String,String> exMap=new HashMap<String, String>();
		//this is a map
		exMap.put("name", "Dileep");
		exMap.put("name", "Dhanvi");
		exMap.put("name", "Nithya");
		exMap.put("name", "sss");
		
		//Set it=exMap.keySet();
		Collection it=exMap.values();
		
		Iterator mp=it.iterator();
		//String name = "name";
		while (mp.hasNext()){
		System.out.println("hello");	
		String name = (mp.next()).toString();
		System.out.println(name);
		}
	

	}

}
