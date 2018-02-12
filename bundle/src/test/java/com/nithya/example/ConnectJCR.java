package com.nithya.example;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.Repository;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;

import org.apache.jackrabbit.commons.JcrUtils;
import org.apache.jackrabbit.core.TransientRepository;

import org.slf4j.impl.StaticLoggerBinder;


public class ConnectJCR {

	public static void main(String[] args) throws Exception {


		try {
			Repository repository = new TransientRepository();
			 repository = JcrUtils.getRepository("http://localhost:4502/crx/server");

			// Create a Session
			Session session = repository.login(new SimpleCredentials("admin", "admin".toCharArray()));
			//If you get javax.jcr.lock.LockException please use the line below
			//instead of the above one
			//Session session = repository.login( new SimpleCredentials("admin", "admin".toCharArray()),"crx.default");

			// Create a node that represents the root node
			Node root = session.getRootNode();
			Node content = root.getNode("content");
			Node subContent = content.getNode("dam");


			//Getting the iterator over the nodes
			NodeIterator childNodeIterator = subContent.getNodes();



			//Iterating over the nodes and printing their names
			while(childNodeIterator.hasNext()){
				Node childNode=(Node) childNodeIterator.next();
				System.out.println(childNode.getName());

			}
		}
		catch(Exception E){
			
		System.out.println("the exception is " +E);	

		}
}
}


