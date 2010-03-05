package com.video.web.struts.whisper;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Module;
import com.video.domain.SystemNotice;
import com.video.domain.User;
import com.video.domain.Whisper;
import com.video.util.Pagination;
import com.video.util.SomeStatic;
import com.video.web.struts.BaseAction;

public class WhisperAction extends BaseAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String type = request.getParameter("type");
		if ("send".equals(type)) {
			String strGrade = request.getParameter("grade");
			String title = request.getParameter("title");
			String message = request.getParameter("message");
			Integer grade = null;
			if (!"all".equals(strGrade) && strGrade != null) {
				grade = Integer.parseInt(strGrade);
			}
			if(title!=null&&!title.trim().isEmpty()&&message!=null&&!message.trim().isEmpty()){
				SystemNotice systemNotice = new SystemNotice();
				systemNotice.setTitle(title);
				systemNotice.setMessage(message);
				systemNotice.setSendDate(new Date());
				systemNotice.setStatus(0);
				systemNotice.setType(0);
				Module module = new Module();
				module.setId(new Long(0));
				systemNotice.setModule(module);
				getAllDao().createSystemNotice(grade, systemNotice);
			}
			
			

		}

		if ("deleteByGrade".equals(type)) {
			String strGrade = request.getParameter("delGrade");
			Integer grade = null;
			if (!"all".equals(strGrade) && strGrade != null) {
				grade = Integer.parseInt(strGrade);
			}
			User user = new User();
			user.setGrade(grade);
			getAllDao().deleteSystemNoticeByGrade(user);

		}

		if ("deleteByDate".equals(type)) {
			String strDate = request.getParameter("date");
			int dateNum;
			if (strDate != null && !strDate.trim().isEmpty()) {
				dateNum = Integer.parseInt(strDate);
				getAllDao().deleteSystemNoticeByDate(dateNum);
			}

		}

		if ("select".equals(type)) {

			
			int pageSize = 10;
			int pageNo = 1;
			String str_pageNo = request.getParameter("pageNo");
			if (str_pageNo != null) {
				pageNo = Integer.parseInt(str_pageNo);
			}
			Pagination<SystemNotice> pagination = new Pagination<SystemNotice>();
			pagination.setNo(pageNo);
			pagination.setSize(pageSize);
		
			getAllDao().getSystemNotices(pagination);

			request.setAttribute("pagination", pagination);

			return mapping.findForward("search");
		}

		if ("deleteById".equals(type)) {
			int pageSize = 10;
			int pageNo = 1;
			String str_pageNo = request.getParameter("pageNo");
			if (str_pageNo != null) {
				pageNo = Integer.parseInt(str_pageNo);
			}
			String strId = request.getParameter("id");
			Long id = new Long(0);
			if (strId != null&&!strId.trim().isEmpty()) {
				id = Long.parseLong(strId);
				SystemNotice systemNotice = getAllDao().getSystemNoticeById(id);
			
				getAllDao().deleteSystemNoticeBySendDate(systemNotice);
			}
		
			
		
		
				return new ActionForward(MessageFormat.format("{0}?pageNo={1}",
						mapping.findForward("list2").getPath(), pageNo), true);
			

		}

		if ("oprate".equals(type)) {
			int pageSize = 10;
			int pageNo = 1;
			String str_pageNo = request.getParameter("pageNo");
			if (str_pageNo != null) {
				pageNo = Integer.parseInt(str_pageNo);
			}
			
			String[] ids = request.getParameterValues("ids");
			

			String tp = request.getParameter("tp");
			if ("delete".equals(tp)) {
				for (String sid : ids) {

					Long id = Long.parseLong(sid);
					SystemNotice systemNotice = getAllDao().getSystemNoticeById(id);
				
					getAllDao().deleteSystemNoticeBySendDate(systemNotice);
				

				}

			}
			if ("shield".equals(tp)) {

			}
			String keyword = request.getParameter("keyword");
			if (keyword != null && !keyword.trim().isEmpty()) {
				request.setAttribute("keyword", keyword);

				return new ActionForward(MessageFormat.format(
						"{0}?pageNo={1}&keyword={2}&type={3}", mapping
								.findForward("list1").getPath(), pageNo,
						keyword, "select"), true);
			} else {
				return new ActionForward(MessageFormat.format("{0}?pageNo={1}",
						mapping.findForward("list2").getPath(), pageNo), true);
			}

		}

		return mapping.findForward("success");
	}

}
