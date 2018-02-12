/**
 * 
 */
package com.nithya.apps.worflow;

import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

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
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;

import com.nithya.apps.service.DomainPathService;

/**
 * @author Nithya
 *
 */
@Component(immediate=true)

@Service
  
@Properties({
    @Property(name = Constants.SERVICE_DESCRIPTION, value = "To find the path of activated page."),
    @Property(name = Constants.SERVICE_VENDOR, value = "Nithya"),
    @Property(name = "process.label", value = "Activated page path") })


public class MyCustomWorkflow implements WorkflowProcess {

	@Reference
	DomainPathService dpService;
	
	public static Logger log=LoggerFactory.getLogger(MyCustomWorkflow.class);
	public void execute(WorkItem item, WorkflowSession wfsession,MetaDataMap args) throws WorkflowException {
		
		
		String pagePath=item.getWorkflowData().getPayload().toString();
		
		String strDomainPath = dpService.getDomainPath();
		
		log.info("your payloaf path-->"+strDomainPath+pagePath+".html");
		
		Session session = wfsession.adaptTo(Session.class);
		try {
			if(session.nodeExists(pagePath+"/jcr:content")) {
			Node n=session.getNode(pagePath+"/jcr:content");
			n.setProperty("status", "published");
			session.save();
			}
			
			
			
		} catch (PathNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RepositoryException e) {
			log.error("Exception occured while reading the repo-->",e);
		}
		
		
		
	}

}
