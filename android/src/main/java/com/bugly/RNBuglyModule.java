package com.bugly;

import android.content.Context;
import android.util.Log;
// import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.UpgradeInfo;
import com.tencent.bugly.crashreport.CrashReport;


public class RNBuglyModule extends ReactContextBaseJavaModule {

  public RNBuglyModule(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  public String getName() {
    return "RNBugly";
  }

  /**
   * 检查是否需要更新
   *
   * @param isManual  用户手动点击检查，非用户点击操作请传false
   * @param isSilence 是否显示弹窗等交互，[true:没有弹窗和toast] [false:有弹窗或toast]
   * 
   * 示例：
   *    1. APP启动时，自动检查更新：checkUpgrade(false, false);
   *    2. 设置页面-检查新版本：checkUpgrade(true, false);
   */
  @ReactMethod
  public void checkUpgrade(boolean isManual, boolean isSilence) {
    Log.i("ReactNative-bugly", "checkUpgrade(): isManual = " + isManual + " isSilence = " + isSilence);
    Beta.checkUpgrade(isManual, isSilence);
  }

  // 主动上报开发者 catch 的异常
  @ReactMethod
  public void postCatchedException(String str) {
    Log.i("ReactNative-bugly", "postCatchedException(): " + str);
    CrashReport.postCatchedException(new MyBuglyException(str));
  }

  // Note: debug 版本的异常崩溃会被 RN 拦截、不会上报
  @ReactMethod
  public void testJavaCrash() {
    Log.i("ReactNative-bugly", "testJavaCrash()");
    CrashReport.testJavaCrash();
  }

  /***** 获取升级信息 *****/
  @ReactMethod
  public void getUpgradeInfo(final Promise promise) {
    Log.i("ReactNative-bugly", "getUpgradeInfo()");
    UpgradeInfo upgradeInfo = Beta.getUpgradeInfo();
    WritableMap map = Arguments.createMap();
    if(upgradeInfo == null) {
      promise.resolve(map);
      return;
    }
    map.putString("newFeature", upgradeInfo.newFeature);
    map.putInt("versionCode", upgradeInfo.versionCode);
    map.putString("versionName", upgradeInfo.versionName);
    map.putString("apkMd5", upgradeInfo.apkMd5);
    promise.resolve(map);
  }

  /**
   * 初始化
   */
  public static void init(Context context, String appId, boolean isDebug) {
    // true 表示初始化时自动检查升级，false 表示不会自动检查升级，需要手动调用 Beta.checkUpgrade() 方法
    Beta.autoCheckUpgrade = false;
    Bugly.init(context, appId, isDebug);
  }

}