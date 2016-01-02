package com.example.alif.mynote;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.alif.mynote.utils.Constants;
import com.firebase.client.Firebase;

import java.io.ByteArrayOutputStream;


public class MainActivity extends ActionBarActivity {

    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Firebase.setAndroidContext(this);
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

        //iv= (ImageView)findViewById(R.id.my_image);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.logo);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bmp.compress(Bitmap.CompressFormat.PNG, 100, baos);
                bmp.recycle();
                byte[] byteArray = baos.toByteArray();
                String image = Base64.encodeToString(byteArray, Base64.DEFAULT);

                Firebase ref = new Firebase(Constants.FIREBASE_URL + "username");
                Firebase alifa = ref.child("alifa");
                alifa.child("password").setValue(image);

                byte[] imageAsBytes = Base64.decode(image, Base64.DEFAULT);
                Bitmap test = BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length);
                Drawable icon = new BitmapDrawable(test);
                iv.setImageDrawable(icon);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
