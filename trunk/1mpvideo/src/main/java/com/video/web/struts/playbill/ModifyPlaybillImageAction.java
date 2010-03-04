package com.video.web.struts.playbill;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jspsmart.upload.SmartUpload;
import com.video.domain.Playbill;
import com.video.domain.User;
import com.video.domain.Video;
import com.video.util.Pagination;
import com.video.util.SomeStatic;
import com.video.util.ZoomImage;
import com.video.web.struts.BaseAction;

public class ModifyPlaybillImageAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String idString = request.getParameter("id");
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("sessionUser");

		Long id = null;
		if (idString != null && !idString.trim().isEmpty()) {
			id = Long.parseLong(idString);
		}
		Playbill playbill = getAllService().getPlaybill(id);

		if (action == null) {

			String image = request.getParameter("image");
			playbill.setImagesUrl(image);
			getAllService().updatePlaybill(playbill);

		} else {
			List<Video> videoes = getAllService().getPlaybillVideoList(id);
			int size = videoes.size();
			size = size + (5 - (size % 5));
			request.setAttribute("playbill", playbill);
			request.setAttribute("videoes", videoes);
			request.setAttribute("size", size);
			return mapping.findForward("modify");
		}


		return new ActionForward(MessageFormat.format("{0}{1}/addDate/1",
				mapping.findForward("su").getPath(), user.getId()), true);
	}
}
