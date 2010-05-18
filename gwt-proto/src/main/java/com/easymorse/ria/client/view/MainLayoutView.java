package com.easymorse.ria.client.view;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.easymorse.ria.client.ResourcesImages;
import com.easymorse.ria.client.util.AuthUtil;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class MainLayoutView extends Composite implements ResizeHandler {

	@UiField
	FlowPanel flowPanels;
	FlowPanel layout;

	String authString;

	private Tree mainMenu;

	private HorizontalPanel bottomPanel;

	private DecoratorPanel contentDecorator;

	private TopPanelView topPanelView;

	private Map<TreeItem, Widget> treeItems = new HashMap<TreeItem, Widget>();

	private SimplePanel contentWrapper;

	public static HandlerManager handlerManager = new HandlerManager(null);

	ResourcesImages images = GWT.create(ResourcesImages.class);

	/**
	 * 菜单的加载panel
	 */

	private RPCPanel rpcPanel;

	public RPCPanel getRpcPanel() {
		return rpcPanel;
	}

	HorizontalPanel horizontalPanels = new HorizontalPanel();
	VerticalPanel verticalPanelss = new VerticalPanel();

	private static MainLayoutViewUiBinder uiBinder = GWT
			.create(MainLayoutViewUiBinder.class);

	interface MainLayoutViewUiBinder extends UiBinder<Widget, MainLayoutView> {
	}

	Grid contentLayout;

	public MainLayoutView(String authString) {
		initWidget(uiBinder.createAndBindUi(this));
		this.authString = authString;
		mainLayout();
	}

	public void mainLayout() {

		// 创建和设置总的布局
		this.layout = new FlowPanel();
		flowPanels.add(this.layout);
		RootPanel.get().add(this.layout);
		this.layout.setStyleName("Application");

		// 创建配置顶部布局

		topPanelView = new TopPanelView();
		this.layout.add(this.getTopPanelView());

		// 创建和配置底部布局
		bottomPanel = new HorizontalPanel();
		bottomPanel.setWidth("100%");
		bottomPanel.setSpacing(0);
		bottomPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
		this.layout.add(bottomPanel);

		// 创建菜单
		this.initTree();

		// 创建内容部分
		contentLayout = new Grid(2, 1);
		contentLayout.setCellPadding(0);
		contentLayout.setCellSpacing(0);
		contentDecorator = new DecoratorPanel();
		contentDecorator.setWidget(contentLayout);
		contentDecorator.addStyleName("Application-content-decorator");
		bottomPanel.add(contentDecorator);
		bottomPanel.setCellHorizontalAlignment(contentDecorator,
				HasHorizontalAlignment.ALIGN_RIGHT);
		contentDecorator.getElement().setAttribute("align", "RIGHT");

		// 内容部分的正文
		contentWrapper = new SimplePanel();
		contentLayout.setWidget(0, 0, contentWrapper);
		contentLayout.getCellFormatter().setStyleName(1, 0,
				"Application-content-wrapper");

		mainMenu.ensureSelectedItemVisible();
		// 调整内容部分的宽度
		Window.addResizeHandler(this);
		this.setContentSize(Window.getClientWidth());
	}

	@SuppressWarnings("unchecked")
	private void initTree() {
		mainMenu = new Tree();
		mainMenu.setAnimationEnabled(true);
		mainMenu.addStyleName("Application-menu");

		AuthUtil authUtil = new AuthUtil();
		GWT.log("getAuthString()-------"+this.getAuthString());
		List<Map<String, List>> authList = AuthUtil.getAuthMap().get(this.getAuthString());
		TreeItem item = null;
		TreeItem childrenItem = null;
		GWT.log("authList size is "+authList.size());
		for (int i = 0; i < authList.size(); i++) {
			Map<String, List>   authMaps =  authList.get(i);
			Iterator iterator = authMaps.keySet().iterator();
			while (iterator.hasNext()) {
				String s = (String)iterator.next();
				if ("数据管理".equals(s)) {
					item = mainMenu.addItem("数据管理");
					List l = authMaps.get("数据管理");
					for (int li = 0; li < l.size(); li++) {
						if ("数据查询".equals(l.get(li))) {
							childrenItem = item.addItem(new Image(images
									.treeimage())
									+ "数据查询");
							childrenItem.setUserObject("test_date1");
							treeItems.put(childrenItem, new HTML(
									"数据查询"));

						}
						if ("数据维护".equals(l.get(li))) {
							childrenItem = item.addItem(new Image(images
									.treeimage())
									+ "数据维护");
							childrenItem.setUserObject("test_data2");
							rpcPanel = new RPCPanel();
							treeItems.put(childrenItem, rpcPanel.getVerticalPanel());

						}
					}

				}
				if ("用户管理".equals(s)) {
					item = mainMenu.addItem("用户管理");
					List l = authMaps.get("用户管理");
					for (int li = 0; li < l.size(); li++) {
						if ("帐号管理".equals(l.get(li))) {
							childrenItem = item.addItem(new Image(images
									.treeimage())
									+ "帐号管理");
							childrenItem.setUserObject("test_date3");
							treeItems.put(childrenItem, new HTML(
									"帐号管理"));

						}
						if ("个人信息管理".equals(l.get(li))) {
							childrenItem = item.addItem(new Image(images
									.treeimage())
									+ "个人信息管理");
							childrenItem.setUserObject("test_data4");
							treeItems.put(childrenItem, new HTML(
							"个人信息管理"));

						}
					}
				}
			}
		}

		bottomPanel.add(mainMenu);
	}

	/**
	 * size
	 * 
	 * @param width
	 */
	private void setContentSize(int width) {
		int menuWidth = mainMenu.getOffsetWidth();
		int contentWidth = Math.max(width - menuWidth - 30, 1);
		int contentWidthInner = Math.max(contentWidth - 10, 1);
		bottomPanel.setCellWidth(mainMenu, menuWidth + "px");
		bottomPanel.setCellWidth(contentDecorator, contentWidth + "px");
		contentLayout.getCellFormatter().setWidth(0, 0,
				contentWidthInner + "px");
		contentLayout.getCellFormatter().setWidth(1, 0,
				contentWidthInner + "px");
	}

	@Override
	public void onResize(ResizeEvent event) {
		setContentSize(event.getWidth());

	}

	public TopPanelView getTopPanelView() {
		return topPanelView;
	}

	public Tree getMainMenu() {
		return mainMenu;
	}

	public FlowPanel getLayout() {
		return layout;
	}

	public Map<TreeItem, Widget> getTreeItems() {
		return treeItems;
	}

	public SimplePanel getContentWrapper() {
		return contentWrapper;
	}

	public String getAuthString() {
		return authString;
	}

}
