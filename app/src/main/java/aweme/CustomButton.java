package aweme;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;

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
        ColorStateList colorStateList = createColorStateList(0xff4169e1, 0xaf4169e1, 0xff0000ff, 0xff000000);
        drawable.setColor(colorStateList);
        this.setBackground(drawable);
        this.setClickable(true);
        this.setTextColor(Color.WHITE);
    }

    public static ColorStateList createColorStateList(int normal, int pressed, int focused, int unable) {
        int[] colors = new int[]{pressed, focused, normal, focused, unable, normal};
        int[][] states = new int[6][];
        states[0] = new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled};
        states[1] = new int[]{android.R.attr.state_enabled, android.R.attr.state_focused};
        states[2] = new int[]{android.R.attr.state_enabled};
        states[3] = new int[]{android.R.attr.state_focused};
        states[4] = new int[]{android.R.attr.state_window_focused};
        states[5] = new int[]{};
        ColorStateList colorList = new ColorStateList(states, colors);
        return colorList;
    }

    public int dp2px(float dp){
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }
}