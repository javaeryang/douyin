package util;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Toast;

import log.Vlog;

public class Util {
    public static String getDefaultCameraPath(){
        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "/Camera";
        if (path != null && !TextUtils.isEmpty(path)){
            return path;
        }else {
            return Environment.getExternalStorageDirectory().getAbsolutePath() + "/JDHelper";
        }
    }

    public static void gotoAlipay(Activity activity, String payUrl){
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse("alipayqr://platformapi/startapp?saId=10000007&clientVersion=3.7.0.0718&qrcode=" + payUrl));

        if (intent.resolveActivity(activity.getPackageManager()) != null) {
            activity.startActivity(intent);
        } else {
            intent.setData(Uri.parse(payUrl));
            activity.startActivity(intent);
        }
    }

    /****************
     *
     * 发起添加群流程。群号：Javaer(二)(260056346) 的 key 为： 024zhiRbVwMHKsVZc1MN3t5Pq8vA99Mb
     * 调用 joinQQGroup(024zhiRbVwMHKsVZc1MN3t5Pq8vA99Mb) 即可发起手Q客户端申请加群 Javaer(二)(260056346)
     *
     * @param key 由官网生成的key
     * @return 返回true表示呼起手Q成功，返回fals表示呼起失败
     ******************/
    public static boolean joinGroup(String key, Activity activity) {
        Intent intent = new Intent();
        intent.setData(Uri.parse("mqqopensdkapi://bizAgent/qm/qr?url=http%3A%2F%2Fqm.qq.com%2Fcgi-bin%2Fqm%2Fqr%3Ffrom%3Dapp%26p%3Dandroid%26k%3D" + key));
        // 此Flag可根据具体产品需要自定义，如设置，则在加群界面按返回，返回手Q主界面，不设置，按返回会返回到呼起产品界面    //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e) {
            // 未安装手Q或安装的版本不支持
            Toast.makeText(activity, "未安装手Q或安装的版本不支持", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public static void openUrl(String url, Activity activity){
        Uri uri = Uri.parse(url);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(uri);
        activity.startActivity(intent);
    }
}
