package com.nithya.apps.servlet;

import java.io.IOException;

import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 */

/**
 * @author Nithya
 *
 */


@SlingServlet(paths="/bin/service/add")
public class SecondServletExample extends SlingAllMethodsServlet{
	
	Logger log = LoggerFactory.getLogger(SecondServletExample.class);
	
	protected void doPost(final SlingHttpServletRequest req, final SlingHttpServletResponse resp) throws ServletException, IOException{
		
		Session session=req.getResourceResolver().adaptTo(Session.class);
		
		String path="/content/nithya";
		
		try {
			Node n=session.getNode(path);
		} catch (PathNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	String  num1 = req.getParameter("num1");
	String  num2 = req.getParameter("num2");
	
	int a = Integer.parseInt(num1);
	int b = Integer.parseInt(num2);
	int c = a + b;
	
	resp.getWriter().write("The Sum of  " +num1+ " and " +num2+ " is " +c);

	log.info("The sum of {} and {} is {}",num1, num2);
	
		
		
}
	
	protected void doGet(final SlingHttpServletRequest req, final SlingHttpServletResponse resp) throws ServletException, IOException{
		doPost(req,resp);
		
		
	}

	
}
