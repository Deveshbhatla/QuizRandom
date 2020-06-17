package com.devesh.devesh_quiz.maths;

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

public class QuestionsActivity extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;
    private MediaPlayer mediaPlayer;

    String questions[] = {
                            "समीकरण 49 ÷ {[([(4 × 3) ÷ (4 + 2)] ÷ [(4 × 5) – (3 × 6)])] + 6} =? का मान ज्ञात कीजिये|",
                            "13 प्राकृतिक संख्याओं का औसत 11 है। तो अंतिम 11 संख्याओं का अधिकतम औसत क्या हो सकता है?",
                            "निम्न व्यंजक का इकाई अंक क्या है? 13456 × 45789 × 23871 × 667832 × 23560?",
                            "P रुपयों का 30%, Q रुपयों के 40% के बराबर है| यदि P रुपयों का x%, Q रुपयों के बराबर होता है, तो x का मान क्या है?",
                            ".एक दीवार एक 6 मी ऊँचाई एवं 4 मी तथा 8 मी की समांतर भुजाओं वाले समलम्ब के रूप में है| यदि रंगने की दर 25 रूपये प्रति वर्ग मी है, तो दीवार को रंगने की लागत क्या है?",
                            "दो संख्याएँ 7 और 21 का तीसरा अनुपात क्या है?",
                            "सबसे बड़ी संख्या ज्ञात कीजिये कि जिससे 200 और 320 को समान रूप से भाग दिया जा सके?",
                            "एक 720 रु. की धनराशि 1.5 वर्षों में सरल ब्याज पर 882 रु. बन जाती है। कितने वर्षों में समान दर से 800 रु. की धनराशि 1040 रु. बन जायेगी?",
                            "a, b और c तीन संख्याएं हैं। a और b के अंतर और योग का अनुपात 5 : 6 है, यदि c = 4a – 5b है, तो c : (a + b) ढूंढें|",
                            "एक दूकानदार ग्राहकों को 10% छूट देने पश्चात् भी 20% का लाभ कमाता है| रु. 450 क्रय मूल्य की वस्तु का अंकित मूल्य ज्ञात करें|",
                            "व्यंजक 3 × (10 + 5) + (48/6)/4 – 7 का मान क्या है?",
                            "एक व्यक्ति 800 किमी की कुछ यात्रा रेल के द्वारा और कुछ यात्रा नाव द्वारा तय करता है| वह नाव पर 7 घंटे अधिक व्यतीत करता है| यदि नाव की गति 20 किमी/घंटा है और रेल की गति 55 किमी/घंटा है, तब उसने नाव द्वारा कितनी दूरी तय की है?",
                            "10 पुरुष 15 दिनों में एक कार्य पूरा करते हैं। कार्य शुरू करने के पांच दिन बाद, 10 लोग उनके साथ जुड़ गए। शेष कार्य को पूरा करने के लिए कितने दिन लगेंगे?",
                            "निम्न प्रश्न में प्रश्नवाचक चिह्न (?) के स्थान पर लगभग क्या मान आएगा? 24.93 + 70.02 + 9.92 = 2207.32 ÷ (?)",
                            ".दिया गया है कि एक निश्चित संख्या से (2^24 + 1) पूरी तरह से भाज्य है| इनमें से कौन सा विकल्प भी उसी संख्या से निश्चित रूप से पूरी तरह भाज्य होगा?"

                            };
    String answers[] = {"7","141/11","0","75"," 900 रूपये","63","40","2","13 : 4","रु. 600","40","316 किमी","5 दिन","21.04","(2^48 – 1)"};
    String opt[] = {
                    "12","5","8","7",
                    "12","141/11","141/11","13",
                    "1","2","6","0",
                    "50","60","70","75",
                    "250 रूपये","450 रूपये","900 रूपये","600 रूपये",
                    "21","42","35","63",
                    "12","10","60","40",
                    "21"," 7","24","2",
                    "11 : 4","13 : 1","7 : 8","13 : 4",
                     "रु. 600","रु. 540","रु. 800","रु. 900",
                    "50","40","80","30",
                    "316 किमी","580 किमी","317 किमी","416 किमी",
                    "15 दिन","2 दिन","12 दिन","5 दिन",
                    "19.07","21.04","22.00","2.04",
                    "(2^48 – 1)","(2^12 + 1)","(2^12 - 1)","(2^24 + 1)"
                   };


    int flag=0,j=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

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



                if (radio_g.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
                if (ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                } else {
                    wrong++;

                    Toast.makeText(getApplicationContext(), "Wrong,Correct answer is " + answers[flag], Toast.LENGTH_SHORT).show();

                }

                j++;
                if (j < 7)
                    flag = number.get(j);
                else
                {marks = correct;
                Intent in = new Intent(getApplicationContext(), ResultActivity.class);
                startActivity(in);}

                    if (score != null)
                        score.setText("" + correct);

                    if (j <= 7) {

                        tv.setText(questions[flag]);
                        rb1.setText(opt[flag * 4]);
                        rb2.setText(opt[flag * 4 + 1]);
                        rb3.setText(opt[flag * 4 + 2]);
                        rb4.setText(opt[flag * 4 + 3]);


                    } else {
                        marks = correct;
                        Intent in = new Intent(getApplicationContext(), ResultActivity.class);
                        startActivity(in);
                    }
                    radio_g.clearCheck();


            }

        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ResultActivity.class);
                startActivity(intent);
            }
        });

        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(QuestionsActivity.this, R.raw.background_music);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);
        mediaPlayer.setVolume(1,1);

    }
    @Override
    public void onStop() {
        super.onStop();
        mediaPlayer.stop();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent=new Intent(getApplicationContext(), MathsActivity.class);
        startActivity(intent);
    }

}