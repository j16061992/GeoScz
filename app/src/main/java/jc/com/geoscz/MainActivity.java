package jc.com.geoscz;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import jc.com.geoscz.fragments.MainFragment;
import jc.com.geoscz.fragments.MapFragment;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    ImageButton uno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uno = (ImageButton) findViewById(R.id.uno);
        uno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(IUMAIN_MAP);
            }
        });
    }

    public static final int IUMAIN_UNO = 1;
    public static final int IUMAIN_MAP = 2;

    public void replaceFragment(int typeOfFragment) {
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.fragment);
        frameLayout.setVisibility(View.VISIBLE);
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch (typeOfFragment) {
            case IUMAIN_UNO:
                MainFragment mainFragment = new MainFragment();
                fragmentTransaction.replace(R.id.fragment, mainFragment);
//                PRINCIPAL = IUMAIN_HOME;
                break;
            case IUMAIN_MAP:
                MapFragment mapFragment= new MapFragment();
                fragmentTransaction.replace(R.id.fragment, mapFragment);
//                PRINCIPAL = IUMAIN_HOME;
                break;

        }
        fragmentTransaction.commit();
    }
}
