<%@include file="/libs/foundation/global.jsp"%><%
%><%@page session="false" %>


  dialogstudycomponents component.

  this is my dialog study component
<%@include file="/libs/foundation/global.jsp"%><%
%><%@page session="false" %>


  dialogstudycomponents component.

  this is my dialog study component
<br>
<br>
<br>


<% String name = properties.get("enteredname","default");%>

The name entered is <%=name%>

<br>
<br>
<br>

${properties.enteredname}
<br>
<br>
<br>

${properties.description}
<br>
<br>
${properties.countryname}
<br>
<br>
${properties.image}
<br>
<br>
${properties.fulltimeornot}
