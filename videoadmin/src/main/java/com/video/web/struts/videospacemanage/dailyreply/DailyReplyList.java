package com.video.web.struts.videospacemanage.dailyreply;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.DailyReply;
import com.video.util.Pagination;
import com.video.util.SomeStatic;
import com.video.web.struts.BaseAction;

public class DailyReplyList extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DailyReply dailyReplyTerm = new DailyReply();
		String comment = request.getParameter("keyword");
		Pagination<DailyReply> dailyReplyPage = new Pagination<DailyReply>();
		int pageSize = 10;
		int pageNo = 1;
		String pageNoString = request.getParameter("pageNo");

		if (pageNoString != null && !pageNoString.trim().isEmpty()) {
			pageNo = Integer.parseInt(pageNoString);
		}
		dailyReplyPage.setNo(pageNo);
		dailyReplyPage.setSize(pageSize);
		if (comment != null && !comment.trim().isEmpty()) {
			dailyReplyTerm.setComment(comment);
			request.setAttribute("keyword", comment);
		}
		

		dailyReplyPage.setCondition(dailyReplyTerm);

		getAllDao().getDailyReplies(dailyReplyPage);

		List<DailyReply> dailyReplyList = dailyReplyPage.getResults();

		if (dailyReplyList != null && dailyReplyList.size() > 0) {
			for (int i = 0; i < dailyReplyList.size(); i++) {
				DailyReply dailyReply = dailyReplyList.get(i);
				Long userId = dailyReply.getUserId();
				Long dailyId = dailyReply.getDailyId();
				if (userId != null) {
					dailyReply.setUser(getAllDao().getUserById(userId));
				}
				if (dailyId != null) {
					dailyReply.setDaily(getAllDao().getDailyById(dailyId));
				}

			}
		}
		request.setAttribute("dailyReplyPage", dailyReplyPage);
		return mapping.findForward("success");
	}
}
