package com.video.web.struts.videomanage;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONArray;
import org.json.JSONObject;

import com.video.domain.Playbill;
import com.video.domain.TopicComment;
import com.video.domain.Video;
import com.video.web.struts.BaseAction;

public class GetPlayBillAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String method = request.getParameter("method");
		String strId = request.getParameter("id");
		Long id = new Long(0);
		if(strId!=null && !strId.trim().isEmpty()){
			id = Long.parseLong(strId);
		}
		Playbill playbill = getAllDao().getPlaybill(id);
		if("ajax".equals(method)){
			JSONObject result = new JSONObject();
			JSONArray videoes = new JSONArray();
			
			for(Video video:playbill.getVideoes()){
				 JSONObject jsonvideo = new JSONObject();
				 jsonvideo.put("id", video.getId());
				 jsonvideo.put("name", video.getName());
				
			
				 videoes.put(jsonvideo);
			}
			result.put("results", videoes);
			result.put("id", id);
			String jsonResult = result.toString();
			response.getWriter().print(jsonResult);
			return null;
		}
		else{
			
			request.setAttribute("playbill", playbill);
			return mapping.findForward("success");
		}
		
	}

}
