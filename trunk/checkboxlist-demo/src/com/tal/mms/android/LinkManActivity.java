package com.tal.mms.android;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract;
import android.provider.ContactsContract.PhoneLookup;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.TextView;

public class LinkManActivity extends Activity {
	/**
	 * 所有联系人数据
	 */
	private List<LinkMain> contactList = null;
	/**
	 * 全选时选中联系人数据
	 */
	private List<LinkMain> checkBoxList_checkall = null;
	/**
	 * 选中的联系人数据
	 */
	private List<LinkMain> checkBoxLists = null;
	//全选控件
	private CheckBox checkAll = null;
	/**
	 * 全选标示
	 */
	private boolean flag = false;
	//进度框
	private static ProgressDialog dialog = null;
	
	private LinkMainAdapter lmaAdapter = null;
	private ListView linkmainListView = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_linkman);
		
		checkAll =  (CheckBox)findViewById(R.id.linkmain_checkall);


		checkBoxLists = new ArrayList<LinkMain>();
		linkmainListView = (ListView)findViewById(R.id.linear_linkmainlist);


		//全选监听器
		checkAll.setOnCheckedChangeListener(new OnCheckedChangeListener() {			
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				// TODO Auto-generated method stub
				if(arg1){
					checkAll.setChecked(true);
					flag = true;
					lmaAdapter.notifyDataSetChanged();
				}else{
					checkAll.setChecked(false);
					flag = false;
					lmaAdapter.notifyDataSetChanged();
				}
			}
		});

		dialog =ProgressDialog.show(LinkManActivity.this,"","小经理正在为您备货...");
		dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		dialog.setCancelable(true);
	
		new Thread(new Runnable(){
			public void run() {
				//获取所有联系数据
				getContactList();								
				Message msg = new Message();
				msg.what = 1;
				_handler.sendMessage(msg);
				
				//列表适配器
				lmaAdapter = new LinkMainAdapter(LinkManActivity.this, contactList);		

			}
		}){}.start();
	}
	
	/**
	 * 获取联系人数据
	 */
	public void getContactList(){
		contactList = new ArrayList<LinkMain>();
		checkBoxList_checkall = new ArrayList<LinkMain>();
		LinkMain lm = null;
		//得到ContentResolver对象   
		ContentResolver cr = getContentResolver();     		
		//取得电话本中开始一项的光标   
		Cursor cursor = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);   				
		while (cursor.moveToNext())   
		{   
		    // 取得联系人名字   
		    int nameFieldColumnIndex = cursor.getColumnIndex(PhoneLookup.DISPLAY_NAME);   
		    String name = cursor.getString(nameFieldColumnIndex);   	 
		    // 取得联系人ID   
		    String contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));   
		    Cursor phone = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, 
		    		ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = "+ contactId +" and "+
		    		ContactsContract.CommonDataKinds.Phone.TYPE+" = "+ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE , null, null);   

		    // 取得电话号码(可能存在多个号码)  
		    List<String> strPhoneNumberList = new ArrayList<String>();
		    while (phone.moveToNext())   
		    {   
		         String strPhoneNumber1 = phone.getString(phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));  
		         strPhoneNumberList.add(strPhoneNumber1);
		    }     
		    phone.close();
		    for (int i = 0; i < strPhoneNumberList.size(); i++) {
		    	lm = new LinkMain();
		    	lm.setName(name);
		    	lm.setPhone(strPhoneNumberList.get(i));
		    	contactList.add(lm);
		    	checkBoxList_checkall.add(lm);
			}		    
		}   
		cursor.close();

	}
	
	Handler _handler =new Handler(){
		@Override
		public void handleMessage(Message msg) {
			
			super.handleMessage(msg);
			switch (msg.what) {
			case 1:
				if(checkBoxList_checkall != null && checkBoxLists != null){
					dialog.cancel();
					linkmainListView.setAdapter(lmaAdapter);
					
				}
				break;

			}
		}
	};
	//声明内部类 联系人对象
	private class LinkMain implements Serializable {
		private static final long serialVersionUID = 1L;
		private String name ;
		private String phone;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}		
	}
    /**
     * 适配器
     * @author Tal
     *
     */
	private class LinkMainAdapter extends ArrayAdapter<LinkMain>{
        private Activity activity;
		public LinkMainAdapter(Activity context, List<LinkMain> objects) {
			super(context, 0, objects);
			this.activity = context;
		}

		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			LinkMain myLinkMain = contactList.get(position);
			View rowview = convertView;
			ViewCache viewCache = null;
			if(rowview == null){
				LayoutInflater inflater = activity.getLayoutInflater();
				rowview = inflater.inflate(R.layout.activity_linkmain_item, null);
			    viewCache = new ViewCache(rowview);
			    rowview.setTag(viewCache);
			}else{
				viewCache = (ViewCache)rowview.getTag();
			}
			CheckBox cb = viewCache.getCheckBox();
			if(flag){
				cb.setChecked(true);							
			}else{
				cb.setChecked(false);
			}
			
			viewCache.getName().setText(myLinkMain.getName());
			viewCache.getPhone().setText(myLinkMain.getPhone());
         
//	       cb.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
//				@Override
//				public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
//
//					if(arg1){
//						if(flag){						
//								if (checkBoxList_checkall.size() > 0) {
//			                          LinkMain lm = contactList.get(position);
//			                          if (checkBoxList_checkall.indexOf(lm) < 0) {
//			                        	  checkBoxList_checkall.add(lm);
//			                          }
//		                      } else {
//		                    	  checkBoxList_checkall.add(contactList.get(position));
//		                      }
//						}else{
//							if (checkBoxLists.size() > 0) {
//		                          LinkMain lm = contactList.get(position);
//		                          if (checkBoxLists.indexOf(lm) < 0) {
//		                        	  checkBoxLists.add(lm);
//		                          }
//	                      } else {
//	                    	  checkBoxLists.add(contactList.get(position));
//	                      }
//							
//						}
//					}else{
//						if(flag){						
//							if (checkBoxList_checkall.size() > 0) {
//		                          LinkMain lm = contactList.get(position);
//		                          for (int i = 0; i < checkBoxList_checkall.size(); i++) {
//	                                if (lm == checkBoxList_checkall.get(i)) {
//	                                	checkBoxList_checkall.remove(i);
//	                                }
//	                              }
//		                          
//	                      } else {
//	                    	  checkBoxList_checkall.remove(contactList.get(position));
//	                      }
//					}else{
//						if (checkBoxLists.size() > 0) {
//	                          LinkMain lm = contactList.get(position);
//	                          for (int i = 0; i < checkBoxLists.size(); i++) {
//	                                if (lm == checkBoxLists.get(i)) {
//	                                	checkBoxLists.remove(i);
//	                                }
//	                              }
//                      } else {
//                    	  checkBoxLists.remove(contactList.get(position));
//                      }
//						
//					}						
//					}					
//
//				}
//			});
			return rowview;
		}		
		
		private class ViewCache{
			private View baseView;
			TextView name,phone;
			CheckBox checkBox;
			
			public ViewCache(View baseView){
				this.baseView = baseView;
			}
			public TextView getName(){
				if(name == null){
					name =(TextView)baseView.findViewById(R.id.linkmain_item_name);
				}
				return name;
			}
			public TextView getPhone(){
				if(phone==null){
					phone=(TextView)baseView.findViewById(R.id.linkmain_item_phone);
				}
				return phone;
			}
			public CheckBox getCheckBox(){
				if(checkBox==null){
					checkBox=(CheckBox)baseView.findViewById(R.id.linkmain_item_checkbox);
				}
				return checkBox;
			}
		}
	}

	
