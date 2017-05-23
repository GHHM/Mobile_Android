package org.androidtown.lab6;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button write;
    Button clear;
    Button read;
    Button finish;
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Connect objects from xml
        * */
        editText = (EditText) findViewById(R.id.editText);
        write = (Button) findViewById(R.id.write);
        clear = (Button) findViewById(R.id.clear);
        read = (Button) findViewById(R.id.read);
        finish = (Button) findViewById(R.id.finish);

        File sdCard = Environment.getExternalStorageDirectory();       // Get external storage directory
        File directory = new File(sdCard.getAbsolutePath() + "/MyFiles");     //make new path
        directory.mkdirs();     //make directory
        file = new File(directory, "textfile.txt");     //Create file on main memory
        try {
            if(file.createNewFile()){                  //Create file on disk
                Log.d("TAG","File create success");
            }
            else{
                Log.d("TAG","File create failure");
            }
        }catch (IOException e){}

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    FileOutputStream fOut = new FileOutputStream(file);     //Make fileOutputStream
                    //  FileOutputStream fOut = new FileOutputStream(file, true);  //append
                    OutputStreamWriter osw = new OutputStreamWriter(fOut);      //Make OutputStreamWriter using fileOutputStream
                    osw.write(editText.getText().toString());       //write on txt file
                    osw.close();
                    fOut.close();

                    Toast.makeText(getApplicationContext(), "Done writing SD textfile.txt", Toast.LENGTH_SHORT).show();
                } catch (Throwable e) {
                    Toast.makeText(getApplicationContext(), "file io exception", Toast.LENGTH_SHORT).show();
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");       //clear edit text
                Toast.makeText(getApplicationContext(), "clear", Toast.LENGTH_SHORT).show();
            }
        });

        read.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    FileInputStream fIn = new FileInputStream(file);    //open FileInputStream
                    InputStreamReader isr = new InputStreamReader(fIn); //read file through InputStreamReader
                    BufferedReader buffer = new BufferedReader(isr);    //use BufferReader for readeLine()
                    editText.setText(buffer.readLine());
                    Toast.makeText(getApplicationContext(), "read", Toast.LENGTH_SHORT).show();
                } catch (java.io.FileNotFoundException e) {
                    Toast.makeText(getApplicationContext(), "File not found", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                }
            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Application finish", Toast.LENGTH_SHORT).show();
                finish();   //finish application
            }
        });
    }
}
