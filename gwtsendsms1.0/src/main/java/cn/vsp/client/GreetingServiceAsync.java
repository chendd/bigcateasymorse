package cn.vsp.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void greetServer(String input, AsyncCallback<String> callback);
	void dealSms(String phoneNum,String message,String smsSign, AsyncCallback<String> callback);
	void findSmsBean(String smsSign,AsyncCallback<String> callback);
}
