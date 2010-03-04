package com.video.web.struts.group;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jspsmart.upload.SmartUpload;
import com.video.domain.Event;
import com.video.domain.Group;
import com.video.domain.User;
import com.video.util.SomeStatic;
import com.video.util.UtilMethod;
import com.video.util.ZoomImage;
import com.video.web.struts.BaseAction;

public class CreateGroupAction extends BaseAction {

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
		String name = mySmartUpload.getRequest().getParameter("name");
		String type = mySmartUpload.getRequest().getParameter("type");
		String description = mySmartUpload.getRequest().getParameter(
				"description");
		if (name == null || name.trim().isEmpty()) {
			return mapping.findForward("error");
		} else {
			try {
				com.jspsmart.upload.File myFile = mySmartUpload.getFiles()
						.getFile(0);

				if (!myFile.isMissing()) {
					String FileType = myFile.getFileExt();
					FileType = FileType.toLowerCase(); // 将扩展名转换成小写
					String fileUrl = SomeStatic.UPLOAD_GROUP_URL
							+ "/upload/subfile/goupfor" + user.getId()
							+ ".jpg";
					int autoType = UtilMethod.intFormat(type);
					Group group = new Group();
					group.setOwner(user);
					group.setAddDate(new Date());
					group.setAuditType(autoType);
					group.setDescrption(description);
					group.setName(name);
					group.setFlag(1);
					String image = "/upload/group/goup_" + user.getId()
							+ "_" + new Date().getTime() + ".jpg";
					group.setImage(image);
					group = getAllService().createGroup(group);

					String newUrl = SomeStatic.UPLOAD_GROUP_URL + image;
					myFile.saveAs(fileUrl);
					ZoomImage.resizeImage(fileUrl, newUrl);
					

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			return mapping.findForward("success");

		}

	}

}
