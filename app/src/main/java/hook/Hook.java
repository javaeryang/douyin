package hook;

import android.view.View;

import java.lang.reflect.Field;
import java.util.List;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import log.Vlog;

/**
 * Created by javaer on 2018/7/3.
 */

public class Hook {

    public static Object Holder;

    public static void hook(ClassLoader classLoader){
        XposedHelpers.findAndHookMethod("com.douyin.baseshare.a.a",
                classLoader,
                "a",
                "com.douyin.baseshare.a.a",
                View.class,
                new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        Vlog.log("param view >>>> "+param.args[1]);
                        Object mActionHandler = XposedHelpers.getObjectField(param.args[0], "mActionHandler");
                        Vlog.log("mActionHandler >>>> " + mActionHandler);
                    }
                }
        );

        XposedHelpers.findAndHookMethod("com.ss.android.ugc.aweme.feed.ui.f",
                classLoader,
                "onAction",
                "com.ss.android.ugc.aweme.framework.services.IShareService$ShareStruct",
                String.class,
                new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        Class c = param.args[0].getClass();
                        Field[] fields = c.getDeclaredFields();
                        Vlog.log("str >>>>");
                        for (Field f : fields){
                            f.setAccessible(true);
                            Vlog.log(""+f.getName()+" >>>>"+f.get(param.args[0]));
                        }
                    }
                }
        );

        XposedHelpers.findAndHookMethod("com.ss.android.ugc.aweme.feed.panel.BaseListFragmentPanel",
                classLoader,
                "h",
                "com.ss.android.ugc.aweme.feed.model.Aweme",
                new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        Object video = XposedHelpers.getObjectField(param.args[0], "video");
                        Object url = XposedHelpers.getObjectField(video, "playAddr");
                        List<String> list = (List<String>) XposedHelpers.getObjectField(url, "urlList");
//                        if (list != null && list.size() > 0){
//                            for (String s : list){
//                                Vlog.log(">>>>"+s);
//                            }
//                        }
                    }
                }
        );

        XposedHelpers.findAndHookMethod("com.ss.android.ugc.aweme.feed.panel.BaseListFragmentPanel",
                classLoader,
                "D",
                new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        Object ViewHolder = param.getResult();
                        if (ViewHolder != null){
                            Holder = ViewHolder;
                        }
                    }
                }
        );

    }
}
