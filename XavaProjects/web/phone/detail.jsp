<%@ include file="imports.jsp"%>

<%@ page import="java.util.Iterator" %>
<%@ page import="org.openxava.view.View" %>
<%@ page import="org.openxava.view.meta.MetaGroup" %>
<%@ page import="org.openxava.view.meta.PropertiesSeparator" %>
<%@ page import="org.openxava.model.meta.MetaProperty" %>
<%@ page import="org.openxava.model.meta.MetaReference" %>
<%@ page import="org.openxava.model.meta.MetaCollection" %>
<%@ page import="org.openxava.web.WebEditors" %>
<%@ page import="org.openxava.web.taglib.IdTag"%>
<%@ page import="org.openxava.web.Ids"%>
<%@ page import="org.openxava.model.meta.MetaMember"%>
<%@ page import="org.openxava.util.XavaPreferences"%>
<%@ page import="org.openxava.util.Is"%>
<%@ page import="org.openxava.controller.meta.MetaControllers"%>
<%@ page import="org.openxava.controller.meta.MetaAction"%>

<jsp:useBean id="errors" class="org.openxava.util.Messages" scope="request"/>
<jsp:useBean id="context" class="org.openxava.controller.ModuleContext" scope="session"/>
<jsp:useBean id="style" class="org.openxava.web.style.Style" scope="request"/>

<%
String viewObject = request.getParameter("viewObject");
viewObject = (viewObject == null || viewObject.equals(""))?"xava_view":viewObject;
org.openxava.view.View view = (org.openxava.view.View) context.get(request, viewObject);
view.setViewObject(viewObject); 
String propertyPrefix = request.getParameter("propertyPrefix");
String containerClass = "false".equals(request.getParameter("frame"))?"":"ox-frame"; 
propertyPrefix = (propertyPrefix == null)?"":propertyPrefix; 
view.setPropertyPrefix(propertyPrefix);
boolean divIsOpen = false;
for (Iterator it = view.getMetaMembers().iterator(); it.hasNext();) {	
	MetaMember m = (MetaMember) it.next();
	if (m instanceof MetaProperty && !PropertiesSeparator.INSTANCE.equals(m)) {		
		MetaProperty p = (MetaProperty) m;
		String labelStyle = view.getLabelStyleForProperty(p);
		if (Is.empty(labelStyle)) labelStyle = XavaPreferences.getInstance().getDefaultLabelStyle();
		labelStyle = style.getLabel() + " " + labelStyle;
		String label = view.getLabelFor(p);
		boolean editable = view.isEditable(p);
		boolean throwPropertyChanged = view.throwsPropertyChanged(p);
		if (!divIsOpen) {  
			divIsOpen = true;
%>
<div class="<%=containerClass%>">
<%	
		}
%>
<div class="phone-detail-element">
	<span id="<xava:id name='<%="label_" + view.getPropertyPrefix() + p.getName()%>'/>" class="<%=labelStyle%>">
		<%=label%>
	</span>
	<br/> 
	<% String required = view.isEditable() && p.isRequired() ? "class='" + style.getRequiredEditor() + "'":""; %>
	<span id="<xava:id name='<%="editor_" + view.getPropertyPrefix() + p.getName()%>'/>" <%=required%>>
		<xava:editor property="<%=p.getName()%>" editable="<%=editable%>" throwPropertyChanged="<%=throwPropertyChanged%>"/>
	</span>
</div>	
<%
	}
	else if (m instanceof MetaReference) {
		MetaReference ref = (MetaReference) m;
		if (view.displayReferenceWithNoFrameEditor(ref)) {
			if (!divIsOpen) {
				divIsOpen = true;
%>
<div class="<%=containerClass%>"> 	
<%	
			}
		}		
		else if (divIsOpen) {
			divIsOpen = false;
%>
</div>
<%
		}
		String referenceKey = Ids.decorate(
				request.getParameter("application"),
				request.getParameter("module"),
				propertyPrefix +  ref.getName()); 
		request.setAttribute(referenceKey, ref);
%>
		<jsp:include page="frameAndDescriptionsListReference.jsp">
			<jsp:param name="referenceKey" value="<%=referenceKey%>"/>
		</jsp:include>		
<%
	}
	else if (m instanceof MetaCollection) {
		MetaCollection collection = (MetaCollection) m;
		if (divIsOpen) {
			divIsOpen = false;
%>
</div>
<%
		}
		String collectionPrefix = propertyPrefix == null?collection.getName() + ".":propertyPrefix + collection.getName() + ".";
%>
		<div id="<xava:id name='<%="collection_" + collectionPrefix%>'/>">				
			<jsp:include page="collection.jsp"> 
				<jsp:param name="collectionName" value="<%=collection.getName()%>"/>
				<jsp:param name="viewObject" value="<%=viewObject%>"/>			
			</jsp:include>
		</div>				
<%
	} 
	else if (m instanceof MetaGroup) {
		MetaGroup group = (MetaGroup) m;			
		if (divIsOpen) {
			divIsOpen = false;
%>
</div>
<%
		}
		String viewName = viewObject + "_" + group.getName();
		View subview = view.getGroupView(group.getName());			
		context.put(request, viewName, subview);
%>
		<div class="phone-frame-title"><%=group.getLabel()%></div>
		<jsp:include page="detail.jsp">
				<jsp:param name="viewObject" value="<%=viewName%>" />
		</jsp:include>
<%
	}
}
%>

<% if (!divIsOpen) { %>
<div>
<% } %> 

</div>

<% if (view.hasSections()) { %>
<div id="<xava:id name='<%="sections_" + viewObject%>'/>"> 
	<jsp:include page="sections.jsp"/>
</div>	
<% } %>

