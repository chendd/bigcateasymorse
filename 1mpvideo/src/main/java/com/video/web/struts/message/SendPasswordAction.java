package com.video.web.struts.message;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.SafeCode;
import com.video.domain.User;
import com.video.util.SendMail;
import com.video.web.struts.BaseAction;

public class SendPasswordAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		User user = null;
		String email = request.getParameter("email");
		String message=null;
		if(email==null||email.trim().isEmpty()){
			message = "邮箱不能为空，请重新填写";
		}
		else if(!email.matches("\\w+(\\.\\w+)*@\\w+(\\.\\w+)+")){
			message = "邮箱格式错误，请重新填写";
		}
		else{
			User u = new User();
			u.setEmail(email);
			 user = getAllService().getUser(u);
			if(user==null){
				message = "该邮箱不存在，请重新填写";
			}
		}
		if(message!=null){
			request.setAttribute("message", message);
		}
		else{
			List<String> address = new ArrayList<String>();
			address.add(email);
			String uuid = UUID.randomUUID().toString();
			String title = "亿万像";
			String words = "<p>亿万像提醒您：请点击这个链接：<a href='http://192.168.0.225:8085/1mpvideo2/reset_password/"+uuid+"'>重新设置你在亿万像上的登录密码</a> 如果以上链接没法点击，请将以下地址复制到浏览器地址栏里打开： http://192.168.0.225:8085/1mpvideo2/reset_password/"+uuid+" </p>";
			SendMail sendMail = new SendMail();
			sendMail.sendMessage(address, title, words);
			SafeCode safeCode = new SafeCode();
			Long s = new Date().getTime()+1000*60*60*24;
			Date finalDate = new Date(s);
			safeCode.setCode(uuid);
			safeCode.setUser(user);
			safeCode.setFinalDate(finalDate);
			getAllService().createSafeCode(safeCode);
			request.setAttribute("success", true);
		}
		return mapping.findForward("success");
	}

}
