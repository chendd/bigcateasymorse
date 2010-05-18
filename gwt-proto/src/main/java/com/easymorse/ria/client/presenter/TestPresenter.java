package com.easymorse.ria.client.presenter;

import com.easymorse.ria.client.event.AboutEvent;
import com.easymorse.ria.client.event.AboutEventHandler;
import com.easymorse.ria.client.event.LoginEvent;
import com.easymorse.ria.client.event.LoginEventHandler;
import com.easymorse.ria.client.event.MainManuEvent;
import com.easymorse.ria.client.event.MainManuEventHandler;
import com.easymorse.ria.client.rpc.GreetingService;
import com.easymorse.ria.client.rpc.GreetingServiceAsync;
import com.easymorse.ria.client.view.AboutDialogBox;
import com.easymorse.ria.client.view.MainLayoutView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.TreeItem;

public class TestPresenter implements Presenter, ValueChangeHandler<String> {

	private HandlerManager handlerManager;

	private HasWidgets container;

	private MainLayoutView mainLayoutView;

	String userName;
	
	String authString;
	
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	public TestPresenter(HandlerManager handlerManager,String authString) {
		this.handlerManager = handlerManager;
		this.mainLayoutView = new MainLayoutView(authString);
		// mainLayoutView = new MainLayoutView();
		bind();
	}

	private void bind() {

		this.handlerManager.addHandler(LoginEvent.TYPE,
				new LoginEventHandler() {

					@Override
					public void startLogin(LoginEvent event) {
						userName = event.getUserName();
						greetingService.greetServer(userName,
								new AsyncCallback<String>() {
									public void onFailure(Throwable caught) {
										// Show the RPC error message to the
										// user
										Window
												.alert("Remote Procedure Call - Failure");
									}

									public void onSuccess(String result) {
										Window.alert("输入的用户名是：" + result);
									}
								});
					}
				});

		this.handlerManager.addHandler(MainManuEvent.TYPE,
				new MainManuEventHandler() {

					@Override
					public void changeTracManu(MainManuEvent event) {

						if (mainLayoutView.getTreeItems().get(
								event.getTreeItem()) != null) {

							mainLayoutView.getContentWrapper().clear();
							mainLayoutView.getContentWrapper().add(
									mainLayoutView.getTreeItems().get(
											event.getTreeItem()));
							History.newItem(event.getTreeItem().getUserObject()
									.toString());
						}

					}

				});
		if(null != mainLayoutView.getRpcPanel()){
			mainLayoutView.getRpcPanel().getButton().addClickHandler(
					new ClickHandler() {

						@Override
						public void onClick(ClickEvent event) {
							handlerManager.fireEvent(new LoginEvent(mainLayoutView
									.getRpcPanel().getTextBox().getText()));

						}

					});
		}
	

		mainLayoutView.getMainMenu().addSelectionHandler(
				new SelectionHandler<TreeItem>() {

					@Override
					public void onSelection(SelectionEvent<TreeItem> event) {

						handlerManager.fireEvent(new MainManuEvent(event
								.getSelectedItem()));

					}
				});

		this.handlerManager.addHandler(AboutEvent.TYPE,
				new AboutEventHandler() {

					@Override
					public void aboutDialog(AboutEvent event) {
						// TODO Auto-generated method stub
						mainLayoutView.getLayout().setVisible(false);

						container.add(new AboutDialogBox(mainLayoutView));

					}
				});

		mainLayoutView.getTopPanelView().getLink().addClickHandler(
				new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						handlerManager.fireEvent(new AboutEvent("哈哈"));

					}

				});
		//mainLayoutView.getTopPanelView().get
	}

	@Override
	public void go(HasWidgets container) {
		this.container = container;
		// container.clear();
		// mainLayoutView.getLayout().setVisible(false);
		// mainLayoutView.setVisible(false);
		if (History.getToken().equals("")) {
			History.newItem("browse");
		} else {
			History.fireCurrentHistoryState();
		}

	}

	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		Window.alert("哈哈。他调用了 onvalues");
	}

	public String getAuthString() {
		return authString;
	}

	public void setAuthString(String authString) {
		this.authString = authString;
	}

	// public RPCPanel getRpcPanel() {
	// return this.rpcPanel;
	// }
	

}
