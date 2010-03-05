package com.video.web.struts.group;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Group;
import com.video.web.struts.BaseAction;

public class ToUpdateRecommendGroupsAction extends BaseAction{
	
	
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		List<Group> groups = new ArrayList<Group>();
		groups = getAllDao().getRecommendGroups();
		request.setAttribute("groups", groups);
		for(Group group:groups){
			System.out.println(group.getId());
		}
		return mapping.findForward("success");
	}

}
