/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.video.web.struts.video;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
//import org.apache.struts.actions.MappingDispatchAction;

import com.video.domain.UploadVideo;
import com.video.domain.User;
import com.video.domain.Video;
import com.video.util.CopyFile;
import com.video.util.GetVideoInfoThread;
import com.video.util.SomeStatic;
import com.video.util.UtilMethod;
import com.video.web.struts.BaseAction;

/**
 * MyEclipse Struts Creation date: 05-18-2007
 * 
 * XDoclet definition:
 * 
 * @struts.action validate="true"
 */
public class UploadFilesAction extends BaseAction {
	/*
	 * Generated Methods
	 */

	/**
	 * Method execute
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	String strId = request.getParameter("id");
	Long id = UtilMethod.longFormat(strId);
	User user = getAllService().getUserById(id);
	
		Video video = new Video();
		UploadVideo uploadVideo = new UploadVideo();
		try {
			request.setCharacterEncoding("UTF-8");
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			//upload.setHeaderEncoding(request.getCharacterEncoding());
		
			List items = (List) upload.parseRequest(request);
			Long videoId=null;
			Iterator iter = items.iterator();
			String fName = null;
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();

				if (item.isFormField()) {/*
					String name = item.getFieldName();
					String value = item.getString();
					System.out.println("name = " + name);
					System.out.println("value = " + value);
					System.out.println("/r/n");*/
				} else {
					String fieldName = item.getFieldName();
					String fileName = item.getName();
					long sizeInBytes = item.getSize();
					getListInSession(request).add(fileName);
					getListInSession(request).add(UUID.randomUUID());
					String contentType = item.getContentType();
					int i = fileName.lastIndexOf('.');
					String name = fileName.substring(0, i);
					String type = fileName.substring(i+1, fileName.length()).toLowerCase();
					int size = (int)sizeInBytes/1000;
					
					
//					System.out.println(type);
//					System.out.println("fieldName = " + fieldName);
//					System.out.println("fileName = " + fileName);
//					System.out.println("contentType = " + contentType);
//					
//					System.out.println("size = " + size);
//					System.out.println("br");
//					
//					System.out.println(item.getContentType());
					 fName = user.getUserName()+new Date().getTime()+"."+type;
					File file = new File(SomeStatic.UPLOAD_USERFACE_URL+"/upload/uploadvideoes/"+fName);
					item.write(file);
					
					video.setName(name);
					video.setChannelId(new Long(1));
					video.setAddDate(new Date());
					video.setVideoSize(size);
					video.setImage("/images/p_video.jpg");
					video.setUser(user);
					getAllService().createVideo(video);
					
					
					uploadVideo.setVideo(video);
					uploadVideo.setVideoType(type);
					uploadVideo.setUrl(fName);
					getAllService().createUploadVideo(uploadVideo);
					videoId = uploadVideo.getId();
					
					
					
					
					
				}
			}
			uploadVideo.setVideo(video);
			GetVideoInfoThread getVideoInfoThread = new GetVideoInfoThread();
			getVideoInfoThread.setAllService(getAllService());
			getVideoInfoThread.setUploadVideo(uploadVideo);
			getVideoInfoThread.setInfile(SomeStatic.UPLOAD_USERFACE_URL+"/upload/uploadvideoes/"+fName);
			getVideoInfoThread.start();
			File file = new File(SomeStatic.UPLOAD_USERFACE_URL+"/upload/uploadvideoes/"+fName);
			if(file.isFile()){
				CopyFile copyFile  = new CopyFile();
				copyFile.setAllService(getAllService());
				copyFile.setVideoId(videoId);
				copyFile.setInUrl(SomeStatic.UPLOAD_USERFACE_URL+"/upload/uploadvideoes/"+fName);
				copyFile.setOutUrl(SomeStatic.UPLOAD_VIDEO_URL+"/video/"+fName);
				copyFile.start();
				
				
				
			}
			else{
				System.out.println("error");
			}
			System.out.println("-------- final--------");
			response.getWriter().print(video.getId());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		

		return null;
	}


	public List getListInSession(HttpServletRequest request) {
		List result = (List) request.getSession().getAttribute("_result");
		if (result == null) {
			result = new ArrayList();
			request.getSession().setAttribute("_result", result);
		}
		return result;

	}
}


