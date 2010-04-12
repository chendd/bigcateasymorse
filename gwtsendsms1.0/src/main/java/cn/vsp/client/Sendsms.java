package cn.vsp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Sendsms implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	FlowPanel layout;
	SimplePanel simplePanel;
	Grid contentLayout;

	boolean sign = false;
	String smsSign = null;

	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		this.initView();

	}

	public void initView() {

		this.layout = new FlowPanel();
		simplePanel = new SimplePanel();
		RootPanel.get().add(this.layout);
		layout.add(simplePanel);

		contentLayout = new Grid(3, 2);
		layout.setHeight("50%");
		layout.setWidth("100%");

		simplePanel.setWidget(contentLayout);

		final Label phoneLabel = new Label("手机号码：");
		final TextBox phoneTextBox = new TextBox();
		final Label messageLabel = new Label("短信内容：");
		final TextArea messageTextArea = new TextArea();
		messageTextArea.setCharacterWidth(20);
		messageTextArea.setVisibleLines(3);
		final Button confirmButton = new Button("确定");
		final Button cancelButton = new Button("取消");

		contentLayout.setWidget(0, 0, phoneLabel);
		contentLayout.setWidget(0, 1, phoneTextBox);
		contentLayout.setWidget(1, 0, messageLabel);
		contentLayout.setWidget(1, 1, messageTextArea);
		contentLayout.setWidget(2, 0, confirmButton);
		contentLayout.setWidget(2, 1, cancelButton);

		confirmButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				smsSign = phoneTextBox.getText() + System.currentTimeMillis();
//				System.out.println(">>>>>>>>>结果是"+sendNameToServer(phoneTextBox.getText(), messageTextArea
//						.getText(), smsSign));
				simplePanel.clear();
				
				HTML htmlWidget = new HTML("<font color='red'><h2>请耐心等待</h2></font>");
				simplePanel.add(htmlWidget);
				
				sendNameToServer(phoneTextBox.getText(), messageTextArea
						.getText(), smsSign);
					/**
					 * 成功发送
					 */		
					
				}
		});

	}
	public void sendNameToServer(String phone ,String message,final String smsSign) {

		
		GreetingServiceAsync greetingServiceAsync = (GreetingServiceAsync) GWT
				.create(GreetingService.class);
		ServiceDefTarget serviceDefTarget = (ServiceDefTarget) greetingServiceAsync;
		serviceDefTarget.setServiceEntryPoint(GWT.getModuleBaseURL()
				+ "greet");
		
		greetingService.dealSms(phone,message,smsSign,
				new AsyncCallback<String>() {
					public void onFailure(Throwable caught) {
						
						Window.alert("rpc错误了");
					}

					public void onSuccess(String result) {
						
						greetingService.findSmsBean(smsSign, new AsyncCallback<String>() {

							@Override
							public void onFailure(Throwable arg0) {
							
								Window.alert("有错误");
							}

							@Override
							public void onSuccess(String result) {
							
								simplePanel.clear();

								contentLayout = new Grid(2, 2);
								layout.setHeight("30%");
								layout.setWidth("100%");

								simplePanel.setWidget(contentLayout);

								final Label phoneLabel = new Label("手机号码：");
								final Label phoneValue = new Label(result.split(",")[0]);
								final Label messageLabel = new Label("短信内容：");
								final Label messageValue = new Label(result.split(",")[1]);
								

								contentLayout.setWidget(0, 0, phoneLabel);
								contentLayout.setWidget(0, 1, phoneValue);
								contentLayout.setWidget(1, 0, messageLabel);
								contentLayout.setWidget(1, 1, messageValue);
							

							}
						});
					
					}
				});
		
	}
}
