package com.easymorse.ria.client;

import com.easymorse.ria.client.presenter.Presenter;
import com.easymorse.ria.client.view.MainLayoutView;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;

/**
 * 
 * 
 * 
 * 
 * 
 * 
 * @author marshal
 * 
 */
public class ApplicationController implements ValueChangeHandler<String>,Presenter {
	private HandlerManager handlerManager;

	public ApplicationController(HandlerManager handlerManager) {
		this.handlerManager = handlerManager;
	}

	@Override
	public void onValueChange(ValueChangeEvent<String> event) {

	}

	@Override
	public void go(HasWidgets container) {
//		HelloworldView view=new HelloworldView("zhangsan");
//		container.add(view);
		container.add(new MainLayoutView());
		
	}
}
