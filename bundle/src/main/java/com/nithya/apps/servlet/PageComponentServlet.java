package com.nithya.apps.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.SlingServletException;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;

//@SlingServlet(paths = "/bin/services/mine")

@SlingServlet(resourceTypes= "/apps/nithyadialogstudy/page/dialogstudypage", selectors = {"nit","dil"}, extensions = {"html"} , methods = {"GET","POST"},  metatype =true)

public class PageComponentServlet extends SlingAllMethodsServlet {
	
	//put logger please and add logs in the required place.
	public void doGet(SlingHttpServletRequest slingReq, SlingHttpServletResponse slingResp)throws SlingServletException, IOException{
		List<String> nodeList = new ArrayList<String>();
		//slingResp.setContentType("application/json");
		Session session = slingReq.getResourceResolver().adaptTo(Session.class);
		try {
			
			//Here you have to check whether the path exist or not before you make a call getNode else it will throw an exception. it should be like below code.
			
			/*if(session.nodeExists("/content/xtypestudypage/jcr:content")) {
				//here you have to get the node by using getNode method, your below code should go here.
			}*/
			
			List <String> lChildNode = new ArrayList<String>();
			if(session.nodeExists("/content/xtypestudypage/jcr:content")) {
				Node n = session.getNode("/content/xtypestudypage/jcr:content");
				String Line = "<br>";
				/*if(n.hasNodes()) {
					
					NodeIterator nodeIt = n.getNodes();
					while(nodeIt.hasNext()) {
						
						Node childNode = nodeIt.nextNode() ;
						
						if (childNode.hasNodes()) {
							
							NodeIterator nodeIt1 = n.getNodes();
							
							while(nodeIt1.hasNext()) {
								NodeIterator childNodeIt = childNode.getNodes();
								String strChildNode = childNodeIt.nextNode().toString();
								lChildNode.add(strChildNode);
								}
						//	slingResp.getWriter().write("The child node is  "+childNodeIt.getPrimaryNodeType().toString() +Line);
							for(int i=0;   i <=lChildNode.size(); i++) {
								slingResp.getWriter().write("The  other nodes in child node list is  " + lChildNode.get(i) +Line);
							}
						
						
						}
						
					}
					
					
				}*/
				
				
				

				if(n.hasNodes()) { //This is not correct, you are trying to check whether "n" has child nodes or not.. if there, then you have to list out all nodes using getNodes(). So no
					//need to check the condition twice... if(n.hasNodes()) is enough to check and inside the condition getNodes() will get all child nodes

					NodeIterator nIt = n.getNodes();

					while(nIt.hasNext()) {
						String strNode = nIt.nextNode().toString();
						nodeList.add(strNode);
					}
					}

               // String Line = "<br>";
				System.out.println(nodeList);
				for(int i=0;   i < nodeList.size(); i++) {
				slingResp.getWriter().write("The node list is  " +nodeList.get(i) +Line);
				}
			}
		
		   
		} catch (PathNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public void doPost(SlingHttpServletRequest slingReq, SlingHttpServletResponse slingResp)throws SlingServletException, IOException{
		
		doGet(slingReq,slingResp);
	}
	
}
