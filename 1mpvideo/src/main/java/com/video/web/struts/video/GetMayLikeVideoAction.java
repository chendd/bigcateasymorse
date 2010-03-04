package com.video.web.struts.video;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.MayLikeVideo;
import com.video.web.struts.BaseAction;

public class GetMayLikeVideoAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<MayLikeVideo> list = getAllService().getMayLikeVideoes();
		JSONArray array = JSONArray.fromObject(list);
		response.getWriter().print(array);
		return null;
	}
}
