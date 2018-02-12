package com.nithya.apps.service.impl;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

import com.nithya.apps.service.MyFirstService;

@Component(immediate=true)
@Service
public class MyFirstServiceImpl implements MyFirstService {

	public String getMessage() {
		
		return "Welcome to my first service";
	}

}
