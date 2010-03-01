package com.main;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.domain.dao.UploadvideoDao;
import com.domain.dao.UploadvideoDaoImpl;
import com.domain.dao.VideoDao;
import com.domain.dao.VideoDaoImpl;
import com.domain.pojo.Uploadvideo;
import com.domain.pojo.Video;
import com.util.DbUtil;
import com.util.LockFileOperation;
import com.util.PublicParam;

public class MainFunction {

	public static void main(String[] args) {

		String lockStatus = LockFileOperation.readValue(PublicParam.LOCK_FILE,
				"status");
		System.out.println("------------:" + lockStatus);
		if (lockStatus.equals("unlock")) {
			LockFileOperation.modifyValue(PublicParam.LOCK_FILE, "status",
					"locked");
			System.out.println(LockFileOperation.readValue(
					PublicParam.LOCK_FILE, "status"));

			Connection connection = null;
			try {

				connection = new DbUtil().getConnection();
				List<Uploadvideo> uploadVideoes = new ArrayList<Uploadvideo>();
				UploadvideoDao uploadvideoDao = new UploadvideoDaoImpl();
				VideoDao videoDao = new VideoDaoImpl();
				uploadVideoes = uploadvideoDao.getUploadvideoes(connection);
				for(Uploadvideo uploadvideo:uploadVideoes){
					Video video = videoDao.findVideoById(uploadvideo.getVideo().getId(), connection);
					uploadvideo.setVideo(video);
					
				}
				int size = uploadVideoes.size();
				int x=size/5;
				int y = size%5;
				List<Uploadvideo> subList1 = new ArrayList<Uploadvideo>();
				List<Uploadvideo> subList2 =new ArrayList<Uploadvideo>();
				List<Uploadvideo> subList3 =new ArrayList<Uploadvideo>();
				List<Uploadvideo> subList4 =new ArrayList<Uploadvideo>();
				List<Uploadvideo> subList5 =new ArrayList<Uploadvideo>();
				if(x>0){
					for(int i=0;i<x*5;i++){
						if(i%5==0){
							subList1.add(uploadVideoes.get(i));
						}
						if(i%5==1){
							subList2.add(uploadVideoes.get(i));
						}
						if(i%5==2){
							subList3.add(uploadVideoes.get(i));
						}
						if(i%5==3){
							subList4.add(uploadVideoes.get(i));
						}
						if(i%5==4){
							subList5.add(uploadVideoes.get(i));
						}
						
					}
				}
				if(y>0){
					for(int i=0;i<y;i++){
						if(i%5==0){
							subList1.add(uploadVideoes.get(x*5+i));
						}
						if(i%5==1){
							subList2.add(uploadVideoes.get(x*5+i));
							
						}
						if(i%5==2){
							subList3.add(uploadVideoes.get(x*5+i));
						}
						if(i%5==3){
							subList4.add(uploadVideoes.get(x*5+i));
						}
					}
					
				}

				Converting converting1 = new Converting();
				converting1.setUploadVideoes(subList1);
				Converting converting2 = new Converting();
				converting2.setUploadVideoes(subList2);
				Converting converting3 = new Converting();
				converting3.setUploadVideoes(subList3);
				Converting converting4 = new Converting();
				converting4.setUploadVideoes(subList4);
				Converting converting5 = new Converting();
				converting5.setUploadVideoes(subList5);
				if (subList1.size() > 0) {

					converting1.start();
				}
				if (subList2.size() > 0) {

					converting2.start();
				}
				if (subList3.size() > 0) {

					converting3.start();
				}
				if (subList4.size() > 0) {

					converting4.start();
				}
				if (subList5.size() > 0) {

					converting5.start();
				}
				
				while(true){
					if(!converting1.isAlive()&&!converting2.isAlive()&&!converting3.isAlive()&&!converting4.isAlive()&&!converting5.isAlive()){
					
						break;
					}
				}
				System.out.println("end");

			} catch (Exception e) {
				LockFileOperation.modifyValue(PublicParam.LOCK_FILE, "status",
						"unlock");
				e.printStackTrace();

			}
			finally{
				System.out.println("+---sdfun==");
				LockFileOperation.modifyValue(PublicParam.LOCK_FILE, "status",
				"unlock");
			}
			
			

		}
		
	}

}
