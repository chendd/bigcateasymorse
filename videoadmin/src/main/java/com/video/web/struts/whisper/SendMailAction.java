package com.video.web.struts.whisper;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.User;
import com.video.util.Pagination;
import com.video.util.SendMail;
import com.video.web.struts.BaseAction;

public class SendMailAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String title = request.getParameter("title");
		String message = request.getParameter("message");
		if(title!=null && !title.trim().isEmpty()&&message!=null&&!message.trim().isEmpty()){
			Pagination<User> pagination = new Pagination<User>();
			getAllDao().listUsers(pagination);
			List<String > emails = new ArrayList<String>();
			for(User user:pagination.getResults()){
				String email = user.getEmail();
				if(email.matches("\\w+(\\.\\w+)*@\\w+(\\.\\w+)+")){
					emails.add(email);
				}
				SendMail sendMail = new SendMail();
				sendMail.sendMessage(emails, title, message);
				}
				
			}
			
		
		return new ActionForward(MessageFormat.format("{0}?status=1", mapping
				.findForward("success").getPath()), true);
	}

}
