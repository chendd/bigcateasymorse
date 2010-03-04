package com.video.web.struts.vblog;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONArray;
import org.json.JSONObject;

import com.video.domain.Daily;
import com.video.domain.DailyChannel;
import com.video.domain.DailyTag;
import com.video.domain.Playbill;
import com.video.domain.User;
import com.video.util.Pagination;
import com.video.web.struts.BaseAction;

public class GetMyDailiesAction extends BaseAction{
	

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 String strId = request.getParameter("id");
		 User user;
		    Long id;
		    if(strId!=null&&!strId.trim().isEmpty()){
		    	id = Long.parseLong(strId);
		    	user = new User();
		    	user.setId(id);
		    }
		    else{
		    	HttpSession session = request.getSession();
		    	user = (User)session.getAttribute("sessionUser");
		    }
			String strPageSize = request.getParameter("pageSize");
			String strPageNo = request.getParameter("pageNo");
			int pageSize = 10;
			int pageNo = 1;
			if(strPageSize!=null && !strPageSize.trim().isEmpty()){
				try{
					pageSize = Integer.parseInt(strPageSize);
				}
				catch (Exception e) {
				
				}
			}
			if(strPageNo!=null && !strPageNo.trim().isEmpty()){
				try{
					pageNo = Integer.parseInt(strPageNo);
				}
				catch (Exception e) {
				
				}
			}
			Pagination<Daily> pagination = new Pagination<Daily>();
		
			
		Daily daily = new Daily();
		daily.setUser(user);
		String strChannelId = request.getParameter("channelId");
		String strTagId = request.getParameter("tagId");
		if(strChannelId!=null && !strChannelId.trim().isEmpty()){
			try{
				Long channelId = Long.parseLong(strChannelId);
				DailyChannel channel = new DailyChannel();
				channel.setId(channelId);
				daily.setChannel(channel);
				
			}
			catch (Exception e) {
				
			}
			
		}
		else{
			strChannelId ="";
		}
		if(strTagId!=null && !strTagId.trim().isEmpty()){
			try{
				Long tagId = Long.parseLong(strTagId);
				
				daily.setConditionId(tagId);
				
			}
			catch (Exception e) {
				
			}
			
		}
		else{
			strTagId = "";
		}
			pagination.setSize(pageSize);
			pagination.setNo(pageNo);
			pagination.setCondition(daily);
			getAllService().getMyDailies(pagination);
		
	if(pagination.getResults()!=null){
					
				
				JSONObject result = new JSONObject();
			
				JSONArray jsonDailies = new JSONArray();
		
				for(Daily daily2: pagination.getResults()){
					 JSONObject jsonDaily = new JSONObject();
					 jsonDaily.put("id", daily2.getId());
					 jsonDaily.put("title", daily2.getTitle());
					 jsonDaily.put("browseTimes", daily2.getBrowseTimes());
					 jsonDaily.put("commentCount", daily2.getCommentCount());
					 jsonDaily.put("addDate", new SimpleDateFormat("yyyy-MM-dd").format(daily2.getAddDate()));
					 jsonDaily.put("addTime", new SimpleDateFormat("hh:mm:ss").format(daily2.getAddDate()));
					 jsonDaily.put("channelId", daily2.getChannel().getId());
					 jsonDaily.put("channelName", daily2.getChannel().getName());
					 jsonDaily.put("log", daily2.getLog());
					 JSONArray jsonTags = new JSONArray();
					for(DailyTag tag:daily2.getTags()){
						 JSONObject jsonTag = new JSONObject();
						 jsonTag.put("id", tag.getId());
						 jsonTag.put("name", tag.getName());
						 jsonTags.put(jsonTag);
						 
					}
					jsonDaily.put("tags", jsonTags);
		
					 jsonDailies.put(jsonDaily);
			
				}
				result.put("results", jsonDailies);
				result.put("pageSum", pagination.getPageSum());
				result.put("no", pagination.getNo());
				result.put("next", pagination.isNext());
				result.put("pre", pagination.isPrevious());
				result.put("channelId", strChannelId);
				result.put("tagId", strTagId);
				String jsonResult = result.toString();
				response.getWriter().print(jsonResult);
				}
	
		return null;
	}

}
