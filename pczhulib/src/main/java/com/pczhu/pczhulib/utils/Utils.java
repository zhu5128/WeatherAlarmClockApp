package com.pczhu.pczhulib.utils;

import android.content.Context;

import com.pczhu.pczhulib.BuildConfig;

/**
 * <pre>
 * 名称：Utils
 * 作用：全局上下文初始化类
 * 描述：为应用全局提供上下文，并且需要在Application 中最先初始化
 * 作者：pczhu
 * 创建时间： 2017/4/20 下午7:01
 * 版本：V1.0
 * 修改历史：
 * </pre>
 */

public final class Utils {

    private static Context context;

    private Utils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 初始化工具类
     *
     * @param context 上下文
     */
    public static void init(Context context) {
        Utils.context = context.getApplicationContext();
    }

    /**
     * 获取ApplicationContext
     *
     * @return ApplicationContext
     */
    public static Context getContext() {
        if (context != null)
            return context;
        throw new NullPointerException("u should init first");
    }

    public static boolean isDebug(){
        return BuildConfig.DEBUG;
    }
}
