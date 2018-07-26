package aweme.custom;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;

import static util.ViewUtil.createColorStateList;

/**
 * Created by javaer on 2018/7/20.
 */

public class CustomButton extends TextView {
    public CustomButton(Context context) {
        super(context);
        init();
    }

    private void init() {
        int strokeWidth = 3;
        int roundRadius = 12;
        int strokeColor = Color.parseColor("#606060");

        GradientDrawable drawable = new GradientDrawable();
        drawable.setCornerRadius(roundRadius);
        drawable.setStroke(strokeWidth, strokeColor);
        ColorStateList colorStateList = createColorStateList(0xffe29334, 0xaf4169e1, 0xff0000ff, 0xff000000);
        drawable.setColor(colorStateList);
        this.setBackground(drawable);
        this.setClickable(true);
        this.setTextColor(Color.WHITE);
    }

    public int dp2px(float dp){
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }
}