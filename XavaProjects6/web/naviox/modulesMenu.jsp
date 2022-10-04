<%@include file="../xava/imports.jsp"%>

<jsp:useBean id="modules" class="com.openxava.naviox.Modules" scope="session"/>
<jsp:useBean id="folders" class="com.openxava.naviox.Folders" scope="session"/>

<% if (!folders.isRoot()) { %>
<div id="modules_list_header">
<a id="back_folder" href="javascript:naviox.goBack()">« <%=folders.getParentFolderLabel()%></a>
<%=folders.getFolderLabel()%>
<span id="back_folder_counterweight">&nbsp;</span>
</div>
<% } %>

<div id="modules_list_search_header">
<xava:message key="modules_search"/>
</div>

<div id="modules_list_core">
<jsp:include page="modulesList.jsp"/>
</div>
