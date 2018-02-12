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

import com.nithya.apps.service.MyNewService;



@Component(immediate=true, metatype=true, label="Example Configuration Service")
@Service
public class MyNewServiceImpl implements MyNewService{
	
	 @Property(unbounded=PropertyUnbounded.DEFAULT, label="Enter your Name", description="This is to enter your name")
	private static final String SIMPLE_FIELD = "simplefield";
	
	private static Logger log=LoggerFactory.getLogger(MyNewServiceImpl.class);
	
	static Map<String,String> propValuesmp=new HashMap<String, String>();
	
	public String getName(String strName) {
		// TODO Auto-generated method stub
		
		log.info(propValuesmp.toString());
		return propValuesmp.get("firstname")+"  Nair";
	}

	public int getAge(int iAge) {
		// TODO Auto-generated method stub
		return iAge+10;
	}
	
	@Activate
	  public void activate(Map<String, Object> properties)
	  {
	    log.info("[*** AEM ConfigurationService]: activating configuration service from my service");
	    String yourName=PropertiesUtil.toString(properties.get(SIMPLE_FIELD), "");
	    log.info("This is your name--->"+yourName);
	    propValuesmp.put("firstname", yourName);
	    
	    
	    
	  }
	
	

}
