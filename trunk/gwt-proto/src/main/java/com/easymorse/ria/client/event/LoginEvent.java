package com.easymorse.ria.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class LoginEvent extends GwtEvent<LoginEventHandler> {

	public static Type<LoginEventHandler> TYPE = new Type<LoginEventHandler>();

	
	private String userName;

	public LoginEvent(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}
	
	@Override
	protected void dispatch(LoginEventHandler handler) {
		handler.startLogin(this);
	}

	@Override
	public Type<LoginEventHandler> getAssociatedType() {
		return TYPE;
	}

}
