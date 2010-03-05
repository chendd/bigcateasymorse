package com.video.web.struts.videomanage;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jspsmart.upload.SmartUpload;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.video.domain.IndexRecommendVideo;
import com.video.domain.Video;
import com.video.util.SomeStatic;
import com.video.web.struts.BaseAction;

public class UpdateIndexRecommendVideoAction extends BaseAction{
	
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String type = request.getParameter("type");

		if("ajax".equals(type)){
			String strIds = request.getParameter("ids");
			String strVids = request.getParameter("vids");
			if(strIds!=null){
				
		
			String[] ids = strIds.split(",");
			String[] vids = strVids.split(",");
			List<IndexRecommendVideo> list = new ArrayList<IndexRecommendVideo>();
			Long i=new Long(1);
		
				for(String strId : ids){
					
					Long id = Long.parseLong(strId);
				
					IndexRecommendVideo indexRecommendVideo = getAllDao().getIndexRecommendVideoById(id);
					if(indexRecommendVideo!=null){
						indexRecommendVideo.setId(i);
						
						
					}
					else{
						indexRecommendVideo = new IndexRecommendVideo();
						indexRecommendVideo.setId(i);
						Long vid = Long.parseLong(vids[i.intValue()-1]);
						
						Video video = getAllDao().getVideoById(vid);
						indexRecommendVideo.setName(video.getName());
						indexRecommendVideo.setDescription(video.getDescription());
						indexRecommendVideo.setImageUrl(video.getImage());
						indexRecommendVideo.setVideo(video);
					}
					list.add(indexRecommendVideo);
					i++;
				}
				getAllDao().deleteIndexRecommendVideo();
				for(IndexRecommendVideo video:list){
					getAllDao().createIndexRecommendVideo(video);
					
				}
			}
			response.getWriter().write("ok");
			return null;
		}
else if("image".equals(type)){
			String strId = request.getParameter("id");
			Long id = new Long(0);
			if(strId!=null &&!strId.isEmpty()){
				id = Long.parseLong(strId);
			}
			IndexRecommendVideo indexRecommendVideo = getAllDao().getIndexRecommendVideoById(id);
			SmartUpload mySmartUpload = new SmartUpload();
			mySmartUpload.setAllowedFilesList("jpg,gif");
			mySmartUpload.setMaxFileSize(10240000);
			ServletConfig ctx = getServlet().getServletConfig();
			mySmartUpload.initialize(ctx, request, response);

			try {
				mySmartUpload.upload();

				com.jspsmart.upload.File myFile = mySmartUpload.getFiles().getFile(
						0);

				if (!myFile.isMissing()) {
					
					String FileType = myFile.getFileExt();
					FileType = FileType.toLowerCase(); // 将扩展名转换成小写
					int FileSize = myFile.getSize();
					String newFileName = SomeStatic.UPLOAD_USERFACE_URL+"/upload/videoImg/indexVideo"+id+"." + FileType; // 可自动生成文件名以防止同名覆盖
					myFile.saveAs(newFileName);
	
				      indexRecommendVideo.setImageUrl("/upload/videoImg/indexVideo"+id+"."+FileType);
				     getAllDao().updateIndexRecommendVideo(indexRecommendVideo);
				}
			} catch (Exception e) {

			}
			response.sendRedirect("uploadok.html");
			return null;
		}
		
		else{
			String strId =request.getParameter("id");
			
			if(strId!=null && !strId.trim().isEmpty()){
				Long id = Long.parseLong(strId);
				String name = request.getParameter("name");
				String description = request.getParameter("description");
				IndexRecommendVideo indexRecommendVideo = getAllDao().getIndexRecommendVideoById(id);
				indexRecommendVideo.setDescription(description);
				indexRecommendVideo.setName(name);
				getAllDao().updateIndexRecommendVideo(indexRecommendVideo);
				
			}
		
			return mapping.findForward("success");
		}
		
	}

}
