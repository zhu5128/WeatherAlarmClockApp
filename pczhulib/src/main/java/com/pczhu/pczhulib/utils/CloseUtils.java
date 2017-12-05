package com.pczhu.pczhulib.utils;

import android.util.Log;

import java.io.Closeable;
import java.io.IOException;

/**
 * <pre>
 * 名称：CloseUtils
 * 作用：流关闭工具类
 * 描述：关闭输入输出流
 * 作者：pczhu
 * 创建时间： 2017/4/20 下午7:38
 * 版本：V1.0
 * 修改历史：
 * </pre>
 */
public final class CloseUtils {

    private CloseUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 关闭IO
     *
     * @param closeables closeables
     */
    public static void closeIO(Closeable... closeables) {
        if (closeables == null) return;
        for (Closeable closeable : closeables) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.w("CloseUtils",e.getMessage(),new Throwable(e));
                }
            }
        }
    }

    /**
     * 安静关闭IO
     *
     * @param closeables closeables
     */
    public static void closeIOQuietly(Closeable... closeables) {
        if (closeables == null) return;
        for (Closeable closeable : closeables) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException ignored) {

                }
            }
        }
    }
}
