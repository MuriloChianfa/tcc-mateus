package com.example.teste.Avatar.BodyPart.Listeners;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.teste.Avatar.AvatarHelper;
import com.example.teste.Avatar.AvatarPart;
import com.example.teste.Avatar.BodyPart.Eye;
import com.example.teste.R;

import java.util.List;

public class EyeListener implements View.OnClickListener
{
    private final Activity context;

    public EyeListener(Activity context)
    {
        this.context = context;
    }

    @Override
    public void onClick(View v)
    {
        AlertDialog.Builder alertDialogPincipal = new AlertDialog.Builder(context);

        View convertView = (context.getLayoutInflater()).inflate(R.layout.custompopup_mouth,null);

        alertDialogPincipal.setView( convertView );
        ListView lvPrincipal = convertView.findViewById(R.id.listaImagens);
        lvPrincipal.setAdapter(new AvatarHelper(context, Eye.All()));

        final AlertDialog show = alertDialogPincipal.show();

        lvPrincipal.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                ImageView imagePrincipal = context.findViewById(R.id.imgOlhos);

                switch (position) {
                    case 0: mostrarSubOpcoes(Eye.Type1()); break;
                    case 1: imagePrincipal.setImageResource(R.drawable.olhos_2); break;
                    case 2: mostrarSubOpcoes(Eye.Type2()); break;
                    case 3: mostrarSubOpcoes(Eye.Type3()); break;
                    case 4: mostrarSubOpcoes(Eye.Type4()); break;
                    case 5: mostrarSubOpcoes(Eye.Type5()); break;
                }

                show.dismiss();
            }
        } );
    }

    private void mostrarSubOpcoes(List<AvatarPart> opcoes)
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        View view = (context.getLayoutInflater()).inflate(R.layout.custompopup_mouth, null);

        alertDialogBuilder.setView(view);
        ListView layoutOpcoes = view.findViewById(R.id.listaImagens );
        layoutOpcoes.setAdapter(new AvatarHelper(context, opcoes));

        final AlertDialog alertDialog = alertDialogBuilder.show();
        final ImageView imageViewOlhos = context.findViewById(R.id.imgOlhos);

        layoutOpcoes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                AvatarPart avatarPart = (AvatarPart) parent.getItemAtPosition(position);

                imageViewOlhos.setImageResource(avatarPart.getImage());

                alertDialog.dismiss();
            }
        });
    }
}
