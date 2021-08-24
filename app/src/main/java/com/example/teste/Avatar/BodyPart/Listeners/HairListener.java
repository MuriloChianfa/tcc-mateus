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
import com.example.teste.Avatar.BodyPart.Hair;
import com.example.teste.R;

import java.util.List;

public class HairListener implements View.OnClickListener
{
    private final Activity context;

    public HairListener(Activity context)
    {
        this.context = context;
    }

    @Override
    public void onClick(View v)
    {
        AlertDialog.Builder alertDialogPincipal = new AlertDialog.Builder(context);

        View convertView = (context.getLayoutInflater()).inflate(R.layout.custompopup_mouth, null);
        alertDialogPincipal.setView( convertView );

        ListView lvPrincipal = convertView.findViewById(R.id.listaImagens);
        lvPrincipal.setAdapter(new AvatarHelper(context, Hair.All()));

        final AlertDialog show = alertDialogPincipal.show();

        lvPrincipal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                switch (position) {
                    case 0: mostrarSubOpcoes(Hair.Type1()); break;
                    case 1: mostrarSubOpcoes(Hair.Type2()); break;
                    case 2: mostrarSubOpcoes(Hair.Type3()); break;
                    case 3: mostrarSubOpcoes(Hair.Type4()); break;
                    case 4: mostrarSubOpcoes(Hair.Type5()); break;
                }

                show.dismiss();
            }
        });
    }

    private void mostrarSubOpcoes(List<AvatarPart> opcoes)
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        View view = (context.getLayoutInflater()).inflate(R.layout.custompopup_mouth, null);

        alertDialogBuilder.setView(view);
        ListView layoutOpcoes = view.findViewById(R.id.listaImagens);
        layoutOpcoes.setAdapter(new AvatarHelper(context, opcoes));

        final AlertDialog alertDialog = alertDialogBuilder.show();
        final ImageView imageViewCabelo = context.findViewById(R.id.imgCabelo);
        layoutOpcoes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                AvatarPart avatarPart = (AvatarPart) parent.getItemAtPosition(position);

                imageViewCabelo.setImageResource(avatarPart.getImage());

                alertDialog.dismiss();
            }
        });
    }
}
