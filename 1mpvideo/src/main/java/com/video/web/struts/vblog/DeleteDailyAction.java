package com.video.web.struts.vblog;

import java.text.MessageFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Daily;
import com.video.domain.User;
import com.video.util.UtilMethod;
import com.video.web.struts.BaseAction;

public class DeleteDailyAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("sessionUser");
		String strId = request.getParameter("id");
		if(strId!=null && !strId.trim().isEmpty()){
			Long id = UtilMethod.longFormat(strId);
			if(!id.equals(new Long(0))){
				
				Daily daily = getAllService().getDailyById(id);
				if(daily.getUser().getId().equals(user.getId())){
					getAllService().deleteDaily(id);
				}
				
				
			}
			
		}
		return new ActionForward(MessageFormat.format("{0}{1}/", mapping
				.findForward("success").getPath(),user.getId() ),true);
	}

}
