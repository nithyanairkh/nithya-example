/**
 * 
 */
package com.nithya.apps.servlet;

import java.io.IOException;
import java.util.Map;

import javax.jcr.Node;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.jackrabbit.commons.JcrUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.SlingServletException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceUtil;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nithya.apps.service.MyNewService;
import com.nithya.apps.service.NithyaStudyService;

/**
 * @author Nithya
 *
 */

@SlingServlet (paths = "/bin/service/mine")



public class MyNewServlet extends SlingAllMethodsServlet{
	
	private static Logger log=LoggerFactory.getLogger(MyNewServlet.class);
	
	@Reference
	MyNewService service;
	
	//@Reference
	//NithyaStudyService nitstudyservice;
	
	public void doGet(SlingHttpServletRequest req, SlingHttpServletResponse resp) throws SlingServletException, IOException {
		
		log.info("*************I am in side the servlet**************************");
		
		//resp.getWriter().write("My new servlet");
		
		String name = req.getParameter("name1");
		String age = req.getParameter("age");
		
		int iAge = Integer.parseInt(age);
		
		
		try {
		//getting resource using resource resolver
		
		String resourcePath = ("/content/xtypestudypage/jcr:content/par/dialogstudycomponent");
		
		Resource resource = req.getResource();
		
		
		
		ResourceResolver resolver = req.getResourceResolver();
		
		Resource res =resolver.resolve(resourcePath);
		 
		ValueMap properties = res.adaptTo(ValueMap.class);
		
		String title = properties.get("enteredname","");
		
		
		}catch (NullPointerException n){
			log.error("Null pointer exception is {}",n);
		}catch (Exception e) {
			
			
			log.error("Exception is {}", e);
		}
		
		resp.getWriter().write(" Your New Name is " +service.getName(name)+ " and Age is " +service.getAge(iAge));
		
		//String newName = nitstudyservice.getName("name1");
		
	//	resp.getWriter().write(" Your New Name is " + newName);
	}
		
		
	
	public void doPost(SlingHttpServletRequest req,SlingHttpServletResponse res) throws SlingServletException, IOException{
		
		doGet(req,res);
	}
	
	
	
	// TODO Auto-generated method stub


	
	@Activate
	  public void activate(Map<String, Object> properties)
	  {
	    log.info("[*** AEM ConfigurationService]: activating configuration service from servlet");
	  }

}
