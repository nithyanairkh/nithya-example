package com.nithya.apps.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;


@SlingServlet(resourceTypes = "geometrixx/components/homepage", selectors = {"data","nit"}, extensions = "html", methods = {"GET","POST"}, metatype =true,paths="/bin/service/nithyadileep")


// if you do not have any specific resource type and still you need your servlet to be executed based on resource type, use "sling/servlet/default
public class SlingResourceTypeServlet extends SlingAllMethodsServlet {
	
	 protected void doGet(final SlingHttpServletRequest req, final SlingHttpServletResponse resp) throws ServletException, IOException {
	  resp.setContentType("application/json");
		 
		String path="/content/geometrixx";
		
		List<String> nodePathList=new ArrayList<String>();
		
		Session session=req.getResourceResolver().adaptTo(Session.class);
		
		
		
		try {
			Node parentNode=session.getNode(path);
			
			NodeIterator nodeIt = parentNode.getNodes();
			
			while(nodeIt.hasNext()) {
				Node eachNode=nodeIt.nextNode();

				if(eachNode.hasNode("jcr:content")) {
				Node jcrNode=eachNode.getNode("jcr:content");
				
				if(jcrNode.hasProperty("hideInNav") && jcrNode.getProperty("hideInNav").getString()=="true") {
					nodePathList.add(jcrNode.getProperty("jcr:title").getString());
				}
			}
				
			}
		} catch (PathNotFoundException e) {
			
			e.printStackTrace();
		} catch (RepositoryException e) {
			
			e.printStackTrace();
		}
		 
		 resp.getWriter().write("This is Example for selector and your selector is -->"+nodePathList.toString());
		 
		
	 }


}
