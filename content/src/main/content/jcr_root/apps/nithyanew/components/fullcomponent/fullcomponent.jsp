 <%@include file="/libs/foundation/global.jsp"%>
<%@page session="false" %>
<%@page import = "com.nithya.apps.service.PassingFromJspService"%>
<%@page import = "com.nithya.apps.vo.PassingFromJspVo"%>


<%

PassingFromJspService service = sling.getService(PassingFromJspService.class);
PassingFromJspVo voValues = null;

if(currentNode!=null){

voValues =   service.getPath(currentNode);

 String title = voValues.getStrTitle(); 

  out.println("The obtained title is " +title);

    out.println("The obtained description is " + voValues.getDescription());



} 



    %>

<c:set var="voV" value="<%=voValues %>" />

<br> Your Link  is ${voV.strLinkUrl} <br>
Your check value  is ${voV.myCheck} <br>
Your title  is ${voV.strTitle} <br>
Your selected option is ${voV.strMyselect} <br>
Your description is ${voV.description} <br>


The value of checkbox is ${properties.mycheck}


