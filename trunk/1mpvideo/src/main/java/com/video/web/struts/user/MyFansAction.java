package com.video.web.struts.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.SubscribeUser;
import com.video.domain.User;
import com.video.util.Pagination;
import com.video.util.UtilMethod;
import com.video.web.struts.BaseAction;

public class MyFansAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("sessionUser");
		String type = request.getParameter("type");
		
		String pageNo = request.getParameter("pageNo");
		int size = 10;
		int no =  UtilMethod.intFormat(pageNo);
		Pagination<SubscribeUser> pagination = new Pagination<SubscribeUser>();
		if(user!=null){
			
			pagination.setSize(size);
			pagination.setNo(no);
			SubscribeUser subscribeUser = new SubscribeUser();
			if(type.equals("1")){
				subscribeUser.setUser(user);
				pagination.setCondition(subscribeUser);
				getAllService().getSubscibeUsers(pagination);
				for(SubscribeUser subscribeUser2:pagination.getResults()){
					subscribeUser2.setUser(subscribeUser2.getPassiveUser());
				}
			}
			else if(type.equals("2")){
				subscribeUser.setPassiveUser(user);
				pagination.setCondition(subscribeUser);
				getAllService().getSubscibeUsers(pagination);
			}
			
			
		}
		request.setAttribute("pagination", pagination);
		request.setAttribute("type", type);
		return mapping.findForward("success");
	}

}
