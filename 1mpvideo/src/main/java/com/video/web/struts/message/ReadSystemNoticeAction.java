package com.video.web.struts.message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.SystemNotice;
import com.video.domain.User;
import com.video.domain.Whisper;
import com.video.util.UtilMethod;
import com.video.web.struts.BaseAction;

public class ReadSystemNoticeAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("sessionUser");
		//TODO 需要用户验证过滤
		String strId = request.getParameter("id");
		if(strId!=null &&!strId.trim().isEmpty()){
			Long id = UtilMethod.longFormat(strId);
			if(!id.equals(new Long(0))){
				SystemNotice systemNotice = getAllService().getSystemNoticeById(id);
				if(!systemNotice.getUser().getId().equals(user.getId())){
					return mapping.findForward("error");
				}
				
				
				request.setAttribute("systemNotice", systemNotice);
			
			}
		}
		return mapping.findForward("success");
	}

}
