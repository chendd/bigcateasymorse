package com.video.web.struts.videomanage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Group;
import com.video.domain.Video;
import com.video.domain.VideoChannel;
import com.video.util.Pagination;
import com.video.util.SomeStatic;
import com.video.web.struts.BaseAction;

public class GetVideoesAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		int pageSize = 10;
		int pageNo = 1;
		String str_pageNo = request.getParameter("pageNo");
		if(str_pageNo!=null){
			pageNo = Integer.parseInt(str_pageNo);
		}
		String strChannelId = request.getParameter("channelId");
		
		Pagination<Video> pagination = new Pagination<Video>();
		if(strChannelId != null && !strChannelId.trim().isEmpty() &&!"all".equals(strChannelId)){
			Long channelId = Long.parseLong(strChannelId);
			Video video = new Video();
			video.setChannelId(channelId);
			pagination.setCondition(video);
		}
		
		pagination.setNo(pageNo);
		pagination.setSize(pageSize);
		getAllDao().getVideoes(pagination);
		List<VideoChannel> channels=getAllDao().getVideoChannelList();
		request.setAttribute("channels", channels);
		request.setAttribute("pagination", pagination);
		return mapping.findForward("success");
		
	}

}
