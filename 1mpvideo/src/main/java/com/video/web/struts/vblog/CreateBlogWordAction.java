package com.video.web.struts.vblog;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.BlogWord;
import com.video.domain.User;
import com.video.web.struts.BaseAction;

public class CreateBlogWordAction extends BaseAction{
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
				if(getAllService().getUserById(id)!=null){
					BlogWord blogWord = new BlogWord();
					User user =new User();
					user.setId(id);
					HttpSession session = request.getSession();
					User writer = (User)session.getAttribute("sessionUser");
				
					blogWord.setUser(user);
					blogWord.setWriter(writer);
					blogWord.setWords(word);
					blogWord.setAddDate(new Date());
					getAllService().createBlogWord(blogWord);
					response.getWriter().print("ok");
				}
			}
			catch (Exception e) {
				
			}
			
			
		}
		return null;
	}

}
