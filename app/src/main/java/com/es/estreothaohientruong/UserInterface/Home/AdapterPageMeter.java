package com.es.estreothaohientruong.UserInterface.Home;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.es.estreothaohientruong.R;
import com.es.estreothaohientruong.UserInterface.Base.AdapterDelegate;

/**
 * Created by phuon on 5/27/2016.
 */
public class AdapterPageMeter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater = null;
    private AdapterDelegate delegate;
    public AdapterPageMeter(Context mContext,AdapterDelegate delegate){
        super();
        this.context = mContext;
        this.delegate = delegate;
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
            convertView = inflater.inflate(R.layout.item_meter, null);
            holder.tvSTT = (TextView) convertView.findViewById(R.id.i_meter_tvSTT);
            holder.btnDetail = (LinearLayout) convertView.findViewById(R.id.i_meter_btnDetail);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvSTT.setText(position + 1 +"");
        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delegate.onClickItemAdapter(v);
            }
        });
        return convertView;
    }
    private class ViewHolder {
        TextView tvSTT;
        LinearLayout btnDetail;
    }
}
