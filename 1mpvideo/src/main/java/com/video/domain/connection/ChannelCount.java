package com.video.domain.connection;

import java.io.Serializable;

import com.video.domain.VideoChannel;

public class ChannelCount implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private VideoChannel channel;
	private int count;
	
	public VideoChannel getChannel() {
		return channel;
	}
	public void setChannel(VideoChannel channel) {
		this.channel = channel;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	

}
