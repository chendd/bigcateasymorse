package com.video.web.struts.userandadmin;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.User;
import com.video.web.struts.BaseAction;

public class UpdateUserAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String type = request.getParameter("type");
		String pageNo = request.getParameter("pageNo") == null ? "1" : request
				.getParameter("pageNo");
		if ("one".equals(type)) {
			String email = request.getParameter("email");
			String realName = request.getParameter("fullName");
			String gender = request.getParameter("gender");
			String postCode = request.getParameter("postCode");
			String marriage = request.getParameter("marriage");
			Map<String, String> messages = new HashMap<String, String>();
			
			Date birthday = null;
			
			User user = getAllDao().getUserByRealName(realName);
			if(user != null){
				if(!user.getEmail().equals(email)){
					messages.put("realName", "该昵称已被使用");
				}
			}
			
			User user2 = getAllDao().getUserByEmail(email);
			if(messages.size()==0){
				
				user2.setBirthday(birthday);
				user2.setMarriage(marriage);
				user2.setPostCode(postCode);
				user2.setGender(gender);
				user2.setRealName(realName);
				getAllDao().updateUser(user2);
				return mapping.findForward("success");
			}
			else{
				request.setAttribute("messages", messages);
				

				return new ActionForward(MessageFormat.format("{0}?id={1}", mapping.findForward("error").getPath(),user2.getId()),false);
			}
			
		
			
			
		}
		else if("lockOne".equals(type)){
			String strId = request.getParameter("id");
			
			
			Long id = new Long(0);
			if(strId!=null&&!strId.trim().isEmpty()){
				try{
					id = Long.parseLong(strId);
				}
				catch(Exception e){
					throw new RuntimeException(e);
				}
			}
			User user = getAllDao().getUserById(id);
			user.setStatus(3-user.getStatus());
			getAllDao().updateUser(user);
			return new ActionForward(MessageFormat.format("{0}?pageNo={1}", mapping.findForward("success").getPath(),pageNo),true);
			
		}
		else {

			String[] ids = request.getParameterValues("ids");
			List<User> users = new ArrayList<User>();
			for (String sid : ids) {
				
				Long id = Long.parseLong(sid);
				User user = getAllDao().getUserById(id);
				users.add(user);

			}
			
			
		
			if("lock".equals(type)){
				for(User user:users){
					user.setStatus(2);
					getAllDao().updateUser(user);
				}
			}
			if("move".equals(type)){
				String moveto = request.getParameter("moveto");
				int grade = Integer.parseInt(moveto);
				for(User user:users){
					user.setGrade(grade);
					getAllDao().updateUser(user);
				}
			}
			
			return new ActionForward(MessageFormat.format("{0}?pageNo={1}", mapping.findForward("success").getPath(),pageNo),true);

		}


	}

}
