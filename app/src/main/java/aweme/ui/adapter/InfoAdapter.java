package aweme.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import aweme.ui.base.BaseListAdapter;
import data.Info;

/**
 * Created by Administrator on 2018/7/22.
 */
@SuppressWarnings("ResourceType")
public class InfoAdapter extends BaseListAdapter<Info>{

    public InfoAdapter(Context context) {
        super(context);
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup parent, int viewType) {
        RelativeLayout layout = new RelativeLayout(getContext());
        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

        TextView title = new TextView(getContext());
        LayoutParams title_params = new LayoutParams(LayoutParams.WRAP_CONTENT, dp2px(40));
        title_params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        title_params.setMargins(dp2px(10), 0, 0, 0);
        title.setLayoutParams(title_params);

        TextView subTitle = new TextView(getContext());
        LayoutParams subTitle_params = new LayoutParams(LayoutParams.WRAP_CONTENT, dp2px(40));
        subTitle_params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        subTitle_params.setMargins(0, 0, 0, dp2px(10));
        subTitle.setLayoutParams(subTitle_params);

        layout.addView(title);
        layout.addView(subTitle);
        return layout;
    }

    @Override
    public ViewHolder<Info> onCreateViewHolder(View view, int viewType) {
        return new InfoHolder(view, this);
    }

    public final class InfoHolder extends ViewHolder<Info>{

        public InfoHolder(View view, BaseListAdapter<Info> baseListAdapter) {
            super(view, baseListAdapter);
        }

        @Override
        public void onBind(int position, int viewType) {

        }
    }
}
