package com.video.web.struts.videomanage;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.VideoChannel;
import com.video.web.struts.BaseAction;

public class MoveVideoChannelAction extends BaseAction {

	private List<VideoChannel> childVideoChannelList = null;

	private void notMoveVideoChannelList(VideoChannel parentVideoChannel) {
		childVideoChannelList.add(parentVideoChannel);
		List<VideoChannel> childList = getAllDao().getChildVideoChannelList(
				parentVideoChannel.getId());
		for (VideoChannel videoChannel : childList) {
			notMoveVideoChannelList(videoChannel);
		}
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String flag = request.getParameter("flag");
		String ids = request.getParameter("id");
		Long id = null;
		String url = "init";
		if (ids != null && !ids.trim().isEmpty()) {
			id = Long.parseLong(ids);
		}

		if (flag != null && !flag.trim().isEmpty()) {
			String endIds = request.getParameter("endId");
			Long endId = null;
			if (endIds != null && !endIds.trim().isEmpty()) {
				endId = Long.parseLong(endIds);
			}
			VideoChannel videoChannel = new VideoChannel();
			videoChannel.setId(id);
			videoChannel.setParentId(endId);

			getAllDao().updateVideoChannelWithParent(videoChannel);
			url = "success";

		} else {
			childVideoChannelList = new ArrayList<VideoChannel>();
			VideoChannel videoChannel = getAllDao().getVideoChannelById(id);
			notMoveVideoChannelList(videoChannel);

			List<VideoChannel> videoChannelAllList = getAllDao()
					.getVideoChannelList();

			List<VideoChannel> videoChannelList = new ArrayList<VideoChannel>();

			for (VideoChannel videoChannels : videoChannelAllList) {
				boolean ff = false;
				for (VideoChannel childVideoChannel : childVideoChannelList) {
					if (videoChannels.getId().equals(childVideoChannel.getId())) {
						ff = true;
						break;
					}
				}
				if (!ff) {
					videoChannelList.add(videoChannels);
				}
			}
			request.setAttribute("videoChannelList", videoChannelList);
			request.setAttribute("videoChannel", videoChannel);
		}

		return mapping.findForward(url);
	}
}
