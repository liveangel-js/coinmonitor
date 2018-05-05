package org.liveangel.A.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by sjiang3 on 6/7/17.
 */
@Component
public class ServletListener implements ServletContextListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServletListener.class);


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LOGGER.info("Servlet ÈÝÆ÷ contextInitialized");


    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        LOGGER.info("Servlet ÈÝÆ÷ contextDestroyed");

    }
}
