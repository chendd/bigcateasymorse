package com.video.util;

import java.io.FileInputStream;

import jcifs.smb.SmbFileOutputStream;

import com.video.domain.UploadVideo;
import com.video.domain.logic.AllServiceFacade;

public class CopyFile extends Thread{
	private Long videoId;
	private String inUrl;
	private String outUrl;
	private AllServiceFacade allService;

	public AllServiceFacade getAllService() {
		return allService;
	}

	public void setAllService(AllServiceFacade allService) {
		this.allService = allService;
	}
	
	
	
	public String getInUrl() {
		return inUrl;
	}




	public void setInUrl(String inUrl) {
		this.inUrl = inUrl;
	}




	public String getOutUrl() {
		return outUrl;
	}




	public void setOutUrl(String outUrl) {
		this.outUrl = outUrl;
	}




	@Override
	public void run() {
		try{
			 FileInputStream fis  = new FileInputStream(inUrl);
			 SmbFileOutputStream fos = new SmbFileOutputStream(outUrl);
		     byte[] buf = new byte[1024];
		     int i = 0;
		     while((i=fis.read(buf))!=-1) {
		       fos.write(buf, 0, i);
		       }
		     fis.close();
		     fos.close();
		     
		     UploadVideo video = new UploadVideo();
		     video.setId(videoId);
		     video.setStauts(0);
		     getAllService().updateUploadVideoStatus(video);
		    
			}
		catch(Exception e){
			e.printStackTrace();
		}
		

		
	}

	public Long getVideoId() {
		return videoId;
	}

	public void setVideoId(Long videoId) {
		this.videoId = videoId;
	}
	
}