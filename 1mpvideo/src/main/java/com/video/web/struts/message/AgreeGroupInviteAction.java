package com.video.web.struts.message;

import java.text.MessageFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.SystemNotice;
import com.video.domain.User;
import com.video.util.UtilMethod;
import com.video.web.struts.BaseAction;

public class AgreeGroupInviteAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("sessionUser");
		String strId = request.getParameter("id");
		if(strId!=null && !strId.trim().isEmpty()){
			Long mid = UtilMethod.longFormat(strId);
			if(!mid.equals(new Long(0))){
				SystemNotice systemNotice = getAllService().getSystemNoticeById(mid);
				if(systemNotice != null && systemNotice.getUser().getId().equals(user.getId())){
					
						getAllService().agreeGroupInvite(systemNotice);
				
				
				}
				
			}
			
		}
		return new ActionForward(MessageFormat.format("{0}/{1}/", mapping
				.findForward("success").getPath(), strId), true);
	}

}
