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
import com.video.util.Pagination;
import com.video.web.struts.BaseAction;

public class MyBoxAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		User user =(User) session.getAttribute("sessionUser");
		int size = 10;
		int no=1;
		Pagination<Whisper> pagination1 = new Pagination<Whisper>();
		pagination1.setNo(no);
		pagination1.setSize(size);
		Whisper whisper = new Whisper();
		whisper.setToUser(user);
		pagination1.setCondition(whisper);
		getAllService().getWhispers(pagination1);
		request.setAttribute("pagination1", pagination1);
		
		
		
		Pagination<SystemNotice> pagination2 = new Pagination<SystemNotice>();
		pagination2.setNo(no);
		pagination2.setSize(size);
		SystemNotice systemNotice = new SystemNotice();
		systemNotice.setUser(user);
		pagination2.setCondition(systemNotice);
		getAllService().getSystemNoticesByUserId(pagination2);
		request.setAttribute("pagination2", pagination2);
		
		return mapping.findForward("success");
	}

}
