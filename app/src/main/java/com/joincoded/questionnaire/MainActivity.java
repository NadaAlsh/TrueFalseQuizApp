package com.joincoded.questionnaire;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView questionTextView, correctTextView, falseTextView;
    private Button trueButton, falseButton, nextButton;
    private ArrayList<String> question;
    private ArrayList<Boolean> answer;
    private int currentIndex = 0;
    private static boolean answers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTextView = (TextView) findViewById(R.id.questionTextView);
        correctTextView = (TextView) findViewById(R.id.correctTextView);
        falseTextView = (TextView) findViewById(R.id.falseTextView);
        trueButton = (Button) findViewById(R.id.trueButton);
        falseButton = (Button) findViewById(R.id.falseButton);
        nextButton = (Button) findViewById(R.id.nextButton);

        question = new ArrayList<String>();
        answer = new ArrayList<>();

        question.add("Android is an operating system.");
        answer.add(true);
        question.add("Kotlin is officially supported for Android development.");
        answer.add(false);
        displayQuestion();

        trueButton.setOnClickListener(View -> checkAnswer(true));

        falseButton.setOnClickListener(View -> checkAnswer(false));

        nextButton.setOnClickListener(View -> nextQuestion());

    }


//        trueButton = (Button)findViewById(R.id.trueButton);
//        trueButton.setOnClickListener(this);
//        falseButton = (Button)findViewById(R.id.falseButton);
//        falseButton.setOnClickListener(this);
//
//        question = (TextView)findViewById(R.id.question);
//
//        NextQuestion(random.nextInt(questionLength));

    private void displayQuestion(){
        questionTextView.setText(question.get(currentIndex));

        correctTextView.setVisibility(View.INVISIBLE);
        falseTextView.setVisibility(View.INVISIBLE);
        nextButton.setVisibility(View.INVISIBLE);
        trueButton.setVisibility(View.VISIBLE);
        falseButton.setVisibility(View.VISIBLE);

    }

    private void checkAnswer(boolean userAnswer){
        boolean correctAnswer = answer.get(currentIndex);

        if(userAnswer == correctAnswer){
            correctTextView.setVisibility(View.VISIBLE);
            falseTextView.setVisibility(View.INVISIBLE);
            nextButton.setVisibility(View.VISIBLE);
            trueButton.setVisibility(View.INVISIBLE);
            falseButton.setVisibility(View.INVISIBLE);
        }
        else{
            correctTextView.setVisibility(View.INVISIBLE);
            falseTextView.setVisibility(View.VISIBLE);
            nextButton.setVisibility(View.INVISIBLE);
            trueButton.setVisibility(View.VISIBLE);
            falseButton.setVisibility(View.VISIBLE);
        }
    }

    public void nextQuestion() {

        if (currentIndex < question.size() - 1)
            currentIndex++;

         else
            currentIndex = 0;
        displayQuestion();

    }
    @Override
    public void onClick(View v) {

    }
}


//    private void NextQuestion(int num){
//        question.setText(question.getText());
//        trueButton.setText(question.getText());
//        falseButton.setText(question.getText());
//
//        answer = question.getCorrectAnswer(num);
//    }
//}