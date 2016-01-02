package com.example.alif.mynote.utils;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alif.mynote.R;

public class CardViewActivity extends Activity {

    TextView note_title;
    TextView pemilik;
    //ImageView personPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.cardview_activity);
        note_title = (TextView)findViewById(R.id.note_title);
        pemilik = (TextView)findViewById(R.id.pemilik);
        //personPhoto = (ImageView)findViewById(R.id.person_photo);

        note_title.setText("Emma Wilson");
        pemilik.setText("23 years old");
        //personPhoto.setImageResource(R.drawable.emma);
    }
}
