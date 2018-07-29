package hook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.List;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import log.Vlog;
import version.Version;

/**
 * Created by javaer on 2018/7/18.
 */

public class HookRemoveAd {
    /**
     * 移除广告
     * @param classLoader
     */
    public static void hookRemoveAd(final ClassLoader classLoader){
        XposedHelpers.findAndHookMethod(Version.adapter_h,
                classLoader,
                Version.adapter_h_a,
                List.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        List<Object> list = (List<Object>) param.args[0];
                        if (list != null && list.size() > 0){
                            for (Object o : list){
                                boolean isAd = (boolean) XposedHelpers.callMethod(o, Version.Aweme_Method_isAd);
                                if (isAd){
                                    list.remove(o);
                                    Vlog.log("移除广告>>>>>>");
                                }
                            }
                        }
                        param.args[0] = list;
                    }
                }
        );

        XposedHelpers.findAndHookMethod(Version.SplashActivity,
                classLoader,
                "onCreate",
                Bundle.class,
                new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        Activity activity = (Activity) param.thisObject;
                        activity.finish();
                        Intent intent = new Intent();
                        Class Main = classLoader.loadClass(Version.MainActivity);
                        intent.setClass(activity, Main);
                        activity.startActivity(intent);
                        Vlog.log("跳过首页onCreate");
                    }
                }
        );

        XposedHelpers.findAndHookMethod(Version.SplashAdActivity,
                classLoader,
                "onCreate",
                Bundle.class,
                new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        Activity activity = (Activity) param.thisObject;
                        activity.finish();
                        Intent intent = new Intent();
                        Class Main = classLoader.loadClass(Version.MainActivity);
                        intent.setClass(activity, Main);
                        activity.startActivity(intent);
                        Vlog.log("跳过首页广告");
                    }
                }
        );
    }
}
