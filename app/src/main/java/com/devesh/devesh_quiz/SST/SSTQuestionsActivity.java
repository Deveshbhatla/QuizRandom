package com.devesh.devesh_quiz.SST;

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


public class SSTQuestionsActivity extends AppCompatActivity {

    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;
    private MediaPlayer mediaPlayer;


    String questions[] = {
            "न्याय पंचायत के कार्य के रूप में कौन सा कथन गलत है?",
            "गांधी के रूप में किसे जाना जाता था?",
            "देशबंधु किसे कहा जाता था?",
            "चट्टान जो अपने मूल घटक की तुलना में कठिन है:",
            "इसमें बड़े पैमाने पर पर्यावरण प्रदूषण हुआ है:",
            "ग्लेशियर से पिघलने, वाष्पीकरण और हिमस्खलन के कारण बर्फ कम होने को क्या कहा जाता है?",
            "भारतीय राष्ट्रीय कांग्रेस का भव्य बूढ़ा किसे कहा जाता था?",
            "नोह्कलिआइ झरना किस प्रदेश में है?",
            "पंचायतों की आय का स्रोत क्या है?",
            "दोनों घरों के संयुक्त बैठक को बुलाया जाता है:",
            "हजीरा - विज ऐपुर - जगदीशपुर पाइपलाइन। इस अवस्था से नहीं गुजरता",
            "लौह अयस्क के प्रगलन में प्रयुक्त धातुकर्म कोयला है",
            "निम्नलिखित में से कौन सा राज्य लौह अयस्क का प्रमुख उत्पादक है?",
            "गुलामगिरी ’में जाति व्यवस्था के अन्याय के बारे में किसने लिखा है?",
            "प्राचीन भारत में पांडुलिपियों को लिखने के लिए निम्नलिखित में से किस सामग्री का उपयोग किया गया था?"

    };
    String answers[] = {" ऊपर के सभी","खान अब्दुल गफ्फार खान","त्तरंजन दास","मेटामॉर्फिक चट्टान","औद्योगिक और शहरी क्षेत्र","अपक्षरण","दादाभाई नौरोजी","मेघालय ","हाउस टैक्स","संयुक्त सत्र","महाराष्ट्र","बिटुमिनस","कर्नाटक","ज्योतिबा फुले","वेल्लम"};
    String opt[] = {
            "यह गांव के स्कूलों का रखरखाव करता है"," यह स्वास्थ्य केंद्र चलाता है","यह किसानों को कर्ज देता है"," ऊपर के सभी",
            "जवाहर लाल नेहरू","अली भाई","खान अब्दुल गफ्फार खान","जिनिना",
            "लाला लाजपत राय","चंद्र शेखर आज़ाद","चित्तरंजन दास","बाल गंगाधर तिलक",
            "तलछटी पत्थर","आग्नेय चट्टान","मेटामॉर्फिक चट्टान","कोयला",
            "ग्रामीण क्षेत्रों में ही","औद्योगिक और शहरी क्षेत्र","केवल शहरी क्षेत्र","उपरोक्त सभी",
            "गलिंग","क्रीप","अपक्षरण","प्लकिंग",
            "लाला लाजपत राय","सरदार वल्लभ भाई पटेल","महात्मा गांधी","दादाभाई नौरोजी",
            "केरल","मेघालय","असम","मणिपुर",
            "हाउस टैक्स","शिक्षा कर","आय टेक्स","परिवहन कर",
            "संसद के सदस्य","संयुक्त सत्र","लोक सभा अध्यक्ष","रक्षा मंत्री",
            "उत्तर प्रदेश","गुजरात","मध्य प्रदेश","महाराष्ट्र",
            "एन्थ्रेसाइट","बिटुमिनस","लिग्नाइट","पीट",
            "छत्तीसगढ़","झारखंड","कर्नाटक","मध्य प्रदेश",
            "राजा राममोहन राय","ज्योतिबा फुले","बालगंगाधर तिलक","बंकिम चंद्र चट्टोपाध्याय",
            "चर्मपत्र","वेल्लम","ताड़ के पत्ते","पेपर"


    };
    int flag=0,j=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sst_questions);

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
                    Intent in = new Intent(getApplicationContext(), SSTResultActivity.class);
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
                    Intent in = new Intent(getApplicationContext(), SSTResultActivity.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),SSTResultActivity.class);
                startActivity(intent);
            }
        });
        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(SSTQuestionsActivity.this, R.raw.background_music);
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

        Intent intent=new Intent(getApplicationContext(), SstActivity.class);
        startActivity(intent);
    }

}
