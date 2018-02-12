package com.nithya.apps.service.impl;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nithya.apps.service.PassingFromJspService;
import com.nithya.apps.vo.PassingFromJspVo;



@Component

@Service

public class PassingFromJspServiceImpl implements PassingFromJspService {
	
	Logger log = LoggerFactory.getLogger(PassingFromJspServiceImpl.class);
	
	public PassingFromJspVo  getPath(Node curNode) {
		
		PassingFromJspVo objVo = new PassingFromJspVo();
		
		if(curNode!=null) {
			
			    objVo.setMyCheck(getBoolProperty("mycheck" , curNode));
				objVo.setStrLinkUrl(getProperty("linkurl",curNode));
				objVo.setStrMyselect(getProperty("myselect",curNode));
				objVo.setStrTitle(getProperty("title",curNode));
				try {
					if(curNode.hasNode("image")) {
						curNode=curNode.getNode("image");
						objVo.setDescription(getProperty("jcr:description",curNode));
					}
				} catch (RepositoryException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
			    }
		return objVo;	
	}
	
	
	String getProperty(String strProperty, Node nCurNode  ) {
		
	try {
		if(nCurNode.hasProperty(strProperty)) {
			String propVal = nCurNode.getProperty(strProperty).getString();
			log.info("the value of property{}  is {}" ,strProperty ,propVal);
		return propVal;	
		}
	} catch (RepositoryException e) {
		log.error("exception occured {}" ,e);
		e.printStackTrace();
	}
		
	return null;
	}
	
	
boolean getBoolProperty(String strProperty, Node nCurNode  ) {
	boolean bValue = false;
		
		try {
			    if((nCurNode.hasProperty(strProperty) && (nCurNode.getProperty(strProperty).getBoolean()) == true)) {
			    	bValue = true;
				} 
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			log.info("the value of bValue returning is{}" ,bValue);
		return bValue;
		}

	
	
	
	

}


