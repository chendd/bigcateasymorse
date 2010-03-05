package com.video.web.struts.search;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.KeywordChannel;
import com.video.web.struts.BaseAction;

public class AddSearchChannelAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String name = request.getParameter("name");
		String flag = request.getParameter("flag");
		String url = "init";
		boolean boo = false;
		if (flag != null && !flag.trim().isEmpty()) {
			KeywordChannel keywordChannel = null;
			if (name != null && !name.trim().isEmpty()) {
				keywordChannel = getAllDao().getKeywordChannelByName(name);
				if (keywordChannel != null) {
					request.setAttribute("errors", "分类名已存在!");
					boo = true;
				}
			} else {
				request.setAttribute("errors", "分类名不能为空!");
				boo = true;
			}
			if (boo) {
				url = "error";
			} else {
				keywordChannel = new KeywordChannel();
				keywordChannel.setName(name);
				getAllDao().createKeywordChannel(keywordChannel);
				url = "success";
			}
		}
		return mapping.findForward(url);
	}
}
