<%@page import="java.util.Iterator"%>
<%@page import="org.openxava.application.meta.MetaModule"%>
<%@page import="com.openxava.naviox.model.Folder"%>

<jsp:useBean id="modules" class="com.openxava.naviox.Modules" scope="session"/>
<jsp:useBean id="folders" class="com.openxava.naviox.Folders" scope="session"/> 

<% 
folders.setModules(modules); 

for (Iterator it= folders.getSubfolders(request).iterator(); it.hasNext();) { 
	Folder folder = (Folder) it.next();
%>	
	<a  href="javascript:naviox.goFolder('<%=folder.getId()%>')">
	<div class="folder-row " >	
		<div class="folder-name">
			<i class="mdi mdi-<%=folder.getIcon()%>"></i>
			<%=folder.getLabel()%>
			<i class="folder-icon mdi mdi-chevron-right"></i>
		</div>		
	</div>	
	</a>
	
<%	
}
%>

<jsp:include page="selectModules.jsp">
	<jsp:param name="folderModules" value="true"/>
</jsp:include>