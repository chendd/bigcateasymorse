package com.easymorse.ria.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.ui.TreeItem;

public class MainManuEvent extends GwtEvent<MainManuEventHandler> {

	public static Type<MainManuEventHandler> TYPE = new Type<MainManuEventHandler>();
	
	private TreeItem treeItem;
	
	public MainManuEvent(TreeItem treeItem){
		
		this.treeItem = treeItem;
		
	}
	
	public TreeItem getTreeItem() {
		return treeItem;
	}

	@Override
	protected void dispatch(MainManuEventHandler handler) {
		
		handler.changeTracManu(this);
		
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<MainManuEventHandler> getAssociatedType() {
		
		return TYPE;
	}

	
	
}
