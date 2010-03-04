package com.video.web.struts.vblog;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONArray;
import org.json.JSONObject;

import com.video.domain.DailyChannel;
import com.video.web.struts.BaseAction;

public class GetDailyChannelsAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String strId = request.getParameter("id");
		if(strId!=null&&!strId.trim().isEmpty()){
			try{
				Long id = Long.parseLong(strId);
				if(getAllService().getUserById(id)!=null){
					List<DailyChannel> list = getAllService().getSimpleDailyChannels(id);
					if(list !=null && list.size()>0){
						
						JSONObject result = new JSONObject();
						
						JSONArray jsonChannels = new JSONArray();
				
						for(DailyChannel channel: list){
							 JSONObject jsonChannel = new JSONObject();
							 jsonChannel.put("id", channel.getId());
							 jsonChannel.put("name", channel.getName());
							 jsonChannel.put("dailyCount", channel.getDailyCount());
							
							
					
				
							 jsonChannels.put(jsonChannel);
					
						}
						result.put("results", jsonChannels);
						String jsonResult = result.toString();
						response.getWriter().print(jsonResult);
						
						
					}
					
					
					
				}
			}
			catch (Exception e) {
				
			}
			
		}
		return null;
	}

}
