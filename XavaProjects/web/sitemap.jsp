<?xml version="1.0" encoding="utf-8"?>

<urlset xmlns="http://www.sitemaps.org/schemas/sitemap/0.9"
	xmlns:xhtml="http://www.w3.org/1999/xhtml">
	
<%@page import="org.openxava.xavaprojects.site.Landing"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Properties"%>
<%@page import="java.util.stream.Collectors"%>
	
<%
String locBase = request.getRequestURL().toString().replace("/sitemap.jsp", "/ate/");
Properties all = Landing.getAll(request);
List<String> prefixes = all.stringPropertyNames().stream()
	.filter(k -> k.endsWith("_name"))
	.map(n -> n.replaceAll("_name$", ""))
	.collect(Collectors.toList());
for (String prefix: prefixes) {
	String uri = prefix.replace("_", "-");
%>
	<url>
		<loc><%=locBase%><%=uri%>/</loc>
	</url>
<%
}
%>		
</urlset>