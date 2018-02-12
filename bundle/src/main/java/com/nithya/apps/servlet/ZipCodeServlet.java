package com.nithya.apps.servlet;

import java.io.IOException;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.SlingServletException;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import com.nithya.apps.service.ZipCodeService;



@SlingServlet(paths = "/bin/service/zip", metatype=true)



public class ZipCodeServlet extends SlingAllMethodsServlet {

	@Reference
   ZipCodeService zipService;
	
	
	public void doGet(SlingHttpServletRequest req, SlingHttpServletResponse resp) throws SlingServletException, IOException{
		
		
	String strName=req.getParameter("name");
	String strZip =	req.getParameter("zip");
		
		//resp.getWriter().write("The name is " +strName+ ". The Zip is " +strZip+ ".");
		zipService.getName(strName);
		zipService.getZip(strZip);
		
		
		resp.getWriter().write("Name is " +zipService.getName(strName)+ ". Zip is " +zipService.getZip(strZip));
	
	}
	
	
	public void doPost(SlingHttpServletRequest req, SlingHttpServletResponse res)throws SlingServletException, IOException{
		
		
		doGet(req, res);
	}
	
}
