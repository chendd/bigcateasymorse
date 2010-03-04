package com.video.web.struts.video;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.User;
import com.video.domain.Video;
import com.video.util.Pagination;
import com.video.util.SomeStatic;
import com.video.util.UtilMethod;
import com.video.web.struts.BaseAction;

public class GetMyCommentVideoAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String pageNo = request.getParameter("pageNo");
		int no = UtilMethod.intFormat(pageNo);
		User user = (User) request.getSession().getAttribute("sessionUser");
		Pagination<Video> pagination = new Pagination<Video>();
		pagination.setCondition(user);
		pagination.setNo(no);
		pagination.setSize(SomeStatic.VIDEO_MYCOMMENTVIDEO_PAGESIZE);

		getAllService().getMyCommentVideo(pagination);

		JSONObject object = JSONObject.fromObject(pagination);

		response.getWriter().print(object);

		return null;
	}
}
