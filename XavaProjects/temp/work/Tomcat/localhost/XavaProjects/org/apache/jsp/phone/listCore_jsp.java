/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.22
 * Generated at: 2019-12-13 18:19:58 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.phone;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.openxava.tab.impl.IXTableModel;
import org.openxava.util.Strings;
import org.openxava.util.XavaPreferences;
import org.openxava.model.meta.MetaProperty;
import org.openxava.web.WebEditors;
import org.openxava.util.Is;
import org.openxava.web.Ids;
import org.openxava.controller.meta.MetaAction;
import org.openxava.controller.meta.MetaControllers;
import org.openxava.web.Actions;
import org.openxava.util.Users;
import java.util.prefs.Preferences;
import org.openxava.util.XavaResources;
import com.openxava.phone.util.ListElementIterator;
import com.openxava.phone.util.ListElement;
import static org.apache.commons.lang3.StringUtils.containsIgnoreCase;

public final class listCore_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

 private final static int ROW_COUNT = 50; 
	
	private final static boolean containsNone(String str, String searchWord) {
		return !containsIgnoreCase(str, searchWord);
	}

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(6);
    _jspx_dependants.put("/WEB-INF/lib/standard-jstlel.jar", Long.valueOf(1575487390796L));
    _jspx_dependants.put("/phone/imports.jsp", Long.valueOf(1575487392694L));
    _jspx_dependants.put("/phone/../xava/imports.jsp", Long.valueOf(1575487378129L));
    _jspx_dependants.put("jar:file:/C:/Users/javie/git/xavaprojects/XavaProjects/web/WEB-INF/lib/standard-jstlel.jar!/META-INF/fmt-1_0.tld", Long.valueOf(1425975068000L));
    _jspx_dependants.put("jar:file:/C:/Users/javie/git/xavaprojects/XavaProjects/web/WEB-INF/lib/standard-jstlel.jar!/META-INF/c-1_0.tld", Long.valueOf(1425975068000L));
    _jspx_dependants.put("/WEB-INF/openxava.tld", Long.valueOf(1575487391125L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("org.openxava.model.meta.MetaProperty");
    _jspx_imports_classes.add("org.openxava.util.Strings");
    _jspx_imports_classes.add("org.openxava.util.XavaPreferences");
    _jspx_imports_classes.add("static org.apache.commons.lang3.StringUtils.containsIgnoreCase");
    _jspx_imports_classes.add("com.openxava.phone.util.ListElementIterator");
    _jspx_imports_classes.add("org.openxava.web.Ids");
    _jspx_imports_classes.add("org.openxava.util.Is");
    _jspx_imports_classes.add("java.util.prefs.Preferences");
    _jspx_imports_classes.add("org.openxava.controller.meta.MetaAction");
    _jspx_imports_classes.add("org.openxava.tab.impl.IXTableModel");
    _jspx_imports_classes.add("org.openxava.web.Actions");
    _jspx_imports_classes.add("org.openxava.util.Users");
    _jspx_imports_classes.add("org.openxava.util.XavaResources");
    _jspx_imports_classes.add("com.openxava.phone.util.ListElement");
    _jspx_imports_classes.add("org.openxava.web.WebEditors");
    _jspx_imports_classes.add("org.openxava.controller.meta.MetaControllers");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fxava_005fid_0026_005fname_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fxava_005flink_0026_005fargv_005faction;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fxava_005fmessage_0026_005fkey_005fnobody;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fxava_005fid_0026_005fname_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fxava_005flink_0026_005fargv_005faction = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fxava_005fmessage_0026_005fkey_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fxava_005fid_0026_005fname_005fnobody.release();
    _005fjspx_005ftagPool_005fxava_005flink_0026_005fargv_005faction.release();
    _005fjspx_005ftagPool_005fxava_005fmessage_0026_005fkey_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');
      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write(" \n");
      out.write("\n");
      out.write("\n");
      org.openxava.util.Messages errors = null;
      errors = (org.openxava.util.Messages) _jspx_page_context.getAttribute("errors", javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      if (errors == null){
        errors = new org.openxava.util.Messages();
        _jspx_page_context.setAttribute("errors", errors, javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      }
      out.write('\n');
      org.openxava.controller.ModuleContext context = null;
      synchronized (session) {
        context = (org.openxava.controller.ModuleContext) _jspx_page_context.getAttribute("context", javax.servlet.jsp.PageContext.SESSION_SCOPE);
        if (context == null){
          context = new org.openxava.controller.ModuleContext();
          _jspx_page_context.setAttribute("context", context, javax.servlet.jsp.PageContext.SESSION_SCOPE);
        }
      }
      out.write('\n');
      org.openxava.web.style.Style style = null;
      style = (org.openxava.web.style.Style) _jspx_page_context.getAttribute("style", javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      if (style == null){
        style = new org.openxava.web.style.Style();
        _jspx_page_context.setAttribute("style", style, javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      }
      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("   \t\n");

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

      out.write("\n");
      out.write("<div id=\"");
      //  xava:id
      org.openxava.web.taglib.IdTag _jspx_th_xava_005fid_005f0 = (org.openxava.web.taglib.IdTag) _005fjspx_005ftagPool_005fxava_005fid_0026_005fname_005fnobody.get(org.openxava.web.taglib.IdTag.class);
      boolean _jspx_th_xava_005fid_005f0_reused = false;
      try {
        _jspx_th_xava_005fid_005f0.setPageContext(_jspx_page_context);
        _jspx_th_xava_005fid_005f0.setParent(null);
        // /phone/listCore.jsp(79,9) name = name type = null reqTime = true required = true fragment = false deferredValue = false deferredMethod = false expectedTypeName = null methodSignature = null 
        _jspx_th_xava_005fid_005f0.setName(id);
        int _jspx_eval_xava_005fid_005f0 = _jspx_th_xava_005fid_005f0.doStartTag();
        if (_jspx_th_xava_005fid_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
        _005fjspx_005ftagPool_005fxava_005fid_0026_005fname_005fnobody.reuse(_jspx_th_xava_005fid_005f0);
        _jspx_th_xava_005fid_005f0_reused = true;
      } finally {
        org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_xava_005fid_005f0, _jsp_getInstanceManager(), _jspx_th_xava_005fid_005f0_reused);
      }
      out.write("\" class=\"phone-list\">\n");

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

      out.write("\n");
      out.write("<div id=\"");
      out.print(prefixIdRow);
      out.print(row);
      out.write("\">\n");
      out.write("\t<div class=\"phone-list-element\">\n");
      out.write("\t\t<span class=\"phone-list-element-check\"\">\n");
      out.write("\t\t\t<INPUT type=\"");
      out.print(singleSelection?"RADIO":"CHECKBOX");
      out.write("\" name=\"");
      if (_jspx_meth_xava_005fid_005f1(_jspx_page_context))
        return;
      out.write("\" value=\"");
      out.print(prefix + "selected");
      out.write(':');
      out.print(row);
      out.write('"');
      out.write(' ');
      out.print(checked);
      out.write(' ');
      out.print(actionOnClick);
      out.write(" />\n");
      out.write("\t\t</span>\n");
      out.write("\t\t");
      //  xava:link
      org.openxava.web.taglib.LinkTag _jspx_th_xava_005flink_005f0 = (org.openxava.web.taglib.LinkTag) _005fjspx_005ftagPool_005fxava_005flink_0026_005fargv_005faction.get(org.openxava.web.taglib.LinkTag.class);
      boolean _jspx_th_xava_005flink_005f0_reused = false;
      try {
        _jspx_th_xava_005flink_005f0.setPageContext(_jspx_page_context);
        _jspx_th_xava_005flink_005f0.setParent(null);
        // /phone/listCore.jsp(110,2) name = action type = null reqTime = true required = true fragment = false deferredValue = false deferredMethod = false expectedTypeName = null methodSignature = null 
        _jspx_th_xava_005flink_005f0.setAction(action);
        // /phone/listCore.jsp(110,2) name = argv type = null reqTime = true required = false fragment = false deferredValue = false deferredMethod = false expectedTypeName = null methodSignature = null 
        _jspx_th_xava_005flink_005f0.setArgv("row=" + (row++) + actionArgv);
        int _jspx_eval_xava_005flink_005f0 = _jspx_th_xava_005flink_005f0.doStartTag();
        if (_jspx_eval_xava_005flink_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\t\t\t\n");
            out.write("\t\t\t<div class=\"phone-list-element-header\">");
            out.print(el.getHeader());
            out.write("</div>\n");
            out.write("\t\t\t<div class=\"phone-list-element-subheader\">");
            out.print(el.getSubheader());
            out.write("</div>\n");
            out.write("\t\t\t<div class=\"phone-list-element-content\">");
            out.print(el.getContent());
            out.write("</div>\n");
            out.write("\t\t");
            int evalDoAfterBody = _jspx_th_xava_005flink_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_xava_005flink_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
        _005fjspx_005ftagPool_005fxava_005flink_0026_005fargv_005faction.reuse(_jspx_th_xava_005flink_005f0);
        _jspx_th_xava_005flink_005f0_reused = true;
      } finally {
        org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_xava_005flink_005f0, _jsp_getInstanceManager(), _jspx_th_xava_005flink_005f0_reused);
      }
      out.write("\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
 f++;
}

if (loadMore) {

      out.write("\n");
      out.write("<div id=\"load_more_elements\" class=\"ox-action-link\">\n");
      out.write("\t");
      //  xava:link
      org.openxava.web.taglib.LinkTag _jspx_th_xava_005flink_005f1 = (org.openxava.web.taglib.LinkTag) _005fjspx_005ftagPool_005fxava_005flink_0026_005fargv_005faction.get(org.openxava.web.taglib.LinkTag.class);
      boolean _jspx_th_xava_005flink_005f1_reused = false;
      try {
        _jspx_th_xava_005flink_005f1.setPageContext(_jspx_page_context);
        _jspx_th_xava_005flink_005f1.setParent(null);
        // /phone/listCore.jsp(123,1) name = action type = null reqTime = true required = true fragment = false deferredValue = false deferredMethod = false expectedTypeName = null methodSignature = null 
        _jspx_th_xava_005flink_005f1.setAction("List.setPageRowCount");
        // /phone/listCore.jsp(123,1) name = argv type = null reqTime = true required = false fragment = false deferredValue = false deferredMethod = false expectedTypeName = null methodSignature = null 
        _jspx_th_xava_005flink_005f1.setArgv("rowCount=" + (limit + ROW_COUNT));
        int _jspx_eval_xava_005flink_005f1 = _jspx_th_xava_005flink_005f1.doStartTag();
        if (_jspx_eval_xava_005flink_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\n");
            out.write("\t\t<div onclick=\"$('#loading_more_elements').show(); $('#load_more_elements').hide();\">\n");
            out.write("\t\t\t");
            if (_jspx_meth_xava_005fmessage_005f0(_jspx_th_xava_005flink_005f1, _jspx_page_context))
              return;
            out.write("...\n");
            out.write("\t\t</div>\t\n");
            out.write("\t");
            int evalDoAfterBody = _jspx_th_xava_005flink_005f1.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_xava_005flink_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
        _005fjspx_005ftagPool_005fxava_005flink_0026_005fargv_005faction.reuse(_jspx_th_xava_005flink_005f1);
        _jspx_th_xava_005flink_005f1_reused = true;
      } finally {
        org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_xava_005flink_005f1, _jsp_getInstanceManager(), _jspx_th_xava_005flink_005f1_reused);
      }
      out.write("\n");
      out.write("</div>\n");
      out.write("<div id=\"loading_more_elements\" style=\"display:none;\">\n");
      out.write("\t");
      if (_jspx_meth_xava_005fmessage_005f1(_jspx_page_context))
        return;
      out.write("...\n");
      out.write("\t<i class=\"mdi mdi-autorenew module-loading spin\"></i>\n");
      out.write("</div>\t\n");

}
else if (f == 0) {

      out.write("\n");
      out.write("<div  class=\"phone-list-element\">\n");
      out.write("\t<div class=\"phone-list-element-message\">\n");
      out.write("\t\t");
      if (_jspx_meth_xava_005fmessage_005f2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t</div>\t\n");
      out.write("</div>\n");
	
}

      out.write("\n");
      out.write("</div>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_xava_005fid_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  xava:id
    org.openxava.web.taglib.IdTag _jspx_th_xava_005fid_005f1 = (org.openxava.web.taglib.IdTag) _005fjspx_005ftagPool_005fxava_005fid_0026_005fname_005fnobody.get(org.openxava.web.taglib.IdTag.class);
    boolean _jspx_th_xava_005fid_005f1_reused = false;
    try {
      _jspx_th_xava_005fid_005f1.setPageContext(_jspx_page_context);
      _jspx_th_xava_005fid_005f1.setParent(null);
      // /phone/listCore.jsp(108,63) name = name type = null reqTime = true required = true fragment = false deferredValue = false deferredMethod = false expectedTypeName = null methodSignature = null 
      _jspx_th_xava_005fid_005f1.setName("xava_selected");
      int _jspx_eval_xava_005fid_005f1 = _jspx_th_xava_005fid_005f1.doStartTag();
      if (_jspx_th_xava_005fid_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fxava_005fid_0026_005fname_005fnobody.reuse(_jspx_th_xava_005fid_005f1);
      _jspx_th_xava_005fid_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_xava_005fid_005f1, _jsp_getInstanceManager(), _jspx_th_xava_005fid_005f1_reused);
    }
    return false;
  }

  private boolean _jspx_meth_xava_005fmessage_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_xava_005flink_005f1, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  xava:message
    org.openxava.web.taglib.MessageTag _jspx_th_xava_005fmessage_005f0 = (org.openxava.web.taglib.MessageTag) _005fjspx_005ftagPool_005fxava_005fmessage_0026_005fkey_005fnobody.get(org.openxava.web.taglib.MessageTag.class);
    boolean _jspx_th_xava_005fmessage_005f0_reused = false;
    try {
      _jspx_th_xava_005fmessage_005f0.setPageContext(_jspx_page_context);
      _jspx_th_xava_005fmessage_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_xava_005flink_005f1);
      // /phone/listCore.jsp(125,3) name = key type = null reqTime = true required = true fragment = false deferredValue = false deferredMethod = false expectedTypeName = null methodSignature = null 
      _jspx_th_xava_005fmessage_005f0.setKey("load_more");
      int _jspx_eval_xava_005fmessage_005f0 = _jspx_th_xava_005fmessage_005f0.doStartTag();
      if (_jspx_th_xava_005fmessage_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fxava_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_xava_005fmessage_005f0);
      _jspx_th_xava_005fmessage_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_xava_005fmessage_005f0, _jsp_getInstanceManager(), _jspx_th_xava_005fmessage_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_xava_005fmessage_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  xava:message
    org.openxava.web.taglib.MessageTag _jspx_th_xava_005fmessage_005f1 = (org.openxava.web.taglib.MessageTag) _005fjspx_005ftagPool_005fxava_005fmessage_0026_005fkey_005fnobody.get(org.openxava.web.taglib.MessageTag.class);
    boolean _jspx_th_xava_005fmessage_005f1_reused = false;
    try {
      _jspx_th_xava_005fmessage_005f1.setPageContext(_jspx_page_context);
      _jspx_th_xava_005fmessage_005f1.setParent(null);
      // /phone/listCore.jsp(130,1) name = key type = null reqTime = true required = true fragment = false deferredValue = false deferredMethod = false expectedTypeName = null methodSignature = null 
      _jspx_th_xava_005fmessage_005f1.setKey("loading");
      int _jspx_eval_xava_005fmessage_005f1 = _jspx_th_xava_005fmessage_005f1.doStartTag();
      if (_jspx_th_xava_005fmessage_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fxava_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_xava_005fmessage_005f1);
      _jspx_th_xava_005fmessage_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_xava_005fmessage_005f1, _jsp_getInstanceManager(), _jspx_th_xava_005fmessage_005f1_reused);
    }
    return false;
  }

  private boolean _jspx_meth_xava_005fmessage_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  xava:message
    org.openxava.web.taglib.MessageTag _jspx_th_xava_005fmessage_005f2 = (org.openxava.web.taglib.MessageTag) _005fjspx_005ftagPool_005fxava_005fmessage_0026_005fkey_005fnobody.get(org.openxava.web.taglib.MessageTag.class);
    boolean _jspx_th_xava_005fmessage_005f2_reused = false;
    try {
      _jspx_th_xava_005fmessage_005f2.setPageContext(_jspx_page_context);
      _jspx_th_xava_005fmessage_005f2.setParent(null);
      // /phone/listCore.jsp(139,2) name = key type = null reqTime = true required = true fragment = false deferredValue = false deferredMethod = false expectedTypeName = null methodSignature = null 
      _jspx_th_xava_005fmessage_005f2.setKey("no_objects");
      int _jspx_eval_xava_005fmessage_005f2 = _jspx_th_xava_005fmessage_005f2.doStartTag();
      if (_jspx_th_xava_005fmessage_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fxava_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_xava_005fmessage_005f2);
      _jspx_th_xava_005fmessage_005f2_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_xava_005fmessage_005f2, _jsp_getInstanceManager(), _jspx_th_xava_005fmessage_005f2_reused);
    }
    return false;
  }
}