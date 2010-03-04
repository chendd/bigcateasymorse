package com.video.web.struts.group;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Group;
import com.video.domain.GroupAndUser;
import com.video.domain.Topic;
import com.video.domain.User;
import com.video.util.Pagination;
import com.video.web.struts.BaseAction;

public class ToGroupIndexAction extends BaseAction{
	
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("sessionUser");
		if(user!=null){
			Pagination<GroupAndUser> pagination1 = new Pagination<GroupAndUser>();
			pagination1.setNo(1);
			pagination1.setSize(10);
			GroupAndUser groupAndUser1 = new GroupAndUser();
			groupAndUser1.setUser(user);
			pagination1.setCondition(groupAndUser1);
			getAllService().getMyJoinGroups(pagination1);
			request.setAttribute("myJoinGroups", pagination1.getResults());
			
			
			
			
			
			
			Pagination<GroupAndUser> pagination2 = new Pagination<GroupAndUser>();
			pagination2.setNo(1);
			pagination2.setSize(10);
			GroupAndUser groupAndUser2 = new GroupAndUser();
			groupAndUser2.setUser(user);
			groupAndUser2.setRate(3);
			pagination2.setCondition(groupAndUser2);
			getAllService().getMyJoinGroups(pagination2);
			request.setAttribute("myGroups", pagination2.getResults());
			
			
			Pagination<Topic> pagination5 = new Pagination<Topic>();
			pagination5.setNo(1);
			pagination5.setSize(10);
			pagination5.setOrderFieldName("t.add_date");
			Topic topic = new Topic();
			topic.setUser(user);
			pagination5.setCondition(topic);
			getAllService().getMyGroupTopices(pagination5);
			request.setAttribute("myGroupTopices", pagination5.getResults());
		}
		
		
		Pagination<Topic> pagination3 = new Pagination<Topic>();
		pagination3.setNo(1);
		pagination3.setSize(10);
		pagination3.setOrderFieldName("t.add_date");
		getAllService().getTopices(pagination3);
		request.setAttribute("newTopices", pagination3.getResults());
		Pagination<Topic> pagination4 = new Pagination<Topic>();
		pagination4.setNo(1);
		pagination4.setSize(10);
		pagination4.setOrderFieldName("t.browse_times");
		getAllService().getTopices(pagination4);
		request.setAttribute("hotTopices", pagination4.getResults());
		

		Pagination<Group> pagination6 = new Pagination<Group>();
		pagination6.setNo(1);
		pagination6.setSize(4);
		Group group = new Group();
		group.setRecommendDate(new Date());
		pagination6.setCondition(group);
		getAllService().getGroups(pagination6);
		request.setAttribute("recommendGroups", pagination6);
		
		Pagination<Group> pagination7 = new Pagination<Group>();
		pagination7.setNo(1);
		pagination7.setSize(10);
		pagination7.setOrderFieldName("g.activity");
		getAllService().getGroups(pagination7);
		request.setAttribute("hotGroups", pagination7);
		
		
		
		
	
		
		return mapping.findForward("success");
	}

}
