package com.video.web.struts.group;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Topic;
import com.video.web.struts.BaseAction;

public class UpdateTopicAction extends BaseAction{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String type = request.getParameter("type");
		String pageNo = request.getParameter("pageNo") == null ? "1" : request
				.getParameter("pageNo");
		
		if ("all".equals(type)) {
			String tp =request.getParameter("tp");
			String[] ids = request.getParameterValues("ids");
			List<Topic> topices = new ArrayList<Topic>();
			
			for (String sid : ids) {

				Long id = Long.parseLong(sid);
				topices.add(getAllDao().getTopicById(id));

			}
			if("lock".equals(tp)){
				for(Topic topic:topices){
					topic.setFlag(2);
					getAllDao().updateTopic(topic);
				}
			}
			if("delete".equals(tp)){
				for(Topic topic:topices){
					
					getAllDao().deleteTopic(topic.getId());
				}
			}

		}
		else {
			String strId = request.getParameter("id");
			Long id = new Long(0);
			if (strId != null && !strId.trim().isEmpty()) {
				try {
					id = Long.parseLong(strId);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
			Topic topic = getAllDao().getTopicById(id);
			if ("lock".equals(type)) {
				int flag = topic.getFlag();
			
				topic.setFlag(3 - flag);
				getAllDao().updateTopic(topic);

			}
			if ("delete".equals(type)) {
			
				getAllDao().deleteTopic(id);

			}
			if("one".equals(type)){
				
				String title = request.getParameter("title");
				String text = request.getParameter("text");
				String recommend = request.getParameter("recommend");
				String flag = request.getParameter("flag");
				topic.setTitle(title);
				topic.setText(text);
				topic.setRecommendDate("y".equals(recommend)?new Date():null);
				topic.setFlag("1".equals(flag)?1:2);
				getAllDao().updateTopic(topic);
				}
			
		}
		return new ActionForward(MessageFormat.format("{0}?pageNo={1}", mapping
				.findForward("success").getPath(), pageNo), true);
	
	}

}
