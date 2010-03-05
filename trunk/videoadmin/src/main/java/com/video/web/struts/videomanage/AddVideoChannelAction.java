package com.video.web.struts.videomanage;

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

public class AddVideoChannelAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String flag = request.getParameter("flag");
		String url = "init";
		if (flag != null && !flag.trim().isEmpty()) {
			VideoChannelFormBean videoChannelFormBean = (VideoChannelFormBean) form;
			VideoChannel videoChannel = new VideoChannel();
			BeanUtils.copyProperties(videoChannel, videoChannelFormBean);
			getAllDao().createVideoChannel(videoChannel);
			url = "success";
		} else {
			List<VideoChannel> videoChannelList = getAllDao()
					.getVideoChannelList();
			String ids = request.getParameter("id");
			if (ids != null && !ids.trim().isEmpty()) {
				VideoChannel videoChannel = new VideoChannel();
				videoChannel.setParentId(Long.parseLong(ids));
				request.setAttribute("videoChannel", videoChannel);
			}
			List<UserLevel> userLevelList = getAllDao().getUserLevels();
			request.setAttribute("videoChannelList", videoChannelList);
			request.setAttribute("userLevelList", userLevelList);
		}
		return mapping.findForward(url);
	}
}
