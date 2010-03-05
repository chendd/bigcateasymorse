package com.video.web.struts.notice;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Notice;
import com.video.web.struts.BaseAction;

public class UpdateNoticeAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String strId = request.getParameter("id");
		String name = request.getParameter("name");
		String value = request.getParameter("notice");
		if(strId!=null&&!strId.trim().isEmpty()){
			Long id = new Long(0);
			 try{
				 id = Long.parseLong(strId);
			 }
			 catch (Exception e) {
				
			}
			Notice notice = getAllDao().getNoticeById(id);
			if(notice!=null){
				notice.setName(name);
				notice.setNotice(value);
				getAllDao().updateNotice(notice);
			}
		}
		else{
			Notice notice = new Notice();
			notice.setName(name);
			notice.setNotice(value);
			notice.setDate(new Date());
			getAllDao().createNotice(notice);
			
		}
		return mapping.findForward("success");
	}

}
