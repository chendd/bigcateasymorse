package com.video.web.struts.vblog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Daily;
import com.video.domain.DailyHistory;
import com.video.domain.GroupHistory;
import com.video.domain.User;
import com.video.web.struts.BaseAction;

public class ShowDailyAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String strId = request.getParameter("id");
		Long id = new Long(0);
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("sessionUser");
		if(strId!=null && !strId.trim().isEmpty()){
			try{
				id = Long.parseLong(strId);
			}
			catch (Exception e) {
				
			}
		}
		Daily daily = getAllService().getDailyById(id);
		if(daily != null){
			if(user!=null){
			
				DailyHistory dailyHistory = new DailyHistory();
				dailyHistory.setVisiter(user);
				dailyHistory.setDaily(daily);
				getAllService().createOrUpdateDailyHistory(dailyHistory);
				
			}
		}
		if(daily!=null){
			User user2 = getAllService().getUser2ById(daily.getUser().getId());
			daily.setUser(user2);
			request.setAttribute("daily", daily);
			return mapping.findForward("success");
		}
		
		return mapping.findForward("error");
	}

}
