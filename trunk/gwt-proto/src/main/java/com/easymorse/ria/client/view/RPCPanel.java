package com.easymorse.ria.client.view;

import com.easymorse.ria.client.rpc.GreetingService;
import com.easymorse.ria.client.rpc.GreetingServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class RPCPanel {

	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	private TextBox textBox;
	private Button button;

	public VerticalPanel getVerticalPanel() {
		VerticalPanel verticalPanel = new VerticalPanel();
		textBox = new TextBox();
		button = new Button("确定");

		// button.addClickHandler(new ClickHandler(){
		//
		// @Override
		// public void onClick(ClickEvent event) {
		//				
		// sendNameToServer();
		// }
		//			
		//			
		// });

		verticalPanel.add(textBox);
		verticalPanel.add(button);

		return verticalPanel;
	}

	/**
	 * Send the name from the nameField to the server and wait for a response.
	 */
	private void sendNameToServer() {

		String textToServer = textBox.getText();

		greetingService.greetServer(textToServer, new AsyncCallback<String>() {
			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user
				Window.alert("Remote Procedure Call - Failure");

			}

			public void onSuccess(String result) {

				Window.alert("输入的用户名是：" + result);
			}
		});
	}

	public TextBox getTextBox() {
		
		return textBox;
	}

	public Button getButton() {
		return button;
	}

}
