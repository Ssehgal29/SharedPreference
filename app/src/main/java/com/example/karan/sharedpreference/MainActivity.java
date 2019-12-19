package com.example.karan.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText e1,e2;
Button b1,b2,b3;
SharedPreferences pref;
SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.editText);
        e2=findViewById(R.id.editText2);

        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);
        b3=findViewById(R.id.button3);

        pref = getSharedPreferences("jadu", Context.MODE_PRIVATE); //taki is file ko koi or app access na kar pae or humari shared preference file ka reference aab pref me hai
        editor = pref.edit(); // jab hume add , delete karna ho to editor vala reference use karenge or jab sirf read karni ho to pref ko use karna hoga

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String name = e1.getText().toString();
                String phone = e2.getText().toString();

                editor.putString("name_key",name);
                editor.putString("phone_key",phone);

                editor.commit(); //its a commitment tag it is compulsery to use editor unless it wont work

                Toast.makeText(MainActivity.this, "Data Saved...", Toast.LENGTH_SHORT).show();

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String name = pref.getString("name_key",null);
                String phone = pref.getString("phone_key",null);

                Toast.makeText(MainActivity.this, "Name:-"+name+"\nPhone:-"+phone, Toast.LENGTH_SHORT).show();

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
             /*   editor.clear();
                editor.commit();  to clear all the data*/

            editor.remove("key_name"); // to remove a particlar entry\
            editor.commit();

            }
        });

    }
}
