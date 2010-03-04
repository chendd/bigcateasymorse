package com.video.web.struts.vblog;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONArray;
import org.json.JSONObject;

import com.video.domain.DailyTag;
import com.video.util.UtilMethod;
import com.video.web.struts.BaseAction;

public class GetDailyTagsAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		String strId = request.getParameter("id");
		if(strId!=null && !strId.trim().isEmpty()){
			Long id = UtilMethod.longFormat(strId);
			List<DailyTag> tags = getAllService().getDailyTagsByUser(id);
			

			if(tags!=null){
				JSONObject result = new JSONObject();
				
				JSONArray jsonTags = new JSONArray();
		
				for(DailyTag tag: tags){
					 JSONObject jsonTag = new JSONObject();
					 jsonTag.put("id", tag.getId());
					 jsonTag.put("name", tag.getName());
				
					 jsonTags.put(jsonTag);
				}
				result.put("results", jsonTags);
				String jsonResult = result.toString();
				response.getWriter().print(jsonResult);
				
		}
		
			
		}
		return null;
	}

}
