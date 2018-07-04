package aweme;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import log.Vlog;

/**
 * Created by javaer on 2018/7/5.
 */

public class MyLinear extends LinearLayout{
    private Context mContext;
    public MyLinear(Context context) {
        super(context);
        this.mContext = context;
        init();
    }
    private void init(){
        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(dp2px(10), dp2px(5), dp2px(10), dp2px(5));
        this.setLayoutParams(layoutParams);

        LayoutParams tv_p = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        tv_p.setMargins(dp2px(10), dp2px(10), dp2px(10), dp2px(0));
        TextView textView = new TextView(mContext);
        textView.setGravity(Gravity.CENTER_HORIZONTAL);
        textView.setTextColor(Color.RED);
        textView.setText("抖音助手-小璇出品");
        textView.setTextSize(18);
        textView.setLayoutParams(tv_p);
        textView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Vlog.log("抖音助手");
            }
        });

        this.addView(textView);
    }

    private int dp2px(float value){
        final float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (scale * value + 0.5);
    }
}
