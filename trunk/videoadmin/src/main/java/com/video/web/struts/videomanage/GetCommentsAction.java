package com.video.web.struts.videomanage;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONArray;
import org.json.JSONObject;

import com.video.domain.Comment;
import com.video.domain.Group;
import com.video.util.Pagination;
import com.video.util.SomeStatic;
import com.video.web.struts.BaseAction;

public class GetCommentsAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String type = request.getParameter("type");
		if(type!=null){
			String strId = request.getParameter("id");
			Long vid = new Long(0);
			if (strId != null && !strId.trim().isEmpty()) {
				try {
					vid = Long.parseLong(strId);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
			List<Comment> comments = getAllDao().getCommentsByVideoId(vid);
			
			if("getComm".equals(type)){
				response.setCharacterEncoding("UTF-8");
				JSONObject result = new JSONObject();
				JSONArray jsonComments = new JSONArray();
				
				for(Comment comment:comments){
					 JSONObject jsonComment = new JSONObject();
					 jsonComment.put("id", comment.getId());
					 jsonComment.put("comment", comment.getComment());
					
					 jsonComment.put("commentDate", new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss").format(comment.getCommentDate()));
					 jsonComments.put(jsonComment);
				}
				result.put("results", jsonComments);
				result.put("id", vid);
				String jsonResult = result.toString();
				response.getWriter().print(jsonResult);
				
			}
			
			if("del".equals(type)){
				System.out.println("dd");
				String uids = request.getParameter("uids");
				String[] sids = uids.split(",");
				for(String sid:sids){
					
					Long cId = Long.parseLong(sid);
					getAllDao().deleteComment(cId);
					
				}
				response.getWriter().print("ok");
					}
			return null;
		}
		else{
			
			int pageSize = 10;
			int pageNo = 1;
			String str_pageNo = request.getParameter("pageNo");
			if(str_pageNo!=null){
				pageNo = Integer.parseInt(str_pageNo);
			}
			Pagination<Comment> pagination = new Pagination<Comment>();
			pagination.setNo(pageNo);
			pagination.setSize(pageSize);
			getAllDao().getComments(pagination);

			request.setAttribute("pagination", pagination);
			
			return mapping.findForward("success");
		}
		
	}

}
