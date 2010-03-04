package com.video.web.struts.vblog;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONArray;
import org.json.JSONObject;

import com.video.domain.Daily;
import com.video.domain.DailyComment;
import com.video.util.Pagination;
import com.video.web.struts.BaseAction;

public class GetDailyCommentsAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String strId = request.getParameter("id");
		Long id = new Long(0);
		if(strId!=null && !strId.trim().isEmpty()){
			try{
				id = Long.parseLong(strId);
			}
			catch (Exception e) {
				
			}
		}
		
		int pageSize = 5;
		int pageNo = 1;
		String strPageNo = request.getParameter("pageNo");
		if(strPageNo!=null && !strPageNo.trim().isEmpty()){
			try{
				pageNo = Integer.parseInt(strPageNo);
			}
			catch (Exception e) {
			
			}
			
			
		}
		Daily daily = new Daily();
		daily.setId(id);
		DailyComment dailyComment = new DailyComment();
		dailyComment.setDaily(daily);
		Pagination<DailyComment> pagination = new Pagination<DailyComment>();
		pagination.setNo(pageNo);
		pagination.setSize(pageSize);
		pagination.setCondition(dailyComment);
		getAllService().getDailyComment(pagination);
	
		if(pagination.getResults()!=null){
			
			
			JSONObject result = new JSONObject();
		
			JSONArray jsonComments = new JSONArray();
	
			for(DailyComment comment: pagination.getResults()){
				 JSONObject jsonComment = new JSONObject();
				 jsonComment.put("id", comment.getId());
				 jsonComment.put("comment", comment.getComment());
				 jsonComment.put("addDate", new SimpleDateFormat("hh:mm:ss").format(comment.getAddDate()));
				 jsonComment.put("userId", comment.getUser().getId());
				 jsonComment.put("realName", comment.getUser().getRealName());
				 jsonComment.put("userFace", comment.getUser().getFace());
	
				 jsonComments.put(jsonComment);
		
			}
			
			result.put("results", jsonComments);
			if(pagination.isNext()){
				result.put("isNext", pagination.isNext());
				
			}
			if(pagination.isPrevious()){
				result.put("isPrevious", pagination.isPrevious());
			}
			result.put("no", pagination.getNo());
			result.put("pageSum", pagination.getPageSum());
			String jsonResult = result.toString();
			response.getWriter().print(jsonResult);
			}
		return null;
	}

}
