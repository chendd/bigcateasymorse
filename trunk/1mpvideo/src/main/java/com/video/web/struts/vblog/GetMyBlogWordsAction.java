package com.video.web.struts.vblog;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONArray;
import org.json.JSONObject;

import com.video.domain.BlogWord;
import com.video.domain.User;
import com.video.util.Pagination;
import com.video.web.struts.BaseAction;

public class GetMyBlogWordsAction extends BaseAction{
	
	
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
			int pageSize = 5;
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
			
			BlogWord blogWord = new BlogWord();
		
			blogWord.setUser(user);
			
			Pagination<BlogWord> pagination = new Pagination<BlogWord>();
			pagination.setCondition(blogWord);
			pagination.setNo(pageNo);
			pagination.setSize(pageSize);
		
			
			 getAllService().getBlogWords(pagination);
			 
			if(pagination.getResults()!=null){
				
			
			JSONObject result = new JSONObject();
		
			JSONArray jsonWords = new JSONArray();
	
			for(BlogWord word: pagination.getResults()){
				
				 JSONObject jsonWord = new JSONObject();
				 jsonWord.put("id", word.getId());
				 jsonWord.put("image", word.getWriter().getFace());
				 jsonWord.put("userId", word.getWriter().getId());
				 jsonWord.put("realName", word.getWriter().getRealName());
				 jsonWord.put("words", word.getWords());
				 jsonWord.put("addDate", new SimpleDateFormat("hh:mm:ss").format(word.getAddDate()));
				 
				 jsonWords.put(jsonWord);
			}
			result.put("results", jsonWords);
			result.put("pageSum", pagination.getPageSum());
			result.put("no", pagination.getNo());
			result.put("next", pagination.isNext());
			result.put("pre", pagination.isPrevious());
			result.put("recordSum", pagination.getRecordSum());
			String jsonResult = result.toString();
			response.getWriter().print(jsonResult);
			}
		return null;
	}

}
