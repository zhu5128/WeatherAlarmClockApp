package com.pczhu.pczhulib.interfaces;

/**
 * <pre>
 *  名称：PermissionCallBack
 *  作用：权限获取回调
 *  描述：
 *  作者：pczhu
 *  创建时间： 2017/4/28 上午10:55
 *  版本：V1.0
 *  修改历史：
 *  </pre>
 */
public interface PermissionCallBack {
    /**
     * 获取到权限
     */
    void allowAllPermissions();

    /**
     * 获取权限失败
     */
    void notAllowAllPermissions();
}
