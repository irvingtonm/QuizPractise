package com.example.irvin.quizpract;

/**
 * Created by Irvin on 10/27/2017.
 */

public class TrueFalse {

    int mQuestionId;
    boolean mAnswerId;

    public TrueFalse(int questionResId, boolean trueOrFalse) {
        mQuestionId = questionResId;
        mAnswerId = trueOrFalse;
    }

    public int getQuestionId() {
        return mQuestionId;
    }

    public void setQuestionId(int questionId) {
        mQuestionId = questionId;
    }

    public boolean isAnswerId() {
        return mAnswerId;
    }

    public void setAnswerId(boolean answerId) {
        mAnswerId = answerId;
    }
}
