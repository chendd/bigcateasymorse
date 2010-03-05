package com.video.web.struts.group;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONArray;
import org.json.JSONObject;

import com.video.domain.User;
import com.video.util.Pagination;
import com.video.util.SomeStatic;
import com.video.web.struts.BaseAction;

public class GetGroupUsersAction extends BaseAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int pageSize = 20;
		int pageNo = 1;
		String str_pageNo = request.getParameter("pageNo");
		if (str_pageNo != null) {
			pageNo = Integer.parseInt(str_pageNo);
		}
		String strId = request.getParameter("id");
		Long id = new Long(0);
		if (strId != null && !strId.trim().isEmpty()) {
			try {
				id = Long.parseLong(strId);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		String type = request.getParameter("type");
		Pagination<User> pagination = new Pagination<User>();
		pagination.setNo(pageNo);
		pagination.setSize(pageSize);
		pagination.setCondition(id);
		if ("in".equals(type)) {
			getAllDao().getUsersByGroupId(pagination);
		}
		if ("notin".equals(type)) {
			getAllDao().getOhterUsersByGroupId(pagination);

		}
		
		if(pagination.getResults()!=null){
			//转为JSON对象
			JSONObject result = new JSONObject();
			result.put("no", pagination.getNo());
			result.put("pageSum", pagination.getPageSum());
			result.put("recordSum", pagination.getRecordSum());
			result.put("previous", pagination.isPrevious());
			result.put("next", pagination.isNext());
			result.put("groupId", id);
			JSONArray users = new JSONArray();
			
			for(User user:pagination.getResults()){
				 JSONObject jsonUser = new JSONObject();
				 jsonUser.put("id", user.getId());
				 jsonUser.put("userName", user.getUserName());
				 users.put(jsonUser);
			}
			result.put("results", users);
			String jsonResult = result.toString();
			response.getWriter().print(jsonResult);
		}
		

		return null;
	}

}
