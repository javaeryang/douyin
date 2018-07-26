package util;

import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;

/**
 * Created by Administrator on 2018/7/26.
 */

public class ViewUtil {

    public static GradientDrawable createGradientDrawable(int strokeWidth, int roundRadius, int strokeColor){
        GradientDrawable drawable = new GradientDrawable();
        drawable.setCornerRadius(roundRadius);
        drawable.setStroke(strokeWidth, strokeColor);

        return drawable;
    }

    public static GradientDrawable createGradientDrawableRadius(int strokeWidth, float[] Radius, int strokeColor){
        GradientDrawable drawable = new GradientDrawable();
//        drawable.setCornerRadius(roundRadius);
        drawable.setCornerRadii(Radius);
        drawable.setStroke(strokeWidth, strokeColor);

        return drawable;
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
