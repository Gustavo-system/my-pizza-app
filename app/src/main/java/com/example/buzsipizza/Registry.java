package com.example.buzsipizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registry extends AppCompatActivity {

    private Button btnRegistrar;
    private EditText username;
    private EditText lastName;
    private EditText email;
    private EditText password;
    private EditText confirmPassword;
    private EditText numberPhone;
    private EditText address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registry);

        //button for back in the app
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dataColletion();

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goActivity();
            }
        });

    }

    private void dataColletion(){
        btnRegistrar = (Button) findViewById(R.id.btn_registrar_registry);

    }

    private void goActivity(){
        Intent intent = new Intent(Registry.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}