package com.video.web.struts.search;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.SystemKeyword;
import com.video.web.struts.BaseAction;

public class UpdateSystemKeywordAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String ids = request.getParameter("id");
		String flag = request.getParameter("flag");
		Long id = null;
		String url = "init";
		if (ids != null && !ids.trim().isEmpty()) {
			id = Long.parseLong(ids);
		}
		if (flag != null && !flag.trim().isEmpty()) {
			String name = request.getParameter("name");
			String channelIds = request.getParameter("channelId");
			String viewTimess = request.getParameter("viewTimes");

			Long channelId = null;
			int viewTimes = 0;
			if (channelIds != null && !channelIds.trim().isEmpty()) {
				channelId = Long.parseLong(channelIds);
			}
			if (viewTimess != null && !viewTimess.trim().isEmpty()) {
				try {
					viewTimes = Integer.parseInt(viewTimess);
				} catch (Exception e) {
					viewTimes = 0;
				}
			}
			SystemKeyword systemKeyword = new SystemKeyword();
			systemKeyword.setId(id);
			systemKeyword.setName(name);
			systemKeyword.setChannelId(channelId);
			systemKeyword.setViewTimes(viewTimes);
			getAllDao().updateSystemKeyword(systemKeyword);
			url = "success";
		} else {
			SystemKeyword systemKeyword = getAllDao().getSystemKeywordById(id);
			request.setAttribute("keyword", systemKeyword);
		}

		return mapping.findForward(url);
	}
}
