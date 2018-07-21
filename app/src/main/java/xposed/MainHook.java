package xposed;

import hook.Hook;
import hook.HookAwemeUI;
import hook.HookCommentUI;
import hook.HookRemoveAd;

/**
 * Created by javaer on 2018/7/3.
 */

public class MainHook {
    public static void hookMain(ClassLoader classLoader){

        try {
            Hook.hookViewHolder(classLoader);
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }
        try {
            HookAwemeUI.hookUI(classLoader);
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }
        try {
            HookRemoveAd.hookRemoveAd(classLoader);
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }
        try {
            HookCommentUI.hookCommentUI(classLoader);
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }
    }
}
