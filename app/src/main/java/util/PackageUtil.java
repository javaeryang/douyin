package util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by javaer on 2018/7/25.
 */

public class PackageUtil {
    /**
     * 获取应用版本名
     * @param packageName
     * @param context
     * @return
     */
    public static String getAppVersion(String packageName, Context context){
        String version = "";
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(packageName, 0);
            if (info != null){
                version = info.versionName;
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return version;
    }

    /**
     * 获取应用版本号
     * @param packageName
     * @param context
     * @return
     */
    public static int getAppVersionCode(String packageName, Context context){
        int version = -1;
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(packageName, 0);
            if (info != null){
                version = info.versionCode;
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return version;
    }

}
