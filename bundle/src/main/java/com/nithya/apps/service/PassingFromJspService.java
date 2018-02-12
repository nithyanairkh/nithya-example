package com.nithya.apps.service;

import javax.jcr.Node;

import com.nithya.apps.vo.PassingFromJspVo;

public interface PassingFromJspService {
	
	public PassingFromJspVo getPath(Node curNode);

}
