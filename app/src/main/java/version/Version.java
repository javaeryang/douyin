package version;

/**
 * Created by javaer on 2018/7/3.
 */

public class Version {

    //default version is 1.9.0

    public static String SplashActivity = "com.ss.android.ugc.aweme.splash.SplashActivity";
    public static String MainActivity = "com.ss.android.ugc.aweme.main.MainActivity";
    public static String SplashAdActivity = "com.ss.android.ugc.aweme.splash.SplashAdActivity";

    public static String BaseListFragmentPanel = "com.ss.android.ugc.aweme.feed.panel.BaseListFragmentPanel";
    public static String BaseListFragmentPanel_Method_D = "D";

    public static String ViewHolder_Field_f = "f"; //Aweme 上述D方法返回类的Field
    public static String Aweme_Method_getVideo = "getVideo"; //Video
    public static String Video_Field_playAddr = "playAddr"; //VideoUrlModel
    public static String UrlModel_Field_urlList = "urlList"; //UrlModel

    public static String baseshare_a_a = "com.douyin.baseshare.a.a";
    public static String baseshare_a_a_onCreate = "onCreate";
    public static String baseshare_a_a_filed_r = "m";

    public static String adapter_h = "com.ss.android.ugc.aweme.feed.adapter.h";
    public static String adapter_h_a = "a";
    public static String Aweme_Method_isAd = "isAd";

    public static String VideoCommentDialogFragment2 = "com.ss.android.ugc.aweme.comment.ui.VideoCommentDialogFragment2";
    //adjust high versions
    public static void init(int version){

        switch (version){
            case 210:
                BaseListFragmentPanel_Method_D = "D";
                ViewHolder_Field_f = "f"; //Aweme 上述D方法返回类的Field
                Aweme_Method_getVideo = "getVideo"; //Video
                Video_Field_playAddr = "playAddr"; //VideoUrlModel
                UrlModel_Field_urlList = "urlList"; //UrlModel

                baseshare_a_a = "com.ss.android.ugc.aweme.share.v"; // extends SharePage implements OnTouchListener
                baseshare_a_a_onCreate = "onCreate";
                baseshare_a_a_filed_r = "e"; //TextView

                adapter_h = "com.ss.android.ugc.aweme.feed.adapter.h"; //compiled from: FeedPagerAdapter   "homepage_follow", "video"
                adapter_h_a = "a";
                Aweme_Method_isAd = "isAd";

                VideoCommentDialogFragment2 = "com.ss.android.ugc.aweme.comment.ui.VideoCommentDialogFragment2";
                break;
        }
    }
}
