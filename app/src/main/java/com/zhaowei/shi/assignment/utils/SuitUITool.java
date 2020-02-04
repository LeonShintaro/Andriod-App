package com.zhaowei.shi.assignment.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

public class SuitUITool {
    private static final float standard_width = 1080;
    private static final float standard_height = 1920;

    private static float scale_width = -1;
    private static float scale_height = -1;

    private static SuitUITool instance;
    private static Context mContext;

    public SuitUITool(Context mContext) {

        this.mContext = mContext.getApplicationContext();
    }

    public static SuitUITool getInstance(Context context) {
        if (instance == null) {
            instance = new SuitUITool(context);
        }

        scale_width = -1;
        scale_height = -1;
        return instance;
    }

    public float getScale_width() {
        if (scale_width == -1) {
            initScale();
        }
        return scale_width;
    }

    public float getScale_height() {
        if (scale_height == -1) {
            initScale();
        }
        return scale_height;
    }

    private void initScale() {
        DisplayMetrics metric = new DisplayMetrics();
        WindowManager wm = (WindowManager) mContext
                .getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(metric);
        int width = metric.widthPixels;
        int height = metric.heightPixels;
        int statusBarHeight=getStatusBarHeight();
        Log.e("wang", "initScale:width->" + width + "  height->" + height+"  statusBarHeight==>"+statusBarHeight);
        Configuration mConfiguration = mContext.getResources().getConfiguration();
        int ori = mConfiguration.orientation;
//        if (ori == mConfiguration.ORIENTATION_LANDSCAPE) {
//            //Landscape
//            scale_width=(float) height/standard_width;
//            scale_height=(float) width/standard_height;
//        } else if (ori == mConfiguration.ORIENTATION_PORTRAIT) {
//            //portrait
//        scale_width = (float) width / standard_width;
//        scale_height = (float) height / standard_height;
//        }
        scale_width = (float) width / standard_width;
        scale_height = (float) (height-statusBarHeight) / standard_height;
        Log.e("wang", "initScale:scale_width->" + scale_width + "  scale_height->" + scale_height + "  ori==>" + ori);
    }

    private int getStatusBarHeight() {
        int statusBarHeight2 = 0;
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int height = Integer.parseInt(clazz.getField("status_bar_height")
                    .get(object).toString());
            statusBarHeight2 = mContext.getResources().getDimensionPixelSize(height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusBarHeight2;
    }


}
