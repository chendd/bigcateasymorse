package com.video.web.struts.vblog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.util.UtilMethod;
import com.video.web.struts.BaseAction;

public class DeleteDailyCommentAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String strId = request.getParameter("id");
		if(strId!=null&&!strId.trim().isEmpty()){
			Long id = UtilMethod.longFormat(strId);
			if(!id.equals(new Long(0))){
				getAllService().deleteDailyCommentById(id);
				response.getWriter().print("ok");
			}
		}
		return null;
	}

}
