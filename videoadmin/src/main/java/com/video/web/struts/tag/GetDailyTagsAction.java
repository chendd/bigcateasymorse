package com.video.web.struts.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.DailyTag;
import com.video.domain.Tag;
import com.video.util.Pagination;
import com.video.util.SomeStatic;
import com.video.web.struts.BaseAction;

public class GetDailyTagsAction extends BaseAction{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int pageSize = 10;
		int pageNo = 1;
		String str_pageNo = request.getParameter("pageNo");
		if(str_pageNo!=null){
			pageNo = Integer.parseInt(str_pageNo);
		}
		Pagination<DailyTag> pagination = new Pagination<DailyTag>();
		pagination.setNo(pageNo);
		pagination.setSize(pageSize);
		pagination.setOrderFieldName("ID");
		getAllDao().getDailyTags(pagination);
		

		request.setAttribute("pagination", pagination);
		
	
	
	
		return mapping.findForward("success");
		
		
	}

}
