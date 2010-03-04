package com.video.web.struts.group;

import java.text.MessageFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Topic;
import com.video.util.UtilMethod;
import com.video.web.struts.BaseAction;

public class UpdateTopicAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String strId = request.getParameter("id");
		String title = request.getParameter("title");
		String otext1 = request.getParameter("otext1");
		String otext2 = request.getParameter("otext2");
		if(strId!=null && !strId.trim().isEmpty()){
			Long id = UtilMethod.longFormat(strId);
			if(!id.equals(new Long(0))){
				
				Topic topic = new Topic();
				topic.setId(id);
				topic.setTitle(title);
				topic.setText(otext1);
				topic.setText2(otext2);
				getAllService().updateTopic(topic);
			}
		}
		return new ActionForward(MessageFormat.format("{0}{1}/", mapping
				.findForward("success").getPath(), strId), true);
	
	}

}
