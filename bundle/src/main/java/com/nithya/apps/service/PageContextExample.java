/**
 * 
 */
package com.nithya.apps.service;

import javax.jcr.Node;

/**
 * @author Nithya
 *
 */
public interface PageContextExample {
	
	public String getMessage();
	
	public String getDisplayMessage(String strDisplay, int Roll);
	
	public String getResourceName(Node n);

}
