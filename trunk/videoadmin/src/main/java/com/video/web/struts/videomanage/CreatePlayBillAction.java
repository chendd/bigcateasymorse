package com.video.web.struts.videomanage;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Playbill;
import com.video.domain.User;
import com.video.web.struts.BaseAction;

public class CreatePlayBillAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<String> messages = new ArrayList<String>();
		String userId = request.getParameter("userId");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		Long uid = new Long(0);
		User user =null;
		if(userId!=null && !userId.trim().isEmpty()){
			uid = Long.parseLong(userId);
			 user = getAllDao().getUserById(uid);
			if(user == null){
				messages.add("该用户不存在");
			}
			if(name ==null || name.trim().isEmpty()){
				messages.add("名称不能为空");
			}
			
		}
		else{
			messages.add("该用户不存在");
		}
		Playbill playbill = new Playbill();
		playbill.setName(name);
		playbill.setDescription(description);
		if(messages.size()==0){
			
			playbill.setUser(user);
			playbill.setAddDate(new Date());
			playbill.setFlag(1);
			getAllDao().createPlaybill(playbill);
			return mapping.findForward("success");
		}
		else{
			request.setAttribute("playbill", playbill);
			request.setAttribute("messages", messages);
			return mapping.findForward("error");
		}
		
	}

}
