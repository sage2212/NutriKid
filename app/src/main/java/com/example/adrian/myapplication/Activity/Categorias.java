package com.example.adrian.myapplication.Activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.adrian.myapplication.Categoria.Cate_actividad;
import com.example.adrian.myapplication.Categoria.Cate_cereales;
import com.example.adrian.myapplication.Categoria.Cate_frutas;
import com.example.adrian.myapplication.Categoria.Cate_leguminosas;
import com.example.adrian.myapplication.Categoria.Cate_proteinas;
import com.example.adrian.myapplication.Categoria.Cate_vegetales;
import com.example.adrian.myapplication.R;

public class Categorias extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);

        //Declarar objetos que tengo en Activity categorias
        Button btn_1 = (Button) findViewById(R.id.btn_frutas);
        Button btn_2 = (Button) findViewById(R.id.btn_vege);
        Button btn_3 = (Button) findViewById(R.id.btn_prote);
        Button btn_4 = (Button) findViewById(R.id.btn_legu);
        Button btn_5 = (Button) findViewById(R.id.btn_cere);
        Button btn_6 = (Button) findViewById(R.id.btn_acti);
        TextView txt = (TextView) findViewById(R.id.txttitulo);

        //Declarar que objetos tendran las fuente
        Typeface face = Typeface.createFromAsset(getAssets(),"fonts/letra.ttf");
        txt.setTypeface(face);

        //Llamar las categorias
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Cate_frutas.class);
                startActivityForResult(intent, 0);
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Cate_vegetales.class);
                startActivityForResult(intent, 0);
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Cate_proteinas.class);
                startActivityForResult(intent, 0);
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Cate_leguminosas.class);
                startActivityForResult(intent, 0);
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Cate_cereales.class);
                startActivityForResult(intent, 0);
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Cate_actividad.class);
                startActivityForResult(intent, 0);
            }
        });


        //Boton regresar
        ImageButton btn1 = (ImageButton) findViewById(R.id.imbtn_reg);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MainActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }

}
