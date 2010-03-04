package com.video.web.struts.vblog;

import java.util.Date;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.SubscribeUser;
import com.video.domain.User;
import com.video.util.UtilMethod;
import com.video.web.struts.BaseAction;

public class SubscribeUserAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("sessionUser");
		String suid = request.getParameter("suid");
	
		if(suid!=null&&!suid.trim().isEmpty()){
			String type = request.getParameter("type");
			Long sid = UtilMethod.longFormat(suid);
			User passiveUser = new User();
			passiveUser.setId(sid);
			SubscribeUser subscribeUser = new SubscribeUser();
			subscribeUser.setAddDate(new Date());
			subscribeUser.setUser(user);
			subscribeUser.setPassiveUser(passiveUser);
			if(type.equals("create")){
				
				getAllService().createSubscribe(subscribeUser);
				System.out.println("==============");
				
				
			}
			else if(type.equals("delete")){
				
				getAllService().deleteSubscribe(subscribeUser);
			}
			
			
		}
		response.sendRedirect(request.getContextPath()+"/home/"+suid+"/");
		return null;
				
	}

}
