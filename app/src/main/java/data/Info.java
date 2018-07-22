package data;

/**
 * Created by Administrator on 2018/7/22.
 */

public class Info {

    //normal  0
    //with subTitle  1
    //update info  2

    int type;
    String title;
    String subTitle;

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
