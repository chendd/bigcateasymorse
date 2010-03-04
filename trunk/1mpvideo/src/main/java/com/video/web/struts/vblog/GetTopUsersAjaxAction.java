package com.video.web.struts.vblog;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONArray;
import org.json.JSONObject;

import com.video.domain.User;
import com.video.util.Pagination;
import com.video.util.UtilMethod;
import com.video.web.struts.BaseAction;

public class GetTopUsersAjaxAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String strPageSize = request.getParameter("pageSize");
		String strPageNo = request.getParameter("pageNo");
		String orderFieldName = request.getParameter("order");
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
		pagination.setNo(pageNo);
		pagination.setSize(pageSize);
		if(orderFieldName!=null&&!orderFieldName.trim().isEmpty()){
			pagination.setOrderFieldName(orderFieldName);
		}
		

		getAllService().getTopUsers(pagination);

		JSONObject result = new JSONObject();

		JSONArray jsonUsers = new JSONArray();

		for (User user : pagination.getResults()) {
			String strGender = user.getGender();
			String gender = null;
			if ("m".equals(strGender)) {
				gender = "男";
			} else if ("f".equals(strGender)) {
				gender = "女";
			} else {
				gender = "保密";
			}
			Date birthday = user.getBirthday();
			String age = "保密";
			if (birthday != null) {
				age = UtilMethod.getAge(birthday).toString();
			}

			JSONObject jsonUser = new JSONObject();
			jsonUser.put("id", user.getId());
			jsonUser.put("image", user.getFace());
			jsonUser.put("realName", user.getRealName());
			jsonUser.put("age", age);
			jsonUser.put("gender", gender);
			jsonUser.put("friendCount", user.getFriendCount());
			jsonUser.put("beSubscribeCount", user.getBeSubscribeCount());
			jsonUser.put("score", user.getScore());

			jsonUser.put("videoCount", user.getVideoCount());

			jsonUsers.put(jsonUser);
		}
		result.put("results", jsonUsers);
		result.put("no", pagination.getNo());
		result.put("pageSum", pagination.getPageSum());
		result.put("next", pagination.isNext());
		result.put("previous", pagination.isPrevious());
		result.put("order",orderFieldName);
		String jsonResult = result.toString();
		response.getWriter().print(jsonResult);
		return null;
	}

}
