package com.domain.pojo;


import java.io.Serializable;
import java.util.Date;

/**
 * 
* @author <a href="mailto:jarrywin@gmail.com">Jarry Zheng</a>
*
* $LastChangedBy$
* $LastChangedDate$
* $LastChangedRevision$
* $HeadURL$
* 
* 3gp视频类
 */
public class Programme implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long channelId;
	private String name;
	private Long filesize;
	private int timeLength;
	private String image;
	private  Date addDate;
    private Date updateDate;
    private String introDetail;
    private String downloadUrl;
    private int downloadTimes;
    private int browseTimes;
    private Long userId;
    private Long videoId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getChannelId() {
		return channelId;
	}
	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getFilesize() {
		return filesize;
	}
	public void setFilesize(Long filesize) {
		this.filesize = filesize;
	}
	public int getTimeLength() {
		return timeLength;
	}
	public void setTimeLength(int timeLength) {
		this.timeLength = timeLength;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getIntroDetail() {
		return introDetail;
	}
	public void setIntroDetail(String introDetail) {
		this.introDetail = introDetail;
	}
	public String getDownloadUrl() {
		return downloadUrl;
	}
	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}
	public int getDownloadTimes() {
		return downloadTimes;
	}
	public void setDownloadTimes(int downloadTimes) {
		this.downloadTimes = downloadTimes;
	}
	public int getBrowseTimes() {
		return browseTimes;
	}
	public void setBrowseTimes(int browseTimes) {
		this.browseTimes = browseTimes;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getVideoId() {
		return videoId;
	}
	public void setVideoId(Long videoId) {
		this.videoId = videoId;
	}
    public Programme() {
		
	}
    

    

}
