package com.devesh.devesh_quiz.Physics;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.devesh.devesh_quiz.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class PhysicsQuestionActivity extends AppCompatActivity {

    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;
    private MediaPlayer mediaPlayer;


    String questions[] = {
            "लंबाई L का एक तार, जो सामग्री प्रतिरोधकता से बना होता है, वह दो समान भागों में कट जाता है। दो भागों की प्रतिरोधकता बराबर होती है",
            "10 वोल्ट की बैटरी 20 ohm के प्रतिरोध के माध्यम से 20,000 C का आवेश वहन करती है। 10 सेकंड में किया गया काम है",
            "केवल 6ohm प्रतिरोधों का उपयोग करके 2 ohm प्रतिरोध प्राप्त करने के लिए, उनमें से आवश्यक संख्या है",
            "सदो डिवाइस दो बिंदुओं के बीच जुड़े हुए हैं, ए और बी समानांतर में कहते हैं। भौतिक बिंदु जो दो बिंदुओं के बीच समान रहेगा",
            "2 Ω, 4 Ω , 1 Ω और 100 Ω का उपयोग करके प्राप्त कम से कम प्रतिरोध है",
            "बल्ब के गर्म रेशा का प्रतिरोध ठंड प्रतिरोध का लगभग 10 गुना है। जब उपयोग में न हो तो 100 W-220 V दीपक का प्रतिरोध क्या होगा?",
            "नएक अच्छा हीटर के साथ उपयोग किए जाने पर एक फ्यूज तार बार-बार जल जाता है। के फ्यूज वायर का उपयोग करने की सलाह दी जाती है",
            "एक घरेलू आपूर्ति से 1500W, 200 वोल्ट और 500W, 200 वोल्ट के एक प्रशंसक का उपयोग किया जाना है। उपयोग किए जाने वाले फ्यूज की रेटिंग है",
            "ऊर्जा न तो बनाई जा सकती है और न ही नष्ट की जा सकती है, लेकिन फिर भी हर कोई ऊर्जा संकट के बारे में चर्चा करता है",
            "करंट के चुंबकीय प्रभाव की खोज किसने की थी",
            "चुंबक के अंदर, क्षेत्र रेखाएं चलती हैं",
            "किस उपकरण द्वारा चुंबकीय क्षेत्र की उपस्थिति निर्धारित की जाती है?",
            "सीधे प्रवाहकत्त्व वाले तार द्वारा निर्मित चुंबकीय क्षेत्र का पैटर्न है",
            "एक क्षैतिज विद्युत लाइन के माध्यम से एक धारा दक्षिण से उत्तर दिशा की ओर बहती है। चुंबकीय क्षेत्र की दिशा 0.5 मीटर ऊपर है:",
            "निम्नलिखित कारकों में से कौन सा एक समान चुंबकीय क्षेत्र में एक वर्तमान ले जाने के द्वारा बल अनुभव की ताकत को प्रभावित करता है?"
    };
    String answers[] = {"ρ","2 × 10^5 जूल","3","वोल्टेज","<1 Ω","484 Ω","अधिक त्रिज्या","10 A","ये सभी","ओरस्टेड","उत्तर से दक्षिण की ओर","चुंबकीय सुई","तार के चारों ओर गोलाकार","उत्तर","उपरोक्त सभी"};
    String opt[] = {
            "ρ","ρ/2","3ρ","4ρ",
            "2 × 10^2 जूल","2 × 10^4 जूल","2 × 10^8 जूल","2 × 10^5 जूल",
            "2","3","5","1",
            "विद्युत धारा","वोल्टेज","प्रतिरोध","इनमें से कोई नहीं",
            "<100 Ω ",">2 Ω ","<1 Ω","<4 Ω",
            "484 Ω","48 Ω","480 Ω","48.4 Ω",
            "अधिक लंबाई","मकम त्रिज्या","कम लंबाईा","मअधिक त्रिज्या",
            "7.5 A","10 A","5 A","2.5 A",
            "ऊर्जा लगातार अलग-अलग रूप में परिवर्तित होती है।","कम उपयोग योग्य रूपों में परिवेश के लिए ऊर्जा का उपयोग करने योग्य रूप बदल जाता है।","ऊर्जा की खपत होती है और उसका दोबारा उपयोग नहीं किया जा सकता।","ये सभी",
            "ओरस्टेड","फफैराडे","बोह्र","एम्पीयर",
            "उत्तर से दक्षिण की ओर","दक्षिण से उत्तर की ओर","दक्षिणी ध्रुव से दूर","उत्तरी ध्रुव से दूर",
            "चुंबकीय सुई","एममीटर","गैल्वेनोमीटर","वोल्टमीटर",
            "धारा के विपरीत दिशा में","तार के समानांतर दिशा में","तार के चारों ओर गोलाकार","धारा की समान दिशा में",
            "दक्षिण","उत्तर","पश्चिम","पूर्व",
            "चुंबकीय क्षेत्र की ताकत","एक चालक में धारा का परिमाण","चुंबकीय क्षेत्र के भीतर कंडक्टर की लंबाई","उपरोक्त सभी"
    };
    int flag=0,j=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physics_question);

        final TextView score = (TextView)findViewById(R.id.textView4);
        TextView textView=(TextView)findViewById(R.id.DispName);
        Intent intent = getIntent();
        String name= intent.getStringExtra("myname");

        if (name.trim().equals(""))
            textView.setText("Hello User");
        else
            textView.setText("Hello " + name);

        submitbutton=(Button)findViewById(R.id.button3);
        quitbutton=(Button)findViewById(R.id.buttonquit);
        tv=(TextView) findViewById(R.id.tvque);

        final int random = new Random().nextInt(7) + 2;
        final ArrayList<Integer> number = new ArrayList<Integer>();
        for (int i = random; i <= random+6; ++i)
            number.add(i);
        Collections.shuffle(number);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[flag * 4]);
        rb2.setText(opt[flag * 4 + 1]);
        rb3.setText(opt[flag * 4 + 2]);
        rb4.setText(opt[flag * 4 + 3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong,Correct answer is "+answers[flag], Toast.LENGTH_SHORT).show();

                }

                j++;
                if (j < 7)
                    flag = number.get(j);
                else
                {marks = correct;
                    Intent in = new Intent(getApplicationContext(), PhysicsResultActivity.class);
                    startActivity(in);}
                if (score != null)
                    score.setText(""+correct);

                if(j<=7)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(), PhysicsResultActivity.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),PhysicsResultActivity.class);
                startActivity(intent);
            }
        });

        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(PhysicsQuestionActivity.this, R.raw.background_music);
        mediaPlayer.start();
        mediaPlayer.setVolume(1,1);

        mediaPlayer.setLooping(true);
    }
    @Override
    public void onStop() {
        super.onStop();
        mediaPlayer.stop();
    }
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent=new Intent(getApplicationContext(), PhysicsActivity.class);
        startActivity(intent);
    }

}
