package com.video.web.struts.user;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Friend;
import com.video.domain.User;
import com.video.web.formbean.UserForm;
import com.video.web.struts.BaseAction;

public class RegisterAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String send = request.getParameter("send");
		UserForm userForm = (UserForm) form;
		User user = new User();
		BeanUtils.copyProperties(user, userForm);

		if (userForm.getBirthdayString() != null
				&& !userForm.getBirthdayString().trim().isEmpty()) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			Date birthday = new Date(format.parse(userForm.getBirthdayString())
					.getTime());
			user.setBirthday(birthday);
		}
		if(userForm.getGender().equals("s")){
			user.setFace("/upload/userface/s.jpg");
		}
		if(userForm.getGender().equals("m")){
			user.setFace("/upload/userface/m.jpg");
		}
		if(userForm.getGender().equals("f")){
			user.setFace("/upload/userface/f.jpg");
		}
		user.setRegDate(new Date());

		getAllService().createUser(user);
		user = getAllService().getUser(user);
	    User user2 = new User();
	    user2.setId(new Long(1));
	    Friend friend = new Friend();
	    friend.setUser(user2);
	    friend.setfUser(user);
	    friend.setRegdate(new Date());
	    getAllService().createFriend(friend);
		request.getSession().setAttribute("sessionUser", user);
		if (send != null && !send.trim().isEmpty()) {
			response.sendRedirect(send);
		}
		return mapping.findForward("success");
	}
}
