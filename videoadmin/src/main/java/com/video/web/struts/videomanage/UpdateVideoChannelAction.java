package com.video.web.struts.videomanage;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.UserLevel;
import com.video.domain.VideoChannel;
import com.video.web.formbean.VideoChannelFormBean;
import com.video.web.struts.BaseAction;

public class UpdateVideoChannelAction extends BaseAction {

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
		String ids = request.getParameter("id");
		String url = "init";
		if (flag != null && !flag.trim().isEmpty()) {
			VideoChannelFormBean videoChannelFormBean = (VideoChannelFormBean) form;
			VideoChannel videoChannel = new VideoChannel();
			BeanUtils.copyProperties(videoChannel, videoChannelFormBean);
			getAllDao().updateVideoChannel(videoChannel);
			url = "success";
		} else {
			VideoChannel videoChannel = getAllDao().getVideoChannelById(
					Long.parseLong(ids));
			childVideoChannelList = new ArrayList<VideoChannel>();
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

			List<UserLevel> userLevelList = getAllDao().getUserLevels();
			request.setAttribute("videoChannelList", videoChannelList);
			request.setAttribute("userLevelList", userLevelList);
			request.setAttribute("videoChannel", videoChannel);
		}
		return mapping.findForward(url);
	}
}
