package aweme.ui.adapter;

import android.content.Context;
import android.graphics.Color;
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
        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, dp2px(45));
        layout.setLayoutParams(layoutParams);

        TextView title = new TextView(getContext());
        title.setId(0);
        LayoutParams title_params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        title_params.addRule(RelativeLayout.CENTER_VERTICAL);
        title_params.setMargins(dp2px(18), 0, 0, 0);
        title.setLayoutParams(title_params);

        TextView subTitle = new TextView(getContext());
        subTitle.setId(1);
        LayoutParams subTitle_params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        subTitle_params.addRule(RelativeLayout.CENTER_VERTICAL);
        subTitle_params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        subTitle_params.setMargins(0, 0, dp2px(20), 0);
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

        TextView title_view;
        TextView subTitle_view;

        public InfoHolder(View view, BaseListAdapter<Info> baseListAdapter) {
            super(view, baseListAdapter);
        }

        @Override
        public void onInitialize() {
            title_view = mItemView.findViewById(0);
            title_view.setTextSize(dp2px(6));
            title_view.setTextColor(Color.BLACK);
            subTitle_view = mItemView.findViewById(1);
        }

        @Override
        public void onBind(int position, int viewType) {
            Info info = getItem(position);
            title_view.setText(info.getTitle());
            subTitle_view.setText(info.getSubTitle());
        }
    }
}
