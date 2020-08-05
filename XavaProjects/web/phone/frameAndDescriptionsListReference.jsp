<%@ include file="imports.jsp"%>

<%@ page import="org.openxava.model.meta.MetaReference" %>
<%@ page import="org.openxava.web.Ids" %>
<%@ page import="org.openxava.util.XavaPreferences "%>
<%@ page import="org.openxava.util.Is" %>
<%@ page import="org.openxava.view.View" %>
<%@ page import="org.openxava.controller.meta.MetaAction" %>
<%@ page import="org.openxava.controller.meta.MetaControllers" %>

<jsp:useBean id="context" class="org.openxava.controller.ModuleContext" scope="session"/>
<jsp:useBean id="style" class="org.openxava.web.style.Style" scope="request"/>

<%
String viewObject = request.getParameter("viewObject");
viewObject = (viewObject == null || viewObject.equals(""))?"xava_view":viewObject;
View view = (org.openxava.view.View) context.get(request, viewObject);
String referenceKey = request.getParameter("referenceKey");
MetaReference ref = (MetaReference) request.getAttribute(referenceKey); 
String labelKey = Ids.decorate(
		request.getParameter("application"),
		request.getParameter("module"),
		"label_" + view.getPropertyPrefix() + ref.getName()); 
String label = view.getLabelFor(ref);		
if (view.displayReferenceWithNoFrameEditor(ref)) {
	String labelStyle = view.getLabelStyleForReference(ref);
	if (Is.empty(labelStyle)) labelStyle = XavaPreferences.getInstance().getDefaultLabelStyle();
	labelStyle = style.getLabel() + " " + labelStyle;
	String urlReferenceEditor = "reference.jsp"
		+ "?referenceKey=" + referenceKey		
		+ "&frame=true&composite=false&onlyEditor=true"; 				
%>
<div class="phone-detail-element">
	<span id="<xava:id name='<%="label_" + view.getPropertyPrefix() + ref.getName()%>'/>" class="<%=labelStyle%>">
		<%=label%>
	</span>
	<span>
		<jsp:include page="referenceActions.jsp">
			<jsp:param name="referenceKey" value="<%=referenceKey%>"/>
		</jsp:include>
	</span>
	<br/> 
	<jsp:include page="<%=urlReferenceEditor%>"/>
</div>	
<%		
}
else { 
	String viewName = viewObject + "_" + ref.getName();
	View subview = view.getSubview(ref.getName());
	if (subview.isRepresentsEntityReference()) subview.setKeyEditable(false);
	context.put(request, viewName, subview);
	String propertyInReferencePrefix = view.getPropertyPrefix() + ref.getName() + ".";	 
	boolean editable = view.isEditable(ref); 
%>
<div class="phone-frame-title"><%=label%></div>
<div class="ox-frame">
<div id="<%=labelKey%>" class="phone-frame-header"> 
<% 
	if (subview.isRepresentsEntityReference() && editable) { 
		if (subview.isSearch()) {
			MetaAction searchAction = MetaControllers.getMetaAction(subview.getSearchAction());
%>	
	<xava:link action='<%=subview.getSearchAction()%>' argv='<%="keyProperty="+propertyInReferencePrefix%>'>
		<div class="phone-frame-action">				
			<%=searchAction.getLabel()%>
		</div>
	</xava:link>
<% 
		}
		if (subview.isCreateNew()) {
			MetaAction createNewAction = MetaControllers.getMetaAction("Reference.createNew");
%> 
	<xava:link action="Reference.createNew" argv='<%="model="+ref.getReferencedModelName() + ",keyProperty="+propertyInReferencePrefix%>'>
		<div class="phone-frame-action">
			<%=createNewAction.getLabel()%>
		</div>
	</xava:link>
<% 
		}				
		if (subview.isModify()) {
			MetaAction modifyAction = MetaControllers.getMetaAction("Reference.modify");
%> 
	<xava:link action="Reference.modify" argv='<%="model="+ref.getReferencedModelName() + ",keyProperty="+propertyInReferencePrefix%>'>
		<div class="phone-frame-action">
			<%=modifyAction.getLabel()%>
		</div>
	</xava:link>
<% 
		}				
	} 
%>
</div>

<jsp:include page="detail.jsp"> 
	<jsp:param name="viewObject" value='<%=viewName%>' />
	<jsp:param name="propertyPrefix" value='<%=propertyInReferencePrefix%>' />
	<jsp:param name="frame" value="false"/> 
</jsp:include>

</div> 
<% 		
}
%>