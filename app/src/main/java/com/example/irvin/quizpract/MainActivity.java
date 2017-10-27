package com.example.irvin.quizpract;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView mQuestionTextView;
    TextView mScoreTextView;
    Button trueBtn;
    Button falseBtn;
    int mScore;
    int mQuestionIdd;
    int mIndex;
    ProgressBar mProgressBar;

    TrueFalse[] questionBank = {
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, false),
            new TrueFalse(R.string.question_3, true)

    };

    final int proBar = (int) (100.0/ Math.ceil(questionBank.length));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuestionTextView = (TextView) findViewById(R.id.questionTextView);
        mScoreTextView = (TextView) findViewById(R.id.scoreTextView);
        trueBtn = (Button) findViewById(R.id.true_button);
        falseBtn = (Button) findViewById(R.id.false_button);

        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);

        mQuestionIdd = questionBank[mIndex].getQuestionId();
        mQuestionTextView.setText(mQuestionIdd);

        trueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correctAnswer(true);
                changeQuestion();
            }
        });

        falseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correctAnswer(false);
                changeQuestion();
            }
        });


    }

    public void changeQuestion() {
        mIndex = (mIndex + 1) % 3;

        if (mIndex == 0) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Game Over");
            alert.setCancelable(false);
            alert.setMessage("Your Score is " + mScore);
            alert.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alert.show();
        }

        mQuestionIdd = questionBank[mIndex].getQuestionId();
        mQuestionTextView.setText(mQuestionIdd);
        mProgressBar.incrementProgressBy(proBar);


    }

    public void correctAnswer(boolean userSelection) {
        boolean rightAnswer = questionBank[mIndex].isAnswerId();

        if (userSelection == rightAnswer) {
            Toast.makeText(getApplicationContext(), R.string.right_toast, Toast.LENGTH_SHORT).show();
            mScore = mScore + 1;
            mScoreTextView.setText("Score is " + mScore + "/" + questionBank.length);
        } else {
            Toast.makeText(getApplicationContext(), R.string.wrong_toast, Toast.LENGTH_LONG).show();
        }
    }

}