package com.video.web.struts.group;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Group;
import com.video.domain.Topic;
import com.video.util.Pagination;
import com.video.web.struts.BaseAction;

public class GetMyGroupTopicesAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setCharacterEncoding("UTF-8");
		String strId = request.getParameter("id");
		String pageNo = request.getParameter("pageNo");
		if(strId!=null&&!strId.trim().isEmpty()){
			Long id = new Long(0);
			try{
				id = Long.parseLong(strId);
			
				
			}
			catch (Exception e) {
				
			}
			Group group = getAllService().getGroupById(id);
			if(group!=null){
				int no = 1;
				if(pageNo!=null&&!pageNo.trim().isEmpty()){
					no = Integer.parseInt(pageNo);
				}
				Pagination<Topic> pagination = new Pagination<Topic>();
				pagination.setNo(no);
				pagination.setSize(10);
				pagination.setCondition(group);
				pagination.setOrderFieldName("t.add_date");
				getAllService().getTopicesByGroupId(pagination);
				if(pagination.getResults()!=null){
					JSONObject object = JSONObject.fromObject(pagination);
					
					response.getWriter().print(object);
				}
				
			}
		}
		return null;
	}

}
