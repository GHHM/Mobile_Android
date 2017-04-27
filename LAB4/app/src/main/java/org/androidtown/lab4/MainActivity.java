package org.androidtown.lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import static android.R.attr.button;
import static org.androidtown.lab4.R.id.email;
import static org.androidtown.lab4.R.id.female;
import static org.androidtown.lab4.R.id.gender;
import static org.androidtown.lab4.R.id.male;
import static org.androidtown.lab4.R.id.sms;

/*MainActivity
* Input: none
* Output: none
* Receive data of user about name, gender, and receive method.
* Using intent, send the data to another activity 'NewActivity'
* */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button inputButton = (Button) findViewById(R.id.register);
        final EditText editText = (EditText) findViewById(R.id.editText);
        final RadioGroup gender = (RadioGroup) findViewById(R.id.gender);
        final RadioButton female = (RadioButton) findViewById(R.id.female);
        final RadioButton male = (RadioButton) findViewById(R.id.male);
        final CheckBox sms = (CheckBox) findViewById(R.id.sms);
        final CheckBox email = (CheckBox) findViewById(R.id.email);

        inputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NewActivity.class);
                intent.putExtra("name", editText.getText().toString());     //put name info in intent

                int radioID = gender.getCheckedRadioButtonId();  //put gender info in intent
                if (female.getId() == radioID)
                    intent.putExtra("gender", "여");
                else if (male.getId() == radioID)
                    intent.putExtra("gender", "남");

                String receive = "";         //make string about receive
                if (sms.isChecked()) {
                    receive += "SMS";
                }
                if (email.isChecked()) {
                    if (sms.isChecked())
                        receive += " & Email";
                    else
                        receive += "Email";
                }

                intent.putExtra("receive",receive);  //put string info in intent
                startActivity(intent);  //send
            }
        });
    }
}
