package com.pczhu.pczhulib.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.bluelinelabs.logansquare.LoganSquare;

import java.io.IOException;
import java.util.Map;

/**
 * <pre>
 * 名称：LinkToActivity
 * 作用：去往某个Activity
 * 描述：
 * 作者：pczhu
 * 创建时间： 2017/4/25 下午4:57
 * 版本：V1.0
 * 修改历史：
 * </pre>
 */
public class LinkToActivity {

    public static final String URI_HOST = "arouter://cn.mobile.renrentou";
    private static Context mContext;
    private static LinkToActivity mLinkToActivity = null;
    private LinkToActivity(){
        
    }
    public synchronized static LinkToActivity getInstance(Context context){
        LinkToActivity.mContext = context;
        if(mLinkToActivity == null){
            mLinkToActivity = new LinkToActivity();
        }
        return mLinkToActivity;
    }

    /**
     * 跳转到某个页面
     * @param uriPath 页面地址
     * @param params 参数
     */
    public void gotoSomeWhereActivity(String uriPath, Map<String,Object> params){
        StringBuilder paramsStr = new StringBuilder("?");
        if(params != null){
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                if(entry.getValue() instanceof String){
                    paramsStr.append(entry.getKey() + "=" + entry.getValue() + "&");
                }else if(entry.getValue() instanceof Object){
                    try {
                        paramsStr.append(entry.getKey() + "=" + LoganSquare.serialize(entry.getValue())+ "&");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(URI_HOST+uriPath+paramsStr.toString()));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }


}
