<%@include file="../xava/imports.jsp"%>

<%@page import="org.openxava.util.Labels"%>
<%@page import="org.openxava.util.Is"%> <%-- tmp --%>
<%@page import="org.openxava.model.meta.MetaProperty"%>
<%@page import="org.openxava.tab.Tab"%>

<jsp:useBean id="context" class="org.openxava.controller.ModuleContext" scope="session"/>

<%
Tab tab = (Tab) context.get(request, "xava_tab");
%>

<div id="phone_dropdown_order" class="phone-dropdown phone-list-order ox-button-bar"> 
	
<% 
String ascending = Labels.get("ascending").toLowerCase();
String descending = Labels.get("descending").toLowerCase();
for (MetaProperty property: tab.getMetaPropertiesNotCalculated()) {
	String label = property.getQualifiedLabel(request);
	if (Is.emptyString(label)) label = Labels.getQualified(property.getQualifiedName());
%> 
	<div onclick="phone.markDropdownOption(this)">		
		<xava:link action='PhoneList.orderByAscending' argv='<%="property="+property.getQualifiedName()%>'>
			<i class="mdi mdi-check" style="display: none;"></i>
			<%=label%> <%=ascending%>
		</xava:link>
	</div> 		 	
	<div onclick="phone.markDropdownOption(this)">	
		<xava:link action="PhoneList.orderByDescending" argv='<%="property="+property.getQualifiedName()%>'>
			<i class="mdi mdi-check" style="display: none;"></i>
			<%=label%> <%=descending%>
		</xava:link>
	</div>
<%
}
%>
		
</div>
