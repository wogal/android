


package com.example.javaapp;

import static com.example.javaapp.R.*;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button m_but_1;
    Button m_but_2;
    Button m_but_3;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        EdgeToEdge.enable (this);
        setContentView (layout.activity_main);
        m_but_1 = findViewById (id.button1);
        m_but_2 = findViewById (id.button2);
        m_but_3 = findViewById (id.button3);

        m_but_1.setOnClickListener (this);
        m_but_2.setOnClickListener (this);
        m_but_3.setOnClickListener (this);
    }


    /**
     * @param v The view that was clicked.
     */
    @Override
    public void onClick (@NonNull final View v) {
        int id;
        id = v.getId ();
        if (id == R.id.button1) {
            Toast.makeText (this, "Action = m_but_1", Toast.LENGTH_SHORT).show ();
        } else if (id == R.id.button2) {
            Toast.makeText (this, "Action = m_but_2", Toast.LENGTH_SHORT).show ();
        } else if (id == R.id.button3) {
            Toast.makeText (this, "Action = m_but_3", Toast.LENGTH_SHORT).show ();
        }
    }
}









