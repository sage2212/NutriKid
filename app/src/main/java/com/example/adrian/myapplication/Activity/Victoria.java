package com.example.adrian.myapplication.Activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.adrian.myapplication.R;

public class Victoria extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_victoria);
        Button btn_1 = (Button) findViewById(R.id.button);
        TextView txt1 = (TextView) findViewById(R.id.textView1);
        TextView txt2 = (TextView) findViewById(R.id.textView2);
        TextView txt3 = (TextView) findViewById(R.id.textView3);
        TextView txt4 = (TextView) findViewById(R.id.textView4);
        TextView txt5 = (TextView) findViewById(R.id.textView5);
        TextView txt6 = (TextView) findViewById(R.id.textView6);


        Typeface face = Typeface.createFromAsset(getAssets(),"fonts/splatch.ttf");
        txt1.setTypeface(face);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MainActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }

}
