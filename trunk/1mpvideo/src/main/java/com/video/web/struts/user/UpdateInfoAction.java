package com.video.web.struts.user;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.User;
import com.video.web.struts.BaseAction;

public class UpdateInfoAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("sessionUser");
		String realName = request.getParameter("realName");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String area = request.getParameter("area");
		String gender = request.getParameter("gender");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String qq = request.getParameter("qq");
		String mobilePhone = request.getParameter("mobilePhone");
		if(province!=null&&!province.trim().isEmpty()&&city!=null&&!city.trim().isEmpty()&&area!=null&&!area.trim().isEmpty()){
			String userArea = province+";"+city+";"+area;
			user.setArea(userArea);
		}
		if(realName!=null&&!realName.trim().isEmpty()){
			user.setRealName(realName);
		}
		if(year!=null&&!year.trim().isEmpty()&&month!=null&&!month.trim().isEmpty()&&day!=null&&!day.trim().isEmpty()){
			String strDate = year+"-"+month+"-"+day;
			Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
			user.setBirthday(birthday);
		}
		if(gender!=null && !gender.trim().isEmpty()){
			user.setGender(gender);
		}
		user.setQq(qq);
		user.setMobilePhone(mobilePhone);
		getAllService().updateUser(user);
		request.setAttribute("message", "更新成功");
		return mapping.findForward("success");
	}

}
