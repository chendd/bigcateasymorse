package com.util;


import java.io.File;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.domain.dao.EventDao;
import com.domain.dao.EventDaoImpl;
import com.domain.dao.VideoDao;
import com.domain.dao.VideoDaoImpl;
import com.domain.pojo.Event;
import com.domain.pojo.Uploadvideo;
import com.domain.pojo.Video;



public class ConvertThread extends Thread{
	


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
		

		
			
			
			uploadvideo.setConvertStatus(PublicParam.SUCC_FLV);
			
			
			VideoDao videoDao = new VideoDaoImpl();
			EventDao eventDao = new EventDaoImpl();
			
			
			try {
				Date date = new Date();
				String strDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
				File file = new File(PublicParam.URL_FLV+strDate);
				if(!file.isDirectory()){
					file.mkdir();
				}
				String infile = PublicParam.URL_IN+uploadvideo.getUrl();
				File file2 = new File(infile);
				if(file2.isFile()){
					
				
				String outName = strDate+"/"+uploadvideo.getId()+"_"+new Date().getTime()+".flv";
				String outfile =PublicParam.URL_FLV+outName;
				String cmd = "/usr/local/bin/ffmpeg  -i " + infile 
				+ " -ar 22050 -ab 56 -f flv -y -s 320x240 " + outfile;
				
				new Convert().ffmpeg(cmd);
				connection = new DbUtil().getConnection();
				Video video = uploadvideo.getVideo();
				video.setUrl(outName);
				video.setFlag(1);
				videoDao.updateVideo(video, connection);
				Event event = new Event();
				event.setDescription("上传的新视频：《"+video.getName()+"》");
				event.setUrl("video/"+video.getId()+"/");
				event.setUserId(video.getUserId());
				event.setAddDate(new Date());
				eventDao.createEvent(event, connection);
				
				new DbUtil().commit(connection);
			
				uploadvideo.setConvertStatus(PublicParam.SUCC_FLV);
				
				}
			
			} catch (Exception e) {
				
				new DbUtil().rollback(connection);
				throw new RuntimeException(e);
				
			}
			finally{
				new DbUtil().close(connection);
			
			}
			
			
	
	}

}
