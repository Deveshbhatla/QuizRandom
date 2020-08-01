package com.devesh.devesh_quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.devesh.devesh_quiz.Chemistry.ChemistryActivity;
import com.devesh.devesh_quiz.Physics.PhysicsActivity;
import com.devesh.devesh_quiz.SST.SstActivity;
import com.devesh.devesh_quiz.maths.MathsActivity;


public class PlayFragment extends Fragment {
    ImageButton maths;
    ImageButton physics;
    ImageButton chemistry;
    ImageButton sst;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_play,container,false);
        maths=view.findViewById(R.id.button1);
        physics=view.findViewById(R.id.button2);
        chemistry=view.findViewById(R.id.button3);
        sst=view.findViewById(R.id.button4);


        maths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MathsActivity.class);
                startActivity(intent);

            }
        });
        physics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PhysicsActivity.class);
                startActivity(intent);
            }
        });
        chemistry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ChemistryActivity.class);
                startActivity(intent);

            }
        });
        sst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SstActivity.class);
                startActivity(intent);

            }
        });
        return view;
    }
}
