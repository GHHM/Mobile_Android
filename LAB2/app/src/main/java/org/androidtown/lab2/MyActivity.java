package org.androidtown.lab2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.attr.value;

public class MyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        Button button = (Button) findViewById(R.id.button);
        final EditText e1 = (EditText) findViewById(R.id.e1);
        final EditText e2 = (EditText) findViewById(R.id.e2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), newActivity.class);
                intent.putExtra("name", e1.getText().toString());
                intent.putExtra("age",e2.getText().toString());
                startActivityForResult(intent, 1);

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
      //  Toast.makeText(this,"aaaaa",Toast.LENGTH_LONG).show();
        try{
            if((requestCode == 1) && resultCode == Activity.RESULT_OK){
                    Bundle bundle = data.getExtras();
                Toast.makeText(this,
                        bundle.getString("value"),Toast.LENGTH_LONG).show();
            }
        }catch(Exception e){}
    }
}
