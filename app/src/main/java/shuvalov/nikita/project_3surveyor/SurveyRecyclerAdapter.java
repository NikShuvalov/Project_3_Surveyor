package shuvalov.nikita.project_3surveyor;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

import shuvalov.nikita.project_3surveyor.Likert.LikertAnswer;
import shuvalov.nikita.project_3surveyor.Likert.LikertQuestion;

/**
 * Created by NikitaShuvalov on 11/19/16.
 */

public class SurveyRecyclerAdapter extends RecyclerView.Adapter{
    private ArrayList<Question> mQuestions;

    public SurveyRecyclerAdapter(ArrayList<Question> questions) {
        mQuestions = questions;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==0){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.likert_scale_form, null);
            return new LikertScaleHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        switch(holder.getItemViewType()) {
            case 0:
                ((LikertScaleHolder) holder).bindDataToViews((LikertQuestion) mQuestions.get(position));
                ((RadioGroup) holder.itemView.findViewById(R.id.radio_group)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        ReplyRecorder.getInstance().addAnswer(position, new LikertAnswer(i));
                    }
                });
                break;
        }
    }



    @Override
    public int getItemCount() {
        return mQuestions.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (LikertQuestion.class.equals(mQuestions.get(position).getClass())){
            return 0;
        }else{
            return -1;
        }
    };
}

class LikertScaleHolder extends RecyclerView.ViewHolder{
    private RadioGroup mRadioGroup;
    private RadioButton mRadioButton1, mRadioButton2, mRadioButton3, mRadioButton4, mRadioButton5;
    private TextView mQuestionView, mFloorDefine, mCeilingDefine;

     LikertScaleHolder(View itemView) {
         super(itemView);
         mRadioGroup = (RadioGroup) itemView.findViewById(R.id.radio_group);
         mRadioButton1 = (RadioButton)itemView.findViewById(R.id.opt_1);
         mRadioButton2 = (RadioButton)itemView.findViewById(R.id.opt_2);
         mRadioButton3 = (RadioButton)itemView.findViewById(R.id.opt_3);
         mRadioButton4 = (RadioButton)itemView.findViewById(R.id.opt_4);
         mRadioButton5 = (RadioButton)itemView.findViewById(R.id.opt_5);
         mQuestionView = (TextView)itemView.findViewById(R.id.question_prompt);
         mFloorDefine = (TextView)itemView.findViewById(R.id.low_text);
         mCeilingDefine = (TextView)itemView.findViewById(R.id.high_text);
    }

    public void bindDataToViews(LikertQuestion likertQuestion){
        mQuestionView.setText(likertQuestion.getQuestionPrompt());
        mFloorDefine.setText(likertQuestion.getFloor());
        mCeilingDefine.setText(likertQuestion.getCeiling());
    }


}
