package com.video.util;

import java.util.ResourceBundle;

public class SomeStatic {
	public final static ResourceBundle resourceBundle = ResourceBundle
			.getBundle("StaticValue");
	public final static String[] ALL_LAYOUT = resourceBundle.getString(
			"ALL_LAYOUT").split(",");
	public final static int VIDEOTAG_NEW_PAGESIZE = Integer
			.parseInt(resourceBundle.getString("VIDEOTAG_NEW_PAGESIZE"));
	public final static int VIDEOTAG_HOT_PAGESIZE = Integer
			.parseInt(resourceBundle.getString("VIDEOTAG_HOT_PAGESIZE"));
	public final static int VIDEOTAG_MY_PAGESIZE = Integer
			.parseInt(resourceBundle.getString("VIDEOTAG_MY_PAGESIZE"));
	public final static int VIDEOTAG_LIKE_PAGESIZE = Integer
			.parseInt(resourceBundle.getString("VIDEOTAG_LIKE_PAGESIZE"));
	public final static int TAGSTRONGUSER_SIZE = Integer
			.parseInt(resourceBundle.getString("TAGSTRONGUSER_SIZE"));
	public final static int SYSTEMKEYWORD_SIZE = Integer
			.parseInt(resourceBundle.getString("SYSTEMKEYWORD_SIZE"));
	public final static int VIDEO_TAG_PAGESIZE = Integer
			.parseInt(resourceBundle.getString("VIDEO_TAG_PAGESIZE"));
	public final static int VIDEO_KEY_PAGESIZE = Integer
			.parseInt(resourceBundle.getString("VIDEO_KEY_PAGESIZE"));
	public final static int VIDEO_INDEX_PAGESIZE = Integer
			.parseInt(resourceBundle.getString("VIDEO_INDEX_PAGESIZE"));
	public final static int VIDEO_MYCOMMENTVIDEO_PAGESIZE = Integer
			.parseInt(resourceBundle.getString("VIDEO_MYCOMMENTVIDEO_PAGESIZE"));
	public final static int VIDEO_BROWSEHISTORY_PAGESIZE = Integer
			.parseInt(resourceBundle.getString("VIDEO_BROWSEHISTORY_PAGESIZE"));
	public final static int VIDEO_COMMENT_PAGESIZE = Integer
			.parseInt(resourceBundle.getString("VIDEO_COMMENT_PAGESIZE"));
	public final static int VIDEO_OTHER_PAGESIZE = Integer
			.parseInt(resourceBundle.getString("VIDEO_OTHER_PAGESIZE"));
	public final static int USER_OTHER_PAGESIZE = Integer
			.parseInt(resourceBundle.getString("USER_OTHER_PAGESIZE"));
	public final static int PLAYBILL_MYSUBSCRIBE_PAGESIZE = Integer
			.parseInt(resourceBundle.getString("PLAYBILL_MYSUBSCRIBE_PAGESIZE"));
	public final static int PLAYBILL_MY_PAGESIZE = Integer
			.parseInt(resourceBundle.getString("PLAYBILL_MY_PAGESIZE"));
	public final static int PLAYBILL_PARTICULAR_PAGESIZE = Integer
			.parseInt(resourceBundle.getString("PLAYBILL_PARTICULAR_PAGESIZE"));
	public final static int PLAYBILL_COMMENT_PAGESIZE = Integer
			.parseInt(resourceBundle.getString("PLAYBILL_COMMENT_PAGESIZE"));
	public final static int PLAYBILL_OTHER_PAGESIZE = Integer
			.parseInt(resourceBundle.getString("PLAYBILL_OTHER_PAGESIZE"));
	public final static int PLAYBILL_NEW_PAGESIZE = Integer
			.parseInt(resourceBundle.getString("PLAYBILL_NEW_PAGESIZE"));
	public final static int TAG_ABOUTUSER_PAGESIZE = Integer
			.parseInt(resourceBundle.getString("TAG_ABOUTUSER_PAGESIZE"));
	public final static int PLAYBILL_ADDVIDEO_PAGESIZE = Integer
			.parseInt(resourceBundle.getString("PLAYBILL_ADDVIDEO_PAGESIZE"));
	public final static int PLAYBILLLIST_MY_PAGESIZE = Integer
			.parseInt(resourceBundle.getString("PLAYBILLLIST_MY_PAGESIZE"));
	public final static int PLAYBILL_VIDEO_PAGESIZE = Integer
			.parseInt(resourceBundle.getString("PLAYBILL_VIDEO_PAGESIZE"));
	public final static int SEARCH_VIDEO_PAGESIZE = Integer
			.parseInt(resourceBundle.getString("SEARCH_VIDEO_PAGESIZE"));
	public final static int SEARCH_PLAYBILL_PAGESIZE = Integer
			.parseInt(resourceBundle.getString("SEARCH_PLAYBILL_PAGESIZE"));
	public final static int VIDEO_MY_PAGE = Integer.parseInt(resourceBundle
			.getString("VIDEO_MY_PAGE"));
	public final static int VIDEO_MY_LIST = Integer.parseInt(resourceBundle
			.getString("VIDEO_MY_LIST"));
	public final static int VIDEO_MY_TAG = Integer.parseInt(resourceBundle
			.getString("VIDEO_MY_TAG"));
	public final static int SEARCH_VBLOG_PAGESIZE = Integer
			.parseInt(resourceBundle.getString("SEARCH_VBLOG_PAGESIZE"));
	public final static String IMAGE_URL = resourceBundle
			.getString("IMAGE_URL");
	public final static String UPLOAD_VIDEO_URL = resourceBundle
			.getString("UPLOAD_VIDEO_URL");
	public final static String UPLOAD_USERFACE_URL = resourceBundle
			.getString("UPLOAD_USERFACE_URL");
	public final static String UPLOAD_GROUP_URL = resourceBundle
			.getString("UPLOAD_GROUP_URL");
	public final static String UPLOAD_PLAYBILL_URL = resourceBundle
			.getString("UPLOAD_PLAYBILL_URL");
	public final static String PRIVIEW_URL = resourceBundle
	.getString("PRIVIEW_URL");

}
