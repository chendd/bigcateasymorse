package com.video.web.struts;

import javax.servlet.ServletContext;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionServlet;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.video.domain.logic.AllServiceFacade;

public abstract class BaseActionForm extends ActionForm {
	private AllServiceFacade allService;

	public AllServiceFacade getAllService() {
		return allService;
	}

	public void setAllService(AllServiceFacade allService) {
		this.allService = allService;
	}

	public void setServlet(ActionServlet actionServlet) {
		super.setServlet(actionServlet);
		if (actionServlet != null) {
			ServletContext servletContext = actionServlet.getServletContext();
			WebApplicationContext wac = WebApplicationContextUtils
					.getRequiredWebApplicationContext(servletContext);
			this.allService = (AllServiceFacade) wac.getBean("allService");
		}
	}
}
