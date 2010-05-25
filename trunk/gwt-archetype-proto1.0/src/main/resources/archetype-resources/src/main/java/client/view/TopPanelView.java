/**
 * 
 */
#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.view;

import ${package}.client.ResourcesImages;
import ${package}.client.util.CommonDate;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author dahui <a href="mailto:jiessiedyh@gmail.com">jiessiedyh@gmail.com</a>
 * 
 */
public class TopPanelView extends Composite {

	private static TopPanelViewUiBinder uiBinder = GWT
			.create(TopPanelViewUiBinder.class);

	interface TopPanelViewUiBinder extends UiBinder<Widget, TopPanelView> {
	}

	@UiField
	FlexTable topPanel;

	Anchor link;
	ResourcesImages images = GWT.create(ResourcesImages.class);

	public TopPanelView() {
		initWidget(uiBinder.createAndBindUi(this));
		this.initWidgets();
	}

	public  void initWidgets() {
		// 创建配置顶部布局
		
		topPanel.setStyleName("Application-top");

		// 创建关于和帮助部分
		HorizontalPanel linksPanel = new HorizontalPanel();

		 link = new Anchor("关于");
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
		titlePanel.add(new HTML("<h1>" + CommonDate.title1 + "</h1><h2>"
				+ CommonDate.title2 + "</h2>"));

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

		String[] vendors = { "English", "简体中文" };
		ListBox localeBox = new ListBox();
		localeBox.setWidth("200px");
		localeWrapper.add(localeBox);

		for (String v : vendors) {
			localeBox.addItem(v);
		}
	//	return topPanel;
	}

	public Anchor getLink() {
		return link;
	}

}
