/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.22
 * Generated at: 2019-10-21 19:45:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.naviox.editors;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.openxava.model.meta.MetaProperty;
import org.openxava.view.View;
import org.openxava.application.meta.MetaApplications;
import org.openxava.application.meta.MetaModule;
import org.openxava.controller.meta.MetaControllers;
import org.openxava.controller.meta.MetaController;
import org.openxava.controller.meta.MetaAction;
import org.openxava.model.meta.MetaModel;
import org.openxava.model.meta.MetaMember;
import org.openxava.view.meta.MetaCollectionView;
import org.openxava.view.meta.MetaView;
import org.openxava.util.Is;
import org.openxava.util.Labels;
import org.openxava.util.Strings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public final class actionsEditor_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(7);
    _jspx_dependants.put("/naviox/editors/commonDefinitions.jsp", Long.valueOf(1569351605700L));
    _jspx_dependants.put("/WEB-INF/lib/standard-jstlel.jar", Long.valueOf(1569351604600L));
    _jspx_dependants.put("jar:file:/C:/Users/javie/git/xavaprojects/XavaProjects/web/WEB-INF/lib/standard-jstlel.jar!/META-INF/fmt-1_0.tld", Long.valueOf(1425975068000L));
    _jspx_dependants.put("/naviox/editors/../../xava/imports.jsp", Long.valueOf(1569351590385L));
    _jspx_dependants.put("jar:file:/C:/Users/javie/git/xavaprojects/XavaProjects/web/WEB-INF/lib/standard-jstlel.jar!/META-INF/c-1_0.tld", Long.valueOf(1425975068000L));
    _jspx_dependants.put("/WEB-INF/openxava.tld", Long.valueOf(1569351605504L));
    _jspx_dependants.put("/naviox/editors/collectionActions.jsp", Long.valueOf(1569351605625L));
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
    _jspx_imports_classes.add("org.openxava.controller.meta.MetaController");
    _jspx_imports_classes.add("org.openxava.util.Strings");
    _jspx_imports_classes.add("java.util.Iterator");
    _jspx_imports_classes.add("org.openxava.application.meta.MetaApplications");
    _jspx_imports_classes.add("java.util.Collection");
    _jspx_imports_classes.add("org.openxava.util.Is");
    _jspx_imports_classes.add("java.util.ArrayList");
    _jspx_imports_classes.add("org.openxava.controller.meta.MetaAction");
    _jspx_imports_classes.add("org.openxava.view.meta.MetaCollectionView");
    _jspx_imports_classes.add("org.openxava.util.Labels");
    _jspx_imports_classes.add("org.openxava.model.meta.MetaMember");
    _jspx_imports_classes.add("org.openxava.view.View");
    _jspx_imports_classes.add("org.openxava.view.meta.MetaView");
    _jspx_imports_classes.add("org.openxava.controller.meta.MetaControllers");
    _jspx_imports_classes.add("org.openxava.model.meta.MetaModel");
    _jspx_imports_classes.add("org.openxava.application.meta.MetaModule");
  }

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
  }

  public void _jspDestroy() {
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      org.openxava.web.style.Style style = null;
      style = (org.openxava.web.style.Style) _jspx_page_context.getAttribute("style", javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      if (style == null){
        style = new org.openxava.web.style.Style();
        _jspx_page_context.setAttribute("style", style, javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      }
      out.write('\r');
      out.write('\n');
      org.openxava.controller.ModuleContext context = null;
      synchronized (session) {
        context = (org.openxava.controller.ModuleContext) _jspx_page_context.getAttribute("context", javax.servlet.jsp.PageContext.SESSION_SCOPE);
        if (context == null){
          context = new org.openxava.controller.ModuleContext();
          _jspx_page_context.setAttribute("context", context, javax.servlet.jsp.PageContext.SESSION_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("\r\n");

String propertyKey = request.getParameter("propertyKey");
String [] fvalues = (String []) request.getAttribute(propertyKey + ".fvalue");
boolean editable="true".equals(request.getParameter("editable"));
String disabled=editable?"":"disabled";
String script = request.getParameter("script");
String agent = (String) request.getAttribute("xava.portlet.user-agent");
if (null != agent && agent.indexOf("MSIE")>=0) {
    script = org.openxava.util.Strings.change(script, "onchange", "onclick");
}
String viewObject = request.getParameter("viewObject");
viewObject = (viewObject == null || viewObject.equals(""))?"xava_view":viewObject;
View view = (View) context.get(request, viewObject);
String moduleName = view.getValueString("module.name");
String applicationName = request.getParameter("application"); 
MetaModule module = MetaApplications.getMetaApplication(applicationName).getMetaModule(moduleName);

      out.write('\r');
      out.write('\n');
      out.write(" \r\n");
      out.write("\r\n");
      out.write("<table width=\"100%\"><tr>\r\n");

java.util.Collection actions = java.util.Arrays.asList(fvalues); 
int i=0; 
for (Object ocontroller: module.getControllersNames()) {
	MetaController controller = MetaControllers.getMetaController((String) ocontroller);
	for (Object oaction: controller.getAllNotHiddenMetaActionsRecursive()) { 
		MetaAction action = (MetaAction) oaction;
		if (action.getMetaController().getName().equals("Navigation")) continue;
		String checked = actions.contains(action.getQualifiedName())?"checked='true'":"";

      out.write("\r\n");
      out.write("\t<td>\r\n");
      out.write("\t<INPUT name=\"");
      out.print(propertyKey);
      out.write("\" type=\"checkbox\" class=\"");
      out.print(style.getEditor());
      out.write("\" \r\n");
      out.write("\t\ttabindex=\"1\" \r\n");
      out.write("\t\tvalue=\"");
      out.print(action.getQualifiedName());
      out.write("\" \r\n");
      out.write("\t\t");
      out.print(checked);
      out.write("\r\n");
      out.write("\t\t");
      out.print(disabled);
      out.write("\r\n");
      out.write("\t\t");
      out.print(script);
      out.write("\r\n");
      out.write("\t/>\t\t\r\n");
      out.write("\t");
      out.print(action.getLabel());
      out.write(" \r\n");
      out.write("\t");
 if (++i % 4 == 0) { 
      out.write("</tr><tr>");
 } 
      out.write("\r\n");
      out.write("\t</td>\r\n");
		
	}
}

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

String viewName = module.getViewName();
MetaModel model = MetaModel.get(module.getModelName());
java.util.Collection<String> collectionNames = model.getColectionsNames();
MetaView metaView = viewName == null ? model.getMetaViewByDefault() : model.getMetaView(viewName);

for (String collectionName : collectionNames) {
	MetaCollectionView mcv = metaView.getMetaCollectionView(collectionName);	
	if (mcv == null) continue;
	String prefix = collectionName + ":"; 
	String collectionLabel = Labels.get(collectionName) + ": ";
	Collection<String> actionNames = new ArrayList<String>();
	actionNames.add(prefix + (Is.emptyString(mcv.getNewActionName()) ? "Collection.new" : mcv.getNewActionName()));
	actionNames.add(prefix + (Is.emptyString(mcv.getAddActionName()) ? "Collection.add" : mcv.getAddActionName()));
	actionNames.add(prefix + (Is.emptyString(mcv.getHideActionName()) ? "Collection.hideDetail" : mcv.getHideActionName()));
	actionNames.add(prefix + (Is.emptyString(mcv.getSaveActionName()) ? "Collection.save" : mcv.getSaveActionName())); // saveAndStay?
	actionNames.add(prefix + (Is.emptyString(mcv.getRemoveActionName()) ? "Collection.remove" : mcv.getRemoveActionName()));
	actionNames.add(prefix + (Is.emptyString(mcv.getEditActionName()) ? "Collection.edit" : mcv.getEditActionName()));
	actionNames.add(prefix + (Is.emptyString(mcv.getRemoveSelectedActionName()) ? "Collection.removeSelected" : mcv.getRemoveSelectedActionName()));	
	if (!Is.emptyString(mcv.getOnSelectElementActionName())) actionNames.add(prefix + mcv.getOnSelectElementActionName());
		
	for (String listAction : (Collection<String>) mcv.getActionsListNames()) actionNames.add(prefix + listAction);
	MetaController controller = MetaControllers.getMetaController("DefaultListActionsForCollections");
	for (Iterator<MetaAction> it = controller.getAllMetaActions().iterator(); it.hasNext();) {
		MetaAction action = it.next();
		if (action.isHidden()) continue;
		actionNames.add(prefix + action.getQualifiedName());
	}
		
	for (String subController : (Collection<String>) mcv.getSubcontrollersListNames()) {
		controller = MetaControllers.getMetaController(subController);
		for (Iterator<MetaAction> it = controller.getAllMetaActions().iterator(); it.hasNext();) {
			MetaAction action = it.next();
			if (action.isHidden()) continue;
			actionNames.add(prefix + action.getQualifiedName());
		}
	}
	
	for (String rowAction : (Collection<String>) mcv.getActionsRowNames()) actionNames.add(prefix + rowAction);
	controller = MetaControllers.getMetaController("DefaultRowActionsForCollections");
	for (Iterator<MetaAction> it = controller.getAllMetaActions().iterator(); it.hasNext();) {
		MetaAction action = it.next();
		if (action.isHidden()) continue;
		actionNames.add(prefix + action.getQualifiedName());
	}
	
	for (String detailAction : (Collection<String>) mcv.getActionsDetailNames()) actionNames.add(prefix + detailAction);	
	
	for (String actionName : actionNames) {		
		String checked = actions.contains(actionName)?"checked='true'":"";

      out.write("\r\n");
      out.write("\t<td>\r\n");
      out.write("\t<INPUT name=\"");
      out.print(propertyKey);
      out.write("\" type=\"checkbox\" class=\"");
      out.print(style.getEditor());
      out.write("\" \r\n");
      out.write("\t\ttabindex=\"1\" \r\n");
      out.write("\t\tvalue=\"");
      out.print(actionName);
      out.write("\"\t\r\n");
      out.write("\t\t");
      out.print(checked);
      out.write("\t\r\n");
      out.write("\t\t");
      out.print(disabled);
      out.write("\r\n");
      out.write("\t\t");
      out.print(script);
      out.write("\r\n");
      out.write("\t/>\t\t\r\n");
      out.write("\t");
      out.print(collectionLabel + Labels.get(Strings.change(actionName, prefix, "")));
      out.write(" \r\n");
      out.write("\t");
 if (++i % 4 == 0) { 
      out.write("</tr><tr>");
 } 
      out.write("\r\n");
      out.write("\t</td>\t\t\r\n");
	}
	
}

      out.write("\r\n");
      out.write("</tr></table>\r\n");
 
if (!editable) { 
	for (i=0; i<fvalues.length; i++) {

      out.write("\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"");
      out.print(propertyKey);
      out.write("\" value=\"");
      out.print(fvalues[i]);
      out.write("\">\t\t\r\n");

	}
} 

      out.write('	');
      out.write('\r');
      out.write('\n');
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
}