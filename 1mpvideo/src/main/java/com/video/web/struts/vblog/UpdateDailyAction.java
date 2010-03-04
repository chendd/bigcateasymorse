package com.video.web.struts.vblog;



import java.text.MessageFormat;
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

import com.video.domain.Daily;
import com.video.domain.Event;
import com.video.domain.Topic;
import com.video.domain.User;
import com.video.util.UtilMethod;
import com.video.web.struts.BaseAction;

public class UpdateDailyAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session =request.getSession();
		User user = (User)session.getAttribute("sessionUser");
		String title = request.getParameter("title");
		String otext1 = request.getParameter("otext1");
		String otext2 = request.getParameter("otext2");
		String cid = request.getParameter("channelId");
		
		Long channelId = UtilMethod.longFormat(cid);
		String strId = request.getParameter("id");
		Long id = UtilMethod.longFormat(strId);
		if(title==null || title.trim().isEmpty()||otext1==null || otext1.trim().isEmpty()||otext2==null || otext2.trim().isEmpty()){
			return mapping.findForward("error");
		}
		Daily daily = new Daily();
		daily.setId(id);
		daily.setChannelId(channelId);
		daily.setUserId(user.getId());
		daily.setTitle(title);
		daily.setLog(otext1);
		daily.setLog2(otext2);
		getAllService().updateDaily(daily);
		
		List<Topic> topics= getAllService().getTopicesByDaily(id);
		for(Topic topic:topics){
			topic.setTitle(title);
			topic.setText(otext1);
			getAllService().updateTopic(topic);
		}
		
		
		
		return new ActionForward(MessageFormat.format("{0}{1}/", mapping
				.findForward("success").getPath(), user.getId()), true);
	}

}
