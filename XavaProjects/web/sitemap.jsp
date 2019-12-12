<?xml version="1.0" encoding="utf-8"?>

<%-- TMP ME QUEDÉ POR AQUÍ: REHACER ESTO --%>

<urlset xmlns="http://www.sitemaps.org/schemas/sitemap/0.9"
	xmlns:xhtml="http://www.w3.org/1999/xhtml">
	<url>
		<loc>https://www.openxava.org/</loc>
	</url>
	<url>
		<loc>https://www.openxava.org/changelog/</loc>
	</url>
	<url>
		<loc>https://www.openxava.org/credits/</loc>
	</url>
	<url>
		<loc>https://www.openxava.org/demos/</loc>
	</url>
	<url>
		<loc>https://www.openxava.org/doc/</loc>
	</url>
	<url>
		<loc>https://www.openxava.org/stories/</loc>
	</url>	
	<url>
		<loc>https://www.openxava.org/support/</loc>
	</url>	
	<url>
		<loc>https://www.openxava.org/xavapro/</loc>
	</url>	
	<url>
		<loc>https://www.openxava.org/xavapro/pricing/</loc>
	</url>
	<url>
		<loc>https://www.openxava.org/OpenXavaDoc/apidocs/</loc>
	</url>
	<url>
		<loc>https://www.openxava.org/OpenXavaDoc/docs/</loc>
	</url>
	<url>
		<loc>https://www.openxava.org/blog/</loc>
	</url>
	<url>
		<loc>https://www.openxava.org/related/</loc>
	</url>	
	
<%@page import="org.openxava.site.Landing"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Properties"%>
<%@page import="java.util.stream.Collectors"%>
	
<%
Properties all = Landing.getAll(request);
List<String> prefixes = all.stringPropertyNames().stream()
	.filter(k -> k.endsWith("_name"))
	.map(n -> n.replaceAll("_name$", ""))
	.collect(Collectors.toList());
for (String prefix: prefixes) {
	String uri = prefix.replace("_", "-");
%>
	<url>
		<loc>https://www.openxava.org/ate/<%=uri%>/</loc>
	</url>
<%
}
%>		
</urlset>