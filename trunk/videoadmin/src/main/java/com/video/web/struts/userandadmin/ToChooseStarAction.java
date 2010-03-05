package com.video.web.struts.userandadmin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.User;
import com.video.web.struts.BaseAction;

public class ToChooseStarAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<Long> starIds = new ArrayList<Long>();
		
		starIds = getAllDao().getStarIds();
		
		request.setAttribute("starIds", starIds);
		
		return mapping.findForward("success");
	}

}
