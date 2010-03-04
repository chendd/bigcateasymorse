package com.video.web.struts.index;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONArray;
import org.json.JSONObject;

import com.video.domain.BlogWord;
import com.video.domain.BrowseHistoryVideo;
import com.video.domain.Event;
import com.video.domain.IndexRecommendVideo;
import com.video.domain.MayLikeVideo;
import com.video.domain.Playbill;
import com.video.domain.SubscribeUser;
import com.video.domain.Tag;
import com.video.domain.User;
import com.video.domain.Video;
import com.video.domain.Whisper;
import com.video.domain.connection.ChannelCount;
import com.video.domain.connection.Condition;
import com.video.util.Pagination;
import com.video.web.struts.BaseAction;

public class GetIndexModuleAction extends BaseAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String mid = request.getParameter("mid");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("sessionUser");
		if ("1".equals(mid)) {
			List<IndexRecommendVideo> videoes = getAllService()
					.getIndexRecommendVideoes();
			JSONObject result = new JSONObject();

			JSONArray jsonVideoes = new JSONArray();

			for (IndexRecommendVideo video : videoes) {
				JSONObject jsonVideo = new JSONObject();
				jsonVideo.put("id", video.getId());
				jsonVideo.put("name", video.getName());
				jsonVideo.put("image", video.getImageUrl());
				jsonVideo.put("description", video.getDescription());
				jsonVideo.put("vid", video.getVideo().getId());
				jsonVideoes.put(jsonVideo);
			}
			result.put("results", jsonVideoes);
			String jsonResult = result.toString();
			response.getWriter().print(jsonResult);
		}

		if ("2".equals(mid)) {
		
			JSONObject result = new JSONObject();

			JSONArray jsonVideoes = new JSONArray();

			
			if(user==null){
				Condition condition = new Condition();
				List<Video> results = getAllService().getVideoRand(condition);
				for(Video video2:results){
					JSONObject jsonVideo = new JSONObject();
					jsonVideo.put("id", video2.getId());
					jsonVideo.put("name", video2.getName());
					jsonVideo.put("image", video2.getImage());
					jsonVideo.put("description", video2.getDescription()==null?"":video2.getDescription());
					
					jsonVideo.put("realName", video2.getUser().getRealName());
					jsonVideo.put("userId", video2.getUser()
							.getId());
					jsonVideo.put("browseCount", video2.getBrowseCount());
					jsonVideo.put("addDate",new SimpleDateFormat("hh:mm").format( video2.getAddDate()));
					jsonVideo.put("commentCount", video2.getCommentCount());
					jsonVideo.put("vid", video2.getId());
					jsonVideoes.put(jsonVideo);
					result.put("results", jsonVideoes);
				}
				
			}
			else{
				ChannelCount channelCount = getAllService().getChannelTop(user.getId());
				if(channelCount==null){
					Condition condition = new Condition();
					List<Video> results = getAllService().getVideoRand(condition);
					for(Video video2:results){
						JSONObject jsonVideo = new JSONObject();
						jsonVideo.put("id", video2.getId());
						jsonVideo.put("name", video2.getName());
						jsonVideo.put("image", video2.getImage());
						jsonVideo.put("description", video2.getDescription()==null?"":video2.getDescription());
						jsonVideo.put("realName", video2.getUser().getRealName());
						jsonVideo.put("userId", video2.getUser()
								.getId());
						jsonVideo.put("addDate",new SimpleDateFormat("hh:mm").format( video2.getAddDate()));
						jsonVideo.put("browseCount", video2.getBrowseCount());
						jsonVideo.put("commentCount", video2.getCommentCount());
						jsonVideo.put("vid", video2.getId());
						jsonVideoes.put(jsonVideo);
						result.put("results", jsonVideoes);
					}
				}
				
				else{
					List<Long> ids = getAllService().getPlayHistoryVideoIds(user.getId());
					String strIds = "0";
					for(Long id : ids){
						strIds = strIds + ";" + id;
						
					}
					Condition condition = new Condition();
					condition.setChannelId(channelCount.getChannel().getId());
					condition.setIds(strIds);
					List<Video> results = getAllService().getVideoRand(condition);
					for(Video video2:results){
						JSONObject jsonVideo = new JSONObject();
						jsonVideo.put("id", video2.getId());
						jsonVideo.put("name", video2.getName());
						jsonVideo.put("image", video2.getImage());
						jsonVideo.put("description", video2.getDescription()==null?"":video2.getDescription());
						jsonVideo.put("realName", video2.getUser().getRealName());
						jsonVideo.put("userId", video2.getUser()
								.getId());
						jsonVideo.put("browseCount", video2.getBrowseCount());
						jsonVideo.put("commentCount", video2.getCommentCount());
						jsonVideo.put("addDate",new SimpleDateFormat("hh:mm").format( video2.getAddDate()));
						jsonVideo.put("vid", video2.getId());
						jsonVideoes.put(jsonVideo);
						result.put("results", jsonVideoes);
					}
				}
				
			}
			
			String jsonResult = result.toString();
			response.getWriter().print(jsonResult);
		}
		
		
		if ("3".equals(mid)) {
			ServletContext context =  this.getServlet().getServletContext();
			List<Event> events = getAllService().getLastEvents();
			JSONObject result = new JSONObject();

			JSONArray jsonEvents = new JSONArray();
			
			for (Event event : events) {
				JSONObject jsonEvent = new JSONObject();
				jsonEvent.put("userId", event.getUser().getId());
				jsonEvent.put("realName", event.getUser().getRealName());
				jsonEvent.put("description", event.getDescription());
				jsonEvent.put("userFace", event.getUser().getFace());
				jsonEvent.put("url", event.getUrl());
				jsonEvents.put(jsonEvent);
			}
			result.put("results", jsonEvents);
			String jsonResult = result.toString();
			response.getWriter().print(jsonResult);
		}

		if ("4".equals(mid)) {
			int pageSize = 10;
			int pageNo = 1;
			String order = request.getParameter("order");
			if(order==null||order.trim().isEmpty()){
				order = "v.browse_count";
			}
			Pagination<Video> pagination = new Pagination<Video>();
			pagination.setNo(pageNo);
			pagination.setSize(pageSize);
			pagination.setOrderFieldName(order);
			getAllService().getVideoes(pagination);

			JSONObject result = new JSONObject();

			JSONArray jsonVideoes = new JSONArray();

			for (Video video : pagination.getResults()) {
				JSONObject jsonVideo = new JSONObject();
				jsonVideo.put("id", video.getId());
				jsonVideo.put("name", video.getName());
				jsonVideo.put("image", video.getImage());
				jsonVideo.put("description", video.getDescription());
				jsonVideo.put("commentCount", video.getCommentCount());
				jsonVideo.put("browseCount", video.getBrowseCount());
				jsonVideo.put("point", video.getPoint());
				jsonVideo.put("order", order);
				jsonVideoes.put(jsonVideo);
			}
			result.put("results", jsonVideoes);
			String jsonResult = result.toString();
			response.getWriter().print(jsonResult);
		}

		if ("5".equals(mid)) {
			int pageSize = 10;
			int pageNo = 1;
			Pagination<Video> pagination = new Pagination<Video>();
			pagination.setNo(pageNo);
			pagination.setSize(pageSize);
			pagination.setOrderFieldName("push_count");
			getAllService().getVideoes(pagination);

			JSONObject result = new JSONObject();

			JSONArray jsonVideoes = new JSONArray();

			for (Video video : pagination.getResults()) {
				JSONObject jsonVideo = new JSONObject();
				jsonVideo.put("id", video.getId());
				jsonVideo.put("name", video.getName());
				jsonVideo.put("image", video.getImage());
				jsonVideo.put("description", video.getDescription()==null?"":video.getDescription());
				jsonVideo.put("commentCount", video.getCommentCount());
				jsonVideo.put("browseCount", video.getBrowseCount());
				jsonVideo.put("point", video.getPoint());
				jsonVideo.put("pushCount", video.getPushCount());
				jsonVideo.put("userName", video.getUser().getRealName());
				jsonVideo.put("userId", video.getUser().getId());
				jsonVideo.put("addDate", new SimpleDateFormat("hh:mm").format(video.getAddDate()));
				jsonVideoes.put(jsonVideo);
			}
			result.put("results", jsonVideoes);
			String jsonResult = result.toString();
			response.getWriter().print(jsonResult);
		}

		if ("6".equals(mid)) {

			int pageSize = 6;
			int pageNo = 1;
			Pagination<User> pagination = new Pagination<User>();
			pagination.setCondition(user);
			pagination.setNo(pageNo);
			pagination.setSize(pageSize);
			
			Pagination<User> pagination2 = new Pagination<User>();
			pagination2.setSize(3);
			pagination2.setNo(1);
			pagination2.setCondition(user);
			
			
			getAllService().getFriends(pagination);
			getAllService().getSimilars(pagination2);
			int num1 = getAllService().countMySubscibeUsers(user.getId());
			int num2 = getAllService().countMyFans(user.getId());
			JSONObject result = new JSONObject();
			JSONArray jsonUsers = new JSONArray();
			JSONObject result2 = new JSONObject();
			JSONArray jsonUsers2 = new JSONArray();
			if(pagination.getRecordSum()>0){
				for (User user1 : pagination.getResults()) {
					JSONObject jsonUser = new JSONObject();
					jsonUser.put("id", user1.getId());
					jsonUser.put("userName", user1.getUserName());
					jsonUser.put("image", user1.getFace());
					jsonUser.put("realName", user1.getRealName());
					jsonUsers.put(jsonUser);
				}
				
			}
			if(pagination2.getRecordSum()>0){
				for (User user1 : pagination2.getResults()) {
					JSONObject jsonUser2 = new JSONObject();
					jsonUser2.put("id", user1.getId());
					jsonUser2.put("userName", user1.getUserName());
					jsonUser2.put("image", user1.getFace());
					jsonUser2.put("realName", user1.getRealName());
					jsonUsers2.put(jsonUser2);
				}
			}
				result.put("results", jsonUsers);
				result.put("results2", jsonUsers2);
				result.put("num1", num1);
				result.put("num2", num2);
				String jsonResult = result.toString();
				response.getWriter().print(jsonResult);
			
			
		}

		if ("7".equals(mid)) {

			int pageSize = 10;
			int pageNo = 1;
			String order = request.getParameter("order");
			if(order==null||order.trim().isEmpty()){
				order = "pnum";
			}
			Pagination<User> pagination = new Pagination<User>();
			pagination.setNo(pageNo);
			pagination.setSize(pageSize);
			pagination.setOrderFieldName(order);

			getAllService().getTopUsers(pagination);

			JSONObject result = new JSONObject();

			JSONArray jsonUsers = new JSONArray();

			for (User user1 : pagination.getResults()) {
				JSONObject jsonUser = new JSONObject();
				jsonUser.put("id", user1.getId());
				jsonUser.put("image", user1.getFace());
				jsonUser.put("realName", user1.getRealName());
				jsonUser.put("subscribeCount", user1.getBeSubscribeCount());
				jsonUser.put("videoCount", user1.getVideoCount());
				jsonUser.put("fortune", user1.getFortune());
				jsonUsers.put(jsonUser);
			}
			result.put("order", order);
			result.put("results", jsonUsers);
			String jsonResult = result.toString();
			response.getWriter().print(jsonResult);
		}

		if ("8".equals(mid)) {
			int pageSize = 4;
			int pageNo = 1;
			Pagination<Playbill> pagination = new Pagination<Playbill>();
			pagination.setNo(pageNo);
			pagination.setSize(pageSize);
			pagination.setOrderFieldName("p.add_date");
			getAllService().getPlayBills(pagination);

			JSONObject result = new JSONObject();

			JSONArray jsonVideoes = new JSONArray();

			for (Playbill playbill : pagination.getResults()) {
				JSONObject jsonVideo = new JSONObject();
				jsonVideo.put("id", playbill.getId());
				jsonVideo.put("name", playbill.getName());
				jsonVideo.put("image", playbill.getImagesUrl());
				jsonVideo.put("description", playbill.getDescription());
				jsonVideo.put("userName", playbill.getUser().getUserName());
				jsonVideo.put("realName", playbill.getUser().getRealName());
				jsonVideo.put("userId", playbill.getUser().getId());
				jsonVideo.put("videoNum", playbill.getVideoes().size());
				jsonVideoes.put(jsonVideo);
			}
			result.put("results", jsonVideoes);
			String jsonResult = result.toString();
			response.getWriter().print(jsonResult);
		}
		if ("9".equals(mid)) {
			int pageSize = 4;
			int pageNo = 1;

			List<Tag> tags = getAllService().getHotVideoTag();

			JSONObject result = new JSONObject();

			JSONArray jsonTags = new JSONArray();

			for (Tag tag : tags) {
				JSONObject jsonTag = new JSONObject();
				jsonTag.put("id", tag.getId());
				jsonTag.put("name", tag.getName());

				jsonTags.put(jsonTag);
			}
			result.put("results", jsonTags);
			String jsonResult = result.toString();
			response.getWriter().print(jsonResult);
		}
		if ("10".equals(mid)) {
			int pageSize = 5;
			int pageNo = 1;
			Pagination<BlogWord> pagination = new Pagination<BlogWord>();

			BlogWord blogWord1 = new BlogWord();
			blogWord1.setUser(user);
			pagination.setCondition(blogWord1);
			pagination.setNo(pageNo);
			pagination.setSize(pageSize);
			getAllService().getBlogWords(pagination);
			if(pagination.getRecordSum()>0){
				JSONObject result = new JSONObject();

				JSONArray jsonWhispers = new JSONArray();
				
				for (BlogWord blogWord : pagination.getResults()) {
					JSONObject jsonWhisper = new JSONObject();
					jsonWhisper.put("id", blogWord.getId());
					jsonWhisper.put("message",
							blogWord.getWords());
					jsonWhisper.put("sendDate", new SimpleDateFormat(
							"yyyy-MM-dd hh:mm:ss").format(blogWord.getAddDate()));
					jsonWhisper.put("userId", blogWord.getWriter().getId());
					jsonWhisper.put("realName", blogWord.getWriter().getRealName());

					jsonWhispers.put(jsonWhisper);
				}
				result.put("results", jsonWhispers);
				String jsonResult = result.toString();
				response.getWriter().print(jsonResult);
			}
			
			
		}

		if ("11".equals(mid)) {
			int pageSize = 6;
			int pageNo = 1;
			Pagination<SubscribeUser> pagination = new Pagination<SubscribeUser>();
			SubscribeUser SubscribeUser1 = new SubscribeUser();

			SubscribeUser1.setUser(user);
			pagination.setCondition(SubscribeUser1);
			pagination.setNo(pageNo);
			pagination.setSize(pageSize);
			getAllService().getSubscibeUsers(pagination);
			if(pagination.getRecordSum()>0){
				
			
			JSONObject result = new JSONObject();

			JSONArray jsonUsers = new JSONArray();

			for (SubscribeUser subscribeUser : pagination.getResults()) {
				JSONObject jsonUser = new JSONObject();
				jsonUser.put("id", subscribeUser.getPassiveUser().getId());
				jsonUser.put("image", subscribeUser.getPassiveUser().getFace());
				jsonUser.put("realName", subscribeUser.getPassiveUser()
						.getRealName());
				jsonUser.put("addDate", new SimpleDateFormat(
						"yyyy-MM-dd hh:mm:ss").format(subscribeUser
						.getAddDate()));

				jsonUsers.put(jsonUser);
			}
			result.put("results", jsonUsers);
			String jsonResult = result.toString();
			response.getWriter().print(jsonResult);
			}
		}
		return super.execute(mapping, form, request, response);
	}

}
