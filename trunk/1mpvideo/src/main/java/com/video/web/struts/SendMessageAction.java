package com.video.web.struts;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.util.SendMail;

public class SendMessageAction extends BaseAction{
	
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String[] emails = request.getParameterValues("emails");
		String words = "测试测试";
		List<String> list = new ArrayList<String>();
		for(String email:emails){
			list.add(email);
		}
		new SendMail().sendMessage(list, "亿万视频好友邀请", words);
		return mapping.findForward("success");
	
	}

}
