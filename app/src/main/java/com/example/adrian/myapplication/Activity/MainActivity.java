package com.example.adrian.myapplication.Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adrian.myapplication.Activity.Categorias;
import com.example.adrian.myapplication.DatabaseHelper;
import com.example.adrian.myapplication.R;
import com.example.adrian.myapplication.acerca;
import com.example.adrian.myapplication.instrucciones;
import com.example.adrian.myapplication.prueba;

public class MainActivity extends Activity {
    SQLiteDatabase db;
    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface face = Typeface.createFromAsset(getAssets(),"fonts/maintitle.ttf");
        TextView txt = (TextView) findViewById(R.id.title);
        txt.setTypeface(face);
        Typeface face2 = Typeface.createFromAsset(getAssets(),"fonts/main.ttf");
        Typeface face3 = Typeface.createFromAsset(getAssets(),"fonts/kids.ttf");
        TextView txtSlogan = (TextView) findViewById(R.id.txtSlogan);
        txtSlogan.setTypeface(face3);
        Button btn = (Button) findViewById(R.id.btn_jugar);
        Button btn2 = findViewById(R.id.btninst);
        Button btn3 = findViewById(R.id.btnacerca);
        btn.setTypeface(face2);
        btn2.setTypeface(face2);
        btn3.setTypeface(face2);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Categorias.class);
                startActivityForResult(intent, 0);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), instrucciones.class);
                startActivityForResult(intent, 0);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), acerca.class);
                startActivityForResult(intent, 0);
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Se borraran todos los niveles completados")
                    .setTitle("ATENCION")
                    .setCancelable(false)
                    .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            helper.eliminar(db);
                            Toast.makeText(MainActivity.this, "Se reinicio el juego", Toast.LENGTH_LONG).show();
                        }
                    })
                    .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogo1, int id) {
                            Toast.makeText(MainActivity.this, "No se reinicio el juego", Toast.LENGTH_LONG).show();

                        }
                    });


            AlertDialog alert = builder.create();
            alert.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
