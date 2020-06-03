package com.example.devesh_quiz.Chemistry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.devesh_quiz.R;
import com.example.devesh_quiz.maths.MathsActivity;
import com.example.devesh_quiz.maths.QuestionsActivity;


public class ChemistryResultActivity extends AppCompatActivity {
    TextView tv, tv2, tv3;
    Button btnRestart;
    Fragment selectedFragment = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chemistry_result);

        tv = (TextView)findViewById(R.id.tvres);
        tv2 = (TextView)findViewById(R.id.tvres2);
        tv3 = (TextView)findViewById(R.id.tvres3);
        btnRestart = (Button) findViewById(R.id.btnRestart);

        StringBuffer sb = new StringBuffer();
        sb.append("Correct answers: " + ChemistryQuestionsActivity.correct + "\n");
        StringBuffer sb2 = new StringBuffer();
        sb2.append("Wrong Answers: " + ChemistryQuestionsActivity.wrong + "\n");
        StringBuffer sb3 = new StringBuffer();
        sb3.append("Final Score: " + ChemistryQuestionsActivity.correct + "\n");
        tv.setText(sb);
        tv2.setText(sb2);
        tv3.setText(sb3);
        tv3.setText(sb3);
        if(ChemistryQuestionsActivity.correct<=3)
        {
            Toast.makeText(getApplicationContext(), "Don't worry you can always try again", Toast.LENGTH_SHORT).show();

        }
        else
            Toast.makeText(getApplicationContext(), "congratulations you scored more than 50%", Toast.LENGTH_SHORT).show();

        ChemistryQuestionsActivity.correct=0;
        ChemistryQuestionsActivity.wrong=0;

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), ChemistryActivity.class);
                startActivity(in);
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent=new Intent(getApplicationContext(), ChemistryActivity.class);
        startActivity(intent);
    }
}
