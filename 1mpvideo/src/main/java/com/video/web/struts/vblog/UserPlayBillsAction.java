package com.video.web.struts.vblog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONArray;
import org.json.JSONObject;

import com.video.domain.Playbill;
import com.video.domain.User;
import com.video.util.Pagination;
import com.video.web.struts.BaseAction;

public class UserPlayBillsAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		User user;
		 String strId = request.getParameter("id");
		    Long id;
		    if(strId!=null&&!strId.trim().isEmpty()){
		    	id = Long.parseLong(strId);
		    	user = getAllService().getUserById(id);
		    
		    }
		    else{
		    	HttpSession session = request.getSession();
		    	user = (User)session.getAttribute("sessionUser");
		    }
			String strPageSize = request.getParameter("size");
			String strPageNo = request.getParameter("no");
			int pageSize = 16;
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
			Pagination<Playbill> pagination = new Pagination<Playbill>();
		
		
			pagination.setSize(pageSize);
			pagination.setNo(pageNo);
			pagination.setCondition(user);
			getAllService().getMyPlaybill(pagination);
		
	request.setAttribute("pagination", pagination);
		return mapping.findForward("success");
	}

}
