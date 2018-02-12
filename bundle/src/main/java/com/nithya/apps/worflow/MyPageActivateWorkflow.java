package com.nithya.apps.worflow;

import javax.jcr.Node;
import javax.jcr.Session;

import org.apache.derby.impl.store.replication.net.ReplicationMessageReceive;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.osgi.framework.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;

@Component(immediate=true)
@Service

@Properties({
	    @Property(name =Constants.SERVICE_DESCRIPTION, value = "Activate payload path."),
	    @Property(name = Constants.SERVICE_VENDOR, value = "Adobe"),
	    @Property(name = "process.label", value = "Activate page workflow")
		
		})
	

public class MyPageActivateWorkflow implements WorkflowProcess{
	
	
	Logger log = LoggerFactory.getLogger(MyPageActivateWorkflow.class);
	
	public void execute(WorkItem wItem, WorkflowSession wSession, MetaDataMap mDMap) throws WorkflowException {
	
		try {
		
	WorkflowData wfData = 	wItem.getWorkflowData();
	String payLoadPath = wfData.getPayload().toString();
	
	Session session = wSession.adaptTo(Session.class);
	if (session.nodeExists(payLoadPath+"/jcr:content")) {
		Node n = session.getNode(payLoadPath+"/jcr:content");
		n.setProperty("status", "pageactivated");
		session.save();
		
	}
	
	log.debug("The {} page has been acivated",payLoadPath);
		}catch(Exception e) {
			
			log.debug("The exception is {}" +e);
		}
		
		
	}
	
	
	

}
