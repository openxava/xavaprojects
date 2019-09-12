<%@include file="../xava/imports.jsp"%>

<%
String collection = request.getParameter("collection");
boolean isNotCollection = org.openxava.util.Is.emptyString(collection);

if (isNotCollection) {
%>
<div id="searching_list">
<div id="filter_list">
	<input id="filter_list_text" type="text" size="38" placeholder='<xava:message key="filter_list"/>'/>
</div>
<%} %>
<div id="phone_list_core">
	<jsp:include page="listCore.jsp"/>
</div>
<% if (isNotCollection) { %>
</div>
<% } else { %>
<jsp:include page="collectionTotals.jsp"/>
<% } %>
