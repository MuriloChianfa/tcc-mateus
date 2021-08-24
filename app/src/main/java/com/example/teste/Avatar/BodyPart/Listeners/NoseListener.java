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
import com.example.teste.Avatar.BodyPart.Nose;
import com.example.teste.R;

public class NoseListener implements View.OnClickListener
{
    private final Activity context;

    public NoseListener(Activity context){
        this.context = context;
    }

    @Override
    public void onClick(View v)
    {
        AlertDialog.Builder alertDialogPincipal = new AlertDialog.Builder(context);

        View convertView = (context.getLayoutInflater()).inflate(R.layout.custompopup_mouth,null);

        alertDialogPincipal.setView(convertView );
        ListView lvPrincipal = convertView.findViewById(R.id.listaImagens);
        lvPrincipal.setAdapter(new AvatarHelper(context, Nose.All()));

        final AlertDialog show = alertDialogPincipal.show();

        lvPrincipal.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                AvatarPart avatarPart = (AvatarPart) parent.getItemAtPosition(position);

                ImageView imageN = context.findViewById(R.id.imgNeriz);
                imageN.setImageResource(avatarPart.getImage());

                show.dismiss();
            }
        });
    }
}
