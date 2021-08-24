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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.teste.compartilhar.EnviarActivity;
import com.example.teste.partes.BotaoBocaListener;
import com.example.teste.partes.BotaoCabeloListener;
import com.example.teste.partes.BotaoNarizListener;
import com.example.teste.partes.BotaoOlhosListener;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ParteAvatar> lstData;
    Context context = this;
    private ListView listView;

    private ImageView imageView;
    private Bitmap btmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.screenShot);

        Button btEnviar = findViewById( R.id.botaoEnviar );
        btEnviar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap b = Screenshot.takescreenshotOfRootView( imageView );
                btmap = scaleDownBitmap( b, 100, MainActivity.this );
                imageView.setImageBitmap( btmap );

                Intent intentEnviar = new Intent( MainActivity.this, EnviarActivity.class );
                intentEnviar.putExtra( "BitmapImage", btmap );
                startActivity( intentEnviar );
            }
        } );

        // Escolher o avatar inicial
        final AlertDialog.Builder alert = new AlertDialog.Builder( MainActivity.this );
        LayoutInflater inflater = getLayoutInflater();
        View convertView = (View) inflater.inflate( R.layout.custompopup_mouth,null );
        alert.setView( convertView );
        final ListView lv = (ListView) convertView.findViewById( R.id.listaImagens );
        lv.setAdapter( new ParteAvatarAdapter( MainActivity.this, ParteAvatar.getAvatarIcones() ) );
        final AlertDialog show = alert.show();
        lv.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView image = findViewById(R.id.avatar);
                switch (position){
                    case 0:
                        image.setImageResource( R.drawable.cabeca_1 );
                        show.dismiss();
                        break;
                    case 1:
                        image.setImageResource( R.drawable.cabeca_2 );
                        show.dismiss();
                        break;
                    case 2:
                        image.setImageResource( R.drawable.cabeca_3 );
                        show.dismiss();
                        break;
                }
            }
        } );

        //Botão Boca
        Button btBoca = findViewById(R.id.botaoBoca);
        btBoca.setOnClickListener(new BotaoBocaListener(this));

        //Botão Cabelo
        Button btCabelo = findViewById( R.id.botaoCabelo );
        btCabelo.setOnClickListener(new BotaoCabeloListener(this));

        //Botão Olhos
        final Button btOlhos = findViewById( R.id.botaoOlhos );
        btOlhos.setOnClickListener(new BotaoOlhosListener(this));

        //Botão Nariz
        Button btNariz = findViewById( R.id.botaoNariz );
        btNariz.setOnClickListener(new BotaoNarizListener(this));
    }

    public static class Screenshot {
        public static Bitmap takescreenshot (View v){
            v.setDrawingCacheEnabled( true );
            v.buildDrawingCache(true);
            Bitmap b = Bitmap.createBitmap( v.getDrawingCache() );
            v.setDrawingCacheEnabled( false );
            return b;
        }

        public static Bitmap takescreenshotOfRootView(View v){
            return takescreenshot( v.getRootView() );
        }
    }

    public static Bitmap scaleDownBitmap(Bitmap photo, int newHeight, Context context) {
        final float densityMultiplier = context.getResources().getDisplayMetrics().density;
        int h= (int) (newHeight*densityMultiplier);
        int w= (int) (h * photo.getWidth()/((double) photo.getHeight()));
        photo=Bitmap.createScaledBitmap(photo, w, h, true);
        return photo;
    }
}