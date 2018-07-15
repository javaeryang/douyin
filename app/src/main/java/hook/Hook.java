package hook;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;

/**
 * Created by javaer on 2018/7/3.
 */

public class Hook {

    /** ViewHolder */
    public static Object Holder;

    public static void hook(ClassLoader classLoader){

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
