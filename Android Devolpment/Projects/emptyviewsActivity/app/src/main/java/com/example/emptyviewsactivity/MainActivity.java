package com.example.emptyviewsactivity;

import static com.example.emptyviewsactivity.R.*;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  //  Button m_but;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
      //  m_but = findViewById (R.id.button);
      //  m_but.setOnClickListener (this);
        super.onCreate (savedInstanceState);
        EdgeToEdge.enable (this);
        setContentView (R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener (findViewById (R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets (WindowInsetsCompat.Type.systemBars ());
            v.setPadding (systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick (final View v) {

      //  m_but = findViewById (R.id.button);

      //  if (R.id.button == v.getId ()) {
       //     Toast.makeText (this, "Im Here", Toast.LENGTH_SHORT).show ();
       // }


//        switch (v.getId ()) {
//            //  case R.id.button:{
//            case 12: {
//                Toast.makeText (this, "Im Here", Toast.LENGTH_SHORT).show ();
//
//            }
//            break;
//            default:
//                throw new IllegalStateException ("Unexpected value: " + v.getId ());
//        }
//
    }
}





















