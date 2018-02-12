package com.nithya.apps.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.PropertyUnbounded;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nithya.apps.service.ZipCodeService;


@Component(immediate =true, metatype=true, label = "Zip Code Service",  configurationFactory = true)
@Service

public class ZipCodeServiceImpl implements ZipCodeService {
	
	@Property(unbounded= PropertyUnbounded.DEFAULT, label="Enter your name", description ="Enter your Name in the given field")
	public static final String NAME_FIELD = "namefield" ;
	
	@Property(unbounded= PropertyUnbounded.DEFAULT, label="Enter your Zip", description ="Enter your Zip code in the given field")
	public static final String ZIP_FIELD = "zipfield" ;
	
	public static Logger log = LoggerFactory.getLogger(ZipCodeServiceImpl.class);
	
	Map <String,String> mpZipName = new HashMap<String, String>();
	public String getName(String name) {
		// TODO Auto-generated method stub
		return mpZipName.get("myname");
	}

	public String getZip(String zip) {
		// TODO Auto-generated method stub
		return mpZipName.get("myzip");
	}
	

	@Activate
	public void activate(Map <String,Object>properties) {
		
		log.info("********Activating configuration from the ZipCodeServiceImpl*******");
		String strName = PropertiesUtil.toString(properties.get(NAME_FIELD), "");
		
		String strZip = PropertiesUtil.toString(properties.get(ZIP_FIELD), "");
		
		log.info("The configured name is "+strName);
		log.info("The configured Zip is "+strZip);
		mpZipName.put("myname", strName);
		mpZipName.put("myzip", strZip);
		
	}

}
