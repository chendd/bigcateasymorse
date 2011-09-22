/*
 * Copyright (C) 2010 Moduad Co., Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com35.push.net;

import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * 
* @ClassName: PhoneStateChangeListener
* @Description: 网络监控，在手机设备断网又恢复后实现重新连接服务器机制
* @author:dengyanhui
* @date 2011-9-22 上午09:48:17
*
 */
public class PhoneStateChangeListener extends PhoneStateListener {

   

    private final ConnectToServerInterface connectToServerInterface;

    public PhoneStateChangeListener(ConnectToServerInterface connectToServerInterface) {
        this.connectToServerInterface = connectToServerInterface;
    }

    @Override
    public void onDataConnectionStateChanged(int state) {
        super.onDataConnectionStateChanged(state);
       
        
        if (state == TelephonyManager.DATA_CONNECTED) {
        	connectToServerInterface.connectToServer();
        }
    }

    private String getState(int state) {
        switch (state) {
        case 0: // '\0'
            return "DATA_DISCONNECTED";
        case 1: // '\001'
            return "DATA_CONNECTING";
        case 2: // '\002'
            return "DATA_CONNECTED";
        case 3: // '\003'
            return "DATA_SUSPENDED";
        }
        return "DATA_<UNKNOWN>";
    }

}
