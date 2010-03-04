package com.video.web.struts.vblog;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.BlogWord;
import com.video.domain.Daily;
import com.video.domain.DailyComment;
import com.video.domain.User;
import com.video.web.struts.BaseAction;

public class CreateDailyCommentAction extends BaseAction{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		response.setCharacterEncoding("UTF-8");
		String strId = request.getParameter("id");
		String word = request.getParameter("word");
		if(strId!=null&&!strId.trim().isEmpty()){
			try{
				Long id = Long.parseLong(strId);
				if(getAllService().getDailyById(id)!=null){
					DailyComment dailyComment = new DailyComment();
					Daily daily = new Daily();
					daily.setId(id);
					HttpSession session = request.getSession();
					User user = (User)session.getAttribute("sessionUser");
				
					dailyComment.setUser(user);
					dailyComment.setDaily(daily);
					dailyComment.setComment(word);
					dailyComment.setAddDate(new Date());
				
					getAllService().createDailyComment(dailyComment);
					
					response.getWriter().print("ok");
				}
			}
			catch (Exception e) {
				
			}
			
			
		}
		return null;
	}

}
