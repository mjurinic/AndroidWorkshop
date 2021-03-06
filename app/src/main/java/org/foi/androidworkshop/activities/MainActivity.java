package org.foi.androidworkshop.activities;

import org.foi.androidworkshop.R;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    private static final String TAG = "INFO";

    public static final String EXTRA_NAME = "EXTRA_NAME";

    @BindView(R.id.btn_fragment_activity)
    Button btnFragmentActivity;

    private Button btnListActivity;
    private Button btnRetrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Log.i(TAG, "Inside onCreate() of MainActivity");

        btnListActivity = (Button) findViewById(R.id.btn_list_activity);
        btnRetrofit = (Button) findViewById(R.id.btn_retrofit);

        btnListActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ListActivity.class);
                startActivity(intent);
            }
        });

        btnRetrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), RetrofitActivity.class));
            }
        });
    }

    @OnClick(R.id.btn_fragment_activity)
    public void onBtnFragmentClicked() {
        //Long way - used when passing some params to the child activity
        Intent intent = new Intent(this, MemeActivity.class);
        intent.putExtra(EXTRA_NAME, "Stefano");
        startActivity(intent);

        //Short way - when no params are needed
        //startActivity(new Intent(this, MemeActivity.class));
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i(TAG, "Inside onStart() of MainActivity");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i(TAG, "Inside onResume() of MainActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i(TAG, "Inside onPause() of MainActivity");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i(TAG, "Inside onStop() of MainActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i(TAG, "Inside onDestroy() of MainActivity");
    }
}
