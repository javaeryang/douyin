package aweme;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by javaer on 2018/7/20.
 */

public class CustomLinearLayout extends ViewGroup{

    public CustomLinearLayout(Context context) {
        super(context);
    }

    public CustomLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec, heightMeasureSpec);

        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec),
                getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec));
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        final int count = getChildCount();
        int childMeasureWidth = 0;
        int childMeasureHeight = 0;
        int layoutWidth = 0;    // 容器已经占据的宽度
        int layoutHeight = 0;   // 容器已经占据的宽度
        int maxChildHeight = 0; //一行中子控件最高的高度，用于决定下一行高度应该在目前基础上累加多少

        for (int i = 0; i < count; i++){
            View child = getChildAt(i);
            childMeasureWidth = child.getMeasuredWidth();
            childMeasureHeight = child.getMeasuredHeight();
            if ((layoutWidth+childMeasureWidth) < getWidth()){
                //如果一行没有排满，继续往右排列
                l = layoutWidth;
                r = l + childMeasureWidth;
                t = layoutHeight;
                b = t + childMeasureHeight;
            }else {
                //排满后换行
                layoutWidth = 0;
                layoutHeight += maxChildHeight;
                maxChildHeight = 0;

                l = layoutWidth;
                r = l + childMeasureWidth;
                t = layoutHeight;
                b = t + childMeasureHeight;
            }
            layoutWidth += childMeasureWidth + 20;////宽度累加
            if (childMeasureHeight > maxChildHeight){
                maxChildHeight = childMeasureHeight + 20;
            }
            child.layout(l, t, r, b);
        }
    }
}
