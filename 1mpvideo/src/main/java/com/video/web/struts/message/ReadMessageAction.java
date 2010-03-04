package com.video.web.struts.message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Whisper;
import com.video.util.UtilMethod;
import com.video.web.struts.BaseAction;

public class ReadMessageAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//TODO 需要用户验证过滤
		String strId = request.getParameter("id");
		if(strId!=null &&!strId.trim().isEmpty()){
			Long id = UtilMethod.longFormat(strId);
			if(!id.equals(new Long(0))){
				Whisper whisper = getAllService().getWhisperById(id);
				request.setAttribute("whisper", whisper);
			
			}
		}
		return mapping.findForward("success");
	}

}
