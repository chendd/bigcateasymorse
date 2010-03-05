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

public class AddKeywordAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String flag = request.getParameter("flag");
		String ids = request.getParameter("id");
		String action = request.getParameter("action");
		Long id = null;
		KeywordChannel keywordChannel = null;
		String url = "init";
		request.setAttribute("action", action);
		if (flag != null && !flag.trim().isEmpty()) {
			if (action != null & !action.trim().isEmpty()) {
				url = "keywordIndex";
			} else {
				url = "success";
			}
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
			systemKeyword.setName(name);
			systemKeyword.setChannelId(channelId);
			systemKeyword.setViewTimes(viewTimes);
			getAllDao().createSystemKeyword(systemKeyword);
		} else {
			List<KeywordChannel> keywordChannelList = getAllDao()
					.getKeywordChannels();
			if (ids != null && !ids.trim().isEmpty()) {
				id = Long.parseLong(ids);
				keywordChannel = getAllDao().getKeywordChannel(id);
				request.setAttribute("keywordChannel", keywordChannel);
			}
			request.setAttribute("keywordChannelList", keywordChannelList);
		}
		
		return mapping.findForward(url);
	}
}
