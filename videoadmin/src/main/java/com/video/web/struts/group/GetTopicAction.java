package com.video.web.struts.group;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONArray;
import org.json.JSONObject;

import com.video.domain.Topic;
import com.video.domain.TopicComment;
import com.video.web.struts.BaseAction;

public class GetTopicAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setCharacterEncoding("UTF-8");
		String type = request.getParameter("type");
	
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
		if(type!=null){
			if("getComm".equals(type)){
				JSONObject result = new JSONObject();
				JSONArray comments = new JSONArray();
				
				for(TopicComment comment:topic.getComments()){
					 JSONObject jsonComment = new JSONObject();
					 jsonComment.put("id", comment.getId());
					 jsonComment.put("comment", comment.getComment());
					
					 jsonComment.put("commentDate", new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss").format(comment.getCommentDate()));
					 comments.put(jsonComment);
				}
				result.put("results", comments);
				result.put("id", id);
				String jsonResult = result.toString();
				response.getWriter().print(jsonResult);
				
			}
	if("del".equals(type)){
		
		String uids = request.getParameter("uids");
		String[] sids = uids.split(",");
		for(String sid:sids){
			Long cId = Long.parseLong(sid);
			getAllDao().deleteTopicComment(cId);
			
		}
		response.getWriter().print("ok");
			}
	if("showText".equals(type)){
		request.setAttribute("topic", topic);
	
		return mapping.findForward("text");
		
				}
			
			
			return null;
		}
		else{
			
			request.setAttribute("topic", topic);

			return mapping.findForward("success");
			
			
		}
	}
	

}
