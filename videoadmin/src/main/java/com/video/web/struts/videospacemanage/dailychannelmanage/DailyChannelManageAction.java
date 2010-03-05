package com.video.web.struts.videospacemanage.dailychannelmanage;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Administrator;
import com.video.domain.Daily;
import com.video.domain.DailyChannel;
import com.video.domain.UserLevel;
import com.video.util.Pagination;
import com.video.web.struts.BaseAction;

public class DailyChannelManageAction extends BaseAction {
	/**
	 * 日志分类管理
	 * 
	 * @param request
	 */
	private String url = "index";
	private Pagination<DailyChannel> pagination = null;
	private int no = 1;
	private String method = "";
	private String flag = "";
	private List<DailyChannel> dailyChannelList = null;
	private List<Administrator> manageList = null;
	private List<UserLevel> userLevelList = null;
	private List<DailyChannel> childDailyChannelList;

	/**
	 * 预处理index
	 * 
	 * @param request
	 */
	private void initPage(HttpServletRequest request) {
		if (pagination == null) {
			pagination = new Pagination<DailyChannel>();
		}
		String noString = request.getParameter("no");
		if (noString != null) {
			try {
				no = Integer.parseInt(noString);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		pagination.setNo(no);
		pagination.setSize(30);
		getAllDao().getDailyChannelPage(pagination);
		request.setAttribute("pagination", pagination);
		url = "index";
	}

	/**
	 * 设置添加对象属性
	 */
	private DailyChannel setDailyChannel(HttpServletRequest request) {
		Long parentId = null;
		Long manageId = null;
		int recommend = 0;
		int beTop = 0;
		int readGrade = 0;
		int publishGrade = 0;
		Long id = null;

		String ids = request.getParameter("id");
		String parentIds = request.getParameter("parentId");
		String recommends = request.getParameter("recommend");
		String beTops = request.getParameter("beTop");
		String readGrades = request.getParameter("readGrade");
		String publishGrades = request.getParameter("publishGrade");
		String manageIds = request.getParameter("manageId");
		String name = request.getParameter("name");
		String description = request.getParameter("description");

		if (ids != null && !ids.trim().isEmpty()) {
			id = Long.parseLong(ids.trim());
		}

		if (parentIds != null && !parentIds.trim().isEmpty()) {
			parentId = Long.parseLong(parentIds.trim());
		}

		if (beTops != null && !beTops.trim().isEmpty()) {
			beTop = Integer.parseInt(beTops.trim());
		}

		if (recommends != null && !recommends.trim().isEmpty()) {
			recommend = Integer.parseInt(recommends.trim());
		}

		if (readGrades != null && !readGrades.trim().isEmpty()) {
			readGrade = Integer.parseInt(readGrades.trim());
		}

		if (publishGrades != null && !publishGrades.trim().isEmpty()) {
			publishGrade = Integer.parseInt(publishGrades.trim());
		}

		if (manageIds != null && !manageIds.trim().isEmpty()) {
			manageId = Long.parseLong(manageIds.trim());
		}

		DailyChannel dailyChannel = new DailyChannel();
		dailyChannel.setId(id);
		dailyChannel.setBeTop(beTop);
		dailyChannel.setDescription(description);
		dailyChannel.setManageId(manageId);
		dailyChannel.setName(name);
		dailyChannel.setParentId(parentId);
		dailyChannel.setPublishGrade(publishGrade);
		dailyChannel.setReadGrade(readGrade);
		dailyChannel.setRecommend(recommend);

		return dailyChannel;
	}

	/**
	 * 设置页面select
	 */
	private void setSelect(HttpServletRequest request) {
		dailyChannelList = getAllDao().getDailyChannels();
		userLevelList = getAllDao().getUserLevels();
		manageList = getAllDao().getAdministratorList();
		request.setAttribute("manageList", manageList);
		request.setAttribute("dailyChannelList", dailyChannelList);
		request.setAttribute("userLevelList", userLevelList);
	}

	/**
	 * 添加分类
	 */
	private void addDailyChannel(HttpServletRequest request) {
		/**
		 * 初始化页面
		 */
		if (flag == null || flag.isEmpty()) {
			setSelect(request);
			String ids = request.getParameter("id");
			long id = 0;
			if (ids != null && !ids.trim().isEmpty()) {
				id = Long.parseLong(ids);
				DailyChannel dailyChannel = new DailyChannel();
				dailyChannel.setParentId(id);
				request.setAttribute("dailyChannel", dailyChannel);
			}
			url = "add";
		} else {
			/**
			 * 添加到数据库
			 */
			DailyChannel dailyChannel = setDailyChannel(request);
			if (dailyChannel.getId() != null) {
				getAllDao().updateDailyChannel(dailyChannel);
			} else {
				getAllDao().createDailyChannel(dailyChannel);
			}
			if (dailyChannel.getId() != null) {
				url = "addSuccess";
				// setSelect(request);
				// initPage(request);

			} else {
				setSelect(request);
				request.setAttribute("dailyChannel", dailyChannel);
				url = "add";
			}
		}
	}

	/**
	 * 预处理N级栏目排序页面
	 */
	private void childManageInitPage(HttpServletRequest request) {
		request
				.setAttribute("dailyChannelTree", getAllDao()
						.getDailyChannels());
	}

	/**
	 * N级栏目排序
	 */
	private void childManageOrder(HttpServletRequest request) {
		childManageInitPage(request);
		String action = request.getParameter("action");
		String parentIdString = request.getParameter("parentid");
		long parentId = 0;
		if (parentIdString != null && !parentIdString.trim().isEmpty()) {
			parentId = Long.parseLong(parentIdString);
		}
		if (flag != null && flag.equals("childOrder")) {
			String[] childIdString = request
					.getParameterValues("childDailyChannels");
			long id = 0;
			for (int i = 0; i < childIdString.length; i++) {
				if (childIdString[i] != null
						&& !childIdString[i].trim().isEmpty()) {
					id = Long.parseLong(childIdString[i]);
				}
				DailyChannel dailyChannel = new DailyChannel();
				dailyChannel.setOrders(i);
				dailyChannel.setId(id);
				getAllDao().updateDailyChannelOrders(dailyChannel);
			}
		} else {
			if (action != null && action.equals("getchild")) {
				List<DailyChannel> childDailyChannelsList = getAllDao()
						.getDailyChannelsByParentId(parentId);
				request.setAttribute("childDailyChannelsList", getAllDao()
						.getDailyChannelsByParentId(parentId));
				request.setAttribute("parentid", parentId);
			}
		}
		request.setAttribute("childDailyChannelsList", getAllDao()
				.getDailyChannelsByParentId(parentId));
		url = "childManage";
	}

	/**
	 * 预处理一级栏目排序页面
	 */
	private void rootManageInitPage(HttpServletRequest request) {
		request.setAttribute("rootDailyChannelsList", getAllDao()
				.getRootDailyChannels());
	}

	/**
	 * 一级栏目排序
	 */
	private void rootManageOrder(HttpServletRequest request) {
		if (flag != null && flag.equals("rootOrder")) {
			String[] rootIdString = request
					.getParameterValues("rootDailyChannels");
			long id = 0;
			for (int i = 0; i < rootIdString.length; i++) {
				if (rootIdString[i] != null
						&& !rootIdString[i].trim().isEmpty()) {
					id = Long.parseLong(rootIdString[i]);
				}
				DailyChannel dailyChannel = new DailyChannel();
				dailyChannel.setOrders(i);
				dailyChannel.setId(id);
				getAllDao().updateDailyChannelOrders(dailyChannel);
			}
			url = "rootOrderSuccess";
		} else {
			url = "rootManage";
		}
		rootManageInitPage(request);
	}

	/**
	 * 复位栏目顺序
	 */
	private void repositionDailyChannel(HttpServletRequest request) {
		if (flag != null && flag.equals("true")) {
			getAllDao().updateRepositionDailyChannelOrders();
			initPage(request);
		} else {
			url = "initReposition";
		}
	}

	/**
	 * 合并栏目
	 */
	private void uniteDailyChannel(HttpServletRequest request) {
		if (flag != null && flag.equals("unite")) {
			String sourceDailyChannelIdString = request
					.getParameter("sourceDailyChannelId");
			String destinationDailyChannelIdString = request
					.getParameter("destinationDailyChannelId");
			long sourceDailyChannelId = 0;
			long destinationDailyChannelId = 0;
			if (sourceDailyChannelIdString != null
					&& !sourceDailyChannelIdString.trim().isEmpty()) {
				sourceDailyChannelId = Long
						.parseLong(sourceDailyChannelIdString);
			}
			if (destinationDailyChannelIdString != null
					&& !destinationDailyChannelIdString.trim().isEmpty()) {
				destinationDailyChannelId = Long
						.parseLong(destinationDailyChannelIdString);
			}
			DailyChannel sourceDailyChannel = getAllDao().getDailyChannelById(
					sourceDailyChannelId);
			DailyChannel destinationDailyChannel = getAllDao()
					.getDailyChannelById(destinationDailyChannelId);
			if (equalsMove(sourceDailyChannel, destinationDailyChannel, true)) {
				uniteAllDailyChannel(sourceDailyChannel,
						destinationDailyChannel);
				url = "uniteSuccess";
				return;
			} else {
				request.setAttribute("error", "对不起不能将一个栏目合并到其子栏目下！");
			}
		}
		childManageInitPage(request);
		url = "unite";
	}

	/**
	 * 栏目及子栏目合并
	 */

	private void uniteAllDailyChannel(DailyChannel sourceDailyChannel,
			DailyChannel destinationDailyChannel) {
		DailyChannel dailyChannel = new DailyChannel();
		dailyChannel.setId(sourceDailyChannel.getId());
		dailyChannel.setParentId(destinationDailyChannel.getId());

		// List<Daily> dailyList = getAllDao().getDailysByChannelId(
		// sourceDailyChannel.getId());

		getAllDao().updateUniteDailyChannel(dailyChannel);

		// for (Daily dailys : dailyList) {
		Daily daily = new Daily();
		daily.setId(sourceDailyChannel.getId());
		daily.setChannelId(destinationDailyChannel.getId());
		getAllDao().updateDailyByChannelId(daily);
		getAllDao().deleteDailyChannel(sourceDailyChannel.getId());
		// }
		List<DailyChannel> sourceDailyChannelList = getAllDao()
				.getDailyChannelsByParentId(sourceDailyChannel.getId());
		if (sourceDailyChannelList == null) {
			return;
		}

		for (DailyChannel sDailyChannel : sourceDailyChannelList) {
			uniteAllDailyChannel(sDailyChannel, destinationDailyChannel);
		}
	}

	/**
	 * 源栏目是否是目的栏目父栏目
	 */
	private boolean equalsMove(DailyChannel sourceDailyChannel,
			DailyChannel destinationDailyChannel, boolean flag) {
		boolean move = flag;
		if (destinationDailyChannel.getParent() == null) {
			return move;
		} else {
			DailyChannel parentDailyChannel = getAllDao()
					.getParentDailyChannel(destinationDailyChannel);
			if (parentDailyChannel.getId() == sourceDailyChannel.getId()) {
				move = false;
				return move;
			} else {
				equalsMove(sourceDailyChannel, parentDailyChannel, move);
			}

		}
		return move;
	}

	/**
	 * 修改栏目
	 */
	private void updateDailyChannel(HttpServletRequest request) {
		String flag = request.getParameter("flag");
		if (flag != null && !flag.trim().isEmpty()) {
			addDailyChannel(request);
		} else {
			String ids = request.getParameter("id");
			long id = 0;
			if (ids != null && !ids.trim().isEmpty()) {
				id = Long.parseLong(ids);
			}
			DailyChannel dailyChannel = getAllDao().getDailyChannelById(id);
			request.setAttribute("dailyChannel", dailyChannel);
			setSelect(request);
			url = "add";
		}

	}

	/**
	 * 栏目移动
	 */
	private void moveDailyChannel(HttpServletRequest request) {
		if (flag == null) {
			String ids = request.getParameter("id");
			long id = 0;
			if (ids != null && !ids.trim().isEmpty()) {
				id = Long.parseLong(ids);
			}
			DailyChannel moveDailyChannel = getAllDao().getDailyChannelById(id);
			List<DailyChannel> list = getAllDao()
					.getDailyChannelsByParentId(id);

			notMoveDailyChannelList(list);

			childDailyChannelList.add(moveDailyChannel);
			List<DailyChannel> allDailyChannelList = getAllDao()
					.getDailyChannels();
			List<DailyChannel> moveDailyChannelList = new ArrayList<DailyChannel>();

			for (DailyChannel dailyChannel : allDailyChannelList) {
				boolean flag = true;
				for (DailyChannel childDailyChannel : childDailyChannelList) {
					if (dailyChannel.getId().equals(childDailyChannel.getId())) {
						flag = false;
						break;
					}
				}
				if (flag) {
					moveDailyChannelList.add(dailyChannel);
				}
			}

			request.setAttribute("moveDailyChannelList", moveDailyChannelList);
			request.setAttribute("moveDailyChannel", moveDailyChannel);

			url = "move";
		} else {
			String moveIds = request.getParameter("moveId");
			String endIds = request.getParameter("endId");
			long moveId = 0;
			long endId = 0;
			if (moveIds != null && !moveIds.trim().isEmpty()) {
				moveId = Long.parseLong(moveIds);
			}
			if (endIds != null && !endIds.trim().isEmpty()) {
				endId = Long.parseLong(endIds);
			}
			DailyChannel dailyChannel = getAllDao().getDailyChannelById(moveId);
			dailyChannel.setParentId(endId);
			getAllDao().updateDailyChannel(dailyChannel);
			url = "moveSuccess";
		}

	}

	/**
	 * 移动栏目的子栏目
	 */

	private void notMoveDailyChannelList(List<DailyChannel> list) {
		List<DailyChannel> childList;
		for (DailyChannel dailyChannel : list) {
			childList = getAllDao().getDailyChannelsByParentId(
					dailyChannel.getId());
			childDailyChannelList.add(dailyChannel);
			notMoveDailyChannelList(childList);
		}
	}

	/**
	 * 栏目清空
	 */
	private void cleanDailyChannel(HttpServletRequest request) {
		String ids = request.getParameter("id");
		long id = 0;
		if (ids != null && !ids.trim().isEmpty()) {
			id = Long.parseLong(ids);
		}

		if (id != 0) {
			getAllDao().updateDailyCleanByChannelId(id);
		}
		url = "cleanSuccess";
	}

	/**
	 * 删除栏目
	 */
	private void deleteDailyChannel(HttpServletRequest request) {
		String ids = request.getParameter("id");
		long id = 0;
		if (ids != null && !ids.trim().isEmpty()) {
			id = Long.parseLong(ids);
		}

		if (id != 0) {
			List<DailyChannel> list = getAllDao()
					.getDailyChannelsByParentId(id);
			if (list == null || list.size() == 0) {
				getAllDao().deleteDailyChannel(id);
				getAllDao().deleteDailyByChannelId(id);
				url = "deleteSuccess";
			} else {
				request.setAttribute("error", "该栏目下有子栏目不能删除！");
				initPage(request);
				url = "index";
			}

		}

	}

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// test();
		method = request.getParameter("method");
		flag = request.getParameter("flag");
		if (method == null || method.equals("init")) {
			initPage(request);
		} else if (method.equals("add")) {
			addDailyChannel(request);
		} else if (method.equals("root")) {
			rootManageOrder(request);
		} else if (method.equals("child")) {
			childManageOrder(request);
		} else if (method.equals("reposition")) {
			repositionDailyChannel(request);
		} else if (method.equals("unite")) {
			uniteDailyChannel(request);
		} else if (method.equals("update")) {
			updateDailyChannel(request);
		} else if (method.equals("move")) {
			childDailyChannelList = new ArrayList<DailyChannel>();
			moveDailyChannel(request);
		} else if (method.equals("clean")) {
			cleanDailyChannel(request);
		} else if (method.equals("delete")) {
			deleteDailyChannel(request);
		}

		return mapping.findForward(url);
	}
}
