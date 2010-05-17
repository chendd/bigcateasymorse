package com.easymorse.ria.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class TestEvent extends GwtEvent<TestEventHandler> {

	public static Type<TestEventHandler> TYPE = new Type<TestEventHandler>();
	
	@Override
	protected void dispatch(TestEventHandler handler) {
		handler.startLogin(this);
	}

	@Override
	public Type<TestEventHandler> getAssociatedType() {
		return TYPE;
	}

}
