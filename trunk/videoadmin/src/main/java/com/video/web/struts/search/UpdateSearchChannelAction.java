package com.video.web.struts.search;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.KeywordChannel;
import com.video.web.struts.BaseAction;

public class UpdateSearchChannelAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String flag = request.getParameter("flag");
		String ids = request.getParameter("id");
		String name = request.getParameter("name");
		String url = "init";
		Long id = null;
		KeywordChannel keywordChannel = null;
		if (ids != null && !ids.trim().isEmpty()) {
			id = Long.parseLong(ids);
		}
		if (flag != null && !flag.trim().isEmpty()) {
			keywordChannel = new KeywordChannel();
			keywordChannel.setId(id);
			keywordChannel.setName(name);
			getAllDao().updateKeywordChannel(keywordChannel);
			url = "success";
		} else {
			keywordChannel = getAllDao().getKeywordChannel(id);
			request.setAttribute("keywordChannel", keywordChannel);
		}
		return mapping.findForward(url);
	}
}
