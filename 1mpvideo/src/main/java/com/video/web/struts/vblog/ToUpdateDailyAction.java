package com.video.web.struts.vblog;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.apache.axis.types.Id;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Daily;
import com.video.domain.DailyChannel;
import com.video.domain.User;
import com.video.util.UtilMethod;
import com.video.web.struts.BaseAction;

public class ToUpdateDailyAction extends BaseAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("sessionUser");
		String strId = request.getParameter("id");

		if (strId != null && !strId.trim().isEmpty()) {
			Long id = UtilMethod.longFormat(strId);
			if (!id.equals(new Long(0))) {
				Daily daily = getAllService().getDailyById(id);
				if (daily != null
						&& daily.getUser().getId().equals(user.getId())) {
					List<DailyChannel> channels = getAllService()
							.getDailyChannels();
					request.setAttribute("daily", daily);
					request.setAttribute("channels", channels);
				}

			}

		}

		return mapping.findForward("success");
	}

}
