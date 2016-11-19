package shuvalov.nikita.project_3surveyor.Likert;

import shuvalov.nikita.project_3surveyor.Answer;

/**
 * Created by NikitaShuvalov on 11/19/16.
 */

public class LikertAnswer extends Answer {
    String mAnswer;

    public LikertAnswer(int answer) {
        mAnswer = String.valueOf(answer);
    }

    @Override
    public String getAnswer() {
        return mAnswer;
    }
}
