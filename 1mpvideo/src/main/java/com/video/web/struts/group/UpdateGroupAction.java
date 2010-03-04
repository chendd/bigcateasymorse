package com.video.web.struts.group;

import java.text.MessageFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jspsmart.upload.SmartUpload;
import com.video.domain.Group;
import com.video.domain.User;
import com.video.util.UtilMethod;
import com.video.util.ZoomImage;
import com.video.web.struts.BaseAction;

public class UpdateGroupAction extends BaseAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("sessionUser");
		SmartUpload mySmartUpload = new SmartUpload();
		mySmartUpload.setAllowedFilesList("jpg,gif");
		mySmartUpload.setMaxFileSize(102400);
		ServletConfig ctx = this.getServlet().getServletConfig();
		mySmartUpload.initialize(ctx, request, response);
		mySmartUpload.upload();
		String strId = mySmartUpload.getRequest().getParameter("id");
		String type = mySmartUpload.getRequest().getParameter("type");
		int autoType = UtilMethod.intFormat(type);
		String description = mySmartUpload.getRequest().getParameter(
				"description");
		if (strId != null && !strId.trim().isEmpty()) {
			Long id = UtilMethod.longFormat(strId);
			Group group = getAllService().getGroupById(id);
			if (group != null&&group.getOwner().getId().equals(user.getId())) {
				group.setDescrption(description);
				group.setAuditType(autoType);
				getAllService().updateGroup(group);

		
			try {

				com.jspsmart.upload.File myFile = mySmartUpload.getFiles()
						.getFile(0);

				if (!myFile.isMissing()) {

					String FileType = myFile.getFileExt();
					FileType = FileType.toLowerCase(); // 将扩展名转换成小写
					String fileUrl = request.getRealPath("/")
							+ "/upload/subfile/goupfor" + user.getId() + ".jpg";

					String image = "/upload/group/goup_" + user.getId() + "_"
							+ new Date().getTime() + ".jpg";
					if (group.getImage() != null
							&& !group.getImage().trim().isEmpty()) {
						image = group.getImage();
					}

					String newUrl = request.getRealPath("/") + image;
					myFile.saveAs(fileUrl);
					ZoomImage.resizeImage(fileUrl, newUrl);
				

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return new ActionForward(MessageFormat.format("{0}{1}/", mapping
					.findForward("success").getPath(), strId),true);
			}
		}

		return mapping.findForward("error");

	}

}
