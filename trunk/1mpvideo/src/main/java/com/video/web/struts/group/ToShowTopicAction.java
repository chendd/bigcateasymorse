package com.video.web.struts.group;

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

public class ToShowTopicAction extends BaseAction{
	
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		String strId = request.getParameter("id");
		if(strId!=null && !strId.trim().isEmpty() ){
			Long id = new Long(0);
			try{
				id = Long.parseLong(strId);
			}
			catch (Exception e) {
				
			}
			Topic topic = getAllService().getTopicById(id);
			if(topic!=null){
				Group group = getAllService().getGroupSimpleById(topic.getGroup().getId());
			
				topic.setGroup(group);
				request.setAttribute("topic", topic);
				
				Pagination<Topic> pagination = new Pagination<Topic>();
				pagination.setNo(1);
				pagination.setSize(10);
				pagination.setCondition(group);
				pagination.setOrderFieldName("t.add_date");
				getAllService().getTopicesByGroupId(pagination);
				request.setAttribute("topices", pagination.getResults());
				
				
			
				
			}
			
			
		}
		

		
		return mapping.findForward("success");
	}

}
