


package com.example.andjava;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button butt_txt;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        EdgeToEdge.enable (this);
        setContentView (R.layout.activity_main);
        butt_txt = findViewById (R.id.butt_ent_text);

        butt_txt.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View v) {
                Toast.makeText (MainActivity.this, "Button Clicked", Toast.LENGTH_SHORT).show ();
            }
        });

        setText sstr = new setText (5);
        //  sstr.


    }
}