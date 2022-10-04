<jsp:useBean id="folders" class="com.openxava.naviox.Folders" scope="session"/>

<% 
if ("true".equals(request.getParameter("folderModules"))) {
	modulesList = folders.getFolderModules(request); 		
}
else if ("true".equals(request.getParameter("fixedModules"))) {
	modulesList = modules.getFixedModules(request); 
}
else if ("true".equals(request.getParameter("bookmarkModules"))) {
	modulesList = modules.getBookmarkModules(request); 
	bookmarkModules = true;
}
else {
	modulesList = modules.getRegularModules(request); 
}
%>