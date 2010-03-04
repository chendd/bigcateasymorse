package com.video.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ZoomImage {
	
	
	public void ZoomTheImage(String fileUrl,String newUrl,int width,int height){
		java.io.File file = new java.io.File(fileUrl);         //读入刚才上传的文件

	     
	     
	     Image src = null;
		try {
			src = javax.imageio.ImageIO.read(file);
			
		                    //构造Image对象
	   
	     BufferedImage tag = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
	     tag.getGraphics().drawImage(src,0,0,width,height,null);        //绘制缩小后的图
	     FileOutputStream newimage=new FileOutputStream(newUrl);           //输出到文件流
	     JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(newimage);       
	     encoder.encode(tag);                                                //近JPEG编码
	      newimage.close();  	
		} catch (Exception e) {
			
			e.printStackTrace();
		}  
	}
	
	
	public static void resizeImage(String fileUrl,String newUrl) throws Exception{
		java.io.File file = new java.io.File(fileUrl);         //读入刚才上传的文件
	     Image src = javax.imageio.ImageIO.read(file);                      //构造Image对象
	     float tagsize=100;
	     int old_w=src.getWidth(null);                                      //得到源图宽
	     int old_h=src.getHeight(null);   
	     int new_w=120;
	     int new_h=120;                             //得到源图长
	     int tempsize;
	     float tempdouble; 
	     if(old_w>old_h){
	    	 
	      tempdouble=old_w/tagsize;
	     }else{
	      tempdouble=old_h/tagsize;
	     }
	     //new_w=Math.round(old_w/tempdouble);
	     //new_h=Math.round(old_h/tempdouble);
	     BufferedImage tag = new BufferedImage(new_w,new_h,BufferedImage.TYPE_INT_RGB);
	     tag.getGraphics().drawImage(src,0,0,new_w,new_h,null);        //绘制缩小后的图
	     FileOutputStream newimage=new FileOutputStream(newUrl);           //输出到文件流
	     JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(newimage);       
	     encoder.encode(tag);                                                //近JPEG编码
	      newimage.close();  	
	  
		
		
	}
	
	

}
