/**
 * 
 */
package com.nithya.apps.servlet;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;

/**
 * @author Nithya
 *
 */
@SlingServlet(paths="/bin/service/test")
public class FirstServletExample extends SlingAllMethodsServlet{
	
//	@Reference
//	MyFirstService service;
	
//	@Reference
//	PageContextExample pagecontextService;
	
	
	protected void doPost(final SlingHttpServletRequest req, final SlingHttpServletResponse resp) throws ServletException, IOException {
		
		/*String name=req.getParameter("name");
		String house=req.getParameter("house");
		resp.getWriter().write("This is example-->"+name+"-->"+house);*/
		
		
		//resp.getWriter().write(pagecontextService.getMessage());
		
	//	resp.getWriter().write(pagecontextService.getDisplayMessage(strDisplay,Roll));
			
		
	}
	
	protected void doGet(final SlingHttpServletRequest req, final SlingHttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
