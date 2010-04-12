package cn.vsp.client;


import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public class MyHandler implements ClickHandler, KeyUpHandler {
	
	public String phone;
	public String message;
	public String smsSign;
	
	boolean sign;
	
	public MyHandler(){
		
	}
	
	public MyHandler(String phone,String message,String smsSign){
		this.phone = phone;
		this.message = message;
		this.smsSign = smsSign;
	}
	
	private final GreetingServiceAsync greetingService = GWT
	.create(GreetingService.class);
	
	
		/**
		 * Fired when the user clicks on the sendButton.
		 */
		public void onClick(ClickEvent event) {
			
			//sendNameToServer(phone,message,smsSign);
		}

		/**
		 * Fired when the user types in the nameField.
		 */
		public void onKeyUp(KeyUpEvent event) {
			if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
			//	sendNameToServer(phone,message,smsSign);
			}
		}

		/**
		 * Send the name from the nameField to the server and wait for a response.
		 */
//		public boolean sendNameToServer(String phone ,String message,String smsSign) {
//
//		
//			
//			GreetingServiceAsync greetingServiceAsync = (GreetingServiceAsync) GWT
//					.create(GreetingService.class);
//			ServiceDefTarget serviceDefTarget = (ServiceDefTarget) greetingServiceAsync;
//			serviceDefTarget.setServiceEntryPoint(GWT.getModuleBaseURL()
//					+ "greet");
//			
//			greetingService.dealSms(phone,message,smsSign,
//					new AsyncCallback<String>() {
//						public void onFailure(Throwable caught) {
//							// Show the RPC error message to the user
//						
//						}
//
//						public void onSuccess(String result) {
//						Window.alert("返回的结果是"+result);
//						sign = true;
//						}
//					});
//			return sign;
//		}
	

}
