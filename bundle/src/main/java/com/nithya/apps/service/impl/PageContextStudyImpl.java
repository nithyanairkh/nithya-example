package com.nithya.apps.service.impl;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

import com.nithya.apps.service.PageContextStudy;



@Component(immediate=true)
@Service
public class PageContextStudyImpl implements PageContextStudy {

	public String getMessage() {
		// TODO Auto-generated method stub
		return "This is my message for PageContextStudy";
	}
	
	
	

}
