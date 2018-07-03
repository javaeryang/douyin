package xposed;

import android.app.Application;
import android.content.Context;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import log.Vlog;
import version.Version;

/**
 * Created by javaer on 2018/7/3.
 */

public class Main implements IXposedHookLoadPackage{

    public static String DY_PKG = "com.ss.android.ugc.aweme";
    public static Context globalContext;
    public static ClassLoader globalClassloader;
    public static int version = 0;

    @Override
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (lpparam.packageName.equals(DY_PKG)){
            Vlog.log("hello douyin!");
            XposedHelpers.findAndHookMethod(Application.class,
                "onCreate",
                new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        Context context = (Context) param.thisObject;
                        int ver = context.getPackageManager().getPackageInfo(DY_PKG,0).versionCode;
                        if (version == 0){
                            version = ver;
                            Version.init(version);
                            Vlog.log("version>>>>>>"+version);
                        }
                        globalClassloader = lpparam.classLoader;
                        globalContext = context;

                        MainHook.hookMain(lpparam.classLoader);
                    }
                }
            );
        }
    }
}
