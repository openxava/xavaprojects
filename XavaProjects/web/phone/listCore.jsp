<%@ include file="imports.jsp"%>

<%@ page import="org.openxava.tab.impl.IXTableModel" %>
<%@ page import="org.openxava.util.Strings" %>
<%@ page import="org.openxava.util.XavaPreferences" %>
<%@ page import="org.openxava.model.meta.MetaProperty" %>
<%@ page import="org.openxava.web.WebEditors" %>
<%@ page import="org.openxava.util.Is" %>
<%@ page import="org.openxava.web.Ids" %>
<%@ page import="org.openxava.controller.meta.MetaAction" %>
<%@ page import="org.openxava.controller.meta.MetaControllers" %>
<%@ page import="org.openxava.web.Actions" %>
<%@ page import="org.openxava.util.Users" %>
<%@ page import="java.util.prefs.Preferences" %>
<%@ page import="org.openxava.util.XavaResources"%>
<%@ page import="com.openxava.phone.util.ListElementIterator"%>
<%@ page import="com.openxava.phone.util.ListElement"%> 
<%@ page import="static org.apache.commons.lang3.StringUtils.containsIgnoreCase"%>

<jsp:useBean id="errors" class="org.openxava.util.Messages" scope="request"/>
<jsp:useBean id="context" class="org.openxava.controller.ModuleContext" scope="session"/>
<jsp:useBean id="style" class="org.openxava.web.style.Style" scope="request"/>

<%! private final static int ROW_COUNT = 50; 
	
	private final static boolean containsNone(String str, String searchWord) {
		return !containsIgnoreCase(str, searchWord);
	}
%>
   	
<%
String searchWord = request.getParameter("searchWord");
searchWord = searchWord == null?"":Strings.removeAccents(searchWord);
org.openxava.controller.ModuleManager manager = (org.openxava.controller.ModuleManager) context.get(request, "manager", "org.openxava.controller.ModuleManager");
String collection = request.getParameter("collection"); 
String id = "list";
String collectionArgv = "";
String prefix = "";
String tabObject = request.getParameter("tabObject"); 
tabObject = (tabObject == null || tabObject.equals(""))?"xava_tab":tabObject;
if (collection != null && !collection.equals("")) {
	id = collection;
	collectionArgv=",collection="+collection;
	prefix = tabObject + "_"; 
}
org.openxava.tab.Tab tab = (org.openxava.tab.Tab) context.get(request, tabObject);
tab.setRequest(request); 
String action=request.getParameter("rowAction");
action=action==null?manager.getEnvironment().getValue("XAVA_LIST_ACTION"):action;
String viewObject = request.getParameter("viewObject");
String actionArgv = viewObject != null && !viewObject.equals("")?",viewObject=" + viewObject:"";
viewObject = (viewObject == null || viewObject.equals(""))?"xava_view":viewObject; 
org.openxava.view.View view = (org.openxava.view.View) context.get(request, viewObject);
view.setRequest(request);
String sfilter = request.getParameter("filter");
boolean filter = !"false".equals(sfilter);
String displayFilter=""; 
String imageFilter="hide-filter";
String filterMessage="hide_filters";
if (!tab.isFilterVisible()) {
	displayFilter="none"; 
	imageFilter ="show-filter"; 
	filterMessage="show_filters";
}
String lastRow = request.getParameter("lastRow");
boolean singleSelection="true".equalsIgnoreCase(request.getParameter("singleSelection"));
String onSelectCollectionElementAction = view.getOnSelectCollectionElementAction();
MetaAction onSelectCollectionElementMetaAction = Is.empty(onSelectCollectionElementAction) ? null : MetaControllers.getMetaAction(onSelectCollectionElementAction);
String selectedRowStyle = style.getSelectedRowStyle(); 
String rowStyle = "";
int totalSize = -1; 
tab.reset();
boolean loadMore = false;
Object initListRowCount = session.getAttribute("xava.initListRowCount");
session.removeAttribute("xava.initListRowCount");
int limit = initListRowCount == null?tab.getPageRowCount():ROW_COUNT;
if (limit < ROW_COUNT) limit = ROW_COUNT;
%>
<div id="<xava:id name='<%=id%>'/>" class="phone-list">
<%
int f = 0, row = f;
String prefixIdRow = Ids.decorate(request, prefix);
for (java.util.Iterator<ListElement> it = new ListElementIterator(tab, view, request, errors); it.hasNext();) {
	if (f == limit) {
		loadMore = true;
		break;
	}
	ListElement el = it.next();
	if (!Is.emptyString(searchWord) &&  
		containsNone(el.getHeader(), searchWord) &&      
		containsNone(el.getSubheader(), searchWord) && 
		containsNone(el.getContent(), searchWord))
	{
		row++;
		continue;
	}
	
	String checked=tab.isSelected(row)?"checked='true'":"";
	String actionOnClick = Actions.getActionOnClick(
			request.getParameter("application"), request.getParameter("module"), 
			onSelectCollectionElementAction, row, viewObject, prefixIdRow + row,
			selectedRowStyle, rowStyle, 
			onSelectCollectionElementMetaAction, tabObject);
	String cssStyle = tab.getStyle(f); 
%>
<div id="<%=prefixIdRow%><%=row%>" class="<%=cssStyle%>">
	<div class="phone-list-element"> 
		<span class="phone-list-element-check"">
			<INPUT type="<%=singleSelection?"RADIO":"CHECKBOX"%>" name="<xava:id name='xava_selected'/>" value="<%=prefix + "selected"%>:<%=row%>" <%=checked%> <%=actionOnClick%> />
		</span>
		<xava:link action='<%=action%>' argv='<%="row=" + (row++) + actionArgv%>'>			
			<div class="phone-list-element-header"><%=el.getHeader()%></div>
			<div class="phone-list-element-subheader"><%=el.getSubheader()%></div>
			<div class="phone-list-element-content"><%=el.getContent()%></div>
		</xava:link>
	</div>
</div>
<% f++;
}

if (loadMore) {
%>
<div id="load_more_elements" class="ox-action-link">
	<xava:link action='List.setPageRowCount' argv='<%="rowCount=" + (limit + ROW_COUNT)%>'>
		<div onclick="$('#loading_more_elements').show(); $('#load_more_elements').hide();">
			<xava:message key="load_more"/>...
		</div>	
	</xava:link>
</div>
<div id="loading_more_elements" style="display:none;">
	<xava:message key="loading"/>...
	<i class="mdi mdi-autorenew module-loading spin"></i>
</div>	
<%
}
else if (f == 0) {
%>
<div  class="phone-list-element">
	<div class="phone-list-element-message">
		<xava:message key="no_objects"/>
	</div>	
</div>
<%	
}
%>
</div>
