package com.video.web.struts.search;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.KeywordChannel;
import com.video.web.struts.BaseAction;

public class KeywordChannelOrderAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String flag = request.getParameter("flag");
		String url = "init";
		if (flag != null && !flag.trim().isEmpty()) {
			String[] keywordChannelIds = request
					.getParameterValues("keywordChannels");
			Long id = null;
			KeywordChannel keywordChannel = null;
			for (int i = 0; i < keywordChannelIds.length; i++) {
				id = Long.parseLong(keywordChannelIds[i]);
				keywordChannel = new KeywordChannel();
				keywordChannel.setId(id);
				keywordChannel.setOrders(i);
				getAllDao().updateKeywordChannelWithOrder(keywordChannel);
			}
			url = "success";
		} else {
			List<KeywordChannel> keywordChannelList = getAllDao()
					.getKeywordChannels();
			request.setAttribute("keywordChannelList", keywordChannelList);
		}
		return mapping.findForward(url);
	}
}
