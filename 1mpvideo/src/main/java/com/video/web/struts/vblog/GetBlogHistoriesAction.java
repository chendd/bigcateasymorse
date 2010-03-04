package com.video.web.struts.vblog;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONArray;
import org.json.JSONObject;

import com.video.domain.BlogHistory;
import com.video.domain.User;
import com.video.util.Pagination;
import com.video.web.struts.BaseAction;

public class GetBlogHistoriesAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Pagination<BlogHistory> pagination = new Pagination<BlogHistory>();
		int pageNo = 1;
		int pageSize = 20;
		String strPageNo = request.getParameter("pageNo");
		String strPageSize = request.getParameter("pageSize");
		if(strPageNo!=null && !strPageNo.trim().isEmpty()){
			try{
				pageNo = Integer.parseInt(strPageNo);
			}
			catch (Exception e) {
			
			}
		}
		if(strPageSize!=null && !strPageSize.trim().isEmpty()){
			try{
				pageSize = Integer.parseInt(strPageSize);
			}
			catch (Exception e) {
			
			}
		}
		pagination.setNo(pageNo);
		pagination.setSize(pageSize);
		String strId = request.getParameter("id");
		if(strId!=null && !strId.trim().isEmpty()){
			try{
				Long id = Long.parseLong(strId);
				User user = new User();
				user.setId(id);
				BlogHistory blogHistory = new BlogHistory();
				blogHistory.setUser(user);
				pagination.setCondition(blogHistory);
			}
			catch (Exception e) {
				
			}
		}
		getAllService().getBlogHistories(pagination);
		if(pagination.getResults()!=null){
			JSONObject result = new JSONObject();
			
			JSONArray jsonHistories = new JSONArray();
	
			for(BlogHistory history: pagination.getResults()){
				 JSONObject jsonHistroy = new JSONObject();
				 jsonHistroy.put("userId", history.getVisiter().getId());
				 jsonHistroy.put("realName", history.getVisiter().getRealName());
				 jsonHistroy.put("userFace", history.getVisiter().getFace());
				 jsonHistroy.put("visitDate", new SimpleDateFormat("hh:mm:ss").format(history.getVisitDate()));
			
				 jsonHistories.put(jsonHistroy);
			}
			
			result.put("results", jsonHistories);
			String jsonResult = result.toString();
			System.out.println(jsonResult);
			response.getWriter().print(jsonResult);
			
			
		}
		return null;
	}

}
