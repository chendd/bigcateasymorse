package com.video.web.struts.videomanage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jspsmart.upload.SmartUpload;
import com.video.domain.UploadVideo;
import com.video.domain.User;
import com.video.domain.VideoChannel;
import com.video.web.struts.BaseAction;

public class CreateUploadVideoAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SmartUpload mySmartUpload = new SmartUpload();
		mySmartUpload.setAllowedFilesList("3gp,rm,rmvb,wmv,flv,avi,mpg");
		mySmartUpload.setMaxFileSize(102400000);
		ServletConfig ctx = this.getServlet().getServletConfig();
		mySmartUpload.initialize(ctx, request, response);
		mySmartUpload.upload();
		String userId = mySmartUpload.getRequest().getParameter("userId");
		List<String> messages = new ArrayList<String>();
		Long uid = new Long(0);
		User user = null;
		String name = mySmartUpload.getRequest().getParameter("name");
		String channelId = mySmartUpload.getRequest().getParameter("channelId");
		Long cid = new Long(0);
		cid = Long.parseLong(channelId);
		VideoChannel channel = getAllDao().getVideoChannelById(cid);
		String description = mySmartUpload.getRequest().getParameter("description");
		String strNum3gp = mySmartUpload.getRequest().getParameter("num3gp");
		int num3gp = 0;
		if(userId!=null&&!userId.trim().isEmpty()){
			try{
				uid = Long.parseLong(userId);
			}
			catch (Exception e) {
				
			}
			user = getAllDao().getUserById(uid);
			if(user==null){
				messages.add("该用户不存在");
			}
			
		}
		
		else{
			messages.add("该用户不存在");
		}
		if(name ==  null || name.trim().isEmpty()){
			messages.add("名称不能为空");
		}
		try{
			num3gp = Integer.parseInt(strNum3gp);
		}
		catch (Exception e) {
			messages.add("数字格式错误");
		}
		UploadVideo uploadVideo = new UploadVideo();
		
		uploadVideo.setNum3gp(num3gp);
	
		if(messages.size()>0){
			request.setAttribute("messages", messages);
			request.setAttribute("video", uploadVideo);
			return mapping.findForward("error");
			}
		else{
			

			try {
				

				com.jspsmart.upload.File myFile = mySmartUpload.getFiles().getFile(
						0);

				if (!myFile.isMissing()) {
					
					String FileType = myFile.getFileExt();
					int videoSize = myFile.getSize();
					FileType = FileType.toLowerCase(); // 将扩展名转换成小写
					int FileSize = myFile.getSize();
					String newFileName = "f:/upload/"+new Date().getTime()+"." + FileType; // 可自动生成文件名以防止同名覆盖
					uploadVideo.setUrl(newFileName);
					uploadVideo.setStauts(1);
				
				
					uploadVideo.setVideoType(FileType);
					uploadVideo.setVideoTime(0);
				
					getAllDao().createUploadVideo(uploadVideo);
					myFile.saveAs(newFileName);

				}
			} catch (Exception e) {

			}
			response.sendRedirect("uploadok.html");
		return null;
		}
		
		
		
		
	}

}
