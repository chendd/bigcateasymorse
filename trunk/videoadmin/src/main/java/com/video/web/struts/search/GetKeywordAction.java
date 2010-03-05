package com.video.web.struts.search;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.KeywordChannel;
import com.video.domain.SystemKeyword;
import com.video.web.struts.BaseAction;

public class GetKeywordAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String ids = request.getParameter("id");
		String flag = request.getParameter("flag");
		Long id = null;

		List<KeywordChannel> keywordChannelList = getAllDao()
				.getKeywordChannels();

		if (flag != null && !flag.trim().isEmpty()) {
			if (ids != null && !ids.trim().isEmpty()) {
				id = Long.parseLong(ids);
			}
		} else {
			if (keywordChannelList != null && keywordChannelList.size() > 0) {
				id = keywordChannelList.get(0).getId();
			}
		}

		List<SystemKeyword> keywordList = null;
		if (id != null) {
			keywordList = getAllDao().getSystemKeywordByChannelId(id);
		}

		request.setAttribute("keywordList", keywordList);
		request.setAttribute("keywordChannelList", keywordChannelList);
		request.setAttribute("keywordChannelId", id);

		return mapping.findForward("success");
	}
}
