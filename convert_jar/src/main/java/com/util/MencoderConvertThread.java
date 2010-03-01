package com.util;

import java.io.File;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.domain.dao.VideoDao;
import com.domain.dao.VideoDaoImpl;
import com.domain.pojo.Uploadvideo;
import com.domain.pojo.Video;

public class MencoderConvertThread extends Thread {

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
		// TODO 设定视频转换后的路径
	
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
		
		String cmd = "/usr/local/bin/mencoder "+infile+" -o "+outfile+" -of lavf   -oac mp3lame -lameopts abr:br=56 -ovc lavc -lavcopts vcodec=flv:vbitrate=500:mbd=2:mv0:trell:v4mv:cbp:last_pred=3:dia=-1:cmp=0:vb_strategy=1 -vf scale=512:-3 -ofps 12 -srate 22050";
				
				VideoDao videoDao = new VideoDaoImpl();
			new MencoderConvert().executeM(cmd);

			connection = new DbUtil().getConnection();
			Video video = uploadvideo.getVideo();
			video.setUrl(outName);
			video.setFlag(1);
			videoDao.updateVideo(video, connection);
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
