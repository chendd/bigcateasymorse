package com.video.web.struts.userandadmin;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Administrator;
import com.video.web.struts.BaseAction;

public class AdminCreateAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String type = request.getParameter("type");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String message = "";
		boolean exist = false;
		if(getAllDao().getAdministratorByName(name)!=null){
			exist = true;
		}
		if("ajax".equals(type)){
			if(exist){
				response.getWriter().print("exist");
				
			}
			
			return null;
		}
		else{
			if("".equals(name)||name==null||"".equals(password)||password==null){
				message = "用户名或密码不能为空";
				return mapping.findForward("error");
			}
			else if(exist){
				message = "该帐号已存在";
				return mapping.findForward("error");
			}
			else{
				Administrator administrator = new Administrator();
				administrator.setName(name);
				administrator.setPassword(password);
				administrator.setLastLoginDate(new Date());
				administrator.setLoginCount(0);
				getAllDao().createAdministrator(administrator);
				return mapping.findForward("success");
			}
			
			
			
			
		}
		
	}

}
