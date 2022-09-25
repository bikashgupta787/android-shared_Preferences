package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name,email,gender,number;
    Button button;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_GENDER = "gender";
    private static final String KEY_NUMBER = "number";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        gender = (EditText) findViewById(R.id.gender);
        number = (EditText) findViewById(R.id.number);
        button = (Button) findViewById(R.id.button);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        if(name!= null){
            Intent intent = new Intent(MainActivity.this,HomeActivity.class);
            startActivity(intent);
        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_NAME,name.getText().toString());
                editor.putString(KEY_EMAIL,email.getText().toString());
                editor.putString(KEY_GENDER,gender.getText().toString());
                editor.putString(KEY_NUMBER,number.getText().toString());
                editor.apply();

                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);

                Toast.makeText(MainActivity.this,"Login Success ", Toast.LENGTH_SHORT).show();



            }
        });
    }
}