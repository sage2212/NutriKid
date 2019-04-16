package com.example.adrian.myapplication.Cereales;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adrian.myapplication.Actividad.Actividad_1;
import com.example.adrian.myapplication.Categoria.Cate_cereales;
import com.example.adrian.myapplication.Categoria.Cate_frutas;
import com.example.adrian.myapplication.R;

public class Cereales_9 extends Activity {
    private EditText Nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cereales_nivel_9);

        Nombre = (EditText) findViewById(R.id.txtNombre);
        TextView txt1 = (TextView) findViewById(R.id.textView1);
        TextView txt2 = (TextView) findViewById(R.id.textView2);
        TextView txt3 = (TextView) findViewById(R.id.textView3);
        TextView txt4 = (TextView) findViewById(R.id.textView4);


        //Declarar que objetos tendran las fuente
        Typeface face = Typeface.createFromAsset(getAssets(),"fonts/texto.ttf");
        txt1.setTypeface(face);
        txt2.setTypeface(face);
        txt3.setTypeface(face);
        txt4.setTypeface(face);
        ImageButton btn = (ImageButton) findViewById(R.id.imgbtn_reg);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Cate_cereales.class);
                startActivityForResult(intent, 0);
            }
        });

    }

    public void Enviar(View v){
        if(Nombre.getText().toString().isEmpty()){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("El campo esta vacio")
                    .setTitle("Oh! Algo anda mal")
                    .setCancelable(false)
                    .setNeutralButton("Aceptar",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();
        }else {
            if(Nombre.getText().toString().equals("platano")||(Nombre.getText().toString().equals("PLATANO"))||(Nombre.getText().toString().equals("Platano"))){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Pasaste a la siguiente categoria Actividad fisica")
                        .setTitle("Felicidades")
                        .setCancelable(false)
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                Intent intent1 = new Intent(Cereales_9.this,Actividad_1.class);
                                startActivity(intent1); //*corregido
                                //  startActivity(intent2);
                                Toast.makeText(Cereales_9.this, "Feliciades Pasaste a la cateogria Actividad fisica", Toast.LENGTH_LONG).show();
                            }
                        });


                AlertDialog alert = builder.create();
                alert.show();

            }
            else{
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Palabra incorrecta")
                        .setTitle("Oh! Algo anda mal")
                        .setCancelable(false)
                        .setNeutralButton("Aceptar",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();

            }
        }
    }

    public void PopUp(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Empieza con la letra P")
                .setTitle("Ayuda")
                .setCancelable(false)
                .setNeutralButton("Aceptar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
