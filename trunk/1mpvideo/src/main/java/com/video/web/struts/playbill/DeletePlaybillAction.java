package com.video.web.struts.playbill;

import java.text.MessageFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Playbill;
import com.video.domain.User;
import com.video.web.struts.BaseAction;

public class DeletePlaybillAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String[] ids = request.getParameterValues("selectId");
		User user = (User) request.getSession().getAttribute("sessionUser");
		Long id = null;
		Playbill playbill = null;
		String url = mapping.findForward("error").getPath();
		if (user != null) {
			url = MessageFormat.format("{0}{1}/1/addDate/1", mapping
					.findForward("success").getPath(), user.getId());
			for (String idString : ids) {
				id = Long.parseLong(idString);
				playbill = getAllService().getPlaybill(id);
				if (playbill != null
						&& playbill.getUser().getId().equals(user.getId())) {
					getAllService().deletePlaybill(id);
				} else {
					break;
				}
			}
		}
		return new ActionForward(url, true);
	}
}
