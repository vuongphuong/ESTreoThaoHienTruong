package com.es.estreothaohientruong.UserInterface.Customer;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.es.estreothaohientruong.R;

/**
 * Created by phuon on 5/27/2016.
 */
public class AdapterCustomerDetail extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater = null;
    public AdapterCustomerDetail(Context mContext){
        super();
        this.context = mContext;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_customer_detail, null);
        }
        return convertView;
    }
    static class ViewHolder {
        TextView tvSTT;
        ImageView ivIcon;
        TextView tv_msCount;
    }
}
