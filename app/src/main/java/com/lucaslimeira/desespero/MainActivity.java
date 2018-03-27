package com.lucaslimeira.desespero;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    public static final int LOGIN_REQUEST_CODE = 10;

    private EditText usernameText;
    private EditText passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.usernameText = findViewById(R.id.username_txt);
        this.passwordText = findViewById(R.id.password_txt);
    }

    public void requestLogin(View view) {
        Intent intent = new Intent(this, ApproveLoginActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("username", this.usernameText.getText().toString());
        bundle.putString("password", this.passwordText.getText().toString());

        intent.putExtras(bundle);
        startActivityForResult(intent, this.LOGIN_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == this.LOGIN_REQUEST_CODE && resultCode == 1) {
            Boolean login_approved = data.getBooleanExtra("loginApproved?", false);
            if(login_approved) {
                Toast.makeText(this, "LOGIN APPROVED", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "LOGIN FAILED", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
