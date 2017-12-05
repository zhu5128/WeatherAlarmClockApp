package com.pczhu.pczhulib.utils;

import android.app.Activity;

import com.blankj.ALog;
import com.pczhu.pczhulib.interfaces.PermissionCallBack;
import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.observers.DefaultObserver;

/**
 * <pre>
 *  名称：PermissionUtils
 *  作用：权限请求工具
 *  描述：权限请求，并且注意权限
 *  作者：pczhu
 *  创建时间： 2017/4/28 上午11:11
 *  版本：V1.0
 *  修改历史：
 *  </pre>
 */
public class PermissionUtils {
    private static RxPermissions rxPermissions;

    private PermissionUtils(){
        
    }
    public static void checkPermission(Activity mActivity,final PermissionCallBack mPermissionCallBack,String... permissions){
        if(rxPermissions == null)
            rxPermissions = new RxPermissions(mActivity);
        rxPermissions.setLogging(true);
        rxPermissions.request(permissions).subscribe(new DefaultObserver<Boolean>() {
            @Override
            public void onNext(Boolean aBoolean) {
                ALog.i("permission_request"+aBoolean);
                if(aBoolean){
                    mPermissionCallBack.allowAllPermissions();
                }else{
                    mPermissionCallBack.notAllowAllPermissions();
                }
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {
                rxPermissions = null;
            }
        });
    }

}
