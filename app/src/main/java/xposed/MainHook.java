package xposed;

import hook.Hook;

/**
 * Created by javaer on 2018/7/3.
 */

public class MainHook {
    public static void hookMain(ClassLoader classLoader){

        Hook.hook(classLoader);
    }
}
