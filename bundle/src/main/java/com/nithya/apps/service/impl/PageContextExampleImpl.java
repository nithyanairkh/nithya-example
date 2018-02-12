package com.nithya.apps.service.impl;

import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.ValueFormatException;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

import com.nithya.apps.service.PageContextExample;

@Component(immediate=true)
@Service()
public class PageContextExampleImpl implements PageContextExample {

	public String getMessage() {
		// TODO Auto-generated method stub
		return "Welcome to Page context";
	}
	
	public String getDisplayMessage(String strDisplay, int iRoll) {
		
		return ("Welcome " +strDisplay+ "your Roll is " +iRoll);
	}

	public String getResourceName(Node n) {
		// TODO Auto-generated method stub
		String path = "";
		try {
			 path = n.getProperty("sling:resourceType").getString();
			 n.setProperty("dileep", "nithya");
			Node p= n.addNode("myfirstnode");
			p.setProperty("age", "6");
			 n.getSession().save();
		} catch (ValueFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PathNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}

}
