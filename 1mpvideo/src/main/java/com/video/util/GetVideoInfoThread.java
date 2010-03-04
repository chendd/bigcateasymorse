package com.video.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Random;

import com.video.domain.UploadVideo;
import com.video.domain.logic.AllServiceFacade;

public class GetVideoInfoThread extends Thread{
	private AllServiceFacade allService;
	private String infile;
	private UploadVideo uploadVideo;
	private String length="0";
	public UploadVideo getUploadVideo() {
		return uploadVideo;
	}

	public void setUploadVideo(UploadVideo uploadVideo) {
		this.uploadVideo = uploadVideo;
	}

	public AllServiceFacade getAllService() {
		return allService;
	}

	public void setAllService(AllServiceFacade allService) {
		this.allService = allService;
	}

	public String getInfile() {
		return infile;
	}

	public void setInfile(String infile) {
		this.infile = infile;
	}

	@Override
	public void run() {
		try {

			
			File file = new File(this.infile);
			if (file.isFile()) {

				String cmd = "/usr/local/bin/mplayer -identify "+this.infile+" -nosound -vc dummy -vo null";
				ffmpeg(cmd);

			}
		} catch (Exception e) {

			throw new RuntimeException(e);

		}

	}

	public boolean ffmpeg(String cmd) {
		String[] cmds = { "/bin/sh", "-c", cmd };
		try {
			Runtime rt = Runtime.getRuntime();
			Process proc = rt.exec(cmds);
			InputStream stderr = proc.getInputStream();
			InputStreamReader isr = new InputStreamReader(stderr);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
		
			System.out.println("<ERROR>");
			while ((line = br.readLine()) != null) {
				if(line.indexOf("ID_LENGTH")!=-1){
					this.length=line;
				}
				System.out.println(line);
			}
			System.out.println("</ERROR>");
			if(!this.length.equals("0")){
				this.length = this.length.replace("ID_LENGTH=", "");
				float f = Float.parseFloat(this.length);
				int timeLength = Math.round(f);
				this.uploadVideo.setVideoTime(timeLength);
				this.uploadVideo.getVideo().setVideoTime(timeLength);
				getAllService().updateVideo(this.uploadVideo.getVideo());
				getAllService().updateUploadVideoLength(uploadVideo);
			}
			while (true) {
				if (proc.waitFor() == 0)
					break;
			}
		} catch (Throwable t) {
			throw new RuntimeException(t);

		}

		return true;

	}
	
	public static void main(String[] args) {
	int a = new 	Random().nextInt(10000);
	System.out.println(a);
	}

}
