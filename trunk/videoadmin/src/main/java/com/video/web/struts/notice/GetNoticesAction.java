package com.video.web.struts.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.IndexRecommendVideo;
import com.video.domain.Notice;
import com.video.web.struts.BaseAction;

public class GetNoticesAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<Notice> notices = getAllDao().getNotices();
		request.setAttribute("notices", notices);
		return mapping.findForward("success");
	}

}
