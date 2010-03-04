package com.video.web.struts.videotag;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Tag;
import com.video.domain.User;
import com.video.util.Pagination;
import com.video.util.SomeStatic;
import com.video.web.struts.BaseAction;

public class GetMyVideoTagAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		User user = (User) request.getSession().getAttribute("sessionUser");
		
		Tag tag = new Tag();
		tag.setUser(user);
		
		Pagination<Tag> pagination = new Pagination<Tag>();
		pagination.setSize(SomeStatic.VIDEOTAG_MY_PAGESIZE);
		pagination.setNo(1);
		pagination.setCondition(tag);
		
		
		List<Tag> tagList = getAllService().getMyVideoTag(pagination);
		JSONArray jsonArray = JSONArray.fromObject(tagList);
		response.getWriter().print(jsonArray);
		return null;
	}
}
