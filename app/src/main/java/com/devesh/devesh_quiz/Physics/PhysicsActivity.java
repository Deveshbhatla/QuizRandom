package com.devesh.devesh_quiz.Physics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.devesh.devesh_quiz.MainActivity;
import com.devesh.devesh_quiz.R;


public class PhysicsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physics);
        Button startbutton=(Button)findViewById(R.id.button);
        final EditText nametext=(EditText)findViewById(R.id.editName);

        startbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=nametext.getText().toString();
                Intent intent=new Intent(getApplicationContext(), PhysicsQuestionActivity.class);
                intent.putExtra("myname",name);
                startActivity(intent);
            }
        });

    }
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent=new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
