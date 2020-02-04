package com.zhaowei.shi.assignment.MyLayout;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.zhaowei.shi.assignment.utils.SuitUITool;

public class SuitRelativeLayout extends RelativeLayout {
    private Context mContext;
    private boolean isMeasured = false;

    public SuitRelativeLayout(Context context) {
        super(context);
        mContext = context;
        isMeasured = false;
    }

    public SuitRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        //RESET
        isMeasured = false;
    }

    public SuitRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        isMeasured = false;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.e("wang", widthMeasureSpec + "  onMeasure->" + heightMeasureSpec);
        if (!isMeasured) {
            SuitUITool uiTool = SuitUITool.getInstance(mContext);
            for (int i = 0; i < this.getChildCount(); i++) {
                View child = this.getChildAt(i);
                //GET CHILD VIEW
                LayoutParams params = (LayoutParams) (child.getLayoutParams());
                //REAL SIZE
                params.width = (int) (params.width * uiTool.getScale_width());
                params.height = (int) (params.height * uiTool.getScale_height());
                params.leftMargin = (int) (params.leftMargin * uiTool.getScale_width());
                params.rightMargin = (int) (params.rightMargin * uiTool.getScale_width());
                params.topMargin = (int) (params.topMargin * uiTool.getScale_height());
                params.bottomMargin = (int) (params.bottomMargin * uiTool.getScale_height());
                Log.e("wang", params.width + "  height->" + params.height);
            }
            isMeasured = true;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

}
