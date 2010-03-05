package com.video.web.struts.tag;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.DailyTag;
import com.video.domain.Tag;
import com.video.domain.User;

import com.video.web.struts.BaseAction;

public class UpdateDailyTagAction extends BaseAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String type = request.getParameter("type");
		String pageNo = request.getParameter("pageNo") == null ? "1" : request
				.getParameter("pageNo");
		if("all".equals(type)){
			String tp = request.getParameter("tp");
			String[] ids = request.getParameterValues("ids");
			List<DailyTag> tags = new ArrayList<DailyTag>();
			for (String sid : ids) {
				
				Long id = Long.parseLong(sid);
				DailyTag tag = getAllDao().getDailyTagById(id);
				tags.add(tag);

			}
			if("lock".equals(tp)){
				
				for(DailyTag tag:tags){
					tag.setStatus(2);
					getAllDao().updateDailyTag(tag);
				}
				
			}
			if("delete".equals(tp)){
				for(DailyTag tag:tags){
					tag.setStatus(3);
					getAllDao().updateDailyTag(tag);
				}
			}
			
		}
		else{
			
			
			String strId = request.getParameter("id");

			Long id = new Long(0);
			if (strId != null && !strId.trim().isEmpty()) {
				try {
					id = Long.parseLong(strId);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
			DailyTag tag = getAllDao().getDailyTagById(id);
			if ("lockOne".equals(type)) {

				tag.setStatus(3 - tag.getStatus());
				getAllDao().updateDailyTag(tag);

			}
			if ("deleteOne".equals(type)) {

				tag.setStatus(3);
				getAllDao().updateDailyTag(tag);
				return new ActionForward(MessageFormat.format("{0}?pageNo={1}",
						mapping.findForward("success").getPath(), pageNo), true);

			}
			
			
			
		}
		return new ActionForward(MessageFormat.format("{0}?pageNo={1}", mapping
				.findForward("success").getPath(), pageNo), true);

		
	}

}
