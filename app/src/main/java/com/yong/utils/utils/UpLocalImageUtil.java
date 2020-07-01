package com.yong.utils.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.luck.picture.lib.entity.LocalMedia;

/**
 * @Description: 本地图片上传封装
 * @Author: yong
 * @time 2020/6/29 18:55
 * @Version: 1.0
 */
public class UpLocalImageUtil {

    /**
     * 显示图片
     */
    public static void showImage(Context context, LocalMedia recordsBean, ImageView imageView) {
        RequestOptions options = new RequestOptions()
                .centerCrop() //centerCrop()是将图片按照比例放大到imageview的尺寸
                .placeholder(R.color.mdtp_white)//占位图
                .error(R.color.mdtp_red);//请求失败图
        Glide.with(context)
                .load(recordsBean.getRealPath())
                .apply(options)
                .into(imageView);
    }
}
