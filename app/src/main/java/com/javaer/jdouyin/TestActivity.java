package com.javaer.jdouyin;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import aweme.custom.PlusButton;
import aweme.custom.PlusTextView;

public class TestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        root.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        ));
        root.setOrientation(LinearLayout.VERTICAL);

        LinearLayout l1 = new LinearLayout(this);
        l1.setOrientation(LinearLayout.VERTICAL);

        l1.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));


        PlusButton plusButton = new PlusButton(this);
        plusButton.setText("测试2");

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                dp2px(40)
        );
        params.setMargins(dp2px(18), dp2px(3), dp2px(18), dp2px(3));
        plusButton.setLayoutParams(params);
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TestActivity.this, "测试2", Toast.LENGTH_SHORT).show();
            }
        });

        l1.addView(plusButton);


        root.addView(l1);


        setContentView(root);

        PlusTextView.PlusBuilder builder = new PlusTextView.PlusBuilder(this);
        builder.text("新按钮");
        builder.backgroundColor(Color.parseColor("#aaff0980"));
        builder.pressColor(Color.parseColor("#ff0980"));
        builder.unableColor(Color.parseColor("#ff0000"));
        builder.click(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(TestActivity.this, "新按钮测试", Toast.LENGTH_SHORT).show();
            }
        });

        PlusTextView plusTextView = new PlusTextView(builder);
        root.addView(plusTextView);
    }

    public int dp2px(float dp){
        final float scale = this.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }
}
