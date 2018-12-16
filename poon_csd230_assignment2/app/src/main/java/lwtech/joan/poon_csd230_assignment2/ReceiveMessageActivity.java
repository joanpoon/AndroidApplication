package lwtech.joan.poon_csd230_assignment2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

public class ReceiveMessageActivity extends Activity {
    public static final String  EXTRA_MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);

        // load the incoming intent
        Intent intent = getIntent(  );

        // extract the string from the extra on the intent
        String messageText = intent.getStringExtra( EXTRA_MESSAGE );


        // store the string from the intent into the TextView
        TextView textView = ( TextView ) findViewById( R.id.rMessage );
        textView.setText( messageText );
    }

    public void enter(View view) {
        Intent intent = getIntent();

        //a string variable that gets the string input
        //two string copies for calculating word and character count
        String messageText = intent.getStringExtra( EXTRA_MESSAGE );
        String messageTextCopy1 = messageText.trim();
        String messageTextCopy2 = messageText;

        //declare variables for character, line and word count
        int lineCount = messageText.split("\n").length;
        int wordCount = messageTextCopy1.trim().split("\\s+").length;
        int charCount = messageTextCopy2.replaceAll("\\s+", "").length();

        //save the integers of line, word, character counts to extra
        Intent intentEnter = new Intent( this, CreateMessageActivity.class);
        intentEnter.putExtra("lineCount", lineCount);
        intentEnter.putExtra("wordCount", wordCount);
        intentEnter.putExtra("charCount", charCount);

        setResult(RESULT_OK, intentEnter);
        finish();
    }

    public void cancel(View view) {
        Intent intentCancel = new Intent(this, CreateMessageActivity.class);
        setResult(RESULT_CANCELED, intentCancel);
        finish();
    }
}
