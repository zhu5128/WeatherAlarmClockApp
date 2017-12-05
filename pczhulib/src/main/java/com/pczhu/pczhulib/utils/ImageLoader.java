package com.pczhu.pczhulib.utils;

import android.net.Uri;
import android.widget.ImageView;

/**
 * <pre>
 *  名称：ImageLoader
 *  作用：图片加载中
 *  描述：
 *  作者：pczhu
 *  创建时间： 2017/4/28 下午4:56
 *  版本：V1.0
 *  修改历史：
 *  </pre>
 */
public class ImageLoader {
    /**
     * 加载本地资源
     * @param imageView
     * @param resId
     */
    public static void loadImage(ImageView  imageView,int resId){
        Uri uri = Uri.parse("res://"+Utils.getContext().getPackageName()+"/"+resId);
        imageView.setImageURI(uri);
    }

    /**
     * 加载网络资源
     * @param imageView
     * @param picUrl
     */
    public static void loadImage(ImageView imageView, String picUrl){
        Uri uri = Uri.parse(picUrl);
        imageView.setImageURI(uri);
    }

}
