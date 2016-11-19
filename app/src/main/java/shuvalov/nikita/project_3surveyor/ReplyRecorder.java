package shuvalov.nikita.project_3surveyor;

import java.util.ArrayList;

/**
 * Created by NikitaShuvalov on 11/19/16.
 */
public class ReplyRecorder {
    private ArrayList<Answer> mAnswers;
    private String mSurveyedName;

    private static ReplyRecorder ourInstance = new ReplyRecorder();

    public static ReplyRecorder getInstance() {
        if (ourInstance == null){
            ourInstance= new ReplyRecorder();
        }
        return ourInstance;
    }

    private ReplyRecorder() {
        mAnswers = new ArrayList<>();
    }

    public void addAnswer(int questionIndex,Answer answer){
        mAnswers.remove(questionIndex);
        mAnswers.add(questionIndex,answer);
    }

    public void setNumOfQuestions(int numOfQuestions){
        for(int i =0; i<numOfQuestions;i++){
            mAnswers.add(null);
        }
    }

    public boolean allAnswered(){
        for (Answer answer:mAnswers) {
            if(answer==null){
                return false;
            }
        }
        return true;
    }

    public ArrayList<Answer> getAnswers(){
        return mAnswers;
    }
    public void attachName(String name){
        mSurveyedName =name;
    }
    public String getSurveyedName(){
        return mSurveyedName;
    }
}
