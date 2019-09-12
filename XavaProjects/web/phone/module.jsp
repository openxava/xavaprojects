<%
org.openxava.controller.ModuleContext phoneContext = (org.openxava.controller.ModuleContext) session.getAttribute("context");
if (phoneContext == null) {
	phoneContext = new org.openxava.controller.ModuleContext();
	session.setAttribute("context", phoneContext);
}
String phoneWindowId = phoneContext.getWindowId(request);
phoneContext.setCurrentWindowId(phoneWindowId);
String phoneApp = request.getParameter("application");
String phoneModule = phoneContext.getCurrentModule(request); 
phoneContext.get(phoneApp, phoneModule, "manager", "com.openxava.phone.controller.PhoneModuleManager");
%>

<%@ include file="../xava/module.jsp" %>
