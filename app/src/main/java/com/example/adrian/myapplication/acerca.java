package com.example.adrian.myapplication;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.adrian.myapplication.Activity.Categorias;
import com.example.adrian.myapplication.Activity.MainActivity;

public class acerca extends Activity {
    Button back;
    TextView textView8,textView10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca);
        back = (Button)findViewById(R.id.btnback);
        textView8 = (TextView)findViewById(R.id.textView8);
        textView10 = (TextView)findViewById(R.id.textView10);

        Typeface face = Typeface.createFromAsset(getAssets(),"fonts/kids.ttf");
        textView8.setTypeface(face);
        textView10.setTypeface(face);


    }

}
