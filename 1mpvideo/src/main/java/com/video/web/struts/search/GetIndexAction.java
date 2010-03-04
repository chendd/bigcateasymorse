package com.video.web.struts.search;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.KeywordChannel;
import com.video.domain.SystemKeywordChange;
import com.video.domain.SystemKeywordTerm;
import com.video.domain.UserKeyword;
import com.video.util.SomeStatic;
import com.video.web.struts.BaseAction;

public class GetIndexAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<KeywordChannel> key = getAllService().getKeywordChannelOrder();
		Map<KeywordChannel, List<SystemKeywordChange>> map = new LinkedHashMap<KeywordChannel, List<SystemKeywordChange>>();

		for (KeywordChannel keywordChannel : key) {
			SystemKeywordTerm term = new SystemKeywordTerm();
			term.setId(keywordChannel.getId());
			term.setSize(SomeStatic.SYSTEMKEYWORD_SIZE);
			List<SystemKeywordChange> value = getAllService()
					.getSystemKeywordWithForeFront(term);
			map.put(keywordChannel, value);
		}
		List<UserKeyword> userList = getAllService()
				.getUserSearchWithForeFront(SomeStatic.SYSTEMKEYWORD_SIZE);
		request.setAttribute("userList", userList);
		request.setAttribute("searchChannelMap", map);

		return mapping.findForward("success");
	}
}
