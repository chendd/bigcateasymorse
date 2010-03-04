package com.video.web.struts.group;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Group;
import com.video.domain.Video;
import com.video.util.Pagination;
import com.video.util.UtilMethod;
import com.video.web.struts.BaseAction;

public class GetGroupVideoesAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String strId = request.getParameter("id");
		String orderFieldName ="v.add_date";
		Long id = new Long (0);
		int no = 1;
		int size = 5;
		if(strId!=null && !strId.trim().isEmpty()){
			id = UtilMethod.longFormat(strId);
			Group group = getAllService().getGroupById(id);
			if(group!=null){
				
			
			String order = request.getParameter("order");
			
			if(order!=null && !order.trim().isEmpty()){
				if(order.equals("v.add_date")||order.equals("v.browse_count")||order.equals("commentcount")){
					orderFieldName = order;
				}
				
			}
			String pageNo = request.getParameter("pageNo");
			String pageSize = request.getParameter("pageSize");
			if(pageNo!=null&&!pageNo.trim().isEmpty()){
				no = UtilMethod.intFormat(pageNo)==0?no:UtilMethod.intFormat(pageNo);
			}
			if(pageSize!=null&&!pageSize.trim().isEmpty()){
				size = UtilMethod.intFormat(pageSize)==0?size:UtilMethod.intFormat(pageSize);
			}
			
			Pagination<Video> pagination = new Pagination<Video>();
			pagination.setNo(no);
			pagination.setSize(size);
			
			if(orderFieldName !=null && !orderFieldName.trim().isEmpty()){
				pagination.setOrderFieldName(orderFieldName);
			}
			
			pagination.setCondition(group);
			getAllService().getVideoesByGroupId(pagination);
			request.setAttribute("pagination", pagination);
			request.setAttribute("order", orderFieldName);
			request.setAttribute("pageSize", size);
			request.setAttribute("group", group);
			}
		}
		return mapping.findForward("success");
	}

}
