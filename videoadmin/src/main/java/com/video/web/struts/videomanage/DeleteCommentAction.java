package com.video.web.struts.videomanage;

import java.text.MessageFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.web.struts.BaseAction;

public class DeleteCommentAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String type = request.getParameter("type");
		String pageNo = request.getParameter("pageNo") == null ? "1" : request
				.getParameter("pageNo");
		
		if("one".equals(type)){
			String strId = request.getParameter("id");
			Long id = new Long(0);
			if(strId != null && !strId.trim().isEmpty()){
				
				id = Long.parseLong(strId);
				getAllDao().deleteComment(id);
			}
			
		}
		else{
			String[] ids = request.getParameterValues("ids");
			for (String sid : ids) {

				Long id = Long.parseLong(sid);
				getAllDao().deleteComment(id);

			}
		}
		return new ActionForward(MessageFormat.format("{0}?pageNo={1}", mapping
				.findForward("success").getPath(), pageNo), true);
	}

}
