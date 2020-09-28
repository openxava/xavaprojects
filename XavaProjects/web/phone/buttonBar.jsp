<%@ include file="imports.jsp"%>

<%@ page import="org.openxava.controller.meta.MetaAction" %>
<%@ page import="org.openxava.util.XavaPreferences"%>
<%@ page import="org.openxava.util.Is"%>
<%@ page import="com.openxava.phone.controller.PhoneManager"%>


<jsp:useBean id="context" class="org.openxava.controller.ModuleContext" scope="session"/>
<jsp:useBean id="style" class="org.openxava.web.style.Style" scope="request"/>

<jsp:useBean id="modules" class="com.openxava.naviox.Modules" scope="session"/>

<%
org.openxava.controller.ModuleManager manager = (org.openxava.controller.ModuleManager) context.get(request, "manager", "org.openxava.controller.ModuleManager");
manager.setSession(session);
boolean onBottom = false;
String mode = request.getParameter("xava_mode"); 
if (mode == null) mode = manager.isSplitMode()?"detail":manager.getModeName();
boolean headerButtonBar = !manager.isSplitMode() || mode.equals("list");  
PhoneManager phoneManager = new PhoneManager(manager);
%>

<div class="<%=style.getButtonBar()%>">

	<%
	java.util.Stack previousViews = (java.util.Stack) context.get(request, "xava_previousViews"); 
	if (headerButtonBar && previousViews.isEmpty()) { 
		String positionClass = null;		
		java.util.Collection actions = manager.getMetaActionsMode();
		java.util.Iterator itActions = actions.iterator();
		boolean backButtonShown = false;
		while (itActions.hasNext()) {
			MetaAction action = (MetaAction) itActions.next();
			String modeNameAction = action.getName().startsWith("detail")?"detail":action.getName();
			if (!manager.isListMode() && !modeNameAction.equals(manager.getModeName())) {
			%>	
	<xava:link action="<%=action.getQualifiedName()%>">		
		<i class="mdi mdi-arrow-left"></i>
	</xava:link>
			<%	
				backButtonShown = true;
				break;
			}
		}		
		if (!backButtonShown && !manager.getModelName().equals("SignIn")) {
			boolean showModulesMenuButton = modules.showsIndexLink() || modules.getAll(request).size() > 1; 
			if (!modules.getCurrent(request).equals("Index") && showModulesMenuButton) {
		%>
	<a href="../phone"><i class="mdi mdi-arrow-left"></i></a>
		<%  } else { %>
	<a href="<%=request.getContextPath()%>/naviox/signOut.jsp?organization="><i class="mdi mdi-arrow-left"></i></a>
		<%	}
		}		
	}	
	else if (!previousViews.isEmpty()) {
		for (java.util.Iterator it = manager.getMetaActions().iterator(); it.hasNext(); ) {
			MetaAction action = (MetaAction) it.next();
			if ("cancel".equals(action.getName()) || "return".equals(action.getName()) || 
				"cancelar".equals(action.getName()) || "volver".equals(action.getName()) ||
				"hideDetail".equals(action.getName())) { 
			%>
	<xava:link action="<%=action.getQualifiedName()%>">
		<i class="mdi mdi-arrow-left"></i>
	</xava:link>			
			<%
				break;
			}
		}
	}
	%>
	
	<span class="phone-title"> 
		<%=phoneManager.getTitle(request)%>
	</span>
	
	<% if (phoneManager.showsActionsOnDropDownMenu()) { %>
		<div class="phone-dropdown-button" onclick="phone.showDropdown('actions')">
			<i class="mdi mdi-dots-vertical"></i>
		</div>
	<% } %>	
	
	<% if (manager.isListMode()) { %>
		<div class="phone-dropdown-button" onclick="phone.showDropdown('order')">
			<i class="mdi mdi-sort"></i>
		</div>
	<% } %>	
		
</div>

