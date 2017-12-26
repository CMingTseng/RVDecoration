package org.daimhim.rvadapter;

import android.view.View;
import android.view.ViewGroup;

/**
 * 项目名称：org.daimhim.rvadapter
 * 项目版本：RVDecoration
 * 创建人：Daimhim
 * 创建时间：2017/12/25 13:58
 * 修改人：Daimhim
 * 修改时间：2017/12/25 13:58
 * 类描述：
 * 修改备注：
 *
 * @author Daimhim
 */

public abstract class RecyclerViewEmpty<VH extends RecyclerViewClick.ClickViewHolder> extends RecyclerViewClick<VH> implements EmptyViewContract {

    private View mEmptyView = null;

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        if (isEmptyView()){
            return onCreateEmptyViewHolder(parent, viewType);
        }else {
            return onCreateDataViewHolder(parent, viewType);
        }
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        if (isEmptyView()){
            onBindEmptyViewHolder(holder, position);
        }else {
            onBindDataViewHolder(holder,position);
        }
    }

    public boolean isEmptyView(){
        return getDataItemCount() == 0 && mEmptyView != null;
    }

    @Override
    public final int getItemCount() {
        if (isEmptyView()){
            return 1 + getDataItemCount();
        }else {
            return getDataItemCount();
        }
    }

    /**
     * 加载空页面
     * @param parent
     * @param viewType
     * @return
     */
    public abstract VH onCreateEmptyViewHolder(ViewGroup parent, int viewType);

    /**
     * 空页面加载数据
     * @param holder
     * @param position
     */
    public void onBindEmptyViewHolder(RecyclerViewClick.ClickViewHolder holder, int position){

    }
    /**
     * 数据加载页面
     * @param parent
     * @param viewType
     * @return
     */
    public abstract VH onCreateDataViewHolder(ViewGroup parent, int viewType);
    /**
     * 数据加载页面
     * @param holder
     * @param position
     */
    public abstract void onBindDataViewHolder(RecyclerViewClick.ClickViewHolder holder, int position);

    /**
     * 获取数据Item长度
     * @return
     */
    public abstract int getDataItemCount();

    @Override
    public void setEmptyView(View emptyView) {
        mEmptyView = emptyView;
    }

}
