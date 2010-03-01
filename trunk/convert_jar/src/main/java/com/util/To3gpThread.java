package com.util;


import java.io.File;
import java.sql.Connection;
import java.util.Date;

import com.domain.dao.ProgrammeDao;
import com.domain.dao.ProgrammeDaoImpl;
import com.domain.pojo.Programme;
import com.domain.pojo.Uploadvideo;



public class To3gpThread extends Thread{
	

	
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
		
	
		
			//TODO 设定视频转换后的路径
			int num = uploadvideo.getNum3gp();
			if(num>=1){
				int timeLength = uploadvideo.getVideoTime();
				int perLength = timeLength/num;
				Programme programme = null;
				ProgrammeDao programmeDao = new ProgrammeDaoImpl();
				String infile = PublicParam.URL_FLV+uploadvideo.getVideo().getUrl(); 
				File file = new File(infile);
				if(file.isFile()){
					
				
				for(int i=0;i<num;i++){
					
					int startTime = i*perLength;
				
					String outfile =PublicParam.URL_3GP+new Date().getTime()+".3gp";
					
					programme = new Programme();
					programme.setName(uploadvideo.getId()+"_"+i);
					programme.setAddDate(new Date());
					programme.setChannelId(uploadvideo.getVideo().getChannelId());
					programme.setDownloadUrl(outfile);//TODO
					programme.setFilesize(new File(outfile).length());
					programme.setImage(uploadvideo.getVideo().getImage());
					programme.setIntroDetail(uploadvideo.getVideo().getDescription());
					programme.setUserId(uploadvideo.getVideo().getUserId());
					programme.setVideoId(uploadvideo.getVideo().getId());
					
					try {
						connection = new DbUtil().getConnection();
						programmeDao.createProgramme(connection, programme);
						new DbUtil().commit(connection);
						String cmd = " /usr/local/bin/ffmpeg   -y -i " + infile
						+ " -ac 1 -acodec libamr_nb -ar 8000 -ss " + startTime + " -t "
						+ perLength
						+ "  -r 29.97 -qscale 8 -ab 12200 -s 176x144 -b 128 -r 15   "
						+ outfile;
						
						new Convert().ffmpeg(cmd);
						
					} catch (Exception e) {
						new DbUtil().rollback(connection);
						throw new RuntimeException(e);
					}
					finally{
						
						new DbUtil().close(connection);
					}
				}
			}
			
			}
			
			uploadvideo.setConvertStatus(PublicParam.SUCC_3GP);
			
			
	
		
	  
	
	}

}
