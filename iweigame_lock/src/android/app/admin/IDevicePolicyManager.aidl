package android.app.admin;  
  
import android.content.ComponentName;  
/** 
 * Internal IPC interface to the device policy service. 
 * {@hide} 
 */  
interface IDevicePolicyManager {  
    void setPasswordQuality(in ComponentName who, int quality);  
    int getPasswordQuality(in ComponentName who);  
      
    void setPasswordMinimumLength(in ComponentName who, int length);  
    int getPasswordMinimumLength(in ComponentName who);  
      
    boolean isActivePasswordSufficient();  
    int getCurrentFailedPasswordAttempts();  
      
    void setMaximumFailedPasswordsForWipe(in ComponentName admin, int num);  
    int getMaximumFailedPasswordsForWipe(in ComponentName admin);  
      
    boolean resetPassword(String password, int flags);  
      
    void setMaximumTimeToLock(in ComponentName who, long timeMs);  
    long getMaximumTimeToLock(in ComponentName who);  
      
    void lockNow();  
      
    void wipeData(int flags);  
      
    void setActiveAdmin(in ComponentName policyReceiver);  
    boolean isAdminActive(in ComponentName policyReceiver);  
    List<ComponentName> getActiveAdmins();  
    boolean packageHasActiveAdmins(String packageName);  
    void removeActiveAdmin(in ComponentName policyReceiver);  
      
    void setActivePasswordState(int quality, int length);  
    void reportFailedPasswordAttempt();  
    void reportSuccessfulPasswordAttempt();  
}  