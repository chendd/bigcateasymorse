package com.video.web.struts.vblog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONArray;
import org.json.JSONObject;

import com.video.domain.User;
import com.video.domain.Video;
import com.video.util.Pagination;
import com.video.web.struts.BaseAction;

public class GetMyVideoesAction extends BaseAction{
	
@Override
public ActionForward execute(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {
	User user ;
	 String strId = request.getParameter("id");
	    Long id;
	    if(strId!=null&&!strId.trim().isEmpty()){
	    	id = Long.parseLong(strId);
	    	user = new User();
	    	user.setId(id);
	    }
	    else{
	    	HttpSession session = request.getSession();
	    	user = (User)session.getAttribute("sessionUser");
	    }
		String strPageSize = request.getParameter("pageSize");
		String strPageNo = request.getParameter("pageNo");
		int pageSize = 8;
		int pageNo = 1;
		if(strPageSize!=null && !strPageSize.trim().isEmpty()){
			try{
				pageSize = Integer.parseInt(strPageSize);
			}
			catch (Exception e) {
			
			}
		}
		if(strPageNo!=null && !strPageNo.trim().isEmpty()){
			try{
				pageNo = Integer.parseInt(strPageNo);
			}
			catch (Exception e) {
			
			}
		}
		Pagination<Video> pagination = new Pagination<Video>();
		Video video = new Video();
	
		video.setUser(user);
		pagination.setSize(pageSize);
		pagination.setNo(pageNo);
		pagination.setCondition(video);
		pagination.setOrderFieldName("v.add_date");
		getAllService().getVideoes(pagination);
if(pagination.getResults()!=null){
				
			
			JSONObject result = new JSONObject();
		
			JSONArray jsonVideoes = new JSONArray();
	
			for(Video video2: pagination.getResults()){
				 JSONObject jsonVideo = new JSONObject();
				 jsonVideo.put("id", video2.getId());
				 jsonVideo.put("name", video2.getName());
				 jsonVideo.put("image", video2.getImage());
				 jsonVideo.put("browseCount", video2.getBrowseCount());
				 jsonVideo.put("commentCount", video2.getCommentCount());
				 jsonVideoes.put(jsonVideo);
		
			}
			result.put("results", jsonVideoes);
	
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
