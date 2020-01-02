package aweme.custom;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PlusTextView extends FrameLayout {


    private String text;

    private int textColor;

    private int backgroundColor; //normal focus

    private int pressedColor; //press

    private int unencbleColor; //不可用颜色

    private TextView textView;

    private OnClickListener onClickListener;

    private Context context;

    public PlusTextView(@NonNull Context context) {
        super(context);
    }

    public PlusTextView(PlusBuilder builder){
        super(builder.context);

        this.text = builder.text;
        this.textColor = builder.textColor;
        this.backgroundColor = builder.backgroundColor;
        this.pressedColor = builder.pressedColor;
        this.unencbleColor = builder.unencbleColor;
        this.textView = builder.textView;
        this.onClickListener = builder.clickListener;
        this.context = builder.context;

        init();
    }

    private void init(){
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
        if (onClickListener != null){
            textView.setOnClickListener(onClickListener);
        }

        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                dp2px(40)
        );
        layoutParams.setMargins(dp2px(18), dp2px(3), dp2px(18), dp2px(18));
        linearLayout.setLayoutParams(layoutParams);

        linearLayout.addView(textView);

        this.addView(linearLayout);
    }

    public int dp2px(float dp){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    public static PlusTextView createPlusText(Context context, String text, int textColor, int backgroundColor, int pressedColor, OnClickListener onClickListener){
        PlusTextView.PlusBuilder builder = new PlusTextView.PlusBuilder(context);
        builder.text(text);
        builder.backgroundColor(backgroundColor);
        builder.textColor(textColor);
        builder.pressColor(pressedColor);
        builder.unableColor(Color.parseColor("#aaff0000"));
        builder.click(onClickListener);

        return new PlusTextView(builder);
    }

    public static final class PlusBuilder{
        String text;

        int textColor;

        int backgroundColor;

        int pressedColor; //press

        int unencbleColor;

        private TextView textView;

        public Context context;

        private OnClickListener clickListener;

        public PlusBuilder(Context context) {
            this.context = context;
            this.text = "PlusTextView";
            this.textColor = Color.WHITE;
            this.backgroundColor = Color.parseColor("#417BC7");
            this.pressedColor = Color.parseColor("#aa417BC7");
            this.unencbleColor = Color.parseColor("#aaff0000"); //不可用颜色
            this.textView = new TextView(context);
        }

        public PlusBuilder text(String s){
            this.text = s;
            return this;
        }

        public PlusBuilder textColor(int textColor){
            this.textColor = textColor;
            return this;
        }

        public PlusBuilder backgroundColor(int backgroundColor){
            this.backgroundColor = backgroundColor;
            return this;
        }

        public PlusBuilder pressColor(int pressedColor){
            this.pressedColor = pressedColor;
            return this;
        }

        public PlusBuilder unableColor(int unencbleColor){
            this.unencbleColor = unencbleColor;
            return this;
        }

        public PlusBuilder textView(TextView textView){
            this.textView = textView;
            return this;
        }

        public PlusBuilder click(OnClickListener clickListener){
            this.clickListener = clickListener;
            return this;
        }

        public PlusTextView build(){
            return new PlusTextView(this);
        }
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
