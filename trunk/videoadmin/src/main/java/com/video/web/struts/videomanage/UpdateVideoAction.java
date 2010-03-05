package com.video.web.struts.videomanage;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jspsmart.upload.SmartUpload;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.video.domain.Tag;
import com.video.domain.Video;
import com.video.domain.VideoChannel;
import com.video.web.struts.BaseAction;

public class UpdateVideoAction extends BaseAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String tp = request.getParameter("tp");
		String pageNo = request.getParameter("pageNo") == null ? "1" : request
				.getParameter("pageNo");
		if (tp == null) {
			String strId = request.getParameter("id");
			String name = request.getParameter("name");
			Long id = new Long(0);
			if (strId != null && !strId.trim().isEmpty()) {
				id = Long.parseLong(strId);
			}
			Video video = getAllDao().getVideoById(id);
			String type = request.getParameter("type");
			if ("image".equals(type)) {

				SmartUpload mySmartUpload = new SmartUpload();
				mySmartUpload.setAllowedFilesList("jpg,gif");
				mySmartUpload.setMaxFileSize(10240000);
				ServletConfig ctx = getServlet().getServletConfig();
				mySmartUpload.initialize(ctx, request, response);

				try {
					mySmartUpload.upload();

					com.jspsmart.upload.File myFile = mySmartUpload.getFiles()
							.getFile(0);

					if (!myFile.isMissing()) {

						String FileType = myFile.getFileExt();
						FileType = FileType.toLowerCase(); // 将扩展名转换成小写
						int FileSize = myFile.getSize();
						String newFileName = request.getRealPath("/")
								+ "upload/subfile/flv" + id + "." + FileType; // 可自动生成文件名以防止同名覆盖
						myFile.saveAs(newFileName);
						// ----

						java.io.File file = new java.io.File(newFileName); // 读入刚才上传的文件
						String newurl = request.getRealPath("/")
								+ "upload/videoImg/flv" + id + ".jpg"; // 新的缩略图保存地址

						Image src = javax.imageio.ImageIO.read(file); // 构造Image对象
						float tagsize = 200;
						int old_w = src.getWidth(null); // 得到源图宽
						int old_h = src.getHeight(null);
						int new_w = 0;
						int new_h = 0; // 得到源图长
						int tempsize;
						float tempdouble;
						if (old_w > old_h) {

							tempdouble = old_w / tagsize;
						} else {
							tempdouble = old_h / tagsize;
						}
						new_w = Math.round(old_w / tempdouble);
						new_h = Math.round(old_h / tempdouble);
						BufferedImage tag = new BufferedImage(new_w, new_h,
								BufferedImage.TYPE_INT_RGB);
						tag.getGraphics().drawImage(src, 0, 0, new_w, new_h,
								null); // 绘制缩小后的图
						FileOutputStream newimage = new FileOutputStream(newurl); // 输出到文件流
						JPEGImageEncoder encoder = JPEGCodec
								.createJPEGEncoder(newimage);
						encoder.encode(tag); // 近JPEG编码
						newimage.close();
						video.setImage("/upload/videoImg/flv" + id + ".jpg");
						getAllDao().updateVideo(video);
					}
				} catch (Exception e) {

				}
				response.sendRedirect("uploadok.html");
				return null;

			}

			else if ("lock".equals(type)) {

				video.setFlag(3 - video.getFlag());
				getAllDao().updateVideo(video);
				return new ActionForward(MessageFormat.format("{0}?pageNo={1}",
						mapping.findForward("success").getPath(), pageNo), true);
			} else if ("delete".equals(type)) {
				video.setFlag(0);
				getAllDao().updateVideo(video);
				return new ActionForward(MessageFormat.format("{0}?pageNo={1}",
						mapping.findForward("success").getPath(), pageNo), true);
			}

			else {
				List<Tag> tags = new ArrayList<Tag>();
				String tagName1 = request.getParameter("tag1");
				String tagName2 = request.getParameter("tag2");
				String tagName3 = request.getParameter("tag3");
				String tagName4 = request.getParameter("tag4");
				String tagName5 = request.getParameter("tag5");
			
				if (tagName1 != null && !tagName1.trim().isEmpty()) {

					Tag tag1 = new Tag();
					tag1.setName(tagName1);
					tags.add(tag1);

				}
				if (tagName2 != null && !tagName2.trim().isEmpty()) {

					Tag tag2= new Tag();
					tag2.setName(tagName2);
					tags.add(tag2);

				}
				if (tagName3 != null && !tagName3.trim().isEmpty()) {

					Tag tag3 = new Tag();
					tag3.setName(tagName3);
					tags.add(tag3);

				}
				if (tagName4 != null && !tagName4.trim().isEmpty()) {

					Tag tag4 = new Tag();
					tag4.setName(tagName4);
					tags.add(tag4);

				}
				if (tagName5 != null && !tagName5.trim().isEmpty()) {

					Tag tag5 = new Tag();
					tag5.setName(tagName5);
					tags.add(tag5);

				}
				getAllDao().updateVideoAndTag(tags, id);
				String strChannelId = request.getParameter("channelId");
				Long channelId = new Long(0);
				if (strChannelId != null && !strChannelId.trim().isEmpty()) {
					channelId = Long.parseLong(strChannelId);
				}
				VideoChannel channel = new VideoChannel();
				String flag = request.getParameter("flag");

				channel.setId(channelId);

				video.setName(name);
				video.setChannel(channel);
				if ("1".equals(flag)) {
					video.setFlag(1);
				} else if ("2".equals(flag)) {
					video.setFlag(2);
				}
				getAllDao().updateVideo(video);

				return mapping.findForward("success");
			}

		} else {

			String[] ids = request.getParameterValues("ids");
			if ("lock".equals(tp)) {
				for (String strId : ids) {
					Long id = Long.parseLong(strId);
					Video video = getAllDao().getVideoById(id);
					video.setFlag(2);
					getAllDao().updateVideo(video);
				}

			} else if ("delete".equals(tp)) {
				for (String strId : ids) {
					Long id = Long.parseLong(strId);
					Video video = getAllDao().getVideoById(id);
					video.setFlag(0);
					getAllDao().updateVideo(video);
				}
			}

			return new ActionForward(MessageFormat.format("{0}?pageNo={1}",
					mapping.findForward("success").getPath(), pageNo), true);

		}

	}

}
