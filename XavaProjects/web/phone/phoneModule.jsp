<% Servlets.setCharacterEncoding(request, response); %>

<%@include file="../xava/imports.jsp"%>

<%@page import="org.openxava.web.Browsers"%>
<%@page import="org.openxava.web.style.Themes"%> 
<%@page import="org.openxava.web.servlets.Servlets"%>
<%@page import="org.openxava.util.Locales"%>
<%@page import="com.openxava.phone.web.Users"%>

<jsp:useBean id="context" class="org.openxava.controller.ModuleContext" scope="session"/>

<% 
String module = context.getCurrentModule(request);
if (Users.currentNeedsToChangePassword() && !"ChangePassword".equals(module)) { 
%>
	<jsp:forward page="/p/ChangePassword"/>
<% 
} 
%>

<jsp:useBean id="modules" class="com.openxava.naviox.Modules" scope="session"/>

<%
String app = request.getParameter("application");
Locales.setCurrent(request);
modules.setCurrent(request.getParameter("application"), request.getParameter("module")); 
String oxVersion = org.openxava.controller.ModuleManager.getVersion();
session.setAttribute("xava.initListRowCount", true); 
%>

<!DOCTYPE html>

<head>
	<title><%=modules.getCurrentModuleDescription(request)%></title>
	<meta name='apple-mobile-web-app-capable' content='yes'/>
	<meta name='viewport' content='width=device-width, initial-scale=1, maximum-scale=1'>				
	<link rel="stylesheet" href="<%=request.getContextPath()%>/xava/style/materialdesignicons.css?ox=<%=oxVersion%>">
	<link href="<%=request.getContextPath()%>/xava/style/<%=Themes.getCSS(request)%>?ox=<%=oxVersion%>" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/phone/style/phone.css?ox=<%=oxVersion%>" rel="stylesheet" type="text/css">
	<script type="text/javascript">
		if (openxava == null) var openxava = {};
		openxava.baseFolder = 'phone';
	</script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/xava/js/dwr-engine.js?ox=<%=oxVersion%>'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/Modules.js?ox=<%=oxVersion%>'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/Folders.js?ox=<%=oxVersion%>'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/PhoneList.js?ox=<%=oxVersion%>'></script>
	
</head>

<body class="<%=Browsers.getCSSClass(request)%>"> 
<jsp:include page='<%="module.jsp?application=" + app + "&module=" + module + "&jsFiles=phone/js/phone.js" + "&htmlHead=false&init=false"%>'/>

<script>
$(function() {
	phone.application = "<%=app%>";
	phone.module = "<%=module%>";
});
</script>
</body>
</html>