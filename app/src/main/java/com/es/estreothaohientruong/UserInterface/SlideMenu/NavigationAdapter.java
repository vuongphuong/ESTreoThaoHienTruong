package com.es.estreothaohientruong.UserInterface.SlideMenu;

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
import com.es.estreothaohientruong.UserInterface.Base.AdapterDelegate;

import java.util.ArrayList;

/**
 * Created by phuon on 5/27/2016.
 */
public class NavigationAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<DrawerItem> title;
    private LayoutInflater inflater = null;
    private AdapterDelegate delegate;
    public NavigationAdapter(Context mContext, ArrayList<DrawerItem> drawerItems,AdapterDelegate delegate){
        super();
        this.context = mContext;
        this.title = drawerItems;
        this.delegate = delegate;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return title.size();
    }

    @Override
    public Object getItem(int position) {
        return title.get(position);
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
            convertView = inflater.inflate(R.layout.item_list_nav, null);
            holder.tv_title = (TextView) convertView.findViewById(R.id.it_list_nav_title);
            holder.ivIcon = (ImageView) convertView.findViewById(R.id.it_list_nav_image);
            holder.ivPrint = (ImageView) convertView.findViewById(R.id.it_list_nav_ivPrint);
            holder.ivBluetooth = (ImageView) convertView.findViewById(R.id.it_list_nav_ivBluetooth);
            DrawerItem drawerItem = title.get(position);
            if (position == 2){
                holder.ivPrint.setVisibility(View.VISIBLE);
                holder.ivBluetooth.setVisibility(View.VISIBLE);
            }else {
                holder.ivPrint.setVisibility(View.GONE);
                holder.ivBluetooth.setVisibility(View.GONE);
            }
            holder.ivPrint.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    delegate.onClickItemAdapter(v);
                }
            });
            holder.ivBluetooth.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    delegate.onClickItemAdapter(v);
                }
            });
            holder.tv_title.setText(drawerItem.getItemName());
            holder.ivIcon.setBackground(drawerItem.imgResID);
        }
        return convertView;
    }
    private static class ViewHolder {
        TextView tv_title;
        ImageView ivIcon,ivPrint,ivBluetooth;
    }
}
