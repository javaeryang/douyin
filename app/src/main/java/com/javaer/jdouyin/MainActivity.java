package com.javaer.jdouyin;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import aweme.CustomButton;
import aweme.CustomLinearLayout;
import aweme.ui.adapter.InfoAdapter;
import data.Info;
import data.InfoEnum;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        root.setLayoutParams(params);
        root.setPadding(20, 20, 20, 20);
        root.setGravity(Gravity.CENTER_VERTICAL);

        CustomLinearLayout layout = new CustomLinearLayout(this);
        root.addView(layout);
        setContentView(root);

        init(layout);
    }

    public void init(CustomLinearLayout root){

        ListView listView = new ListView(this);
        listView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        InfoAdapter adapter = new InfoAdapter(this);
        adapter.setItems(getList());
        listView.setAdapter(adapter);

        root.addView(listView);

        for (int i = 0; i < 10; i++){
            CustomButton button = new CustomButton(this);
            button.setPadding(button.dp2px(10), 0, button.dp2px(10), 0);
            LinearLayout.LayoutParams button_p =
                    new LinearLayout.LayoutParams(
                            button.dp2px(68),
                            button.dp2px(30));
            button_p.setMargins(10, 10, 10, 10);
            button.setLayoutParams(button_p);
            button.setText("1.9."+i);
            button.setTextSize(button.dp2px(5));
            button.setGravity(Gravity.CENTER);
            if (i == 1){
                button.setEnabled(false);
            }
            root.addView(button);
        }
    }

    private List<Info> getList(){
        List<Info> infos = new ArrayList<>();
        for (InfoEnum infoEnum : InfoEnum.values()){
            Info info = new Info();
            info.setType(infoEnum.getType());
            info.setTitle(infoEnum.getTitle());
            info.setSubTitle(infoEnum.getSubTitle());
            infos.add(info);
        }
        return infos;
    }
}
