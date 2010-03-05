package com.video.web.struts.group;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jspsmart.upload.SmartUpload;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.video.domain.User;
import com.video.web.struts.BaseAction;

public class UpdateUserFaceAction extends BaseAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 初始化
		String strId = request.getParameter("id");
		Long id = Long.parseLong(strId);
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
				String newFileName = request.getRealPath("/")+"upload/subfile/face"+id+"." + FileType; // 可自动生成文件名以防止同名覆盖
				myFile.saveAs(newFileName);
//----
				
				java.io.File file = new java.io.File(newFileName);         //读入刚才上传的文件
			     String newurl=request.getRealPath("/")+"upload/userface/face"+id+".jpg";   //新的缩略图保存地址
			     
			     
			     Image src = javax.imageio.ImageIO.read(file);                      //构造Image对象
			     float tagsize=200;
			     int old_w=src.getWidth(null);                                      //得到源图宽
			     int old_h=src.getHeight(null);   
			     int new_w=0;
			     int new_h=0;                             //得到源图长
			     int tempsize;
			     float tempdouble; 
			     if(old_w>old_h){
			    	 
			      tempdouble=old_w/tagsize;
			     }else{
			      tempdouble=old_h/tagsize;
			     }
			     new_w=Math.round(old_w/tempdouble);
			     new_h=Math.round(old_h/tempdouble);
			     BufferedImage tag = new BufferedImage(new_w,new_h,BufferedImage.TYPE_INT_RGB);
			     tag.getGraphics().drawImage(src,0,0,new_w,new_h,null);        //绘制缩小后的图
			     FileOutputStream newimage=new FileOutputStream(newurl);           //输出到文件流
			     JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(newimage);       
			     encoder.encode(tag);                                                //近JPEG编码
			      newimage.close();  	
			     User user = getAllDao().getUserById(id);
			     user.setFace("/upload/userface/face"+id+".jpg");
			     getAllDao().updateUser(user);
			}
		} catch (Exception e) {

		}
		response.sendRedirect("uploadok.html");
		return null;
	}

}
