package org.openxava.xavaprojects.web;

import javax.servlet.*;
import javax.servlet.annotation.*;

import org.quartz.impl.*;

/**
 * tmr
 * 
 * @author Javier Paniza
 */

@WebListener
public class QuartzSchedulerListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        try {
            StdSchedulerFactory.getDefaultScheduler().start();
        } catch (Exception e) {
            e.printStackTrace(); // tmr 
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
        try {
        	StdSchedulerFactory.getDefaultScheduler().shutdown();
        } catch (Exception e) {
            e.printStackTrace(); // tmr 
        }
    }
}
