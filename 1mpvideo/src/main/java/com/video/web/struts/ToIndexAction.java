package com.video.web.struts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.IndexRecommendVideo;
import com.video.domain.User;
import com.video.util.SomeStatic;

public class ToIndexAction extends BaseAction{
	
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("sessionUser");
		List<IndexRecommendVideo> videoes = getAllService()
		.getIndexRecommendVideoes();
		request.setAttribute("videoes", videoes);
		
		
		if(user==null){
			
			String layout = "*,[module1][module2][module5][module8],[module7][module4][module3][module9]";
			Map<String, String> nameMap = new HashMap<String, String>();
			nameMap.put("module1", "最受欢迎的视频");
			nameMap.put("module2", "您一定会喜欢");
			nameMap.put("module3", "过去一分钟里");
			nameMap.put("module4", "视频TOP榜");
			nameMap.put("module5", "被推荐出来的");
			nameMap.put("module6", "我的朋友");
			nameMap.put("module7", "会员TOP榜");
			nameMap.put("module8", "节目单");
			nameMap.put("module9", "标签");
			nameMap.put("module10", "关于我的留言");
			nameMap.put("module11", "我订阅的");
			session.setAttribute("nameMap", nameMap);
			List<Object> resultList = getLayout(layout);
			List<String> list = (ArrayList<String>)resultList.get(0);
			List<List<String>> list1 = (ArrayList<List<String>>)resultList.get(1);
			request.setAttribute("layout", list);
			request.setAttribute("layout1", list1);
			request.setAttribute("side", 2);
			request.setAttribute("allLayout", SomeStatic.ALL_LAYOUT);
			
		}
		else{
			
			
			String layout = user.getLayout();
			
			
			
				Map<String, String> nameMap = new HashMap<String, String>();
				nameMap.put("module1", "最受欢迎的视频");
				nameMap.put("module2", "您一定会喜欢");
				nameMap.put("module3", "过去一分钟里");
				nameMap.put("module4", "视频TOP榜");
				nameMap.put("module5", "被推荐出来的");
				nameMap.put("module6", "我的朋友");
				nameMap.put("module7", "会员TOP榜");
				nameMap.put("module8", "节目单");
				nameMap.put("module9", "标签");
				nameMap.put("module10", "关于我的留言");
				nameMap.put("module11", "我订阅的");
				session.setAttribute("nameMap", nameMap);
				List<Object> resultList = getLayout(layout);
				List<String> list = (ArrayList<String>)resultList.get(0);
				List<List<String>> list1 = (ArrayList<List<String>>)resultList.get(1);
				request.setAttribute("layout", list);
				request.setAttribute("layout1", list1);
				request.setAttribute("allLayout", SomeStatic.ALL_LAYOUT);
				request.setAttribute("user", user);
				request.setAttribute("side", user.getSide());
		}
		return mapping.findForward("success");
	}
	
	public List<Object> getLayout(String layout){
		List<String> list = new ArrayList<String>();
		List<List<String>> list1 = new ArrayList<List<String>>();
		String[] layouts = layout.split(",");
		for(String str_lay:layouts){
			if("*".equals(str_lay)){
				str_lay = "";
				list1.add(null);
			}
			else{
				String str_lay2 = "]"+str_lay+"[";
				String[] str_lays = str_lay2.split("]\\[");
				List<String> list2 = new ArrayList<String>();
				for(String str:str_lays){
					if(!"".equals(str)){
						list2.add(str);
					}
				}
				list1.add(list2);
			}
			list.add(str_lay);
		}
		
		List<Object> resultList = new ArrayList<Object>();
		resultList.add(list);
		resultList.add(list1);
		
		return resultList;
	}

}
