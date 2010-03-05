package com.video.web.struts;

import javax.servlet.ServletContext;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionServlet;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.video.domain.logic.AllDaoFacade;

public abstract class BaseActionForm extends ActionForm {
	private AllDaoFacade allDao;

	public AllDaoFacade getAllDao() {
		return allDao;
	}

	public void setAllDao(AllDaoFacade allDao) {
		this.allDao = allDao;
	}

	public void setServlet(ActionServlet actionServlet) {
		super.setServlet(actionServlet);
		if (actionServlet != null) {
			ServletContext servletContext = actionServlet.getServletContext();
			WebApplicationContext wac = WebApplicationContextUtils
					.getRequiredWebApplicationContext(servletContext);
			this.allDao = (AllDaoFacade) wac.getBean("allDao");
		}
	}
}
