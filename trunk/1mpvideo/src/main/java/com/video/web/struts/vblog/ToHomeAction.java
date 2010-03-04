package com.video.web.struts.vblog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.BlogHistory;
import com.video.domain.DailyHistory;
import com.video.domain.SubscribeUser;
import com.video.domain.User;
import com.video.web.struts.BaseAction;

public class ToHomeAction extends BaseAction{
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
		User user2 = getAllService().getUser2ById(id);
		if(user2 != null&&user!=null&&!user.getId().equals(user2.getId())){
		
			
				BlogHistory blogHistory = new BlogHistory();
				blogHistory.setVisiter(user);
				blogHistory.setUser(user2);
				getAllService().createOrUpdateBlogHistory(blogHistory);
				SubscribeUser subscribeUser = new SubscribeUser();
				subscribeUser.setUser(user);
				subscribeUser.setPassiveUser(user2);
				if(getAllService().getSubscribe(subscribeUser)==null){
					request.setAttribute("subscribeUser", false);
				}
				else{
					request.setAttribute("subscribeUser", true);
				}
				
			
		}
		else{
			request.setAttribute("subscribeUser", false);
		}
		request.setAttribute("user",user2);
		return mapping.findForward("success");
	}
	
	

}
