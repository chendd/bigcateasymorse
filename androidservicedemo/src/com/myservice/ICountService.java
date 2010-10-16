package com.myservice;

import android.content.Intent;

public interface ICountService {

	public abstract int getCount(Intent intent);

}