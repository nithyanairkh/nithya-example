package com.nithya.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.nithya.apps.service.impl.MyFirstServiceImpl;

public class MyFirstServiceImplTest {
	
	MyFirstServiceImpl ob=new MyFirstServiceImpl();
	
	@Test
	public void getMessageTestNotNull(){
		
		String val = ob.getMessage();
		
		assertNotNull(val);
		
		assertEquals("Welcome to my first service",val );
		
	}

}
