package shuvalov.nikita.project_3surveyor.Likert;

import shuvalov.nikita.project_3surveyor.Question;

/**
 * Created by NikitaShuvalov on 11/19/16.
 */

public class LikertQuestion extends Question {
    String mFloor, mCeiling;

    public LikertQuestion(String question, String floor, String ceiling) {
        super(question);
        mFloor = floor;
        mCeiling = ceiling;
    }


    public String getFloor() {
        return mFloor;
    }

    public String getCeiling() {
        return mCeiling;
    }
}
