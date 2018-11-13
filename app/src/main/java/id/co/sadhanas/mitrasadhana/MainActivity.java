package id.co.sadhanas.mitrasadhana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import id.co.sadhanas.mitrasadhana.Activities.LoginTeknisiActivity;
import id.co.sadhanas.mitrasadhana.Activities.LoginPerusahaanActivity;

public class MainActivity extends AppCompatActivity {

    Button btnLoginPerusahaan, btnLoginTeknisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLoginPerusahaan = (Button) findViewById(R.id.btnPerusahaan);
        btnLoginTeknisi = (Button) findViewById(R.id.btnTeknisi);

        btnLoginPerusahaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LoginPerusahaanActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        btnLoginTeknisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LoginTeknisiActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

    }
}
