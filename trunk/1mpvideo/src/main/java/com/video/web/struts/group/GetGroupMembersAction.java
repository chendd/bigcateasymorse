package com.video.web.struts.group;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Group;
import com.video.domain.GroupAndUser;
import com.video.util.Pagination;
import com.video.util.UtilMethod;
import com.video.web.struts.BaseAction;

public class GetGroupMembersAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String url = request.getParameter("url");
		String strId = request.getParameter("id");
		String orderFieldName ="x.add_date";
		Long id = new Long (0);
		int no = 1;
		int size = 5;
		if(strId!=null && !strId.trim().isEmpty()){
			id = UtilMethod.longFormat(strId);
			Group group = getAllService().getGroupById(id);
			if(group!=null){
				
			
			String order = request.getParameter("order");
			if(order!=null && !order.trim().isEmpty()){
				if(order.equals("x.add_date")||order.equals("x.rate")||order.equals("u.id")){
					orderFieldName = order;
				}
				
			}
			String pageNo = request.getParameter("pageNo");
			String pageSize = request.getParameter("pageSize");
			if(pageNo!=null&&!pageNo.trim().isEmpty()){
				no = UtilMethod.intFormat(pageNo)==0?no:UtilMethod.intFormat(pageNo);
			}
			if(pageSize!=null&&!pageSize.trim().isEmpty()){
				size = UtilMethod.intFormat(pageSize)==0?size:UtilMethod.intFormat(pageSize);
			}
			
			Pagination<GroupAndUser> pagination = new Pagination<GroupAndUser>();
			pagination.setNo(no);
			pagination.setSize(size);
			
			if(orderFieldName !=null && !orderFieldName.trim().isEmpty()){
				pagination.setOrderFieldName(orderFieldName);
			}
			GroupAndUser groupAndUser = new GroupAndUser();
			groupAndUser.setGroup(group);
			groupAndUser.setRate(1);
			pagination.setCondition(groupAndUser);
			getAllService().getMyGroupMembers(pagination);
			request.setAttribute("pagination", pagination);
			request.setAttribute("order", orderFieldName);
			request.setAttribute("pageSize", size);
			request.setAttribute("group", group);
			
			
			
			Pagination<GroupAndUser> pagination2 = new Pagination<GroupAndUser>();
			pagination2.setNo(1);
			pagination2.setSize(5);
			pagination2.setCondition(groupAndUser);
			getAllService().getGroupAdmins(pagination2);
			request.setAttribute("admins", pagination2);
			
			}
		
		}
		return mapping.findForward("success");
	}
}
