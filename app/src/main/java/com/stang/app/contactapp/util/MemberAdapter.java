package com.stang.app.contactapp.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.stang.app.contactapp.R;
import com.stang.app.contactapp.domain.MemberBean;

import java.util.ArrayList;

/**
 * Created by hb2012 on 2017-02-18.
 */
public class MemberAdapter extends BaseAdapter{
    ArrayList<MemberBean> memberList;
    LayoutInflater inflater;
    private int[] photos = {
            R.drawable.cupcake,
            R.drawable.donut,
            R.drawable.eclair,
            R.drawable.froyo,
            R.drawable.gingerbread,
            R.drawable.honeycomb,
            R.drawable.icecream,
            R.drawable.jellybean,
            R.drawable.kitkat,
            R.drawable.lollipop
    };
    public MemberAdapter(ArrayList<MemberBean> list, Context context) {
        this.memberList = list;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return memberList.size();
    }

    @Override
    public Object getItem(int i) {
        return memberList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View v, ViewGroup g) {
        ViewHolder holder;
        if(v==null){
            v = inflater.inflate(R.layout.adapter_memberlist, null);
            holder = new ViewHolder();
            holder.ivProfile = (ImageView) v.findViewById(R.id.ivProfile);
            holder.tvName = (TextView) v.findViewById(R.id.tvName);
            holder.tvPhone = (TextView) v.findViewById(R.id.tvPhone);
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }
        holder.ivProfile.setImageResource(photos[i]);
        holder.tvName.setText(memberList.get(i).getName());
        holder.tvPhone.setText(memberList.get(i).getPhone());
        return v;
    }

    static class ViewHolder {
        ImageView ivProfile;
        TextView tvName, tvPhone;
    }
}