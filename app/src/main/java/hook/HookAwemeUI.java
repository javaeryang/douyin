package hook;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;

import aweme.MyLinear;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import log.Vlog;
import version.Version;

/**
 * Created by javaer on 2018/7/5.
 */

public class HookAwemeUI {
    public static Activity globalActivity;

    /**
     * Hook Activity 注入UI界面
     * @param classLoader
     */
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
        XposedHelpers.findAndHookMethod(Version.baseshare_a_a,
                classLoader,
                Version.baseshare_a_a_onCreate,
                Bundle.class,
                new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        Vlog.log("com.douyin.baseshare.a.a>>>>onCreate"+param.thisObject);
                        FrameLayout r = (FrameLayout)
                                XposedHelpers.getObjectField(param.thisObject, Version.baseshare_a_a_filed_r);
                        MyLinear myLinear = new MyLinear(globalActivity);
                        r.addView(myLinear);
                        Vlog.log("add view success");
                    }
                }
        );
    }
}
