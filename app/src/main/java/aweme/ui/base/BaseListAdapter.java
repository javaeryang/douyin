package aweme.ui.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2018/7/22.
 */

public abstract class BaseListAdapter<T> extends BaseAdapter{
    private Context mContext;
    private List<T> mItems;
    private LayoutInflater mLayoutInflater;

    public BaseListAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public List<T> getmItems(){
        return mItems;
    }

    public Context getContext(){
        return mContext;
    }

    public void setItems(List<T> items){
        mItems = items;
    }

    @Override
    public int getCount() {
        return mItems == null ? 0 : mItems.size();
    }

    @Override
    public T getItem(int position) {
        return mItems == null ? null : mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        int viewType = getItemViewType(position);

        if (convertView == null){

            //创建View
            convertView = onCreateView(mLayoutInflater, parent, viewType);

            //创建ViewHolder
            ViewHolder<T> viewHolder = onCreateViewHolder(convertView, viewType);

            //初始化操作
            if (viewHolder != null) viewHolder.onInitialize();

            //保存
            convertView.setTag(viewHolder);
        }

        ViewHolder<T> viewHolder = (ViewHolder<T>) convertView.getTag();

        if (viewHolder != null){
            //进行绑定
            viewHolder.mPosition = position;
            viewHolder.onBind(position,viewType);
        }

        return convertView;
    }

    /**
     * 实例显示的View
     * @param layoutInflater
     * @param parent
     * @param viewType
     * @return
     */
    public abstract View onCreateView(LayoutInflater layoutInflater, ViewGroup parent, int viewType);

    /**
     * 初始化View
     * @param view
     * @param viewType
     * @return
     */
    public abstract ViewHolder<T> onCreateViewHolder(View view, int viewType);

    public abstract class ViewHolder<T>{

        protected int mPosition;
        protected View mItemView;
        private BaseListAdapter<T> mBaseListAdapter;

        public ViewHolder(View view, BaseListAdapter<T> baseListAdapter) {
            this.mItemView = view;
            this.mBaseListAdapter = baseListAdapter;
        }

        public void onInitialize(){

        }

        public View getItemView(){
            return mItemView;
        }

        /**
         * 绑定View, 用于数据跟View进行绑定
         * @param position
         * @param viewType
         */
        public abstract void onBind(int position, int viewType);

        /**
         * 获取指定索引id的内容信息
         * @param position 索引id
         * @return 指定id的内容信息
         */
        public T getItem(int position){
            return mBaseListAdapter.getItem(position);
        }

        /**
         * 获取适配器中数据下标
         * @return
         */
        public int getAdapterPosition() {
            return mPosition;
        }
    }

    protected int dp2px(float dp){
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);

    }

}
