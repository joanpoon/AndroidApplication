package lwtech.joan.poon_csd230_assignment2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CreateMessageActivity extends Activity {
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);

        editText = findViewById(R.id.message);
    }

    public void onSendMessage_explicitly(View view) {
        // extract string from the edit text control
        String etextString = editText.getText().toString();

        // create an intent to start the other activity
        Intent intent = new Intent(this, ReceiveMessageActivity.class);

        // attach key/value pair to the intent
        intent.putExtra(ReceiveMessageActivity.EXTRA_MESSAGE, etextString);

        // start the receive message activity
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                //when user click ok, get count of word, line and char
                int wordCount = data.getIntExtra("wordCount", 0);
                int lineCount = data.getIntExtra("lineCount", 0);
                int charCount = data.getIntExtra("charCount", 0);

                //print the message in textview
                String printMessage = "There are " + charCount + " characters, " + wordCount + " words, and " + lineCount + " lines" ;
                TextView textView = (TextView) findViewById(R.id.outputText);
                textView.setText(printMessage);
            }
            if (resultCode == RESULT_CANCELED) {
                //print cancel message if the cancel button is clicked
                TextView textView = (TextView) findViewById(R.id.outputText);
                textView.setText("Activity was canceled.");
            }

        }
    }
}
