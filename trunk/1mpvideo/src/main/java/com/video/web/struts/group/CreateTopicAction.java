package com.video.web.struts.group;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Event;
import com.video.domain.Group;
import com.video.domain.Topic;
import com.video.domain.User;
import com.video.util.UtilMethod;
import com.video.web.struts.BaseAction;

public class CreateTopicAction extends BaseAction{
	

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("sessionUser");
		
			String strId = request.getParameter("id");
			String title = request.getParameter("title");
			String text = request.getParameter("otext1");
			if(strId!=null && !strId.trim().isEmpty()&& title!=null && !title.trim().isEmpty()&& text!=null && !text.trim().isEmpty()){
				Long id = UtilMethod.longFormat(strId);
				if(!id.equals(new Long(0))){
				
					Group group = new Group();
					group.setId(id);
					Topic topic = new Topic();
					topic.setUser(user);
					topic.setGroup(group);
					topic.setTitle(title);
					topic.setAddDate(new Date());
					topic.setBrowseCount(0);
					topic.setText(text);
					getAllService().createTopic(topic);
					
				
				}
			}
			response.sendRedirect(request.getContextPath()+"/group/"+strId+"/topiclist/");
			return null;
		
		
	}

}
