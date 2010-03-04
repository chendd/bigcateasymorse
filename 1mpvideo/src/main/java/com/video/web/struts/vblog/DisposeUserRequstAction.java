package com.video.web.struts.vblog;

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

/**
 * 
 * @author jarry
 *处理好友请求
 */
public class DisposeUserRequstAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("sessionUser");
		String strId = request.getParameter("id");
		if(strId!=null && !strId.trim().isEmpty()){
			Long mid = UtilMethod.longFormat(strId);
			if(!mid.equals(new Long(0))){
				SystemNotice systemNotice = getAllService().getSystemNoticeById(mid);
				if(systemNotice != null && systemNotice.getUser().getId().equals(user.getId())){
					
						getAllService().agreeUserRequest(systemNotice);
				
				
				}
				
			}
			
		}
		return new ActionForward(MessageFormat.format("{0}{1}/", mapping
				.findForward("success").getPath(), strId), true);
	}
	

}
