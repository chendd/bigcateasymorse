package cn.vsp;

import java.util.Date;




public class NewsBean {

private Long id;

	private String newsTitle;
	
	
	private String newsDate;

	private String newAuthor;

	private String enNewAuthor;
	private String newsUrl;
	/**
	 * 标识，true表示是世博会新闻，false表示是普通新闻 
	 */
	
	private String exponews;
	
	
	public String getExponews() {
		return exponews;
	}

	public void setExponews(String exponews) {
		this.exponews = exponews;
	}

	public String getEnNewAuthor() {
		return enNewAuthor;
	}

	public void setEnNewAuthor(String enNewAuthor) {
		this.enNewAuthor = enNewAuthor;
	}

	
	private String newsContent;


	private String enNewsTitle;
	
	private String enNewsContent;

	public String getEnNewsTitle() {
		return enNewsTitle;
	}

	public void setEnNewsTitle(String enNewsTitle) {
		this.enNewsTitle = enNewsTitle;
	}

	public String getEnNewsContent() {
		return enNewsContent;
	}

	public void setEnNewsContent(String enNewsContent) {
		this.enNewsContent = enNewsContent;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}




	public String getNewsDate() {
		return newsDate;
	}

	public void setNewsDate(String newsDate) {
		this.newsDate = newsDate;
	}

	public String getNewAuthor() {
		return newAuthor;
	}

	public void setNewAuthor(String newAuthor) {
		this.newAuthor = newAuthor;
	}

	public String getNewsUrl() {
		return newsUrl;
	}

	public void setNewsUrl(String newsUrl) {
		this.newsUrl = newsUrl;
	}

	public String getNewsContent() {
		return newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}

}
