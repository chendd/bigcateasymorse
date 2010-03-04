package com.video.web.struts.group;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Group;
import com.video.domain.GroupAndUser;
import com.video.domain.GroupHistory;
import com.video.domain.Playbill;
import com.video.domain.User;
import com.video.domain.Video;
import com.video.util.Pagination;
import com.video.web.struts.BaseAction;

public class ToShowGroupAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("sessionUser");
		String strId = request.getParameter("id");
		
		if(strId != null && !strId.trim().isEmpty()){
			
			Long id = new Long(0);
			try{
				id = Long.parseLong(strId);
				
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			
			Group group = getAllService().getGroupById(id);
		
			if(group != null){
				if(user!=null){
				
					GroupHistory groupHistory = new GroupHistory();
					groupHistory.setVisiter(user);
					groupHistory.setGroup(group);
					getAllService().createOrUpdateGroupHistory(groupHistory);
					
				}
			
				request.setAttribute("group", group);
				Pagination<Video> pagination1 = new Pagination<Video>();
				pagination1.setNo(1);
				pagination1.setSize(8);
				pagination1.setCondition(group);
				pagination1.setOrderFieldName("v.add_date");
				getAllService().getVideoesByGroupId(pagination1);
				request.setAttribute("videoes", pagination1);
				
				
				Pagination<Playbill> pagination2 = new Pagination<Playbill>();
				pagination2.setNo(1);
				pagination2.setSize(4);
				pagination2.setCondition(group);
				getAllService().getPlayBillsByGroupId(pagination2);
				request.setAttribute("playBills", pagination2.getResults());
				
				Pagination<GroupAndUser> pagination3 = new Pagination<GroupAndUser>();
				pagination3.setNo(1);
				pagination3.setSize(6);
				GroupAndUser groupAndUser2 = new GroupAndUser();
				groupAndUser2.setGroup(group);
				pagination3.setCondition(groupAndUser2);
				pagination3.setOrderFieldName("x.add_date");
				getAllService().getMyGroupMembers(pagination3);
				request.setAttribute("members", pagination3);
				
				Pagination<GroupHistory> pagination4 = new Pagination<GroupHistory>();
				pagination4.setNo(1);
				pagination4.setSize(5);
				GroupHistory groupHistory = new GroupHistory();
				groupHistory.setGroup(group);
				pagination4.setCondition(groupHistory);
				getAllService().getGroupHistories(pagination4);
				request.setAttribute("histories", pagination4.getResults());
				
				if(user!=null){
					Pagination<GroupAndUser> pagination5 = new Pagination<GroupAndUser>();
					pagination5.setNo(1);
					pagination5.setSize(1);
					
					GroupAndUser groupAndUser = new GroupAndUser();
					groupAndUser.setUser(user);
					groupAndUser.setGroup(group);
					pagination5.setCondition(groupAndUser);
					getAllService().getMyJoinGroups(pagination5);
					
					if(pagination5.getResults()!=null){
						request.setAttribute("groupAndUser", pagination5.getResults().get(0));
					}
					
				}
				

				
				
				
				
			}
			
		}
		return mapping.findForward("success");
	}

}
