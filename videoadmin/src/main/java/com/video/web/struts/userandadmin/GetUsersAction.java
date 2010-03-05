package com.video.web.struts.userandadmin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Administrator;
import com.video.domain.User;
import com.video.util.Pagination;
import com.video.util.SomeStatic;
import com.video.web.struts.BaseAction;

public class GetUsersAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		int pageSize = 10;
		int pageNo = 1;
		String str_pageNo = request.getParameter("pageNo");
		
		if(str_pageNo!=null){
			pageNo = Integer.parseInt(str_pageNo);
		}
		Pagination<User> pagination = new Pagination<User>();
		pagination.setNo(pageNo);
		pagination.setSize(pageSize);
		String selectType = request.getParameter("selectType");
		if(selectType!=null){
			String keyword = request.getParameter("keyword");
			keyword = keyword.trim().isEmpty()?null:keyword;
			User user = new User();
			if("userName".equals(selectType)){
				user.setUserName(keyword);
			}
			if("realName".equals(selectType)){
				user.setRealName(keyword);
			}
			pagination.setCondition(user);
			
			getAllDao().getUsers(pagination);
			
			request.setAttribute("selectType", selectType);
			request.setAttribute("keyword", keyword);
		}
		else{
			
			
		
			
			getAllDao().getUsers(pagination);
		}
		

		request.setAttribute("pagination", pagination);
		
		
		return mapping.findForward("success");
	}

}
