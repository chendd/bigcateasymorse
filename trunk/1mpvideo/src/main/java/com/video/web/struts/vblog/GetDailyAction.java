package com.video.web.struts.vblog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Daily;
import com.video.util.UtilMethod;
import com.video.web.struts.BaseAction;

public class GetDailyAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String strId  = request.getParameter("id");
		if(strId != null && !strId.trim().isEmpty()){
			Long id = UtilMethod.longFormat(strId);
			Daily daily = getAllService().getDailyById(id);
			if(daily!=null){
				response.getWriter().print(daily.getLog());
				
			}
			
		}

		return null;
	}

}
