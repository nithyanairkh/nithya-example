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

import com.nithya.apps.service.DomainPathService;


@Component (immediate = true, metatype= true, label = "Environment specific domain path")	
@Service


public class DomainPathServiceImpl implements DomainPathService {

	@Property(unbounded = PropertyUnbounded.DEFAULT, label = "DomainPath", description = "Enter the path of your domain")

	public static  String DOMAIN_PATH = "domainPath";

	Map <String,String> propValuesmp  = new HashMap<String, String>();

	public static final  Logger log = LoggerFactory.getLogger(DomainPathServiceImpl.class);
	

	@Activate
	public void activate(Map<String, Object> properties)
	{
		log.info("****************Activation Page Path***************");
		String strDomainPath=PropertiesUtil.toString(properties.get(DOMAIN_PATH), "");
		log.info("This is your path--->"+strDomainPath);
		propValuesmp.put("domainPath", strDomainPath);

	}


	public String getDomainPath() {
		// TODO Auto-generated method stub
		String dPath =	propValuesmp.get("domainPath");
		log.info("The path from configuration is  "+DOMAIN_PATH);
		return dPath;
	}

}
