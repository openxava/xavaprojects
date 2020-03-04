<% Servlets.setCharacterEncoding(request, response); %>

<%@include file="../xava/imports.jsp"%>

<%@page import="org.openxava.web.servlets.Servlets"%>
<%@page import="org.openxava.web.Browsers"%>
<%@page import="org.openxava.web.style.Themes"%>  
<%@page import="org.openxava.util.Locales"%>
<%@page import="com.openxava.naviox.util.Organizations"%>
<%@page import="com.openxava.phone.web.Users"%>
<%@page import="org.openxava.util.SessionData"%>

<% org.openxava.util.Users.setCurrent(request); %>
<% if (Users.currentNeedsToChangePassword()) { %>
	<jsp:forward page="/p/ChangePassword"/>
<% } %>

<jsp:useBean id="context" class="org.openxava.controller.ModuleContext" scope="session"/>
<jsp:useBean id="folders" class="com.openxava.naviox.Folders" scope="session"/>

<%
Organizations.setPersistenceDefaultSchema(request.getSession()); 
Locales.setCurrent(request);
SessionData.setCurrent(request);
String version = org.openxava.controller.ModuleManager.getVersion();
folders.setApplicationNameAsRootLabel(true);
folders.setIncludeFixedAndBoookmarkModules(true); 
%>

<!DOCTYPE html>

<head>
	<title><%=folders.getApplicationLabel()%></title>	
	<meta name='apple-mobile-web-app-capable' content='yes'/>
	<meta name='viewport' content='width=device-width, initial-scale=1, maximum-scale=1'>
	<link href="<%=request.getContextPath()%>/xava/style/<%=Themes.getCSS(request)%>?ox=<%=version%>" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/phone/style/phone.css?ox=<%=version%>" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/xava/style/materialdesignicons.css?ox=<%=version%>">
	<script type='text/javascript' src='<%=request.getContextPath()%>/xava/js/dwr-engine.js?ox=<%=version%>'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/Modules.js?ox=<%=version%>'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/Folders.js?ox=<%=version%>'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/xava/js/jquery.js?ox=<%=version%>"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/xava/js/typewatch.js?ox=<%=version%>'></script>
</head>

<body class="<%=Browsers.getCSSClass(request)%>">

	<div id="modules_list"> 
		<table id="modules_list_box" width="100%">
			<tr id="modules_list_content">
				<td id="modules_list"> 
					<jsp:include page="modulesMenu.jsp"/>
				</td>						
			</tr>
		</table>
	</div> 

	<script type='text/javascript' src='<%=request.getContextPath()%>/naviox/js/naviox.js?ox=<%=version%>'></script>
	
	<script>
	$(function() {
		naviox.init();
	});
	</script>	

</body>
</html>