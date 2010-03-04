package com.video.web.struts.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.User;
import com.video.util.OperateImage;
import com.video.util.SomeStatic;
import com.video.util.ZoomImage;
import com.video.web.struts.BaseAction;

public class SaveFaceAction extends BaseAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("sessionUser");
		try {
			int width = 120;
			// 获取缩放和剪切参数

			String cutPos = request.getParameter("cut_pos");
			String[] pos = cutPos.split(",");
			// 左上角坐标
			int x = Integer.parseInt(pos[0]);
			int y = Integer.parseInt(pos[1]);
			// 缩放后的图片宽度
			int picWidth = Integer.parseInt(pos[2]);
			int picHeight = Integer.parseInt(pos[3]);

			String newFileName = SomeStatic.UPLOAD_USERFACE_URL+"/"
					+ request.getParameter("cut_url");
			String zoomFile = SomeStatic.UPLOAD_USERFACE_URL + "/upload/userface/face"
					+ user.getId() + ".jpg";
			new ZoomImage().ZoomTheImage(newFileName, zoomFile, picWidth,
					picHeight);
			OperateImage o = new OperateImage(x, y, width, width);
			o.setSrcpath(zoomFile);
			o.setSubpath(zoomFile);
			o.cut();
			
				user.setFace("/upload/userface/face"+user.getId()+".jpg");
				getAllService().updateUser(user);
		

		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapping.findForward("success");
	}

}
