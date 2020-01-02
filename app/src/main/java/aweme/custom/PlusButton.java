package aweme.custom;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

public class PlusButton extends FrameLayout {

    private String text = "PlusButton";

    private int textColor = Color.WHITE;

    private int backgroundColor = Color.parseColor("#417BC7"); //normal focus

    private int pressedColor = Color.parseColor("#aa417BC7"); //press

    private int unencbleColor = Color.parseColor("#aaff0000"); //不可用颜色

    private TextView textView;

    private Context context;

    public PlusButton(Context context) {
        super(context);
        this.context = context;

        init();
    }

    private void init(){
        textView = new TextView(context);
        textView.setText(text);
        textView.setTextSize(18);
        textView.setTextColor(textColor);
        textView.setClickable(true);
        textView.setGravity(Gravity.CENTER);
        textView.setPadding(dp2px(10), dp2px(2), dp2px(10), dp2px(2));

        GradientDrawable drawable1 = createGradientDrawableRadius(2,
                new float[]{14, 14, 14, 14, 14, 14, 14, 14}, backgroundColor);
        drawable1.setColor(createColorStateList(
                backgroundColor,
                pressedColor,
                backgroundColor,
                unencbleColor));
        textView.setBackground(drawable1);

        LayoutParams params = new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT
        );
        textView.setLayoutParams(params);

        this.addView(textView);

    }

    public void setOnClickListener(OnClickListener onClickListener){
        textView.setOnClickListener(onClickListener);
    }

    public int dp2px(float dp){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    public void setText(String text) {
        textView.setText(text);
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    @Override
    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public void setPressedColor(int pressedColor) {
        this.pressedColor = pressedColor;
    }

    public void setUnencbleColor(int unencbleColor) {
        this.unencbleColor = unencbleColor;
    }


    /**
     * 单个圆角度
     * @param strokeWidth
     * @param roundRadius
     * @param strokeColor
     * @return
     */
    public GradientDrawable createGradientDrawable(int strokeWidth, int roundRadius, int strokeColor){
        GradientDrawable drawable = new GradientDrawable();
        drawable.setCornerRadius(roundRadius);
        drawable.setStroke(strokeWidth, strokeColor);

        return drawable;
    }

    /**
     * 设置圆角数组
     * @param strokeWidth
     * @param Radius
     * @param strokeColor
     * @return
     */
    public GradientDrawable createGradientDrawableRadius(int strokeWidth, float[] Radius, int strokeColor){
        GradientDrawable drawable = new GradientDrawable();
        drawable.setCornerRadii(Radius);
        drawable.setStroke(strokeWidth, strokeColor);

        return drawable;
    }

    /**
     * 状态选择器
     * @param normal
     * @param pressed
     * @param focused
     * @param unable
     * @return
     */
    public ColorStateList createColorStateList(int normal, int pressed, int focused, int unable) {
        int[] colors = new int[]{pressed, focused, normal, focused, unable, normal};
        int[][] states = new int[6][];
        states[0] = new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled};
        states[1] = new int[]{android.R.attr.state_enabled, android.R.attr.state_focused};
        states[2] = new int[]{android.R.attr.state_enabled};
        states[3] = new int[]{android.R.attr.state_focused};
        states[4] = new int[]{android.R.attr.state_window_focused};
        states[5] = new int[]{};
        return new ColorStateList(states, colors);
    }
}
