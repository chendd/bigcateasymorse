#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.presenter;

import org.apache.log4j.Logger;

import ${package}.client.event.NeedLoginEvent;
import ${package}.client.rpc.GreetingService;
import ${package}.client.rpc.GreetingServiceAsync;
import ${package}.client.view.LoginDialogBox;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

public class LoginPresenter implements Presenter {

	private HandlerManager handlerManager;

	private LoginDialogBox loginDialogBox;

	private TestPresenter testPresenter;

	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	private HasWidgets container;

	private NeedLoginEvent needLoginEvent;

	

	public LoginPresenter(HandlerManager handlerManager) {
		this.handlerManager = handlerManager;
		loginDialogBox = new LoginDialogBox();
		this.needLoginEvent = needLoginEvent;

	}

	@Override
	public void go(HasWidgets container) {

		this.container = container;

		loginDialogBox.getLoginButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				login();
			}
		});

	}

	public LoginDialogBox getLoginDialogBox() {
		return loginDialogBox;
	}

	protected void login() {

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(this.loginDialogBox.getUserName().getValue())
				.append("-").append(
						this.loginDialogBox.getPassword().getValue());

		if (this.loginDialogBox.getSaveCheckBox().getValue()) {
			// stringBuilder.append("&_spring_security_remember_me=on");
		}
		greetingService.login(stringBuilder.toString(),
				new AsyncCallback<String>() {
					public void onFailure(Throwable caught) {
						Window.alert("rpc error!");
					}

					public void onSuccess(String result) {
						String resultsign = result.split("-")[0];
						GWT.log("0--------"+resultsign+"------1---------"+result.split("-")[1]);
						if ("success".equals(resultsign)) {
							getLoginDialogBox().getLoginDialgoBox().hide();
							System.out.println("result.split[1]------------"+result.split("-")[1]);
							testPresenter = new TestPresenter(handlerManager,result.split("-")[1]);
							//testPresenter.setAuthString(result.split("-")[1]);
							testPresenter.go(container);
						} else {

							loginError("用户名或密码错误");
							return;
						}

					}
				});

	}

	private void loginSuccessful() {
		// loginDialogBox.hide();
		// this.handlerManager.fireEvent(new LoginSuccessEvent(loginDialogBox
		// .getUserName().getValue()));
	}

	private void loginError(String errorMessage) {
		loginDialogBox.setMessage(errorMessage);
	}

	public NeedLoginEvent getNeedLoginEvent() {
		return needLoginEvent;
	}

}
