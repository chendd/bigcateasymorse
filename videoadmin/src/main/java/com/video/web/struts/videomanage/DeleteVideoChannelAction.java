package com.video.web.struts.videomanage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.VideoChannel;
import com.video.web.struts.BaseAction;

public class DeleteVideoChannelAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String ids = request.getParameter("id");
		String url = "success";
		Long id = null;
		if (ids != null && !ids.trim().isEmpty()) {
			id = Long.parseLong(ids);
			List<VideoChannel> list = getAllDao().getChildVideoChannelList(id);
			if (list != null && list.size() > 0) {
				url = "error";
				List<VideoChannel> videoChanneList = getAllDao()
						.getVideoChannelList();
				request.setAttribute("videoChanneList", videoChanneList);
				request.setAttribute("errors", "该栏目下有子栏目不能删除！");
			} else {
				getAllDao().deleteVideoChannel(id);
				getAllDao().deleteVideoByChannelId(id);
			}
		}
		return mapping.findForward(url);
	}
}
