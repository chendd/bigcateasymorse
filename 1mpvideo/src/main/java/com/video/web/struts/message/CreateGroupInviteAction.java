package com.video.web.struts.message;

import java.text.MessageFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Module;
import com.video.domain.SystemNotice;
import com.video.domain.User;
import com.video.util.UtilMethod;
import com.video.web.struts.BaseAction;

public class CreateGroupInviteAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String strId = request.getParameter("id");
		String title = request.getParameter("title");
		String message = request.getParameter("message");
		String strUid = request.getParameter("uid");
		if(strId!=null && !strId.trim().isEmpty()){
			Long id = UtilMethod.longFormat(strId);
			
			if(!id.equals(new Long(0))){
				if(title==null||title.trim().isEmpty()||message==null||message.trim().isEmpty()){
					return new ActionForward(MessageFormat.format("{0}?id={1}", mapping
							.findForward("error").getPath(), strUid), true);
				}
				SystemNotice systemNotice = new SystemNotice();
				systemNotice.setTitle(title);
				systemNotice.setMessage(message);
				systemNotice.setStatus(0);
				systemNotice.setType(2);
				Module module = new Module();
				module.setId(id);
				systemNotice.setModule(module);
				User user = new User();
				Long uid = UtilMethod.longFormat(strUid);
				user.setId(uid);
				systemNotice.setUser(user);
				systemNotice.setSendDate(new Date());
				
				getAllService().createSystemNotice(systemNotice);
				
			}
		
			
		}
		return mapping.findForward("success");
	}

}
