package com.video.web.struts.videomanage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.MayLikeVideo;
import com.video.web.struts.BaseAction;

public class GetMayLikeVideoesAction extends BaseAction{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<MayLikeVideo> mayLikeVideoes = getAllDao().getMayLikeVideoes();
		request.setAttribute("mayLikeVideoes", mayLikeVideoes);
		return mapping.findForward("success");
	}

}
