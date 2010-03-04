package com.video.web.struts.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.User;
import com.video.web.struts.BaseAction;

public class LoginAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String url = "error";
		String send = request.getParameter("send");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String random = request.getParameter("random");
		String sessionRandom = (String) request.getSession().getAttribute(
				"rand");
		System.out.println("000::"+password);
		boolean flag = true;
		if (userName == null || userName.trim().isEmpty()) {
			request.setAttribute("userNameError", "用户名不能为空");
			flag = false;
		} else {
			request.setAttribute("userName", userName);
		}

		if (password == null || password.trim().isEmpty()) {
			request.setAttribute("passwordError", "密码不能为空");
			flag = false;
		}
		if (sessionRandom != null) {
			if (random == null || random.trim().isEmpty()) {
				request.setAttribute("randomError", "验证码不能为空");
				flag = false;
			} else {
				if (!random.equals(sessionRandom)) {
					request.setAttribute("randomError", "验证码错误");
					flag = false;
				}
			}
		}
		request.getSession().removeAttribute("rand");
		if (flag) {
			User user = new User();
			user.setUserName(userName);
			user.setPassword(password);
			user = getAllService().getUser(user);
			if (user == null) {
				request.setAttribute("error", "用户名或密码错误");
				url = "error";
			} else {

				request.getSession().setAttribute("sessionUser", user);
				if (send != null && !send.trim().isEmpty()) {
					String server = request.getServerName();
					int port = request.getServerPort();
					send = "/" + send;
					send = send.replaceAll("[/]{2,}", "/");
					String path = "http://" + server + ":"
							+ String.valueOf(port) + send;
					return new ActionForward(path, true);
				} else {
					url = "success";
				}
			}
		} else {
			url = "error";
		}
		request.setAttribute("send", send);
		return mapping.findForward(url);
	}
}
