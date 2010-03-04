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
import com.video.util.UtilMethod;
import com.video.web.struts.BaseAction;

public class MySendBoxAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		User user =(User) session.getAttribute("sessionUser");
		int size = 10;
		int no=1;
		String pageNo = request.getParameter("no");
		if(pageNo!=null && !pageNo.trim().isEmpty()){
			no = UtilMethod.intFormat(pageNo);
		}
		
		Pagination<Whisper> pagination = new Pagination<Whisper>();
		pagination.setNo(no);
		pagination.setSize(size);
		Whisper whisper = new Whisper();
		whisper.setFromUser(user);
		pagination.setCondition(whisper);
		getAllService().getWhispers(pagination);
		request.setAttribute("pagination", pagination);
		
		
		
		
		return mapping.findForward("success");
	}

}