//		 @Override
//		 public boolean onKeyDown(int keyCode, KeyEvent event) {
//			 if(keyCode == KeyEvent.KEYCODE_BACK){
//
//					String tag = "";
//					if(flag){
//						if(checkBoxList_checkall!=null && checkBoxList_checkall.size()>0)
//						{
//							LinkMain li = null;
//							for (int i = 0; i < checkBoxList_checkall.size(); i++) {
//								li=new LinkMain();
//								li = (LinkMain) checkBoxList_checkall.get(i);
//								tag += li.getName();
//								tag += "<"+li.getPhone()+">,";
//							}
//						}
//					}else{
//						if(checkBoxLists!=null && checkBoxLists.size()>0)
//						{
//							LinkMain li = null;
//							for (int i = 0; i < checkBoxLists.size(); i++) {
//								li=new LinkMain();
//								li = (LinkMain) checkBoxLists.get(i);
//								tag += li.getName();
//								tag += "<"+li.getPhone()+">,";
//							}
//						}
//					}
//					
//					Intent intent=new Intent();
//					intent.setClass(LinkManActivity.this,MyActivity.class);
//					intent.putExtra("tag", tag);
//					LinkManActivity.this.setResult(RESULT_OK, intent);
//					LinkManActivity.this.finish();			
//			 
//		 }
//		        return  super.onKeyDown(keyCode, event);}
}
