package com.devesh.devesh_quiz.SST;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.devesh.devesh_quiz.R;


public class SSTResultActivity extends AppCompatActivity {

    TextView tv, tv2, tv3;
    Button btnRestart;
    Fragment selectedFragment = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_s_t_result);

        tv = (TextView)findViewById(R.id.tvres);
        tv2 = (TextView)findViewById(R.id.tvres2);
        tv3 = (TextView)findViewById(R.id.tvres3);
        btnRestart = (Button) findViewById(R.id.btnRestart);

        StringBuffer sb = new StringBuffer();
        sb.append("Correct answers: " + SSTQuestionsActivity.correct + "\n");
        StringBuffer sb2 = new StringBuffer();
        sb2.append("Wrong Answers: " + SSTQuestionsActivity.wrong + "\n");
        StringBuffer sb3 = new StringBuffer();
        sb3.append("Final Score: " + SSTQuestionsActivity.correct + "\n");
        tv.setText(sb);
        tv2.setText(sb2);
        tv3.setText(sb3);
        tv3.setText(sb3);
        if(SSTQuestionsActivity.correct<=3)
        {
            Toast.makeText(getApplicationContext(), "Don't worry you can always try again", Toast.LENGTH_SHORT).show();


        }
        else
            Toast.makeText(getApplicationContext(), "congratulations you scored more than 50%", Toast.LENGTH_SHORT).show();
        SSTQuestionsActivity.correct=0;
        SSTQuestionsActivity.wrong=0;

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), SstActivity.class);
                startActivity(in);
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent=new Intent(getApplicationContext(), SstActivity.class);
        startActivity(intent);
    }
}
