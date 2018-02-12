package com.nithya.apps.worflow;

import java.util.HashMap;
import java.util.Map;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.PropertyUnbounded;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import com.day.cq.mailer.MessageGateway;
import com.day.cq.mailer.MessageGatewayService;

@Component(immediate = true, metatype= true, label = "Workflow Mail Configuration")
@Service

@Property(name= "process.label", value ="Test Email WorkFlow")


public class MailWorkFlow implements WorkflowProcess{
	
	//configuring log
	
	private static final Logger log = LoggerFactory.getLogger(MailWorkFlow.class);
	static Map<String,String> mPath=new HashMap<String, String>();
	
	@Reference
	private MessageGatewayService messageGatewayServc;
	
	@Property(unbounded=PropertyUnbounded.DEFAULT, label="Enter the domain path", description="This is to entern the domain path of your environment")
	private static final String DOMAIN_PATH = "domainpath";

	
	public void execute(WorkItem item, WorkflowSession wSession, MetaDataMap arg2) throws WorkflowException {
		log.info("inside execute workflow");

		String path=item.getWorkflowData().getPayload().toString();
		log.info("Payload path is "+path);
		
		//Absolutr path of the pahe
		
		String domainPath = mPath.get("path");
		
		String strAbsolutePath =  (domainPath + path)+".html";
		
		log.info("The real path is " +strAbsolutePath);
		
	Session session = wSession.adaptTo(Session.class);
		
		try {
		//Email email = new SimpleEmail();
			
			//code to add property to the node
			
			if(session.nodeExists(path + "/jcr:content")) {
				
				Node n = session.getNode(path + "/jcr:content");
				n.setProperty("User", "Nithya");
				
				session.save();
			}
		
		HtmlEmail htmlEmail=new HtmlEmail();
		
		String emailTorecipients = "nithyanair111@gmail.com";
		String emailCcRecipients = "dileepsmail@gmail.com";
		String emailFrom = "nithyanair111@gmail.com";
		
		htmlEmail.addTo(emailTorecipients);
		htmlEmail.addCc(emailCcRecipients);
		htmlEmail.setFrom(emailFrom);
		htmlEmail.setSubject("Mail custom workflow");
		htmlEmail.setMsg("<b>you are receiving this email when a page is created</b>");
		
		log.info("Your mail has been sent");
		

		/*	MessageGateway<HtmlEmail> messageGateway = messageGatewayServc.getGateway(HtmlEmail.class);
			messageGateway.send(htmlEmail);*/
			
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (RepositoryException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
		
	}
	
	
	@Activate
	  public void activate(Map<String, Object> properties)
	  {
	   log.info("Activate method of workflow****************************");
	   String strPath = PropertiesUtil.toString((properties.get(DOMAIN_PATH)), "");
	   mPath.put("path", strPath);
	 
	  }
	
	

}
