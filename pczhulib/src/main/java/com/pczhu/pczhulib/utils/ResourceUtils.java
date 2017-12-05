package com.pczhu.pczhulib.utils;

/**
 * <pre>
 *  名称：ResourceUtils
 *  作用：资源加载工具类
 *  描述：
 *  作者：pczhu
 *  创建时间： 2017/4/27 上午7:49
 *  版本：V1.0
 *  修改历史：
 *  </pre>
 */
public class ResourceUtils {
    /**
     * 加载字符串
     * @param resId 资源id
     * @return
     */
    public static String getString(int resId){
        return Utils.getContext().getString(resId);
    }
}
