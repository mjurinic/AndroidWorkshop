package org.foi.androidworkshop.activities;

import org.foi.androidworkshop.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "INFO";

    //A button added with Butterknife Lib
    @BindView(R.id.btnFragmentActivity)
    Button btnFragmentActivity;

    private Button btnListActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Log.i(TAG, "Inside onCreate()");

        btnListActivity = (Button) findViewById(R.id.btnListActivity);

        btnListActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ListActivity.class);
                startActivity(intent);
            }
        });
    }

    @OnClick(R.id.btnFragmentActivity)
    public void onBtnFragmentClicked() {
        Intent intent = new Intent(this, MemeActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i(TAG, "Inside onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i(TAG, "Inside onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i(TAG, "Inside onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i(TAG, "Inside onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i(TAG, "Inside onDestroy()");
    }
}
