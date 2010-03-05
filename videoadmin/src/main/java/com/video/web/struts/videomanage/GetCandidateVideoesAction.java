package com.video.web.struts.videomanage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONArray;
import org.json.JSONObject;

import com.video.domain.CandidateVideo;
import com.video.util.Pagination;
import com.video.web.struts.BaseAction;

public class GetCandidateVideoesAction extends BaseAction{
	
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setCharacterEncoding("UTF-8");
		int pageSize = 20;
		int pageNo = 1;
		String str_pageNo = request.getParameter("pageNo");
		String type= request.getParameter("type");
		
		if(str_pageNo!=null){
			pageNo = Integer.parseInt(str_pageNo);
		}
		Pagination<CandidateVideo> pagination = new Pagination<CandidateVideo>();
		pagination.setNo(pageNo);
		pagination.setSize(pageSize);
		getAllDao().getCandidateVideoes(pagination);
if("ajax".equals(type)){
	if(pagination.getResults()!=null){
		//转为JSON对象
		JSONObject result = new JSONObject();
		result.put("no", pagination.getNo());
		result.put("pageSum", pagination.getPageSum());
		result.put("recordSum", pagination.getRecordSum());
		result.put("previous", pagination.isPrevious());
		result.put("next", pagination.isNext());
		JSONArray candidateVideoes = new JSONArray();
		
		for(CandidateVideo candidateVideo:pagination.getResults()){
			 JSONObject jsonCandidateVideo = new JSONObject();
			 jsonCandidateVideo.put("id", candidateVideo.getId());
			 jsonCandidateVideo.put("videoId", candidateVideo.getVideo().getId());
			 jsonCandidateVideo.put("videoName", candidateVideo.getVideo().getName());
			 jsonCandidateVideo.put("sake", candidateVideo.getSake());
			 candidateVideoes.put(jsonCandidateVideo);
		}
		result.put("results", candidateVideoes);
		String jsonResult = result.toString();
		response.getWriter().print(jsonResult);
	}
	

	return null;
			
		}
		else{
			
			request.setAttribute("pagination", pagination);
			
			return mapping.findForward("success");
		}
		
	}

}
