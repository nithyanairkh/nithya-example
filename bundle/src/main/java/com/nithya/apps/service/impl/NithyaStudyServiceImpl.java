/**
 * 
 */
package com.nithya.apps.service.impl;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

import com.nithya.apps.service.NithyaStudyService;

/**
 * @author Nithya
 *
 */
@Component(immediate=true, metatype=true)
@Service

public class NithyaStudyServiceImpl implements NithyaStudyService {


	public int getRoll(int a) {
		// TODO Auto-generated method stub
		
		int b = a+10;
		return b;
	}

	public String getName(String strName) {
		// TODO Auto-generated method stub
		
		String strNameInitial = (strName + " Nair ") ;
		return (strNameInitial);
	}

}
