package com.video.web.struts.vblog;

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
import com.video.domain.UserRequest;
import com.video.util.UtilMethod;
import com.video.web.struts.BaseAction;

public class CreateUserRequestAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("sessionUser");
		if(user!=null){
			String strFid = request.getParameter("fid");
			if(strFid!=null && !strFid.trim().isEmpty()){
				String word = request.getParameter("word");
				if(word!=null && !word.trim().isEmpty()){
				Long fid = UtilMethod.longFormat(strFid);
				if(!fid.equals(new Long(0))){
					SystemNotice systemNotice = new SystemNotice();
					Module module = new Module();
					module.setId(user.getId());
					module.setName(user.getRealName());
					module.setImage(user.getFace());
					User rUser = new User();
					rUser.setId(fid);
					systemNotice.setModule(module);
					systemNotice.setUser(rUser);
					systemNotice.setTitle("好友请求");
					systemNotice.setMessage(word);
					systemNotice.setSendDate(new Date());
					systemNotice.setType(4);
					getAllService().createUserRequest(systemNotice);
					response.getWriter().print("ok");
				}
				
			}
			}
		}
		return null;
	}

}
