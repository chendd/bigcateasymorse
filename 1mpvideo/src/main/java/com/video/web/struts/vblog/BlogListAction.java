package com.video.web.struts.vblog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.User;
import com.video.web.struts.BaseAction;

public class BlogListAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String strId = request.getParameter("id");
		Long id = new Long(0);
		if(strId!=null && !strId.trim().isEmpty()){
			try{
				id = Long.parseLong(strId);
			}
			catch (Exception e) {
				
			}
		}
		User user = getAllService().getUser2ById(id);
		
		request.setAttribute("user",user);
		String cid = request.getParameter("channelId");
		if(cid!=null && !cid.trim().isEmpty()){
			try{
				Long channelId = Long.parseLong(cid);
				request.setAttribute("channelId", channelId);
			}
			catch (Exception e) {
				
			}
		}
		return mapping.findForward("success");
	}

}
