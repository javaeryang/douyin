package aweme.custom;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

import util.ViewUtil;

/**
 * Created by Administrator on 2018/7/26.
 */

public class CustomLabelTextView extends LinearLayout{

    private int colorLeft = Color.parseColor("#58575c");
    private int colorRight = Color.parseColor("#61a52a");
    public String leftText;
    public String rightText;
    private Context mContext;
    private String colorLeftString;
    private String colorRightString = "#61a52a";

    public CustomLabelTextView(Context context, String leftText, String rightText) {
        super(context);
        this.mContext = context;
        this.leftText = leftText;
        this.rightText = rightText;
        init();
    }

    public CustomLabelTextView(Context context, String leftText, String rightText, String colorLeft, String colorRight){
        super(context);
        this.mContext = context;
        this.leftText = leftText;
        this.rightText = rightText;
        this.colorLeft = Color.parseColor(colorLeft);
        this.colorRight = Color.parseColor(colorRight);
        this.colorLeftString = colorLeft;
        this.colorRightString = colorRight;
        init();
    }

    private void init(){
        this.setOrientation(HORIZONTAL);
        this.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, dp2px(28)));
        this.setPadding(dp2px(10), 0, 0, 0);
        LayoutParams tv_params = new LayoutParams(LayoutParams.WRAP_CONTENT, dp2px(24));

        TextView tv_left = new TextView(mContext);
        tv_left.setText(leftText);
        tv_left.setTextColor(Color.WHITE);
        tv_left.setClickable(true);
        tv_left.setPadding(dp2px(10), dp2px(2), dp2px(10), dp2px(2));
        GradientDrawable drawable1 = ViewUtil.createGradientDrawableRadius(2, new float[]{14, 14, 0, 0, 0, 0, 14, 14}, colorLeft);
        drawable1.setColor(ViewUtil.createColorStateList(
                Color.parseColor("#58575c"),
                Color.parseColor("#ae58575c"),
                Color.parseColor("#58575c"),
                Color.parseColor("#a158575c")));
        tv_left.setBackground(drawable1);
        tv_left.setLayoutParams(tv_params);

        TextView tv_right = new TextView(mContext);
        tv_right.setText(rightText);
        tv_right.setTextColor(Color.WHITE);
        tv_right.setClickable(true);
        tv_right.setPadding(dp2px(10), dp2px(2), dp2px(10), dp2px(2));
        GradientDrawable drawable2 = ViewUtil.createGradientDrawableRadius(2, new float[]{0, 0, 14, 14, 14, 14, 0, 0}, colorRight);
        drawable2.setColor(ViewUtil.createColorStateList(
                colorRight,
                Color.parseColor("#aa"+colorRightString.substring(1)),
                colorRight,
                colorRight));
        tv_right.setBackground(drawable2);
        tv_right.setLayoutParams(tv_params);

        this.addView(tv_left);
        this.addView(tv_right);
    }

    public int dp2px(float dp){
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    public static int randomColor(String[] colors){
        if (colors == null || colors.length <= 0){
            return Color.RED;
        }
        int random = new Random().nextInt(colors.length);
        return Color.parseColor(colors[random]);
    }

    public static String randomColorString(String[] strings){
        if (strings == null || strings.length <= 0){
            return "#ff0000";
        }
        int random = new Random().nextInt(strings.length);
        return strings[random];
    }

}
