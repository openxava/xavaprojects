<%@ include file="imports.jsp"%>

<%@page import="org.openxava.view.View"%>
<%@page import="org.openxava.web.WebEditors"%>
<%@page import="org.openxava.model.meta.MetaProperty"%>
<%@page import="org.openxava.tab.impl.IXTableModel"%>
<%@page import="org.openxava.tab.Tab"%>
<%@page import="org.openxava.util.Is"%>
<%@page import="org.openxava.util.Labels"%>


<jsp:useBean id="errors" class="org.openxava.util.Messages" scope="request"/>
<jsp:useBean id="context" class="org.openxava.controller.ModuleContext" scope="session"/>
<jsp:useBean id="style" class="org.openxava.web.style.Style" scope="request"/>

<%
String tabObject = request.getParameter("tabObject"); 
tabObject = (tabObject == null || tabObject.equals(""))?"xava_tab":tabObject;
Tab tab = (Tab) context.get(request, tabObject);
String viewObject = request.getParameter("viewObject");
viewObject = (viewObject == null || viewObject.equals(""))?"xava_view":viewObject; 
View view = (View) context.get(request, viewObject);
String collection = request.getParameter("collection");
IXTableModel model = tab.getTableModel(); 
boolean frameOpened = false; 
for (int c=0; c<model.getColumnCount(); c++) {
	MetaProperty p = tab.getMetaProperty(c);	
	if (tab.hasTotal(c)) {
		Object total = tab.getTotal(c); 
		String ftotal = WebEditors.format(request, p, total, errors, view.getViewName(), true);
		org.openxava.view.View rootView = view.getParent().getCollectionRootOrRoot();
		String sumProperty =  collection + "." + p.getName() + "_SUM_";
		String script = "";
		if (rootView.isPropertyUsedInCalculation(sumProperty)) {
			script = org.openxava.web.Collections.sumPropertyScript(request, rootView, sumProperty);
		}
		String label = tab.getTotalLabel(0, c);
		if (Is.emptyString(label)) label = Labels.get("sum");
		if (!frameOpened) {
			frameOpened = true;
	%>
	<div class="ox-frame">
	<% 
		}
	%>	
		<div class="phone-detail-element">
			<span class="<%=style.getLabel()%>"><%=label%></span>
			<br> 
			<span>
				<input id="<xava:id name='<%=sumProperty%>'/>" class="editor xava_numeric" 
					name="<xava:id name='<%=sumProperty%>'/>"
					type="text" title="" style="text-align:right" 
					maxlength="21" size="21" value="<%=ftotal%>" disabled="" <%=script%>/>
			</span>	
		</div>
	<%	
	}
}

int additionalTotalsCount = tab.getAdditionalTotalsCount() + 1;
for (int i=1; i<additionalTotalsCount; i++) {
	for (int c=0; c<model.getColumnCount(); c++) {
		MetaProperty p = tab.getMetaProperty(c);
		if (tab.hasTotal(i, c)) {
		%> 	
			<div class="phone-detail-element">
				<span class="<%=style.getLabel()%>"><%=tab.getTotalLabel(i, c)%></span>
				<br> 
				<span>
					<jsp:include page="collectionTotal.jsp">
						<jsp:param name="row" value="<%=i%>"/>
						<jsp:param name="column" value="<%=c%>"/>
						<jsp:param name="viewObject" value="xava_view"/>
					</jsp:include>
				</span>
			</div>	
		<%	
		}
	}
}  

if (frameOpened) {
%>
		</div>
<%
}
%>