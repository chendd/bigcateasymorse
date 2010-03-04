package com.video.web.struts.user;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jspsmart.upload.SmartUpload;
import com.video.domain.User;
import com.video.util.SomeStatic;
import com.video.web.struts.BaseAction;

public class UploadFaceAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("sessionUser");
		try {
			SmartUpload mySmartUpload = new SmartUpload();
			mySmartUpload.setAllowedFilesList("jpg,gif");
			mySmartUpload.setMaxFileSize(1024000);
			ServletConfig ctx = getServlet().getServletConfig();
			mySmartUpload.initialize(ctx, request, response);
			mySmartUpload.upload();

			com.jspsmart.upload.File myFile = mySmartUpload.getFiles().getFile(
					0);
			if (!myFile.isMissing()) {
				String FileType = myFile.getFileExt();

				FileType = FileType.toLowerCase(); // 将扩展名转换成小写
				String newFileName  = SomeStatic.UPLOAD_USERFACE_URL+"/upload/subfile/face"+user.getId()+"." + FileType; // 可自动生成文件名以防止同名覆盖
				myFile.saveAs(newFileName);

				BufferedImage image = ImageIO.read(new File(newFileName));
				int width = image.getWidth();
				int height = image.getHeight();
				
					
				response.sendRedirect("upload_ok.html?=upload/subfile/face"+user.getId()+"." + FileType +","+width+","+height);

			}
		} catch (Exception e) {

		}
		return null;
	}

}
