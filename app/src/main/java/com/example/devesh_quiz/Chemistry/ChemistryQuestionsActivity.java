package com.example.devesh_quiz.Chemistry;

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

import com.example.devesh_quiz.R;
import com.example.devesh_quiz.maths.MathsActivity;
import com.example.devesh_quiz.maths.QuestionsActivity;
import com.example.devesh_quiz.maths.ResultActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class ChemistryQuestionsActivity extends AppCompatActivity {

    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;
    private MediaPlayer mediaPlayer;


    String questions[] = {
            "जीवाणुओं को नष्ट करने के लिए निम्नलिखित में से किस गैस का प्रयोग किया जाता है?",
            "कहाँ काम करने वाले व्यक्तियों को ब्लैक लंग रोग हो जाता है?",
            "निम्निलिखित में से ऑक्सीजन मिश्रित वह निष्क्रिय गैस कौनसी है जो अवरोधित श्वसन से पीड़ित रोगियों को दी जाती है?",
            "अम्ल वर्षा वनस्पति को नष्ट कर देती है, क्योंकि उसमें?",
            "ऐरोसॉल का उदाहरण है?",
            "धूम कुहरा मौजूद आँख में जलन पैदा करने वाला एक शक्तिशाली द्रव्य है?",
            "वायुमण्डल में कौनसी गैस, पराबैंगनी किरणों का अवशोषण कर लेती है?",
            "कृत्रिम वर्षा या मेघ बीजन के लिए प्राय: प्रयोग किए जाने वाल रासायनिक द्रव्य है?",
            "हरे फलों को कृत्रिम रूप से पकाने के लिए प्रयुक्त गैस है?",
            "निम्नलिखित में से कौनसा पीड़कनाशी ओजोन का ह्रास करता है?",
            "किस कानून को संतुष्ट करने के लिए एक रासायनिक समीकरण को संतुलित करना आवश्यक है:",
            "जब फेरस सल्फेट को जोरदार गर्म किया जाता है, तो यह फेरिक ऑक्साइड को एक मुख्य उत्पाद के रूप में रंग से बदलने के साथ अपघटन से गुजरता है:",
            "श्वसन प्रक्रिया जिसके दौरान ग्लूकोज ऊर्जा के उत्पादन के लिए हमारे शरीर की कोशिकाओं में ऑक्सीजन के साथ दहन से धीमी गति से गुजरता है, एक प्रकार है:",
            "निम्नलिखित में से कौन लाल लिटमस को नीला कर देगा?",
            "कास्टिक पोटाश का रासायनिक सूत्र है"
    };
    String answers[] = {"क्लोरीन","कोयला खान","हीलियम","सल्फ्यूरिक अम्ल होता है","धुआँ","परॉक्सि एसिटिल नाइट्रेट","ओजोन","उपर्युक्त सभी","एथिलीन","मेथिल ब्रोमाइट","मास का संरक्षण ","हरे से भूरा।","एक्ज़ोथिर्मिक प्रक्रिया","बेकिंग सोडा समाधान ","KOH"};
    String opt[] = {
            "क्लोरीन विधि","ऑक्सीजन","हाइड्रोजन","नियॉन",
            " विद्युत्-लेपन उद्योग","कार्बनिक विलायक उद्योग","पेंट विनिर्माण उद्योग","कोयला खान",
            "हीलियम","क्रिप्टॉन","रेडॉन","ऑर्गन",
            "नाइट्रिक अम्ल होता है","ओजोन होती है","कार्बन मोनोक्साइड होती है","सल्फ्यूरिक अम्ल होता है",
            "दूध","नदी का जल","धुआँ","रुधिर",
            "नाइट्रिक ऑक्साइड","सल्फर डाइऑक्साइड","परॉक्सि एसिटिल नाइट्रेट","कार्बन डाइऑक्साइड",
            "ओजोन","मीथेन","नाइट्रोजन","हीलियम",
            "सिल्वर आयोडाइड","सोडियम क्लोराइड","सूखी बर्फ","उपर्युक्त सभी",
            "एथिलीन","एसिटिलीन","इथेन","मीथेन",
            "डी. डी. टी.","बेन्जीन","मेथिल ब्रोमाइट","एथिलीन ओजोननाइड",
            "गति का संरक्षण"," ऊर्जा का संरक्षण","उपरोक्त सभी","मास का संरक्षण",
            "नीला से हरा।","हरा से नीला।","हरे से भूरा।","हरे से पीला।",
            "एक्ज़ोथिर्मिक प्रक्रिया","एंडोथर्मिक प्रक्रिया","प्रतिवर्ती प्रक्रिया","शारीरिक प्रक्रिया",
            "सिरका","बेकिंग सोडा समाधान","नींबू का रस","शीतल पेय",
            "NaOH","Ca(OH)2","NH4OH","KOH"
    };
    int flag=0,j=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chemistry_questions);

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
        Log.d("random1","Number: "+number);

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
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);


                if (radio_g.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if (ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                } else {
                    wrong++;
                    //Log.d("random2","Number: "+random);

                    //Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "Wrong,Correct answer is " + answers[flag], Toast.LENGTH_SHORT).show();

                }

                j++;
                if (j < 7)
                    flag = number.get(j);
                else
                {marks = correct;
                    Intent in = new Intent(getApplicationContext(), ChemistryResultActivity.class);
                    startActivity(in);}

                if (score != null)
                    score.setText("" + correct);

                if (j <= 7) {

                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag * 4]);
                    rb2.setText(opt[flag * 4 + 1]);
                    rb3.setText(opt[flag * 4 + 2]);
                    rb4.setText(opt[flag * 4 + 3]);
                    Log.d("random1", "Number: " + flag);
                    Log.d("j", "Number: " +j);


                } else {
                    marks = correct;
                    Intent in = new Intent(getApplicationContext(), ChemistryResultActivity.class);
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
        mediaPlayer = MediaPlayer.create(ChemistryQuestionsActivity.this, R.raw.background_music);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);
        mediaPlayer.setVolume(1,1);
       }

    @Override
    public void onStop() {
        super.onStop();
        mediaPlayer.stop();
    }
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent=new Intent(getApplicationContext(), ChemistryActivity.class);
        startActivity(intent);
    }

}
