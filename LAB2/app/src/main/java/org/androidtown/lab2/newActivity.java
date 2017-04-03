package org.androidtown.lab2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class newActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        final Intent passedIntent = getIntent();
        if(passedIntent!= null){
        String loginName = passedIntent.getStringExtra("name");
            String loginAge = passedIntent.getStringExtra("age");
            Toast.makeText(getApplication(), "Student Info : " + loginName+", "+loginAge, Toast.LENGTH_LONG).show();
        }else
        {
            Toast.makeText(this,"No data",Toast.LENGTH_LONG).show();
        }

        Button button2 = (Button) findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passedIntent.putExtra("value","OK~");
                setResult(Activity.RESULT_OK,passedIntent);
                finish();
            }
        });
    }
}