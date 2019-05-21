package com.example.adrian.myapplication;

import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

import org.w3c.dom.Text;

public class instrucciones extends Activity {
    TextView txtcate,txtnivel,txtganar,txttitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrucciones);

        txtcate = (TextView)findViewById(R.id.txtcate);
        txtnivel = (TextView)findViewById(R.id.txtniveles);
        txtganar = (TextView)findViewById(R.id.txtganar);
        txttitulo = findViewById(R.id.txttitle);

        Typeface face = Typeface.createFromAsset(getAssets(),"fonts/kids.ttf");
        Typeface face2 = Typeface.createFromAsset(getAssets(),"fonts/main.ttf");

        txtcate.setTypeface(face);
        txtnivel.setTypeface(face);
        txtganar.setTypeface(face);
        txttitulo.setTypeface(face2);

    }

}
