package com.easymorse.ria.client.view;

import java.util.HashMap;
import java.util.Map;

import com.easymorse.ria.client.ResourcesImages;
import com.easymorse.ria.client.util.CommonDate;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class MainLayoutView extends Composite implements ResizeHandler {
	
	
	@UiField
	FlowPanel layout;
	private Tree mainMenu;
	
	
	private HorizontalPanel bottomPanel;

	private DecoratorPanel contentDecorator;

	// private Grid contentLayout;

	private Map<TreeItem, Widget> treeItems = new HashMap<TreeItem, Widget>();

	

	private SimplePanel contentWrapper;

	public static HandlerManager handlerManager = new HandlerManager(null);

	ResourcesImages images = GWT.create(ResourcesImages.class);

	/**
	 * 菜单的加载panel
	 */
	VerticalPanel verticalPanels = new VerticalPanel();
	HorizontalPanel horizontalPanels = new HorizontalPanel();
	VerticalPanel verticalPanelss = new VerticalPanel();

	



	private static MainLayoutViewUiBinder uiBinder = GWT
			.create(MainLayoutViewUiBinder.class);

	interface MainLayoutViewUiBinder extends UiBinder<Widget, MainLayoutView> {
	}

	
	Grid contentLayout;

	public MainLayoutView() {
		initWidget(uiBinder.createAndBindUi(this));
		mainLayout();
	}

	public void mainLayout() {
		/**
		 * 关于的dialogbox
		 */
		final DialogBox dialogBox = createDialogBox();
		dialogBox.setGlassEnabled(true);
		dialogBox.setAnimationEnabled(true);

		// 创建和设置总的布局
		this.layout = new FlowPanel();
		RootPanel.get().add(this.layout);
		this.layout.setStyleName("Application");

		// 创建配置顶部布局
		FlexTable topPanel = new FlexTable();
		this.layout.add(topPanel);
		topPanel.setStyleName("Application-top");

		// 创建关于和帮助部分
		HorizontalPanel linksPanel = new HorizontalPanel();

		Anchor link = new Anchor("关于");
		linksPanel.add(link);


		linksPanel.add(new HTML("&nbsp;|&nbsp;"));
		linksPanel.add(new Anchor("帮助"));
		topPanel.getFlexCellFormatter().setHorizontalAlignment(0, 0,
				HasHorizontalAlignment.ALIGN_RIGHT);
		topPanel.getFlexCellFormatter().addStyleName(0, 0, "Application-links");
		topPanel.getFlexCellFormatter().setColSpan(0, 0, 2);
		topPanel.setWidget(0, 0, linksPanel);

		// 创建标题部分
		HorizontalPanel titlePanel = new HorizontalPanel();
		titlePanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		topPanel.setWidget(1, 0, titlePanel);
		topPanel.getFlexCellFormatter().addStyleName(1, 0, "Application-title");
		titlePanel.add(new Image(images.vspLogo()));
		titlePanel.add(new HTML(
				"<h1>"+CommonDate.title1+"</h1><h2>"+CommonDate.title2+"</h2>"));

		// 创建选项部分
		topPanel.getFlexCellFormatter().addStyleName(1, 1,
				"Application-options");
		topPanel.getFlexCellFormatter().setHorizontalAlignment(1, 1,
				HasHorizontalAlignment.ALIGN_RIGHT);
		VerticalPanel vPanel = new VerticalPanel();
		vPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		vPanel.getElement().setAttribute("align", "right");
		topPanel.setWidget(1, 1, vPanel);
		HorizontalPanel localeWrapper = new HorizontalPanel();
		localeWrapper.add(new Image(images.globe()
				
		));
		vPanel.add(localeWrapper);

		
		
		String[] vendors = { "English", "简体中文"};
		ListBox localeBox = new ListBox();
		localeBox.setWidth("200px");
		localeWrapper.add(localeBox);

		for (String v : vendors) {
			localeBox.addItem(v);
		}
		
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

		// 设置历史监听器
		History.addValueChangeHandler(new ValueChangeHandler<String>() {
			@Override
			public void onValueChange(ValueChangeEvent<String> event) {
				
			}
		});
		

		// 加载第一个菜单选项
		if (History.getToken().length() > 0) {
		

		} else {
			
		}
		mainMenu.ensureSelectedItemVisible();
		// 调整内容部分的宽度
		 Window.addResizeHandler(this);
		 this.setContentSize(Window.getClientWidth());
	}

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

	/**
	 * Create the dialog box for this example.
	 * 
	 * @return the new dialog box
	 */
	private DialogBox createDialogBox() {
		// Create a dialog box and set the caption text
		final DialogBox dialogBox = new DialogBox();
		dialogBox.ensureDebugId("cwDialogBox");
		dialogBox.setText("关于");

		// Create a table to layout the content
		VerticalPanel dialogContents = new VerticalPanel();
		dialogContents.setSpacing(4);
		dialogBox.setWidget(dialogContents);


		// Return the dialog box
		return dialogBox;
	}

	private void initTree() {
		mainMenu = new Tree();
		mainMenu.setAnimationEnabled(true);
		mainMenu.addStyleName("Application-menu");

		

		verticalPanelss.add(new HTML("测试"));
		

	
		verticalPanels.add(horizontalPanels);

		verticalPanels.add(verticalPanelss);
		// verticalPanels.add(new NewsListPanel());

		TreeItem item = mainMenu.addItem("数据管理");
		TreeItem childrenItem = item.addItem(new Image(images.treeimage())
				+ "测试数据1");
		childrenItem.setUserObject("pavilion");
		treeItems.put(childrenItem, new HTML("asdfd"));

		childrenItem = item.addItem(new Image(images.treeimage()) + "测试数据2");
		childrenItem.setUserObject("expo_news");
		treeItems.put(childrenItem, verticalPanels);

		bottomPanel.add(mainMenu);
	}

	@Override
	public void onResize(ResizeEvent event) {
		setContentSize(event.getWidth());

	}

}
