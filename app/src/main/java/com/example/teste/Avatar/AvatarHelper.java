package com.example.teste.Avatar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.teste.R;

import java.util.List;

public class AvatarHelper extends BaseAdapter
{
    public final Context context;

    public final List<AvatarPart> lsData;

    public AvatarHelper(Context context, List<AvatarPart> lsData)
    {
        this.context = context;
        this.lsData = lsData;
    }

    @Override
    public int getCount() {
        return lsData != null? lsData.size() : 0;
    }

    @Override
    public AvatarPart getItem(int position) {
        return lsData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        @SuppressLint("ViewHolder") View view = LayoutInflater.from(context).inflate(R.layout.itemrow, parent, false);

        ImageView img = view.findViewById(R.id.imagemIndividual);
        img.setImageResource((lsData.get(position)).getIcon());

        return view;
    }
}
