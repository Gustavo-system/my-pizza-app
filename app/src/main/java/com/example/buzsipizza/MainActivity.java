package com.example.buzsipizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private  Button btnLogin;
    private Button btnCreateAccount;
    private Button btnForgotPass;

    private  EditText EditUsername;
    private  EditText EditTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataCollection();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = EditUsername.getText().toString();
                String password = EditTextPassword.getText().toString();

                if (login(username,password)){
                    Toast.makeText(MainActivity.this, "Loading ...", Toast.LENGTH_LONG).show();
                    goMain();
                }
            }
        });

        //Accion del boton de Create as Accound
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this , "Loading ..." , Toast.LENGTH_SHORT ).show();
                Intent intent = new Intent(MainActivity.this, Registry.class);
                startActivity(intent);
            }
        });
    }

    //Obtenemos el id de los buttons
    private void DataCollection(){
        btnLogin = (Button) findViewById(R.id.btnlogin);
        btnCreateAccount = (Button) findViewById(R.id.btnCreateAccount);
        btnForgotPass = (Button) findViewById(R.id.btnforgotPassword);

        EditUsername =(EditText) findViewById(R.id.EditUsername);
        EditTextPassword =(EditText) findViewById(R.id.EditTxtPassword);
    }


    //Validamos el username del login
    public boolean isValidLogin(String username){
        return !TextUtils.isEmpty(username);
    }

    public boolean isValidEmail(String username){
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(username).matches();
    }

    //Validamos la contraseña del login
    public boolean isValidPassword(String password){
        final int MIN_PASSWORD=8;
        return password.length()>=MIN_PASSWORD;
    }

    //validar los datos obtenidos del editText
    private  boolean login(String user, String pass){
        if (!isValidLogin(user)){
            Toast.makeText(MainActivity.this, "Usermane is Emply, please try again", Toast.LENGTH_LONG).show();
            return  false;
        }else if (!isValidEmail(user)){
            Toast.makeText(MainActivity.this, "email is not valid, check address", Toast.LENGTH_LONG).show();
            return  false;
        } else if(!isValidPassword(pass)){
            Toast.makeText(MainActivity.this, "Password does not match, please try again", Toast.LENGTH_LONG).show();
            return  false;
        }else {
            return  true;
        }
    }

    private void goMain(){
        Intent intent = new Intent(MainActivity.this,HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

}