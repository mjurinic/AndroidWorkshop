package org.foi.androidworkshop.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.foi.androidworkshop.R;

public class MainActivity extends AppCompatActivity {

    private static final String INFO = "INFO";

    private Button btnListActivity;
    private Button btnFragmentActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(INFO, "Inside onCreate()");

        btnListActivity = (Button) findViewById(R.id.btnListActivity);
        btnFragmentActivity = (Button) findViewById(R.id.btnFragmentActivity);

        btnListActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ListActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i(INFO, "Inside onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i(INFO, "Inside onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i(INFO, "Inside onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i(INFO, "Inside onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i(INFO, "Inside onDestroy()");
    }
}
