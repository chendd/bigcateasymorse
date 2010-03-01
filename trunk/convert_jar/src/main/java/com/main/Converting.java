package com.main;


import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.domain.dao.UploadvideoDao;
import com.domain.dao.UploadvideoDaoImpl;
import com.domain.pojo.Uploadvideo;
import com.util.ConvertThread;
import com.util.CutImgThread;
import com.util.DbUtil;
import com.util.MencoderConvertThread;
import com.util.PublicParam;
import com.util.To3gpThread;

public class Converting extends Thread{
	private List<Uploadvideo> uploadVideoes = new ArrayList<Uploadvideo>();
	
	
	public List<Uploadvideo> getUploadVideoes() {
		return uploadVideoes;
	}



	public void setUploadVideoes(List<Uploadvideo> uploadVideoes) {
		this.uploadVideoes = uploadVideoes;
	}



	@Override
	public void run() {
	this.convertStart();
	}
	
	

	
	public void convertStart(){
		
		
		Connection connection = null;
	System.out.println(uploadVideoes.size());
		for(Uploadvideo video:uploadVideoes){
			
			try{
			
				ConvertThread convertThread = new ConvertThread();
				MencoderConvertThread mencoderConvertThread = new MencoderConvertThread();
				if(video.getVideoType().equals("rm")||video.getVideoType().equals("rmvb")){
					
					mencoderConvertThread.setUploadvideo(video);
					
					mencoderConvertThread.start();
				}
				else if(video.getVideoType()!=null && !video.getVideoType().trim().isEmpty()){
					
					
					convertThread.setUploadvideo(video);
				
					convertThread.start();
					
					
				}
				
				while(true){
				
					if(!convertThread.isAlive()&&!mencoderConvertThread.isAlive()){
					
						break;
					}
				}
				
				CutImgThread cutImgThread = new CutImgThread();
				
				cutImgThread.setUploadvideo(video);
				cutImgThread.start();
				while(true){
					
					if(!cutImgThread.isAlive()){
						break;
					}
				}
				
						
				To3gpThread to3gpThread = new To3gpThread();
				to3gpThread.setUploadvideo(video);
				to3gpThread.start();
				while(true){
					if(!to3gpThread.isAlive()){
						break;
					}
				}
			
					connection = new DbUtil().getConnection();
					UploadvideoDao uploadvideoDao = new UploadvideoDaoImpl();
					uploadvideoDao.updateUploadvideo(video, connection);
					new DbUtil().commit(connection);
					
					String infile = PublicParam.URL_IN+video.getUrl();
					File file = new File(infile);
					if(file.isFile()){
						file.delete();
					}
				
				
			}
			catch (Exception e) {
				
				new DbUtil().rollback(connection);
				e.printStackTrace();
			}
			finally{
				new DbUtil().close(connection);
				
			}
			
		}
		
		
		
		

	}
	

}