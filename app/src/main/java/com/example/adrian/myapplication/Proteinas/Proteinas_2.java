package com.example.adrian.myapplication.Proteinas;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Activity;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adrian.myapplication.Actividad.Actividad_1;
import com.example.adrian.myapplication.Actividad.Actividad_2;
import com.example.adrian.myapplication.Categoria.Cate_frutas;
import com.example.adrian.myapplication.Categoria.Cate_proteinas;
import com.example.adrian.myapplication.DataCategoria;
import com.example.adrian.myapplication.DatabaseHelper;
import com.example.adrian.myapplication.R;

import java.util.ArrayList;

public class Proteinas_2 extends Activity {
    private EditText Nombre;
    TextView grabar;
    DatabaseHelper helper = new DatabaseHelper(this);
    private static final int RECOGNIZE_SPEECH_ACTIVITY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.proteinas_nivel_2);

        Nombre = (EditText) findViewById(R.id.txtNombre);
        TextView txt1 = (TextView) findViewById(R.id.textView1);
        TextView txt2 = (TextView) findViewById(R.id.textView2);
        grabar = (TextView) findViewById(R.id.txtNombre);

        //Declarar que objetos tendran las fuente
        Typeface face = Typeface.createFromAsset(getAssets(),"fonts/texto.ttf");
        txt1.setTypeface(face);
        txt2.setTypeface(face);
        ImageButton btn = (ImageButton) findViewById(R.id.imgbtn_reg);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Cate_proteinas.class);
                startActivityForResult(intent, 0);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case RECOGNIZE_SPEECH_ACTIVITY:

                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> speech = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String strSpeech2Text = speech.get(0);

                    grabar.setText(strSpeech2Text);

                } if(Nombre.getText().toString().isEmpty()){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("El campo esta vacio")
                        .setTitle("Oh! Algo anda mal")
                        .setIcon(R.drawable.icono)
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
                if(Nombre.getText().toString().equals("yogurt")||(Nombre.getText().toString().equals("YOGURT"))||(Nombre.getText().toString().equals("Yogurt"))){
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("Pasaste al siguiente nivel")
                            .setTitle("Felicidades")
                            .setIcon(R.drawable.sonrisa)
                            .setCancelable(false)
                            .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    DataCategoria p = new DataCategoria();
                                    p.setNivel("3");
                                    p.setValor("1");

                                    helper.insertProteinas(p);

                                    Intent intent1 = new Intent(Proteinas_2.this,Proteinas_3.class);
                                    startActivity(intent1); //*corregido
                                    //  startActivity(intent2);
                                    Toast.makeText(Proteinas_2.this, "Nivel 3", Toast.LENGTH_LONG).show();
                                }
                            });


                    AlertDialog alert = builder.create();
                    alert.show();

                }
                else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("Palabra incorrecta")
                            .setTitle("Oh! Algo anda mal")
                            .setIcon(R.drawable.icono)
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

                break;

            default:

                break;
        }
    }

    public void onClickImgBtnHablar(View v) {

        Intent intentActionRecognizeSpeech = new Intent(
                RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

        // Configura el Lenguaje (Español-México)
        intentActionRecognizeSpeech.putExtra(
                RecognizerIntent.EXTRA_LANGUAGE_MODEL, "es-MX");
        try {
            startActivityForResult(intentActionRecognizeSpeech,
                    RECOGNIZE_SPEECH_ACTIVITY);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    "Tú dispositivo no soporta el reconocimiento por voz",
                    Toast.LENGTH_SHORT).show();
        }

    }
    public void Enviar(View v){
        if(Nombre.getText().toString().isEmpty()){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("El campo esta vacio")
                    .setTitle("Oh! Algo anda mal")
                    .setIcon(R.drawable.icono)
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
            if(Nombre.getText().toString().equals("yogurt")||(Nombre.getText().toString().equals("YOGURT"))||(Nombre.getText().toString().equals("Yogurt"))){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Pasaste al siguiente nivel")
                        .setTitle("Felicidades")
                        .setIcon(R.drawable.sonrisa)
                        .setCancelable(false)
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                DataCategoria p = new DataCategoria();
                                p.setNivel("3");
                                p.setValor("1");

                                helper.insertProteinas(p);

                                Intent intent1 = new Intent(Proteinas_2.this,Proteinas_3.class);
                                startActivity(intent1); //*corregido
                                //  startActivity(intent2);
                                Toast.makeText(Proteinas_2.this, "Nivel 3", Toast.LENGTH_LONG).show();
                            }
                        });


                AlertDialog alert = builder.create();
                alert.show();

            }
            else{
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Palabra incorrecta")
                        .setTitle("Oh! Algo anda mal")
                        .setIcon(R.drawable.icono)
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
        builder.setMessage("Empieza con Yog\nSi no puedes pide ayuda a un adulto!\n")
                .setTitle("Ayuda")
                .setIcon(R.drawable.pregunta)
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

