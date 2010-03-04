package com.video.web.struts.videotag;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.TagStrongUser;
import com.video.util.SomeStatic;
import com.video.web.struts.BaseAction;

public class GetTagStrongUserAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<TagStrongUser> list = getAllService().getTagStrongUser(
				SomeStatic.TAGSTRONGUSER_SIZE);
		JSONArray array = JSONArray.fromObject(list);
		//System.out.println(array);
		response.getWriter().print(array);
		return null;
	}
}
