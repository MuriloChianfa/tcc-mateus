package com.example.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;

import android.content.Context;
import android.content.Intent;

import android.graphics.Bitmap;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.teste.Avatar.AvatarHelper;

import com.example.teste.Avatar.BodyPart.Head;

import com.example.teste.Core.Screenshot;
import com.example.teste.Avatar.BodyPart.Listeners.MouthListener;
import com.example.teste.Avatar.BodyPart.Listeners.HairListener;
import com.example.teste.Avatar.BodyPart.Listeners.NoseListener;
import com.example.teste.Avatar.BodyPart.Listeners.EyeListener;

public class MainActivity extends AppCompatActivity
{
    private ImageView imageView;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.screenShot);

        (findViewById(R.id.botaoEnviar)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                bitmap = scaleDownBitmap(Screenshot.takeOfRootView(imageView), 100, MainActivity.this);

                imageView.setImageBitmap(bitmap);

                Intent intentEnviar = new Intent(MainActivity.this, ShaveActivity.class);
                intentEnviar.putExtra("BitmapImage", bitmap);
                startActivity(intentEnviar);
            }
        });

        // Escolher o avatar inicial
        final AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);

        LayoutInflater inflater = getLayoutInflater();
        View convertView = (View) inflater.inflate(R.layout.custompopup_mouth,null);
        alert.setView( convertView );

        final ListView lv = (ListView) convertView.findViewById( R.id.listaImagens);
        lv.setAdapter(new AvatarHelper(MainActivity.this, Head.All()));

        final AlertDialog show = alert.show();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                ImageView image = findViewById(R.id.avatar);

                switch (position) {
                    case 0: image.setImageResource(R.drawable.cabeca_1); show.dismiss(); break;
                    case 1: image.setImageResource(R.drawable.cabeca_2); show.dismiss(); break;
                    case 2: image.setImageResource(R.drawable.cabeca_3); show.dismiss(); break;
                }
            }
        });

        (findViewById(R.id.botaoBoca)).setOnClickListener(new MouthListener(this));
        (findViewById(R.id.botaoCabelo)).setOnClickListener(new HairListener(this));
        (findViewById(R.id.botaoOlhos)).setOnClickListener(new EyeListener(this));
        (findViewById(R.id.botaoNariz)).setOnClickListener(new NoseListener(this));
    }

    public static Bitmap scaleDownBitmap(Bitmap photo, int newHeight, Context context)
    {
        int h = (int) (newHeight * context.getResources().getDisplayMetrics().density);
        int w = (int) (h * photo.getWidth() / ((double) photo.getHeight()));

        return Bitmap.createScaledBitmap(photo, w, h, true);
    }
}
