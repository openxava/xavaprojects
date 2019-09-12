<%@ include file="imports.jsp"%>

<%@page import="org.openxava.model.meta.MetaReference"%>
<%@page import="org.openxava.web.Ids"%>

<jsp:useBean id="context" class="org.openxava.controller.ModuleContext" scope="session"/>

<div class="phone-reference-actions">

<%
String viewObject = request.getParameter("viewObject");
viewObject = (viewObject == null || viewObject.equals(""))?"xava_view":viewObject;
org.openxava.view.View view = (org.openxava.view.View) context.get(request, viewObject);
String referenceKey = request.getParameter("referenceKey");
MetaReference ref = (MetaReference) request.getAttribute(referenceKey); 
boolean editable = view.isEditable(ref); 
String keyPropertyForAction = Ids.undecorate(referenceKey); 

if (editable && view.isCreateNewForReference(ref)) {
%>

<xava:action action='Reference.createNew' argv='<%="model="+ref.getReferencedModelName() + ",keyProperty=" + keyPropertyForAction%>'/>
<%
}
%>
<%
if (editable && view.isModifyForReference(ref)) { 
%>
<xava:action action='Reference.modify' argv='<%="model="+ref.getReferencedModelName() + ",keyProperty=" + keyPropertyForAction%>'/>
<%
}
%>


<%
java.util.Iterator itActions = view.getActionsNamesForReference(ref, editable).iterator();
while (itActions.hasNext()) {
	String action = (String) itActions.next();
%>
<xava:action action="<%=action%>"/>
<%
}
%>

</div>