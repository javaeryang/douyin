package aweme;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import de.robv.android.xposed.XposedHelpers;
import hook.Hook;
import log.Vlog;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import version.Version;

/**
 * Created by javaer on 2018/7/5.
 */

public class MyLinear extends LinearLayout implements AdapterView.OnItemClickListener{
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

        ListView listView = new ListView(mContext);
        listView.setOnItemClickListener(this);
        LinearLayout.LayoutParams lv_params = new LayoutParams(LayoutParams.MATCH_PARENT,dp2px(50));
        lv_params.setMargins(dp2px(10), dp2px(10), dp2px(10), dp2px(0));
        listView.setLayoutParams(lv_params);
        String[] str = new String[]{"下载无水印视频"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, str);
        listView.setAdapter(adapter);

//        LayoutParams tv_p = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
//        tv_p.setMargins(dp2px(10), dp2px(10), dp2px(10), dp2px(0));
//        TextView textView = new TextView(mContext);
//        textView.setGravity(Gravity.CENTER_HORIZONTAL);
//        textView.setTextColor(Color.RED);
//        textView.setText("抖音助手-下载无水印视频");
//        textView.setTextSize(18);
//        textView.setLayoutParams(tv_p);
//        textView.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Object f = XposedHelpers.getObjectField(Hook.Holder, "f");
//                Object video = XposedHelpers.callMethod(f, "getVideo");
//                Object playAddr = XposedHelpers.getObjectField(video, "playAddr");
//                List<String> list = (List<String>) XposedHelpers.getObjectField(playAddr, "urlList");
//                Handler handler = new Handler(Looper.getMainLooper());
//                downLoad(list, mContext, handler);
//                Vlog.log("抖音助手");
//            }
//        });

        this.addView(listView);
//        this.addView(textView);
    }

    public void downLoad(List<String> list, final Context activity, final Handler handler){
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder().url(list.get(0)).get().build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call,final IOException e) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(activity, "下载失败:\n"+"错误信息:\n"+e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                },0);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                InputStream is = response.body().byteStream();
                int len = 0;
                String directory = Environment.getExternalStorageDirectory().getAbsolutePath()+"/抖音助手";

                File file = new File(directory);
                if (!file.exists()){
                    file.mkdir();
                    Vlog.log("创建目录");
                }
                Vlog.log("目录存在");
                try {
                    final File file2 = new File(directory + "/" + System.currentTimeMillis() + ".mp4");
                    FileOutputStream fos = new FileOutputStream(file2);
                    byte[] buffer = new byte[2048];
                    while ((len = is.read(buffer)) != -1){
                        fos.write(buffer, 0, len);
                    }
                    fos.flush();
                    fos.close();
                    is.close();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(activity, "无水印视频下载成功!\n"+"保存在:"+file2.getAbsolutePath(), Toast.LENGTH_LONG).show();
                        }
                    }, 0);
                }catch (final Throwable throwable){
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(activity, "下载失败:\n"+"错误信息:\n"+throwable.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }, 0);
                }
            }
        });
    }

    private int dp2px(float value){
        final float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (scale * value + 0.5);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                if (Hook.Holder == null){
                    Toast.makeText(mContext, "播放信息获取出错!", Toast.LENGTH_SHORT).show();
                    break;
                }
                Object f = XposedHelpers.getObjectField(Hook.Holder, Version.ViewHolder_Field_f);
                Object video = XposedHelpers.callMethod(f, Version.Aweme_Method_getVideo);
                Object playAddr = XposedHelpers.getObjectField(video, Version.Video_Field_playAddr);
                List<String> list = (List<String>) XposedHelpers.getObjectField(playAddr, Version.UrlModel_Field_urlList);
                Handler handler = new Handler(Looper.getMainLooper());
                downLoad(list, mContext, handler);
                Vlog.log("抖音助手");
                break;
        }
    }
}
