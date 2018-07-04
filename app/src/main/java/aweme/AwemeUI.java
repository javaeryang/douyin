package aweme;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import log.Vlog;

/**
 * Created by javaer on 2018/7/5.
 */

public class AwemeUI {
    public static Activity globalActivity;
    public static void hookUI(ClassLoader classLoader){
        XposedHelpers.findAndHookMethod(Activity.class,
                "onResume",
                new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        globalActivity = (Activity) param.thisObject;
                    }
                }
        );
        XposedHelpers.findAndHookMethod("com.douyin.baseshare.a.a",
                classLoader,
                "onCreate",
                Bundle.class,
                new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        Vlog.log("com.douyin.baseshare.a.a>>>>onCreate");
                        FrameLayout r = (FrameLayout)
                                XposedHelpers.getObjectField(param.thisObject, "r");
//                        TextView textView = new TextView(globalActivity);
//                        textView.setText("注入文字2");
//                        textView.setTextColor(Color.RED);
//                        r.addView(textView, 0);
//                        Vlog.log("注入完毕2");
                        MyLinear myLinear = new MyLinear(globalActivity);
                        r.addView(myLinear);
                        Vlog.log("add view success");
                    }
                }
        );
    }
}
