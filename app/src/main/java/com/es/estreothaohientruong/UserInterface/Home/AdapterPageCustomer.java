package com.es.estreothaohientruong.UserInterface.Home;

import android.annotation.SuppressLint;
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

import com.es.estreothaohientruong.Data.Entities.ReportEntity;
import com.es.estreothaohientruong.R;
import com.es.estreothaohientruong.UserInterface.Base.AdapterDelegate;

import java.util.ArrayList;

/**
 * Created by phuon on 5/27/2016.
 */
public class AdapterPageCustomer extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater = null;
    private AdapterDelegate delegate;
    ArrayList<ReportEntity> reportEntities;

    public AdapterPageCustomer(Context mContext, ArrayList<ReportEntity> reportEntities, AdapterDelegate delegate) {
        super();
        this.context = mContext;
        this.delegate = delegate;
        this.reportEntities = reportEntities;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return reportEntities.size();
    }

    @Override
    public Object getItem(int position) {
        return reportEntities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("SetTextI18n")
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_customer, null);
            holder.btnDetail = (LinearLayout) convertView.findViewById(R.id.i_customer_btnDetail);
            holder.tvName = (TextView) convertView.findViewById(R.id.i_customer_tvName);
            holder.tvPhone = (TextView) convertView.findViewById(R.id.i_customer_tvPhone);
            holder.tvAddress = (TextView) convertView.findViewById(R.id.i_customer_tvAddress);
            holder.tvIdCustomer = (TextView) convertView.findViewById(R.id.i_customer_tvMAKH);
            holder.tvIDGCS = (TextView) convertView.findViewById(R.id.i_customer_tvGCS);
            holder.tvSTT = (TextView) convertView.findViewById(R.id.i_customer_tvSTT);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ReportEntity reportEntity = reportEntities.get(position);
        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delegate.onClickItemAdapter(v);
            }
        });
        holder.btnDetail.setTag(reportEntity);
        holder.tvName.setText(reportEntity.getTEN_KHANG());
        holder.tvPhone.setText(reportEntity.getDTHOAI());
        holder.tvAddress.setText(reportEntity.getDCHI_HDON());
        holder.tvIdCustomer.setText(reportEntity.getMA_TRAM());
        holder.tvIDGCS.setText(reportEntity.getMA_GCS_CTO());
        holder.tvSTT.setText(position + 1 +"");
        return convertView;
    }

    private class ViewHolder {
        TextView tvName, tvPhone, tvAddress, tvIdCustomer, tvIDGCS, tvSTT;
        LinearLayout btnDetail;
    }
}
