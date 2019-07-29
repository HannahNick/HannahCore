package com.app.hannahcore.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.app.hannahcore.R;
import com.app.hannahcore.bean.ContactBean;

import java.util.List;


/**
 * Created by Nick on 2017/8/8.
 */
public class ContactAdapter extends BaseAdapter implements SectionIndexer {
    private List<ContactBean> mData;
    private Context mContext;

    public ContactAdapter(Context context, List<ContactBean> data) {
        this.mContext = context;
        this.mData = data;
    }


    public int getCount() {
        return this.mData.size();
    }

    public Object getItem(int position) {
        return mData.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        ContactBean sortModel = mData.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_contact, parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //根据position获取分类的首字母的Char ascii值
        int section = getSectionForPosition(position);

        //如果当前位置等于该分类首字母的Char的位置 ，则认为是第一次出现
        if(position == getPositionForSection(section)||position==0){
            viewHolder.tv_catalog.setVisibility(View.VISIBLE);
            viewHolder.tv_catalog.setText(sortModel.getSortLetters());
        }else{
            viewHolder.tv_catalog.setVisibility(View.GONE);
        }

        viewHolder.tv_name.setText(sortModel.getName());
        viewHolder.tv_phone.setText(sortModel.getPhone());
        return convertView;

    }

    /**
     * 根据ListView的当前位置获取分类的首字母的Char ascii值
     */
    @Override
    public int getSectionForPosition(int position) {
        return mData.get(position).getSortLetters().charAt(0);
    }
    /**
     * 根据分类的首字母的Char ascii值获取其第一次出现该首字母的位置
     */
    @Override
    public int getPositionForSection(int section) {
        for (int i = 0; i < getCount(); i++) {
            String sortStr = mData.get(i).getSortLetters();
            char firstChar = sortStr.toUpperCase().charAt(0);
            if (firstChar == section) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Object[] getSections() {
        return null;
    }

    static class ViewHolder {
        TextView tv_phone;
        TextView tv_catalog;
        TextView tv_name;

        private ViewHolder(View convertView){
            tv_name =  convertView.findViewById(R.id.tv_name);
            tv_catalog =  convertView.findViewById(R.id.tv_catalog);
            tv_phone =  convertView.findViewById(R.id.tv_phone);
        }
    }
}
