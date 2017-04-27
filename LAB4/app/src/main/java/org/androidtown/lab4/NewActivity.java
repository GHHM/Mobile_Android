package org.androidtown.lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.button;
import static android.R.attr.name;
import static org.androidtown.lab4.R.id.gender;


/*NewActivity
* Input: none
* Output: none
* This activity receive data from 'MainActivity' and list the information.
* */
public class NewActivity extends AppCompatActivity {
    TextView nameView;
    TextView genderView;
    TextView receiveView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        nameView = (TextView) findViewById(R.id.name);
        genderView = (TextView) findViewById(gender);
        receiveView = (TextView) findViewById(R.id.receive);
        Button button = (Button) findViewById(R.id.backButton);

        Intent passIntent = getIntent();        //receive intent
        String name = passIntent.getStringExtra("name").toString();
        nameView.setText(name);
        String gender = passIntent.getStringExtra("gender").toString();
        genderView.setText(gender);
        String receive = passIntent.getStringExtra("receive").toString();
        receiveView.setText(receive);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
//  Toast.makeText(getApplicationContext(),name +" "+gender+" "+receive,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
