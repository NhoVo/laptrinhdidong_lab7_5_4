package com.example.laptrinhdidong_lab7_4_5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends BaseAdapter {
    private Context context;
    private int idlayout;
    private List<item> listItem;

    public ItemAdapter(Context context, int idlayout, List<item> listItem) {
        this.context = context;
        this.idlayout = idlayout;
        this.listItem = listItem;
    }

    @Override
    public int getCount() {
        if (listItem.size() != 0 && !listItem.isEmpty()) {
            return listItem.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(idlayout, viewGroup, false);
        }
            TextView tvName = view.findViewById(R.id.tvName);
            final item Item = listItem.get(i);
            if (listItem != null && !listItem.isEmpty()) {
                tvName.setText(Item.getPutname());
            }
            return view;
        }

}
