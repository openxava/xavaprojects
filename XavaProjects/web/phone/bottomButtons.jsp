<%@ include file="imports.jsp"%>

<%@ page import="org.openxava.controller.meta.MetaAction" %>
<%@ page import="org.openxava.controller.meta.MetaSubcontroller"%>
<%@ page import="org.openxava.util.Is"%>
<%@ page import="com.openxava.phone.controller.PhoneManager" %>
<%@ page import="java.util.Iterator"%>

<jsp:useBean id="context" class="org.openxava.controller.ModuleContext" scope="session"/>

<%
org.openxava.controller.ModuleManager manager = (org.openxava.controller.ModuleManager) context.get(request, "manager", "org.openxava.controller.ModuleManager");
manager.setSession(session);
String mode = request.getParameter("xava_mode"); 
if (mode == null) mode = manager.isSplitMode()?"detail":manager.getModeName();
PhoneManager phoneManager = new PhoneManager(manager);
MetaAction defaultAction = phoneManager.getDefaultMetaAction(); 
java.util.Stack previousViews = (java.util.Stack) context.get(request, "xava_previousViews");
%>

<% if (defaultAction != null) { %> 
<button name="xava.DEFAULT_ACTION" type="submit" 
	onclick="openxava.executeAction('<%=request.getParameter("application")%>', '<%=request.getParameter("module")%>', '', false, '<%=defaultAction.getQualifiedName()%>')"
	style="padding: 0; border: none; background-color:transparent; size: 0"></button>
<xava:button action="<%=defaultAction.getQualifiedName()%>"/>
<% } %>	
 
<%
if (!phoneManager.showsActionsOnDropDownMenu()) { 
	Iterator<MetaAction> it = manager.getMetaActions().iterator();
	while (it.hasNext()) {
		MetaAction action = it.next();
		if (action.equals(defaultAction)) continue;
		if (phoneManager.showsAction(action, mode, request)) {
		%>
		<xava:button action="<%=action.getQualifiedName()%>"/>
		<%
		}
	}
} 
else {
	Iterator<MetaAction> it = manager.getMetaActions().iterator();
	while (it.hasNext()) {
		MetaAction action = it.next();
		if (action.equals(defaultAction)) continue;
		if (action.hasIcon() || action.hasIcon()) continue;
		if (phoneManager.showsAction(action, mode, request)) {
			%>
			<xava:button action="<%=action.getQualifiedName()%>"/>
			<%
			break; 
		} 
	}
}

if (previousViews.isEmpty()) {
	for (Object obj : manager.getSubcontrollers()) {
		MetaSubcontroller subcontroller = (MetaSubcontroller) obj;
		if (subcontroller.hasActionsInThisMode(mode)) {		
%>		<jsp:include page="../xava/subButton.jsp">
			<jsp:param name="controller" value="<%=subcontroller.getControllerName()%>"/>
			<jsp:param name="image" value="<%=subcontroller.getImage()%>"/>
			<jsp:param name="icon" value="<%=subcontroller.getIcon()%>"/>
		</jsp:include>		
<%		}
	}
}	
%>

<div>
	<% if (phoneManager.showsActionsOnDropDownMenu()) { %>
		<jsp:include page="actionsMenu.jsp"/>
	<% } %>	
	
	<% if (manager.isListMode()) { %>
		<jsp:include page="listOrder.jsp"/>
	<% } %>
</div>
