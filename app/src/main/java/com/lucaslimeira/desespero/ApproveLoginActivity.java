package com.lucaslimeira.desespero;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ApproveLoginActivity extends Activity {

    private TextView username_pwd_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approve_login);

        this.username_pwd_txt = findViewById(R.id.username_pwd_txt);

        Intent intent = getIntent();
        Bundle params = intent.getExtras();

        String username = params.getString("username");
        String password = params.getString("password");

        this.username_pwd_txt.setText(username + " : " + password);
    }

    public void revokeLogin(View view) {
        this.finishActivity(false);
    }

    public void approveLogin(View view) {
        this.finishActivity(true);
    }

    private void finishActivity(Boolean loginApproved) {
        Intent intent = new Intent();
        Bundle params = new Bundle();
        params.putBoolean("loginApproved?", loginApproved);
        intent.putExtras(params);
        setResult(1, intent);
        finish();
    }
}
