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
Iterator<MetaAction> it = manager.getMetaActions().iterator();
while (it.hasNext()) {
	MetaAction action = it.next();
	if (action.isHidden()) continue;
	if (action.equals(defaultAction)) continue;
	if (Is.emptyString(action.getLabel())) continue;
	// The next question about "Print", "ExtendedPrint" and "Charts" is ad hoc, in the future we could move it
	// to a properties files or even manage via NaviOX security
	if (action.getQualifiedName().equals("ImportData.importData") || action.getQualifiedName().equals("Print.generateExcel") || action.getMetaController().getName().equals("ExtendedPrint") || action.getMetaController().getName().equals("Charts")) continue;
	if (!previousViews.isEmpty() && 
		("cancel".equals(action.getName()) || "return".equals(action.getName()) || 
		"cancelar".equals(action.getName()) || "volver".equals(action.getName()) || 
		"hideDetail".equals(action.getName())))  
	{
		continue;
	}
	if (action.appliesToMode(mode)) {
		String confirmClass = action.isConfirm()?"phone-confirm-action":"";
	%>
	<xava:button action="<%=action.getQualifiedName()%>"/>
	<%
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
