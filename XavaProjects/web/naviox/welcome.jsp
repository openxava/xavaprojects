<%@include file="../xava/imports.jsp"%>

<%@page import="org.openxava.application.meta.MetaApplications"%>
<%@page import="org.openxava.application.meta.MetaApplication"%>
<%@page import="org.openxava.util.Locales"%>
<%@page import="org.openxava.web.style.XavaStyle"%>
<%@page import="org.openxava.util.XavaPreferences"%>


<%-- To put your own text add entries in the i18n messages files of your project 
In MyApplication-labels_en.properties:
MyApplication=My application
MyApplication[description]=My application does this and that

In MyApplication-messages_en.properties:
welcome_point1=This is a additional explanatory line
--%>

<%
String applicationName = request.getContextPath().substring(1);
MetaApplication metaApplication = MetaApplications.getMetaApplication(applicationName);
Locales.setCurrent(request);
String oxVersion = org.openxava.controller.ModuleManager.getVersion();
String title = (String) request.getAttribute("naviox.pageTitle");
if (title == null) title = metaApplication.getLabel();
String language = "es".equals(Locales.getCurrent().getLanguage()) || "ca".equals(Locales.getCurrent().getLanguage())?"es":"en";
%>

<!DOCTYPE html>

<head>
	<title><%=title%></title>
	<meta name='viewport' content='width=device-width, initial-scale=1, maximum-scale=1'>
	<link href="<%=request.getContextPath()%>/xava/style/<%=XavaPreferences.getInstance().getStyleCSS()%>?ox=<%=oxVersion%>" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/xava/style/custom.css?ox=<%=oxVersion%>" rel="stylesheet" type="text/css">
</head>

<body id="welcome" <%=XavaStyle.getBodyClass(request)%>>


<div id="logo">
<div>xava<span>projects</span></div>
</div>

<p><%=metaApplication.getDescription()%></p>
<p><xava:message key="welcome_point1"/></p> 
<p><xava:message key="welcome_point2"/></p> 

<div class="ox-bottom-buttons">
	<input type="hidden">
	<input type="button" tabindex="1" onclick="window.location='https://github.com/openxava/xavaprojects'" value="<xava:message key='download_from_github'/>">
	<br>
	<a href="/XavaProjects/m/SignIn"><xava:label key='SignIn'/></a>   
</div>

<div id="home_screenshot">
<img src="images/home-screenshot_<%=language%>.png"/>
</div>

</body>

