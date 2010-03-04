package com.video.web.struts.vblog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;



import com.video.domain.User;
import com.video.util.Pagination;
import com.video.web.struts.BaseAction;

public class GetMyFriendsAction extends BaseAction{
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		User user;
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
		int pageSize = 10;
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
		
		
		Pagination<User> pagination = new Pagination<User>();
		pagination.setCondition(user);
		pagination.setNo(pageNo);
		pagination.setSize(pageSize);
		
		 getAllService().getFriends(pagination);
		 
		 JSONObject object = JSONObject.fromObject(pagination);

			response.getWriter().print(object);

			return null;
	}

}
