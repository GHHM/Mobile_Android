package org.androidtown.lab7;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout audio1;
    LinearLayout audio2;
    private MediaPlayer mediaPlayer1;
    private MediaPlayer mediaPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audio1 = (LinearLayout) findViewById(R.id.audio1);
        audio2 = (LinearLayout) findViewById(R.id.audio2);
        mediaPlayer1 = new MediaPlayer();       //make new MediaPlayer for audio1
        mediaPlayer2 = new MediaPlayer();//make new MediaPlayer for audio2

        audio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audio1.setBackgroundColor(Color.GRAY);      //when button click, background color change
                audio2.setBackgroundColor(Color.WHITE);
                try{
                    mediaPlayer1.release();     //turn off all mediaPlayer
                    mediaPlayer2.release();
                    mediaPlayer1 = MediaPlayer.create(getApplicationContext(),R.raw.music1); //turn on mediaPlayer1
                    mediaPlayer1.start();       //mediaPlayer1 start
                    Toast.makeText(getApplicationContext(),"음악 실행",Toast.LENGTH_SHORT).show();      //debugging
                }catch(Exception e){
                    Toast.makeText(getApplicationContext(),"오류",Toast.LENGTH_SHORT).show();
                }
            }
        });

        audio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audio2.setBackgroundColor(Color.GRAY); //when button click, background color change
                audio1.setBackgroundColor(Color.WHITE);
                try{
                    mediaPlayer1.release();//turn off all mediaPlayer
                    mediaPlayer2.release();
                    mediaPlayer2 = MediaPlayer.create(getApplicationContext(),R.raw.music2);//turn on mediaPlayer2
                    mediaPlayer2.start();//mediaPlayer2 start
                    Toast.makeText(getApplicationContext(),"음악 실행",Toast.LENGTH_SHORT).show();//debugging
                }catch(Exception e){
                    Toast.makeText(getApplicationContext(),"오류",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
