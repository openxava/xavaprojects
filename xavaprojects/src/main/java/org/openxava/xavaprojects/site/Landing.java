package org.openxava.xavaprojects.site;

import java.io.*;
import java.util.*;

import javax.servlet.http.*;

import org.apache.commons.logging.*;
import org.openxava.util.*;

/**
 * 
 * @author Javier Paniza
 */

public class Landing {
	
	private static Log log = LogFactory.getLog(Landing.class);
	
	public static Properties getAll(HttpServletRequest request) {		
		String suffix = "es".equals(request.getLocale().getLanguage()) || "ca".equals(request.getLocale().getLanguage())?"_es":"";
		String file = "i18n/Landing" + suffix + ".properties";
		try {			
			PropertiesReader reader = new PropertiesReader(LandingServlet.class, file);
			return reader.get();
		} 
		catch (IOException ex) {
			log.error(XavaResources.getString("properties_file_error", file), ex);
			return new Properties();
		}
	}
	
}