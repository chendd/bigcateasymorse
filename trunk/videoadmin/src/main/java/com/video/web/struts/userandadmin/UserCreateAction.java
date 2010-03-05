package com.video.web.struts.userandadmin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.User;
import com.video.web.struts.BaseAction;

public class UserCreateAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String type = request.getParameter("type");
		if("email".equals(type)){
			String email = request.getParameter("email");
			User user = getAllDao().getUserByEmail(email);
			if(user != null){
				response.getWriter().print("exist");
			}
			
			return null;
		}
		else if("userName".equals(type)){
			String userName = request.getParameter("userName");
			User user = getAllDao().getUserByName(userName);
			if(user != null){
				response.getWriter().print("exist");
			}
			
			return null;
		}
		else if("realName".equals(type)){
			String realName = request.getParameter("realName");
			User user = getAllDao().getUserByRealName(realName);
			if(user != null){
				response.getWriter().print("exist");
			}
			
			return null;
		}
		else {
			String email = request.getParameter("email");
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			String passwordAgain = request.getParameter("passwordAgain");
			String realName = request.getParameter("fullName");
			String strYear = request.getParameter("year");
			String strMonth  = request.getParameter("month");
			String strDay = request.getParameter("day");
			String gender = request.getParameter("gender");
			String address = request.getParameter("address");
			String qq = request.getParameter("qq");
			String mobilePhone = request.getParameter("mobilePhone");
			String postCode = request.getParameter("postCode");
			String marriage = request.getParameter("marriage");
			String hobby = request.getParameter("hobby");
			String education = request.getParameter("education");
			String signature = request.getParameter("signature");
			Date birthday = null;
			if(strYear!=null && !strYear.trim().equals("0")&&strMonth!=null && !strMonth.trim().equals("0")&&strDay!=null && !strDay.trim().equals("0")){
				try{
					
					String strBirthday = strYear+"-"+strMonth+"-"+strDay;
					birthday = new SimpleDateFormat("yyyy-MM-dd").parse(strBirthday);
				
					
				}
				catch(Exception e){
					
				}
			}
			User user = new User();
			user.setAddress(address);
			user.setBirthday(birthday);
			user.setEducation(education);
			user.setEmail(email);
			user.setFortune(0);
			user.setGender(gender);
			user.setLastLoginDate(new Date());
			user.setLayout("[module3][module7][module8][module9][module11][module4][module5],[module10][module1],[module6]");
			user.setLevel(1);
			user.setLoginTimes(1);
			user.setMarriage(marriage);
			user.setMobilePhone(mobilePhone);
			user.setPassword(password);
			user.setPostCode(postCode);
			user.setQq(qq);
			user.setRealName(realName);
			user.setRegDate(new Date());
			user.setScore(0);
			user.setSide(0);
			user.setSignature(signature);
			user.setUserName(userName);
			user.setStatus(1);
			user.setGrade(0);
			getAllDao().createUser(user);
			
			return mapping.findForward("success");
		}
	}

}
