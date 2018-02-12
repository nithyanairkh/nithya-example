package com.nithya.apps.servlet;

import java.io.IOException;

import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.SlingServletException;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SlingServlet(paths= "/bin/services/query")

public class QueryExampleServlet extends SlingAllMethodsServlet {
	
	Logger log = LoggerFactory.getLogger(QueryExampleServlet.class);
	
	public void doGet(SlingHttpServletRequest slingReq, SlingHttpServletResponse slingResp) throws SlingServletException, IOException{
		
	Session session=slingReq.getResourceResolver().adaptTo(Session.class);
	String nodePath="";
	String line = "\n";
	 try {
		javax.jcr.query.QueryManager queryManager = session.getWorkspace().getQueryManager(); 	 
		
		String sqlStatement="SELECT * FROM [nt:base] AS s WHERE ISDESCENDANTNODE([/content]) and CONTAINS(s.*, 'nithya')";
		javax.jcr.query.Query query = queryManager.createQuery(sqlStatement,"JCR-SQL2");
		javax.jcr.query.QueryResult result = query.execute();
		javax.jcr.NodeIterator nodeIter = result.getNodes();
		
		while ( nodeIter.hasNext() ) {
			javax.jcr.Node node = nodeIter.nextNode();
			
			if(!(node.getPath().contains("rep:policy"))) {
			nodePath+=node.getPath() +line;
			}
			
		}
	} catch (RepositoryException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 slingResp.getWriter().write(nodePath);
	
	}
	
	public void doPost(SlingHttpServletRequest slingReq, SlingHttpServletResponse slingResp) throws SlingServletException, IOException{
		
		
		doGet(slingReq, slingResp);
	}
	

}
