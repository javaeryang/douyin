package aweme;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.widget.Button;

/**
 * Created by javaer on 2018/7/20.
 */

public class CustomButton extends Button {
    public CustomButton(Context context) {
        super(context);
        init();
    }

    private void init() {
        int strokeWidth = 2;
        int roundRadius = 12;
        int strokeColor = Color.parseColor("#606060");

        GradientDrawable drawable = new GradientDrawable();
        drawable.setAlpha(90);
        drawable.setCornerRadius(roundRadius);
        drawable.setStroke(strokeWidth, strokeColor);
        ColorStateList colorStateList = createColorStateList(0xffffffff, 0xffffff00, 0xff0000ff, 0xffff0000);
        drawable.setColor(colorStateList);
        this.setBackground(drawable);
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
}