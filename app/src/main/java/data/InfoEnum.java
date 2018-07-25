package data;

/**
 * Created by javaer on 2018/7/25.
 */

public enum InfoEnum {

    INFO_ENUM_JD(1, "JDHelper版本", "1.0"),
    INFO_ENUM_DY(1, "抖音版本", "1.9.0"),
    INFO_ENUM_MD(1, "关于插件", "Javaer"),
    INFO_ENUM_AU(1, "支持一下", "welcome"),
    INFO_ENUM_JO(1, "加入我们", "join")
    ;
    int type;
    String title;
    String subTitle;

    InfoEnum(int type, String title, String subTitle) {
        this.type = type;
        this.title = title;
        this.subTitle = subTitle;
    }

    public int getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
}
