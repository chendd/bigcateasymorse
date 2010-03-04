package com.video.web.struts.vblog;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONArray;
import org.json.JSONObject;

import com.video.domain.SubscribeUser;
import com.video.domain.User;
import com.video.util.Pagination;
import com.video.util.UtilMethod;
import com.video.web.struts.BaseAction;

public class GetMyfansAction extends BaseAction{
	
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
		Pagination<SubscribeUser> pagination = new Pagination<SubscribeUser>();
		SubscribeUser SubscribeUser1 = new SubscribeUser();
		
		SubscribeUser1.setPassiveUser(user);
		pagination.setCondition(SubscribeUser1);

		pagination.setNo(pageNo);
		pagination.setSize(pageSize);
		getAllService().getSubscibeUsers(pagination);

		JSONObject result = new JSONObject();

		JSONArray jsonUsers = new JSONArray();
if(pagination.getRecordSum()>0){
	

		for (SubscribeUser subscribeUser : pagination.getResults()) {

			String strGender = subscribeUser.getPassiveUser().getGender();
			String gender = null;
			if ("m".equals(strGender)) {
				gender = "男";
			} else if ("f".equals(strGender)) {
				gender = "女";
			} else {
				gender = "保密";
			}
			Date birthday = subscribeUser.getPassiveUser().getBirthday();
			String age = "保密";
			if (birthday != null) {
				age = UtilMethod.getAge(birthday).toString();
			}

			JSONObject jsonUser = new JSONObject();
			jsonUser.put("id", subscribeUser.getUser().getId());
			jsonUser.put("image", subscribeUser.getUser().getFace());
			jsonUser.put("realName", subscribeUser.getUser().getRealName());
			jsonUser.put("age", age);
			jsonUser.put("gender", gender);
			jsonUser.put("friendCount", subscribeUser.getUser()
					.getFriendCount());
			jsonUser.put("beSubscribeCount", subscribeUser.getUser()
					.getBeSubscribeCount());
			jsonUser.put("score", subscribeUser.getUser().getScore());

			jsonUser.put("videoCount", subscribeUser.getUser()
					.getVideoCount());

			jsonUsers.put(jsonUser);
		}
		result.put("results", jsonUsers);
		result.put("no", pagination.getNo());
		result.put("pageSum", pagination.getPageSum());
		result.put("next", pagination.isNext());
		result.put("previous", pagination.isPrevious());
		String jsonResult = result.toString();
		response.getWriter().print(jsonResult);
}
		return null;
	}
	
}
