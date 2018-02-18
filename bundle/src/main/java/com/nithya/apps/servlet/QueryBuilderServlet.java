package com.nithya.apps.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.jcr.Session;
import javax.jcr.query.Query;
import javax.naming.directory.SearchResult;
import com.day.cq.search.Query;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.SlingServletException;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SlingServlet(paths="/bin/service")


public class QueryBuilderServlet extends SlingAllMethodsServlet {
	@Reference
	private QueryBuilder queryBuilder;
	
	Logger log = LoggerFactory.getLogger(QueryBuilderServlet.class);
	
	public void doGet(SlingHttpServletRequest slingReq, SlingHttpServletResponse slingResp) throws SlingServletException, IOException {
		
		 final Map<String, String> qMap = new HashMap<String, String>();
		 qMap.put("type", "cq:Page");
		 qMap.put("path", "/content/nithya-website");
		 qMap.put("property", "employeeid");
		 qMap.put("property.value", "10");
		 Query query = queryBuilder.createQuery(PredicateGroup.create(qMap), slingReq.getResourceResolver().adaptTo(Session.class));
         SearchResult result = query.getResult();
		 
		
	
	}
}
