package id.co.sadhanas.mitrasadhana.Activities;

import android.content.Intent;
import android.media.MediaCodec;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Patterns;

import java.util.regex.Pattern;


import id.co.sadhanas.mitrasadhana.R;

public class LoginPerusahaanActivity extends AppCompatActivity {

    EditText email, password;
    Button btnLogin, btnRegister;
    //String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String dataEmail = "ajipram@sadhanas.co.id";
    String dataPassword = "admin";

    //public static final Pattern EMAIL = Pattern.compile();
    private static final Pattern EMAIL_ADDRESS = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
            "\\@" +"[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
            "(" + "\\." +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
            ")+" );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_perusahaan);



        email = (EditText) findViewById(R.id.etEmail);
        password = (EditText) findViewById(R.id.etPass);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRegister = (Button) findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailValidation = email.getText().toString().trim();
                String passwordValidation = password.getText().toString();

                if(!Patterns.EMAIL_ADDRESS.matcher(emailValidation).matches()){
                    email.setError("Format email salah");
                    Toast.makeText(LoginPerusahaanActivity.this, "Format email salah", Toast.LENGTH_SHORT).show();
                } else if (!emailValidation.equals(dataEmail)) {
                    email.setError("Email salah");
                    Toast.makeText(LoginPerusahaanActivity.this, "Email tidak ada di database", Toast.LENGTH_SHORT).show();
                } else if (passwordValidation.length() < 4) {
                    password.setError("Password minimal 4 digit");
                    Toast.makeText(LoginPerusahaanActivity.this, "Password minimal 4 digit", Toast.LENGTH_SHORT).show();
                } else if (!passwordValidation.equals(dataPassword)) {
                    password.setError("Password salah");
                    Toast.makeText(LoginPerusahaanActivity.this, "Password tidak ada di database", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(LoginPerusahaanActivity.this, MenuPerusahaan.class);
                    LoginPerusahaanActivity.this.startActivity(intent);
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginPerusahaanActivity.this, registerPerusahaan.class);
                LoginPerusahaanActivity.this.startActivity(intent);
            }
        });


    }



}
