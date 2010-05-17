package com.easymorse.ria.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class AboutEvent extends GwtEvent<AboutEventHandler> {

	public static Type<AboutEventHandler> TYPE = new Type<AboutEventHandler>();

	
	private String userName;

	public AboutEvent(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}
	
	@Override
	protected void dispatch(AboutEventHandler handler) {
		handler.aboutDialog(this);
	}

	@Override
	public Type<AboutEventHandler> getAssociatedType() {
		return TYPE;
	}

}
