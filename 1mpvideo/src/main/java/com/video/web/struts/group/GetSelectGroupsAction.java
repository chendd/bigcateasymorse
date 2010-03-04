package com.video.web.struts.group;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Group;
import com.video.domain.Topic;
import com.video.util.Pagination;
import com.video.util.UtilMethod;
import com.video.web.struts.BaseAction;

public class GetSelectGroupsAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String keyword = request.getParameter("keyword");
		
		String pageNo = request.getParameter("no");
		int size = 20;
		int no = 1;
		if(pageNo!=null &&!pageNo.trim().isEmpty()){
			no = UtilMethod.intFormat(pageNo);
		}
		Pagination<Group> pagination = new Pagination<Group>();
		pagination.setNo(no);
		pagination.setSize(size);
		if(keyword!=null&&!keyword.trim().isEmpty()){
			Group group = new Group();
			group.setName(keyword);
			pagination.setCondition(group);
		}
		
		getAllService().getGroups(pagination);
		request.setAttribute("pagination", pagination);
		request.setAttribute("keyword", keyword);
		return mapping.findForward("success");
	}


}
