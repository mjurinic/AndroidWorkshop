package org.foi.androidworkshop.activities;

import org.foi.androidworkshop.R;
import org.foi.androidworkshop.fragments.MemeFragment;
import org.foi.androidworkshop.listeners.FragmentActionListener;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MemeActivity extends BaseActivity implements FragmentActionListener {

    @BindView(R.id.et_meme_input)
    EditText etMemeInput;

    @BindView(R.id.meme_container)
    LinearLayout memeContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meme);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @OnClick(R.id.btn_send_meme)
    public void sendMemeClicked() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.meme_fragment);

        if (fragment instanceof MemeFragment) {
            ((MemeFragment) fragment).setTopText(etMemeInput.getText().toString());
        }

        //Remove focus from edit text because Android is cancer
        memeContainer.requestFocus();

        //Remove keyboard manually once the user is done typing
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(etMemeInput.getWindowToken(), 0);
    }

    @Override
    public void textSuccessfullySet() {
        Toast.makeText(this, "Successfully set text", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
