package shuvalov.nikita.project_3surveyor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.util.ArrayList;

import shuvalov.nikita.project_3surveyor.Likert.LikertQuestion;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private EditText mNameEntry;
    private Button mSubmitButt;
    private ArrayList<Question> mQuestionList;
    public SurveyRecyclerAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameEntry = (EditText)findViewById(R.id.name_entry);
        mSubmitButt = (Button)findViewById(R.id.submit_button);
        mQuestionList = new ArrayList<>();
        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);


        generateQuestions();

        ReplyRecorder.getInstance().setNumOfQuestions(mQuestionList.size());

        setUpRecycler();
    }

    public void generateQuestions(){
        mQuestionList.add(new LikertQuestion("How often do you shower?","Rarely", "Always"));
        mQuestionList.add(new LikertQuestion("How much do you love Justin Beiber?", "Despise him", "Worship him"));
        mQuestionList.add(new LikertQuestion("How hungry are right now?", "Starved", "Satiated"));
    }


    public void setUpRecycler(){
        mAdapter = new SurveyRecyclerAdapter(mQuestionList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }



}
