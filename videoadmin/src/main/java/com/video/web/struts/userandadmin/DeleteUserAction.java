package com.video.web.struts.userandadmin;

import java.text.MessageFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.web.struts.BaseAction;

public class DeleteUserAction extends BaseAction{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String type = request.getParameter("type");
		String pageNo = request.getParameter("pageNo")==null?"1":request.getParameter("pageNo");
		if("delAll".equals(type)){
			String[] ids = request.getParameterValues("ids");
			
			for(String sid:ids){
				
				Long id = Long.parseLong(sid);
				getAllDao().deleteUser(id);
			
			}
			
		}
		else{
			
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
			getAllDao().deleteUser(id);
			
		}
		
		return new ActionForward(MessageFormat.format("{0}?pageNo={1}", mapping.findForward("success").getPath(),pageNo),true);
	}
	
	

}
