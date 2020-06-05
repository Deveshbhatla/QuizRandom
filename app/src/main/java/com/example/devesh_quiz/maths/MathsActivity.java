package com.example.devesh_quiz.maths;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


import com.example.devesh_quiz.MainActivity;
import com.example.devesh_quiz.R;

import java.util.Random;

public class MathsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths);
        Button startbutton=(Button)findViewById(R.id.button);
        final EditText nametext=(EditText)findViewById(R.id.editName);

        startbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int random = new Random().nextInt(11) + 1;

                String name=nametext.getText().toString();
                Intent intent=new Intent(getApplicationContext(),QuestionsActivity.class);
                intent.putExtra("myname",name);
                startActivity(intent);
//                Log.d("random","Number: "+random);
            }
        });


    }
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent=new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }


}
