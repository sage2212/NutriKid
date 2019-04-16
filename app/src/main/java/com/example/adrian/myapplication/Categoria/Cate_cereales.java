package com.example.adrian.myapplication.Categoria;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.adrian.myapplication.Activity.Categorias;
import com.example.adrian.myapplication.Cereales.Cereales_1;
import com.example.adrian.myapplication.Cereales.Cereales_2;
import com.example.adrian.myapplication.Cereales.Cereales_3;
import com.example.adrian.myapplication.Cereales.Cereales_4;
import com.example.adrian.myapplication.Cereales.Cereales_5;
import com.example.adrian.myapplication.Cereales.Cereales_6;
import com.example.adrian.myapplication.Cereales.Cereales_7;
import com.example.adrian.myapplication.Cereales.Cereales_8;
import com.example.adrian.myapplication.Cereales.Cereales_9;
import com.example.adrian.myapplication.DatabaseHelper;
import com.example.adrian.myapplication.Frutas.Frutas_1;
import com.example.adrian.myapplication.Frutas.Frutas_2;
import com.example.adrian.myapplication.Frutas.Frutas_3;
import com.example.adrian.myapplication.Frutas.Frutas_4;
import com.example.adrian.myapplication.Frutas.Frutas_5;
import com.example.adrian.myapplication.Frutas.Frutas_6;
import com.example.adrian.myapplication.Frutas.Frutas_7;
import com.example.adrian.myapplication.Frutas.Frutas_8;
import com.example.adrian.myapplication.Frutas.Frutas_9;
import com.example.adrian.myapplication.R;

public class Cate_cereales extends Activity {
    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categoria_cereales);

        //Declarar los objetos que tengo
        TextView txt = (TextView) findViewById(R.id.txtnivel);
        Button btn1 = (Button) findViewById(R.id.btn_1);
        Button btn2 = (Button) findViewById(R.id.btn_2);
        Button btn3 = (Button) findViewById(R.id.btn_3);
        Button btn4 = (Button) findViewById(R.id.btn_4);
        Button btn5 = (Button) findViewById(R.id.btn_5);
        Button btn6 = (Button) findViewById(R.id.btn_6);


        //Declarar donde usare la fuente
        Typeface face=Typeface.createFromAsset(getAssets(),"fonts/letra2.otf");
        txt.setTypeface(face);
        //Botones de niveles
        Typeface face2 = Typeface.createFromAsset(getAssets(),"fonts/letra2.otf");
        btn1.setTypeface(face2);
        Typeface face3=Typeface.createFromAsset(getAssets(),"fonts/letra2.otf");
        btn2.setTypeface(face3);
        Typeface face4=Typeface.createFromAsset(getAssets(),"fonts/letra2.otf");
        btn3.setTypeface(face4);
        Typeface face5=Typeface.createFromAsset(getAssets(),"fonts/letra2.otf");
        btn4.setTypeface(face5);
        Typeface face6=Typeface.createFromAsset(getAssets(),"fonts/letra2.otf");
        btn5.setTypeface(face6);
        Typeface face7=Typeface.createFromAsset(getAssets(),"fonts/letra2.otf");
        btn6.setTypeface(face7);





        //Mandar a llamar los niveles
        Button btn_1 = (Button) findViewById(R.id.btn_1);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Cereales_1.class);
                startActivityForResult(intent, 0);
            }
        });

        Button btn_2 = (Button) findViewById(R.id.btn_2);
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Cereales_2.class);
                startActivityForResult(intent, 0);
            }
        });

        Button btn_3 = (Button) findViewById(R.id.btn_3);
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Cereales_3.class);
                startActivityForResult(intent, 0);
            }
        });

        Button btn_4 = (Button) findViewById(R.id.btn_4);
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Cereales_4.class);
                startActivityForResult(intent, 0);
            }
        });

        Button btn_5 = (Button) findViewById(R.id.btn_5);
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Cereales_5.class);
                startActivityForResult(intent, 0);
            }
        });

        Button btn_6 = (Button) findViewById(R.id.btn_6);
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Cereales_6.class);
                startActivityForResult(intent, 0);
            }
        });


        //Regresar
        ImageButton btn_reg = (ImageButton) findViewById(R.id.imgbtn_reg);
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Categorias.class);
                startActivityForResult(intent, 0);
            }
        });

        //Ver valor de los niveles
        String nivel2 = "2";
        String tabla = "cereales";
        String completado2 = helper.searchNivel(nivel2,tabla);

        if(completado2.equals("1")){
            btn_2.setEnabled(true);
        }
        else
        {
            btn_2.setEnabled(false);
        }
        String nivel3 = "3";
        String completado3 = helper.searchNivel(nivel3,tabla);

        if(completado3.equals("1")){
            btn_3.setEnabled(true);
        }
        else
        {
            btn_3.setEnabled(false);
        }
        String nivel4 = "4";
        String completado4 = helper.searchNivel(nivel4,tabla);

        if(completado4.equals("1")){
            btn_4.setEnabled(true);
        }
        else
        {
            btn_4.setEnabled(false);
        }
        String nivel5 = "5";
        String completado5 = helper.searchNivel(nivel5,tabla);

        if(completado5.equals("1")){
            btn_5.setEnabled(true);
        }
        else
        {
            btn_5.setEnabled(false);
        }
        String nivel6 = "6";
        String completado6 = helper.searchNivel(nivel6,tabla);

        if(completado6.equals("1")){
            btn_6.setEnabled(true);
        }
        else
        {
            btn_6.setEnabled(false);
        }

    }


}
