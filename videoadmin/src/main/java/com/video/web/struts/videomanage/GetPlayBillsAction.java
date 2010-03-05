package com.video.web.struts.videomanage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONArray;
import org.json.JSONObject;

import com.video.domain.Playbill;
import com.video.domain.User;
import com.video.util.Pagination;
import com.video.util.SomeStatic;
import com.video.web.struts.BaseAction;

public class GetPlayBillsAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		int pageSize = 10;
		int pageNo = 1;
		String str_pageNo = request.getParameter("pageNo");
		String type= request.getParameter("type");
		
		if(str_pageNo!=null){
			pageNo = Integer.parseInt(str_pageNo);
		}
		Pagination<Playbill> pagination = new Pagination<Playbill>();
		pagination.setNo(pageNo);
		pagination.setSize(pageSize);
		getAllDao().getPlaybills(pagination);
if("ajax".equals(type)){
	if(pagination.getResults()!=null){
		//转为JSON对象
		JSONObject result = new JSONObject();
		result.put("no", pagination.getNo());
		result.put("pageSum", pagination.getPageSum());
		result.put("recordSum", pagination.getRecordSum());
		result.put("previous", pagination.isPrevious());
		result.put("next", pagination.isNext());
		JSONArray playBills = new JSONArray();
		
		for(Playbill playbill:pagination.getResults()){
			 JSONObject jsonPlayBill = new JSONObject();
			 jsonPlayBill.put("id", playbill.getId());
			 jsonPlayBill.put("name", playbill.getName());
			 playBills.put(jsonPlayBill);
		}
		result.put("results", playBills);
		String jsonResult = result.toString();
		response.getWriter().print(jsonResult);
	}
	

	return null;
			
		}
		else{
			
			request.setAttribute("pagination", pagination);
			
			return mapping.findForward("success");
		}
		
	}

}
