package com.video.web.struts.search;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.web.struts.BaseAction;

public class DeleteKeywordAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String ids = request.getParameter("id");
		String[] idsArray = request.getParameterValues("keywordIds");
		Long id = null;
		if (ids != null && !ids.trim().isEmpty()) {
			id = Long.parseLong(ids);
			getAllDao().deleteSystemKeyword(id);
		} else {
			for (int i = 0; i < idsArray.length; i++) {
				id = Long.parseLong(idsArray[i]);
				getAllDao().deleteSystemKeyword(id);
			}
		}

		return mapping.findForward("success");
	}
}
