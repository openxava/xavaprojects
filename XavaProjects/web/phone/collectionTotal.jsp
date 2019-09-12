<%@ include file="imports.jsp"%> 

<%@page import="org.openxava.view.View"%>
<%@page import="org.openxava.model.meta.MetaProperty"%>
<%@page import="org.openxava.web.WebEditors"%>

<jsp:useBean id="errors" class="org.openxava.util.Messages" scope="request"/>
<jsp:useBean id="context" class="org.openxava.controller.ModuleContext" scope="session"/>

<%
String viewObject = request.getParameter("viewObject");
View view = (View) context.get(request, viewObject);
String collectionName = request.getParameter("collectionName");
View subview = view.getSubview(collectionName);
int row = Integer.parseInt(request.getParameter("row"));
int column = Integer.parseInt(request.getParameter("column"));
String totalProperty = subview.getCollectionTotalPropertyName(row, column);
if (subview.isCollectionTotalEditable(row, column)) { 
%>
	<xava:editor property="<%=totalProperty%>"/>  				
<% 
} 
else { 
	MetaProperty p = (MetaProperty) subview.getMetaPropertiesList().get(column);
	Object total = subview.getCollectionTotal(row, column);
	String ftotal = WebEditors.format(request, p, total, errors, view.getViewName(), true);
%>
	<input id="<xava:id name='<%=totalProperty%>'/>" class="editor xava_numeric" 
		name="<xava:id name='<%=totalProperty%>'/>"
		type="text" title="" style="text-align:right" 
		maxlength="21" size="21" value="<%=ftotal%>" readonly="readonly"/>
<%
}
%>


			
