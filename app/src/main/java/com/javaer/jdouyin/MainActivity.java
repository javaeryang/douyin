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
import util.PackageUtil;

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
        root.setGravity(Gravity.CENTER_VERTICAL);

        LinearLayout linearLayout1 = new LinearLayout(this);


        CustomLinearLayout layout = new CustomLinearLayout(this);

        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.addView(layout);
        linearLayout2.setPadding(20, 20, 20, 20);

        root.addView(linearLayout1);
        root.addView(linearLayout2);

        setContentView(root);



        init(linearLayout1, layout);
    }

    public void init(LinearLayout linearLayout1, CustomLinearLayout layout){

        ListView listView = new ListView(this);
        listView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        InfoAdapter adapter = new InfoAdapter(this);
        adapter.setItems(getList());
        listView.setAdapter(adapter);

        linearLayout1.addView(listView);

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
            layout.addView(button);
        }
    }

    private List<Info> getList(){
        List<Info> list = new ArrayList<>();
        list.addAll(getModel());
        for (InfoEnum infoEnum : InfoEnum.values()){
            Info info = new Info();
            info.setType(infoEnum.getType());
            info.setTitle(infoEnum.getTitle());
            info.setSubTitle(infoEnum.getSubTitle());
            list.add(info);
        }
        return list;
    }

    private List<Info> getModel(){
        List<Info> list = new ArrayList<>();
        Info info = new Info();
        info.setType(1);
        info.setTitle("插件版本");
        info.setSubTitle("build_"+ PackageUtil.getAppVersion("com.javaer.jdouyin", this));
        list.add(info);
        info = new Info();
        info.setType(1);
        info.setTitle("抖音版本");
        info.setSubTitle(PackageUtil.getAppVersion("com.ss.android.ugc.aweme", this));
        list.add(info);
        return list;
    }

}
