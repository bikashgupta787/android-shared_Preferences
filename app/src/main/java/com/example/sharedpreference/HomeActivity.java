package com.example.sharedpreference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    TextView fullname, fullemail, fullgender, fullnum;
    Button logout;

    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_GENDER = "gender";
    private static final String KEY_NUMBER = "number";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        fullname = (TextView) findViewById(R.id.fullname);
        fullemail = (TextView) findViewById(R.id.fullemail);
        fullgender = (TextView) findViewById(R.id.fullgender);
        fullnum = (TextView) findViewById(R.id.fullnum);
        logout = (Button) findViewById(R.id.logout);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        String name = sharedPreferences.getString(KEY_NAME,null);
        String email = sharedPreferences.getString(KEY_EMAIL,null);
        String gender = sharedPreferences.getString(KEY_GENDER,null);
        String number = sharedPreferences.getString(KEY_NUMBER,null);

        if(name != null || email != null || gender != null || number != null){
            fullname.setText("Full name - "+name);
            fullemail.setText("Email - "+email);
            fullgender.setText("Gender- "+gender);
            fullnum.setText("Number - "+number);
        }

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                finish();
                Toast.makeText(HomeActivity.this,"logout success",Toast.LENGTH_SHORT).show();
                finish();
            }
        });


    }
}