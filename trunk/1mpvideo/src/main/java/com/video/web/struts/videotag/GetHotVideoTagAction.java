package com.video.web.struts.videotag;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Tag;
import com.video.web.struts.BaseAction;

public class GetHotVideoTagAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<Tag> tagList = getAllService().getHotVideoTag();
		JSONArray jsonArray = JSONArray.fromObject(tagList);
		response.getWriter().print(jsonArray);
		return null;
	}
}
