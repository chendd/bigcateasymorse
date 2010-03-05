package com.video.web.struts.search;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.KeywordChannel;
import com.video.web.struts.BaseAction;

public class IndexSearchChannelAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<KeywordChannel> keywordChannelList = getAllDao()
				.getKeywordChannels();
		request.setAttribute("keywordChannelList", keywordChannelList);
		return mapping.findForward("success");
	}
}
