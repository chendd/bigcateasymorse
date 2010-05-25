#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client;

import ${package}.client.event.NeedLoginEvent;
import ${package}.client.event.NeedLoginEventHandler;
import ${package}.client.presenter.LoginPresenter;
import ${package}.client.presenter.Presenter;
import ${package}.client.presenter.TestPresenter;
import ${package}.client.rpc.GreetingService;
import ${package}.client.rpc.GreetingServiceAsync;
import ${package}.client.view.MainLayoutView;

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
						if("logined".equals(result.split("-")[0])){
							testPresenter = new TestPresenter(handlerManager,result.split("-")[1]);
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

	}
}
