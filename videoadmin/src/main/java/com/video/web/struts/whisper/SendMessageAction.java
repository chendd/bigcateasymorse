package com.video.web.struts.whisper;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Whisper;
import com.video.util.Pagination;
import com.video.web.struts.BaseAction;

public class SendMessageAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Whisper whisper = new Whisper();
		
		whisper.setSendDate(new Date());
		Pagination<Whisper> pagination1 = new Pagination<Whisper>();
		Pagination<Whisper> pagination2 = new Pagination<Whisper>();
		pagination1.setCondition(whisper);
		getAllDao().getWhispers(pagination1);
		getAllDao().getWhispers(pagination2);
		request.setAttribute("pagination1", pagination1);
		request.setAttribute("pagination2", pagination2);
	
		return mapping.findForward("success");
	}

}
