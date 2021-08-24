package com.example.teste.Avatar.BodyPart.Listeners;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.teste.Avatar.AvatarHelper;
import com.example.teste.Avatar.AvatarPart;
import com.example.teste.Avatar.BodyPart.Mouth;
import com.example.teste.R;

public class MouthListener implements View.OnClickListener
{
    private final Activity context;

    public MouthListener(Activity context)
    {
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);

        View convertView = (context.getLayoutInflater()).inflate(R.layout.custompopup_mouth,null);
        alertDialog.setView(convertView);

        final ListView lv = convertView.findViewById( R.id.listaImagens );
        lv.setAdapter(new AvatarHelper(context, Mouth.All()));

        final AlertDialog show = alertDialog.show();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AvatarPart avatarPart = (AvatarPart) parent.getItemAtPosition(position);
                ImageView image = context.findViewById(R.id.imgBoca);
                image.setImageResource(avatarPart.getImage());

                show.dismiss();
            }
        });
    }
}
