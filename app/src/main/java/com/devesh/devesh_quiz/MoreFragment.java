package com.devesh.devesh_quiz;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MoreFragment extends Fragment {
    private TextView Terms,About;
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private ProgressDialog pDialog;
    private Button more;
    private TextView nptel;
    private TextView vigyanprasar;
    private TextView bhartiscript;
    private TextView arvindguptatoys;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_more,container,false);
        About=view.findViewById(R.id.button_about_us);
        nptel=view.findViewById(R.id.nptel);
        vigyanprasar=view.findViewById(R.id.vigyanprasar);
        bhartiscript=view.findViewById(R.id.bhartiscript);
        arvindguptatoys=view.findViewById(R.id.arvindguptatoys);

        nptel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://nptel.ac.in/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        vigyanprasar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://vigyanprasar.gov.in/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        bhartiscript.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.bharatiscript.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        arvindguptatoys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.arvindguptatoys.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });




        About.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBuilder=new AlertDialog.Builder(getContext());

                View view=getLayoutInflater().inflate(R.layout.popup_aboutus,null);
                TextView textView=view.findViewById(R.id.popList);
                Button close=view.findViewById(R.id.dismissPopTop);
                Button close_text=view.findViewById(R.id.dismissPop);
                textView.setText("A startup by the students of  Vignan's University targetted on the students to be availed with the respective subject to be prepared for the examination. We also support students in the areas of their interests even other than academic studies . Thus, we are riding near to our goal of making out professionals from this generation");

                pDialog = new ProgressDialog(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
                pDialog.setTitle("PDF");
                pDialog.setMessage("Loading...");

                close_text.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();

                    }
                });


                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialogBuilder.setView(view);
                dialog = dialogBuilder.create();
                dialog.show();


            }
        });

        return view;
    }


}
