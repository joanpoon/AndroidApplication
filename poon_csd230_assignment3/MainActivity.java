package lwtech.joan.lwtech_joanpoon_lifecyclemethod;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mPrevButton;
    private TextView mQuestionTextView;

    // variable that indicates how many times each life cycle method has been called
    private int onCreateCount = 0;
    private int onRestartCount = 0;
    private int onStartCount = 0;
    private int onResumeCount = 0;
    private int onPauseCount = 0;
    private int onStopCount = 0;

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt("onCreateCount" , onCreateCount);
        savedInstanceState.putInt("onRestartCount" , onRestartCount);
        savedInstanceState.putInt("onStartCountt" , onStartCount);
        savedInstanceState.putInt("onResumeCount" , onResumeCount);
        savedInstanceState.putInt("onPauseCount" , onPauseCount);
        savedInstanceState.putInt("onStopCount" , onStopCount);
    }

    private TrueFalse[] mQuestionBank = new TrueFalse[] {
            new TrueFalse(R.string.question_oceans, true),
            new TrueFalse(R.string.question_mideast, false),
            new TrueFalse(R.string.question_africa, false),
            new TrueFalse(R.string.question_americas, true),
            new TrueFalse(R.string.question_asia, true)
    };

    private int mCurrentIndex = 0;

    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getQuestion();
        mQuestionTextView.setText(question);
    }

    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isTrueQuestion();
        int messageResId = 0;

        if (userPressedTrue == answerIsTrue) {
            messageResId = R.string.correct_toast;
        } else {
            messageResId = R.string.incorrect_toast;
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //update the count of call for onCreate method and the output
        onCreateCount++;
        textOutput();

        if(savedInstanceState != null){
            onCreateCount = savedInstanceState.getInt("onCreateCount");
            onRestartCount = savedInstanceState.getInt("onRestartCount");
            onStartCount = savedInstanceState.getInt("onStartCount");
            onResumeCount = savedInstanceState.getInt("onResumeCount");
            onPauseCount = savedInstanceState.getInt("onPauseCount");
            onStopCount = savedInstanceState.getInt("onStopCount");
        }

        mQuestionTextView = findViewById(R.id.question_text_view);
        mTrueButton = findViewById(R.id.true_button);
        mFalseButton = findViewById(R.id.false_button);
        mPrevButton = findViewById(R.id.prev_button);
        mNextButton = findViewById(R.id.next_button);

        updateQuestion();
    }

    public void onTrueButtonClick( View v ) {
        checkAnswer(true);
    }

    public void onFalseButtonClick( View v ) {
        checkAnswer(false);
    }

    public void onPrevButtonClick( View v ) {
        mCurrentIndex = (mCurrentIndex - 1);
        if(mCurrentIndex < 0) {
            mCurrentIndex = mQuestionBank.length - 1;
        }
        updateQuestion();
    }

    public void onNextButtonClick(View v) {
        mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
        updateQuestion();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //update the count of call for onRestart method and the output
        onRestartCount++;
        textOutput();
    }

    @Override
    protected void onStart() {
        super.onStart();
        ////update the count of call for onStart method and the output
        onStartCount++;
        textOutput();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //update the count of call for onResume method and the output
        onResumeCount++;
        textOutput();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //update the count of call for onPause method and the output
        onPauseCount++;
        textOutput();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //update the count of call for onStop method and the output
        onStopCount++;
        textOutput();
    }

    //this method output the count of call for each life cycle method in the corresponding textview
    protected void textOutput(){
        TextView onCreate = findViewById(R.id.create);
        String createOutput = "onCreate() was called " + onCreateCount + " times.";
        onCreate.setText(createOutput);

        TextView onRestart = findViewById(R.id.restart);
        String restartOutput = "onRestart() was called " + onRestartCount + " times.";
        onRestart.setText(restartOutput);

        TextView onStart = findViewById(R.id.start);
        String startOutput = "onStart() was called " + onStartCount + " times.";
        onStart.setText(startOutput);

        TextView onResume = findViewById(R.id.resume);
        String resumeOutput = "onResume() was called " + onResumeCount + " times.";
        onResume.setText(resumeOutput);

        TextView onPause = findViewById(R.id.pause);
        String pauseOutput = "onPause() was called " + onPauseCount + " times.";
        onPause.setText(pauseOutput);

        TextView onStop = findViewById(R.id.stop);
        String stopOutput = "onStop() was called " + onStopCount + " times.";
        onStop.setText(stopOutput);
    }

}