<%@include file="../xava/imports.jsp"%>

<%@page import="org.openxava.util.Labels"%>
<%@page import="org.openxava.model.meta.MetaProperty"%>
<%@page import="org.openxava.tab.Tab"%>

<jsp:useBean id="context" class="org.openxava.controller.ModuleContext" scope="session"/>

<%
Tab tab = (Tab) context.get(request, "xava_tab");
%>

<div id="phone_dropdown_button" onclick="phone.showDropdown()">
	<i class="mdi mdi-sort"></i>
</div>

<div id="phone_dropdown" class="ox-button-bar">
	
<% 
String ascending = Labels.get("ascending").toLowerCase();
String descending = Labels.get("descending").toLowerCase();
for (MetaProperty property: tab.getMetaPropertiesNotCalculated()) {
%>
	<div onclick="phone.markDropdownOption(this)">		
		<xava:link action='PhoneList.orderByAscending' argv='<%="property="+property.getQualifiedName()%>'>
			<i class="mdi mdi-check" style="display: none;"></i>
			<%=property.getQualifiedLabel(request)%> <%=ascending%>
		</xava:link>
	</div> 		 	
	<div onclick="phone.markDropdownOption(this)">	
		<xava:link action="PhoneList.orderByDescending" argv='<%="property="+property.getQualifiedName()%>'>
			<i class="mdi mdi-check" style="display: none;"></i>
			<%=property.getQualifiedLabel(request)%> <%=descending%>
		</xava:link>
	</div>
<%
}
%>
		
</div>
