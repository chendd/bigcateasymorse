package com.video.web.struts.videomanage;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Video;
import com.video.domain.VideoChannel;
import com.video.web.struts.BaseAction;

public class UniteVideoChannelAction extends BaseAction {

	private List<VideoChannel> childVideoChannelList = null;

	private void notMoveVideoChannelList(VideoChannel parentVideoChannel) {
		childVideoChannelList.add(parentVideoChannel);
		List<VideoChannel> childList = getAllDao().getChildVideoChannelList(
				parentVideoChannel.getId());
		for (VideoChannel videoChannel : childList) {
			notMoveVideoChannelList(videoChannel);
		}
	}

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String flag = request.getParameter("flag");
		String url = "init";
		if (flag != null && !flag.trim().isEmpty()) {
			childVideoChannelList = new ArrayList<VideoChannel>();
			String sourceVideoChannelIds = request
					.getParameter("sourceVideoChannelId");
			String destinationVideoChannelIds = request
					.getParameter("destinationVideoChannelId");
			Long sourceVideoChannelId = sourceVideoChannelIds == null ? null
					: Long.parseLong(sourceVideoChannelIds);
			Long destinationVideoChannelId = destinationVideoChannelIds == null ? null
					: Long.parseLong(destinationVideoChannelIds);

			VideoChannel videoChannel = new VideoChannel();
			Video video = new Video();

			video.setId(sourceVideoChannelId);
			video.setChannelId(destinationVideoChannelId);

			videoChannel.setId(sourceVideoChannelId);
			videoChannel.setParentId(destinationVideoChannelId);
			notMoveVideoChannelList(videoChannel);
			boolean ff = false;
			for (VideoChannel channel : childVideoChannelList) {
				if (channel.getId().equals(destinationVideoChannelId)) {
					ff = true;
				}
			}

			if (ff) {
				List<VideoChannel> videoChannelTree = getAllDao()
						.getVideoChannelList();
				request.setAttribute("videoChannelTree", videoChannelTree);
				request.setAttribute("error", "对不起不能将一个栏目合并到其子栏目下！");
			} else {
				getAllDao().updateVideoChannelWithParentByParent(videoChannel);
				getAllDao().deleteVideoChannel(videoChannel.getId());
				getAllDao().updateVideoWithChannelByVideoChannelId(video);
				url = "success";
			}

		} else {
			List<VideoChannel> videoChannelTree = getAllDao()
					.getVideoChannelList();
			request.setAttribute("videoChannelTree", videoChannelTree);
		}
		return mapping.findForward(url);
	}
}
