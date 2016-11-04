package org.foi.androidworkshop.activities;

import org.foi.androidworkshop.R;
import org.foi.androidworkshop.fragments.MemeFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MemeActivity extends BaseActivity {

    @BindView(R.id.et_meme_input)
    EditText etMemeInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meme);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_send_meme)
    public void sendMemeClicked() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.meme_fragment);
        if (fragment instanceof MemeFragment) {
            ((MemeFragment) fragment).setTopText(etMemeInput.getText().toString());
        }
    }

}
