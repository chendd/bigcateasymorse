package com.video.web.struts.video;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Group;
import com.video.domain.User;
import com.video.domain.Video;
import com.video.util.Pagination;
import com.video.util.SomeStatic;
import com.video.util.UtilMethod;
import com.video.web.struts.BaseAction;

public class GetGroupBrowseHistoryAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String strId= request.getParameter("id");
		String pageNo = request.getParameter("pageNo");
		int no = UtilMethod.intFormat(pageNo);
		
		if(strId!=null && !strId.trim().isEmpty()){
			Long id = UtilMethod.longFormat(strId);
			Group group = new Group();
			group.setId(id);
			Pagination<Video> pagination = new Pagination<Video>();
			pagination.setCondition(group);
			pagination.setNo(no);
			pagination.setSize(4);

			getAllService().getBrowseHistoryByGroupId(pagination);

			JSONObject object = JSONObject.fromObject(pagination);

			response.getWriter().print(object);

		}
		
		return null;
	}
}
