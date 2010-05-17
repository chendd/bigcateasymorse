package com.easymorse.ria.client;

import com.easymorse.ria.client.event.NeedLoginEvent;
import com.easymorse.ria.client.event.NeedLoginEventHandler;
import com.easymorse.ria.client.presenter.LoginPresenter;
import com.easymorse.ria.client.presenter.Presenter;
import com.easymorse.ria.client.presenter.TestPresenter;
import com.easymorse.ria.client.rpc.GreetingService;
import com.easymorse.ria.client.rpc.GreetingServiceAsync;
import com.easymorse.ria.client.view.MainLayoutView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

/**
 * 
 * @author marshal
 * 
 */
public class ApplicationController implements ValueChangeHandler<String>,
		Presenter {
	
	private HandlerManager handlerManager;

	private TestPresenter testPresenter;

	private MainLayoutView mainLayoutView;

	HasWidgets container;
	
	String userName;
	/**
	 * 用户登录的信息
	 */
	String userInfo;

	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	public ApplicationController(HandlerManager handlerManager,HasWidgets container) {
		this.handlerManager = handlerManager;
	//	mainLayoutView = new MainLayoutView();
		this.container = container;
		this.bind();
	}

	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		Window.alert("调用了 applicationController的 onValueChange方法");
	}

	@Override
	public void go(HasWidgets container) {
		//this.container = container;
		//container.add(mainLayoutView);
		this.checkLogin();
		
	}

	private void checkLogin(){
		
		
		
		greetingService.isLogined(userInfo,
				new AsyncCallback<String>() {
					public void onFailure(Throwable caught) {
						Window.alert("rpc error!");
					}
					public void onSuccess(String result) {
						if("logined".equals(result)){
							testPresenter = new TestPresenter(handlerManager);
							testPresenter.go(container);
						}else{
							handlerManager.fireEvent(new NeedLoginEvent());
						}
						
					}
				});
		
	}
	/**
	 * 全局事件
	 */
	private void bind() {
		/**
		 * 作用户的权限事件配置
		 */
		
		
		this.handlerManager.addHandler(NeedLoginEvent.TYPE,
				new NeedLoginEventHandler() {

					@Override
					public void onNeedLogin(NeedLoginEvent event) {
						new LoginPresenter(handlerManager).go(container);
					}
				});
//		this.handlerManager.addHandler(AboutEvent.TYPE,new AboutEventHandler(){
//
//			@Override
//			public void aboutDialog(AboutEvent event) {
//				// TODO Auto-generated method stub
//				mainLayoutView.setVisible(false);
//				Window.alert("ddd");
//				
//			}	
//		});
//		
//		mainLayoutView.getTopPanelView().getLink().addClickHandler(
//		new ClickHandler() {
//
//			@Override
//			public void onClick(ClickEvent event) {
//				handlerManager.fireEvent(new AboutEvent("哈哈"));
//
//			}
//
//		});

//		this.handlerManager.addHandler(LoginEvent.TYPE,
//				new LoginEventHandler() {
//
//					@Override
//					public void startLogin(LoginEvent event) {
//						userName = event.getUserName();
//						greetingService.greetServer(userName,
//								new AsyncCallback<String>() {
//									public void onFailure(Throwable caught) {
//										// Show the RPC error message to the
//										// user
//										Window
//												.alert("Remote Procedure Call - Failure");
//
//									}
//
//									public void onSuccess(String result) {
//
//										Window.alert("输入的用户名是：" + result);
//									}
//								});
//					}
//				});
//		mainLayoutView.getRpcPanel().getButton().addClickHandler(
//				new ClickHandler() {
//
//					@Override
//					public void onClick(ClickEvent event) {
//						handlerManager.fireEvent(new LoginEvent(mainLayoutView.getRpcPanel()
//								.getTextBox().getText()));
//
//					}
//
//				});

	}



}
