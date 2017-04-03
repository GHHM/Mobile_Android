package org.androidtown.lab2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.R.attr.value;

public class newActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        final Intent passedIntent = getIntent();    //Get intent from MyActivity.java
        if(passedIntent!= null){    //If the intent has some data
        String loginName = passedIntent.getStringExtra("name");     //Find data which has value name "name"
            String loginAge = passedIntent.getStringExtra("age");  //Find data which has value name "age"
            Toast.makeText(getApplication(), "Student Info : " + loginName+", "+loginAge, Toast.LENGTH_LONG).show();    //Show received data from intent
        }else
        {
            Toast.makeText(this,"No data",Toast.LENGTH_LONG).show();    //if there is no data, toast "No data"
        }

        Button button2 = (Button) findViewById(R.id.button2);   // Find button "닫기"
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //When this button clicked
                passedIntent.putExtra("value","OK~");   //send data "OK~" which value name is "value" through intent
                setResult(Activity.RESULT_OK,passedIntent); //set the result as intent 'passedIntent'
                finish();   //close the activity
            }
        });
    }
}