package com.easymorse.ria.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class AboutDialogBox extends Composite {

	private static AboutDialogBoxUiBinder uiBinder = GWT
			.create(AboutDialogBoxUiBinder.class);

	interface AboutDialogBoxUiBinder extends UiBinder<Widget, AboutDialogBox> {
	}

	@UiField
	DialogBox dialogBox;

	Button closeButton;

	public Button getCloseButton() {
		return closeButton;
	}

	private MainLayoutView mainLayoutView;

	public AboutDialogBox(MainLayoutView mainLayoutView) {
		initWidget(uiBinder.createAndBindUi(this));
		this.mainLayoutView = mainLayoutView;
		onInitialize();
	}

	public Widget onInitialize() {
		dialogBox = createDialogBox();
		dialogBox.setGlassEnabled(true);
		dialogBox.setAnimationEnabled(true);

		dialogBox.center();
		dialogBox.show();

		return dialogBox;

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

		// Add some text to the top of the dialog
		HTML details = new HTML(" 维思比科技（北京）有限公司作为非结构化信息搜索和组织技术的专业提供商" +
				",致力于解决海量信息“精确获取，智能组织，个性服务”等难题，用创新的技术为技术合作伙伴和最终用户创造价值"
				+" 维思比科技核心开发人员有15-20年左右的研究实践经验，公司管理人员有丰富的在海外和国内工作的背景，" +
   		"维思比科技自主研发的软件产品系列，涵盖了多个前沿领域，主要有非结构化信息全文检索、各种信息源的数" +
   		"据采集（互联网、文件、数据库）自然语言处理和概念标引、控制语言和本体建立系列工具，及概念搜索和启发" +
   		"式搜索应用等多项解决方案。");
		dialogContents.add(details);
		dialogContents.setCellHorizontalAlignment(details,
				HasHorizontalAlignment.ALIGN_LEFT);

	

		// Add a close button at the bottom of the dialog
		 closeButton = new Button("关闭",
				new ClickHandler() {
					public void onClick(ClickEvent event) {
						dialogBox.hide();
						getMainLayoutView().getLayout().setVisible(true);
					}
				});
		dialogContents.add(closeButton);
		if (LocaleInfo.getCurrentLocale().isRTL()) {
			dialogContents.setCellHorizontalAlignment(closeButton,
					HasHorizontalAlignment.ALIGN_LEFT);

		} else {
			dialogContents.setCellHorizontalAlignment(closeButton,
					HasHorizontalAlignment.ALIGN_RIGHT);
		}

		// Return the dialog box
		return dialogBox;
	}

	public MainLayoutView getMainLayoutView() {
		return mainLayoutView;
	}

}
