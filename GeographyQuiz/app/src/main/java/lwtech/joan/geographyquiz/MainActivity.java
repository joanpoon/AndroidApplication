package lwtech.joan.geographyquiz;


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

            mQuestionTextView = findViewById(R.id.question_text_view);
            int question = mQuestionBank[mCurrentIndex].getQuestion();
            mQuestionTextView.setText(question);

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

    }