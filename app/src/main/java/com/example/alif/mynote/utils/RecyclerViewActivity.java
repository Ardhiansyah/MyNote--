package com.example.alif.mynote.utils;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.alif.mynote.R;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends Activity {

    private List<Note> note;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.recyclerview_activity);

        Firebase ref = new Firebase("https://intense-inferno-4289.firebaseio.com/note");
        // Attach an listener to read the data at our posts reference
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                long count = snapshot.getChildrenCount();
                Log.d("ini", String.valueOf(count));
//                System.out.println("There are " + snapshot.getChildrenCount() + " blog posts");
//                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
////                    BlogPost post = postSnapshot.getValue(BlogPost.class);
////                    System.out.println(post.getAuthor() + " - " + post.getTitle());
//                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });

        rv=(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

    private void initializeData(){
        note = new ArrayList<>();
        note.add(new Note("Kelas mobile", "Zola"));
        note.add(new Note("Kelas PPL", "Metana"));
        note.add(new Note("Kelas jarmul", "Alif"));
    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(note);
        rv.setAdapter(adapter);
    }
}
