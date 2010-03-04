package com.video.web.struts.message;

import java.text.MessageFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.User;
import com.video.domain.Whisper;
import com.video.util.UtilMethod;
import com.video.web.struts.BaseAction;

public class CreateWhisperAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		User user =(User) session.getAttribute("sessionUser");
	
			String strId = request.getParameter("id");
		
			String text = request.getParameter("text");
			if(strId!=null && !strId.trim().isEmpty()&&text!=null&&!text.trim().isEmpty()){
				Long id = UtilMethod.longFormat(strId);
				if(!id.equals(new Long(0))){
					User toUser = new User();
					toUser.setId(id);
					Whisper whisper = new Whisper();
					whisper.setFromUser(user);
					whisper.setToUser(toUser);
					whisper.setSendDate(new Date());
					whisper.setStatus(0);
					
					whisper.setMessage(text);
					getAllService().createWhisper(whisper);
					return mapping.findForward("success");
				}
			}
	
		return mapping.findForward("error");
	}

}
