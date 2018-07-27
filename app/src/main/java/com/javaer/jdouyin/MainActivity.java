package com.javaer.jdouyin;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import aweme.custom.CustomLabelTextView;
import aweme.custom.CustomLinearLayout;
import aweme.ui.adapter.InfoAdapter;
import data.Info;
import data.InfoEnum;
import util.PackageUtil;

public class MainActivity extends Activity {

    public static final String MAIN_PKG = "com.javaer.jdouyin";
    public static final String DOUYIN_PKG = "com.ss.android.ugc.aweme";

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
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setPadding(20, 20, 20, 20);
        linearLayout2.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                ));

        CustomLinearLayout layout = new CustomLinearLayout(this);

        linearLayout2.addView(layout);


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
            CustomLabelTextView customLabelTextView = new CustomLabelTextView(this, "测试文字", "test"+i);
            layout.addView(customLabelTextView);
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
        info.setSubTitle("build_"+ PackageUtil.getAppVersion(MAIN_PKG, this));
        list.add(info);
        info = new Info();
        info.setType(1);
        info.setTitle("抖音版本");
        info.setSubTitle(PackageUtil.getAppVersion(DOUYIN_PKG, this));
        list.add(info);
        return list;
    }

}
