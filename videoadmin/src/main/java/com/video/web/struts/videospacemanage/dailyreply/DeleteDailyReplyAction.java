package com.video.web.struts.videospacemanage.dailyreply;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.web.struts.BaseAction;

public class DeleteDailyReplyAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String ids = request.getParameter("id");
		Long id = null;

		if (ids != null && !ids.trim().isEmpty()) {
			id = Long.parseLong(ids);
			getAllDao().deleteDailyReplyById(id);
		} else {
			String[] idArray = request.getParameterValues("dailyReplyId");
			for (int i = 0; i < idArray.length; i++) {
				if (idArray[i] != null && !idArray[i].trim().isEmpty()) {
					id = Long.parseLong(idArray[i]);
					getAllDao().deleteDailyReplyById(id);
				}
			}
		}

		return mapping.findForward("success");
	}
}
