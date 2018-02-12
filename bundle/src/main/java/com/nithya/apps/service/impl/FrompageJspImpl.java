package com.nithya.apps.service.impl;


import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nithya.apps.service.FrompageJsp;

@Component(immediate = true)
@Service

public class FrompageJspImpl implements FrompageJsp {

public static final  Logger log = LoggerFactory.getLogger(FrompageJspImpl.class);


	public void getPropValue(SlingHttpServletRequest req, String str) {
		// TODO Auto-generated method stub
		
		Resource resource = req.getResource();
		
		log.debug("The resource is {}" ,resource );
		
	}

	
}
