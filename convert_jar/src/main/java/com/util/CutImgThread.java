package com.util;


import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;

import jcifs.smb.SmbFileOutputStream;

import com.domain.dao.VideoDao;
import com.domain.dao.VideoDaoImpl;
import com.domain.pojo.Uploadvideo;
import com.domain.pojo.Video;

public class CutImgThread extends Thread {



	private Uploadvideo uploadvideo;
	
	









	public Uploadvideo getUploadvideo() {
		return uploadvideo;
	}







	public void setUploadvideo(Uploadvideo uploadvideo) {
		this.uploadvideo = uploadvideo;
	}












	@Override
	public void run() {
		Connection connection = null;
	
	try{
			// TODO 设定图片路径
			String picName = PublicParam.URL_IMAGE + "v"+uploadvideo.getVideo().getId()
					+ ".jpg";
			
			String infile = PublicParam.URL_FLV+uploadvideo.getVideo().getUrl(); 
			File file = new File(infile);
			if(file.isFile()){
				
			
			
			
			String cmd = "/usr/local/bin/ffmpeg -i " + infile
			+ " -y -f  image2  -ss 00:00:02 -vframes 1 -t 1 -s 120*90  "
			+ picName;
			
			
			System.out.println(cmd);
			new Convert().ffmpeg(cmd);
//			String outUrl = PublicParam.URL_VIDEOIMG+"/upload/videoImg/v"+uploadvideo.getVideo().getId()+".jpg";
//			FileInputStream fis  = new FileInputStream(picName);
//			SmbFileOutputStream fos = new SmbFileOutputStream(outUrl);
//		     byte[] buf = new byte[1024];
//		     int i = 0;
//		     while((i=fis.read(buf))!=-1) {
//		       fos.write(buf, 0, i);
//		       }
//		     fis.close();
//		     fos.close();
			VideoDao videoDao = new VideoDaoImpl();
			connection = new DbUtil().getConnection();
			Video video = uploadvideo.getVideo();
		
			video.setImage("/upload/videoImg/v"+uploadvideo.getVideo().getId()+".jpg");
			video.setFlag(1);
			videoDao.updateVideo(video, connection);
			new DbUtil().commit(connection);
			
			uploadvideo.setConvertStatus(PublicParam.SUCC_CUTIMG);
			}
	}
	catch (Exception e) {
		new DbUtil().rollback(connection);
		throw new RuntimeException(e);
		
	}
	finally{
		new DbUtil().close(connection);
	}
	
			
	


	}

}
