package com.video.web.listener;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.video.util.SomeStatic;

public class ContextReporter implements ServletContextListener {
	private ServletContext context = null;

	public void contextDestroyed(ServletContextEvent contextEvent) {
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent contextEvent) {
		context = contextEvent.getServletContext();
		
		context.setAttribute("IMAGE_URL", SomeStatic.IMAGE_URL);
		context.setAttribute("UPLOAD_USERFACE_URL", SomeStatic.UPLOAD_USERFACE_URL);
	}
}