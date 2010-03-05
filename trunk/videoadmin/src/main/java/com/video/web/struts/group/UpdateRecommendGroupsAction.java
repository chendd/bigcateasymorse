package com.video.web.struts.group;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Group;
import com.video.web.struts.BaseAction;

public class UpdateRecommendGroupsAction extends BaseAction{
	
	
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<Group> groups = new ArrayList<Group>();
		String groupId1 = request.getParameter("group1");
		String groupId2 = request.getParameter("group2");
		String groupId3 = request.getParameter("group3");
		String groupId4 = request.getParameter("group4");
		long dateTime = new Date().getTime();
		if(groupId1!=null&&!groupId1.trim().isEmpty()){
			try{
				Long id1 = Long.parseLong(groupId1);
				Group group1 = new Group();
				group1.setId(id1);
				group1.setRecommendDate(new Date(dateTime));
				groups.add(group1);
			}
			catch(Exception e){
			}
		}
		
		if(groupId2!=null&&!groupId2.trim().isEmpty()){
			try{
				Long id2 = Long.parseLong(groupId2);
				Group group2 = new Group();
				group2.setId(id2);
				group2.setRecommendDate(new Date(dateTime+1000));
				groups.add(group2);
			}
			catch(Exception e){
			}
		}
		
		if(groupId3!=null&&!groupId3.trim().isEmpty()){
			try{
				Long id3 = Long.parseLong(groupId3);
				Group group3 = new Group();
				group3.setId(id3);
				group3.setRecommendDate(new Date(dateTime+2000));
				groups.add(group3);
			}
			catch(Exception e){
			}
		}
		
		if(groupId4!=null&&!groupId4.trim().isEmpty()){
			try{
				Long id4 = Long.parseLong(groupId4);
				Group group4 = new Group();
				group4.setId(id4);
				group4.setRecommendDate(new Date(dateTime+3000));
				groups.add(group4);
			}
			catch(Exception e){
			}
		}
		
		
		 getAllDao().updateRecommendGroups(groups);

		return mapping.findForward("success");
	}

}
