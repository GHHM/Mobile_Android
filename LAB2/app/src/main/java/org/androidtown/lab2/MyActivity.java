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


/*My Activity
* Input: Data(bundle type)
* Output: none
* Take button from xml resource file and make intent.
* This intent has a role of sending information to
* another activity(newActivity.java) when user click a button '추가'
* */
public class MyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        Button button = (Button) findViewById(R.id.button); //take button from xml
        final EditText e1 = (EditText) findViewById(R.id.e1);   //take editText form xml
        final EditText e2 = (EditText) findViewById(R.id.e2);

        /*When user click the button, run this function*/
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), newActivity.class); //Make new intent that has a message for newActivity.class
                intent.putExtra("name", e1.getText().toString());   //Put an information which has value name "name" to intent
                intent.putExtra("age",e2.getText().toString()); //Put an information which has value name as "age" to intent
                startActivityForResult(intent, 1);  //Send intent to new Activity about intent data and result

            }
        });
    }

    /*OnActivityResult
    * input: requestCode(integer type), resultCode(integer), data (intent type)
    * When this activity gets result from another activity,
    * check the result and show the result in toast.
    * */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
         try{
            if((requestCode == 1) && resultCode == Activity.RESULT_OK){
                    Bundle bundle = data.getExtras();   //Typecast data(intent type) to bundle (bundle type)
                Toast.makeText(this,
                        bundle.getString("value"),Toast.LENGTH_LONG).show();    //Show received data as toast
            }
        }catch(Exception e){}
    }
}
