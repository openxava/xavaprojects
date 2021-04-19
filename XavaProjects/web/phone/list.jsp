<%@include file="../xava/imports.jsp"%>

<%@ page import="org.openxava.tab.Tab"%> 

<jsp:useBean id="context" class="org.openxava.controller.ModuleContext" scope="session"/> 

<%
String collection = request.getParameter("collection");
boolean isNotCollection = org.openxava.util.Is.emptyString(collection);

if (isNotCollection) {
	String tabObject = request.getParameter("tabObject"); 
	tabObject = (tabObject == null || tabObject.equals(""))?"xava_tab":tabObject;
	Tab tab = (Tab) context.get(request, tabObject);
	tab.setRequest(request);
%>
<div id="searching_list">
<div id="filter_list">
	<input id="filter_list_text" type="text" size="38" placeholder='<xava:message key="filter_list"/>'/>
</div>
<% if (tab.getConfigurationsCount() > 1) { %>
<div id="phone_list_configurations">
	<jsp:include page="../xava/listConfigurations.jsp"/>
</div>
<% } %>
<%} %>
<div id="phone_list_core">
	<jsp:include page="listCore.jsp"/>
</div>
<% if (isNotCollection) { %>
</div>
<% } else { %>
<jsp:include page="collectionTotals.jsp"/>
<% } %>
