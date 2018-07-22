package com.javaer.jdouyin;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;

import aweme.CustomButton;
import aweme.CustomLinearLayout;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        root.setLayoutParams(params);
        root.setPadding(20, 20, 20, 20);
        root.setGravity(Gravity.CENTER_VERTICAL);

        CustomLinearLayout layout = new CustomLinearLayout(this);
        root.addView(layout);
        setContentView(root);
        for (int i = 0; i < 10; i++){
            CustomButton button = new CustomButton(this);
            LinearLayout.LayoutParams button_p =
                    new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            button_p.setMargins(10, 10, 10, 10);
            button.setLayoutParams(button_p);
            button.setText("1.9."+i);
            if (i == 1){
                button.setEnabled(false);
            }
            layout.addView(button);
        }
    }
}
