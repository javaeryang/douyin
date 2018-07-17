package hook;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import version.Version;

/**
 * Created by javaer on 2018/7/3.
 */

public class Hook {

    /** ViewHolder */
    public static Object Holder;

    /**
     * 获取当前ViewHolder
     * @param classLoader
     */
    public static void hookViewHolder(ClassLoader classLoader){

        XposedHelpers.findAndHookMethod(Version.BaseListFragmentPanel,
                classLoader,
                Version.BaseListFragmentPanel_Method_D,
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
