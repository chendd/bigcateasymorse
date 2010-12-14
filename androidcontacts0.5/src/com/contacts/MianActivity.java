package com.contacts;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.PhoneLookup;
import android.util.Log;

public class MianActivity extends Activity {

	private final String TAG = "getcontacts";
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		getContactInfo();
	}

	protected void getContactInfo() {

		Cursor cursor = getContentResolver().query(
				ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
		while (cursor.moveToNext()) {
			String contactId = cursor.getString(cursor
					.getColumnIndex(ContactsContract.Contacts._ID));
			String name = cursor
					.getString(cursor
							.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME));
			Log.v(TAG, "...name..." + name);
			String hasPhone = cursor
					.getString(cursor
							.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));

			if (hasPhone.equalsIgnoreCase("1"))
				hasPhone = "true";
			else
				hasPhone = "false";

			if (Boolean.parseBoolean(hasPhone)) {
				Cursor phones = getContentResolver().query(
						ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
						null,
						ContactsContract.CommonDataKinds.Phone.CONTACT_ID
								+ " = " + contactId, null, null);
				while (phones.moveToNext()) {
					String phoneNumber = phones
							.getString(phones
									.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
					Log.v(TAG, "...phoneNumber...  " + phoneNumber);
				}
				phones.close();
			}

			// Find Email Addresses
			Cursor emails = getContentResolver().query(
					ContactsContract.CommonDataKinds.Email.CONTENT_URI,
					null,
					ContactsContract.CommonDataKinds.Email.CONTACT_ID + " = "
							+ contactId, null, null);
			while (emails.moveToNext()) {
				String emailAddress = emails
						.getString(emails
								.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA));
				Log.v(TAG, "...emailAddress...  " + emailAddress);
			}
			emails.close();

			Cursor address = getContentResolver()
					.query(ContactsContract.CommonDataKinds.StructuredPostal.CONTENT_URI,
							null,
							ContactsContract.CommonDataKinds.StructuredPostal.CONTACT_ID
									+ " = " + contactId, null, null);
			while (address.moveToNext()) {
				// These are all private class variables, don't forget to create
				// them.
				String poBox = address
						.getString(address
								.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.POBOX));
				String street = address
						.getString(address
								.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.STREET));
				String city = address
						.getString(address
								.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.CITY));
				String state = address
						.getString(address
								.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.REGION));
				String postalCode = address
						.getString(address
								.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.POSTCODE));
				String country = address
						.getString(address
								.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.COUNTRY));
				String type = address
						.getString(address
								.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.TYPE));
				Log.v(TAG, "...city...  " + city);
			} 
		} 
		cursor.close();
	}

}