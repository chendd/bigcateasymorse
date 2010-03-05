package com.video.web.struts.tag;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.DailyTag;
import com.video.domain.Tag;
import com.video.web.struts.BaseAction;

public class CreateDailyTagAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String name = request.getParameter("name");
		DailyTag tag = new DailyTag();
		tag.setName(name);
		tag.setBrowseCount(0);
		tag.setCreateDate(new Date());
		tag.setStatus(1);
		getAllDao().createDailyTag(tag);
		
		return mapping.findForward("success");
	}
	
	

}
