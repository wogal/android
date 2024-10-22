


// gogle aps API == AIzaSyAQENwaxsuYJ6iMtKBUgiqLrxTnCF7TLBA


package com.example.javafragments;

import android.view.WindowManager;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity implements MainActivityk {


    @Override
    public void onCreate() {

        getWindow ().addFlags (WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        EdgeToEdge.enable (this);
        setContentView (R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener (findViewById (R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets (WindowInsetsCompat.Type.systemBars ());
            v.setPadding (systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btFragMap = findViewById (R.id.butn_frag_map);
        btFragMap.setOnClickListener (v -> {
            FragmentManager fragmentManager = getSupportFragmentManager ();
            fragmentManager.beginTransaction ().replace (R.id.fragment_container, MapFragment.class, null).setReorderingAllowed (true).addToBackStack ("name") // Name can be null
                    .commit ();
        });

        Button btFragWifi = findViewById (R.id.butn_frag_wifi);
        btFragWifi.setOnClickListener (v -> {
            FragmentManager fragmentManager = getSupportFragmentManager ();
            fragmentManager.beginTransaction ().replace (R.id.fragment_container, WifiFragment.class, null).setReorderingAllowed (true).addToBackStack ("name") // Name can be null
                    .commit ();
        });
    }
}