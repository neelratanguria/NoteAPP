package com.flameshot.noteapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import static com.flameshot.noteapp.MainActivity.notes;

public class EditNote extends Activity {

    int noteID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);

        final EditText editText = findViewById(R.id.editNote);

        Intent i = getIntent();

        noteID = i.getIntExtra("noteID", -1);

        if (noteID != -1)
        {
            String fillerText = notes.get(noteID);
            editText.setText(fillerText);
        }

        FloatingActionButton okFab = findViewById(R.id.floatingActionButton);

        okFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notes.set(noteID, editText.getText().toString());
                Log.e("onCreate: Name1: ", "WORKING");
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }



}
