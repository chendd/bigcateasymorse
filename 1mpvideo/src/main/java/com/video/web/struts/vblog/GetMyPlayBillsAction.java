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

public class GetMyPlayBillsAction extends BaseAction{
	
	@Override
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
			Pagination<Playbill> pagination = new Pagination<Playbill>();
		
		
			pagination.setSize(pageSize);
			pagination.setNo(pageNo);
			pagination.setCondition(user);
			getAllService().getMyPlaybill(pagination);
		
	if(pagination.getResults()!=null){
					
				
				JSONObject result = new JSONObject();
			
				JSONArray jsonPlayBills = new JSONArray();
		
				for(Playbill playbill2: pagination.getResults()){
					 JSONObject jsonPlayBill = new JSONObject();
					 jsonPlayBill.put("id", playbill2.getId());
					 jsonPlayBill.put("name", playbill2.getName());
					 jsonPlayBill.put("image", playbill2.getImagesUrl());
					 jsonPlayBill.put("videoSize", playbill2.getVideoSize());
		
					 jsonPlayBills.put(jsonPlayBill);
			
				}
				result.put("results", jsonPlayBills);
				result.put("pageSum", pagination.getPageSum());
				result.put("no", pagination.getNo());
				result.put("next", pagination.isNext());
				result.put("pre", pagination.isPrevious());
				String jsonResult = result.toString();
				response.getWriter().print(jsonResult);
				}
		return null;
	}

}
