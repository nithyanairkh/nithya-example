package com.nithya.aem.repo;

import javax.jcr.Node;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;

import org.apache.jackrabbit.commons.JcrUtils;

public class AccessRepository {

	public static void main(String[] args) {
		
		
		try {
			Repository repository = JcrUtils.getRepository("http://localhost:4502/crx/server");
			
			Session session = repository.login(new SimpleCredentials("admin","admin".toCharArray()));
			
			Node n = session.getRootNode();
			
			String strNode = n.toString();
			
			System.out.println("This is the node  "+strNode);
			//String path = n.getPath();
			
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub

	}

}
