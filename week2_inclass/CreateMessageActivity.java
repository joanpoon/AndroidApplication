package com.example.thomasabbott.multiipleactivitesandintents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateMessageActivity extends Activity {
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);

        editText = findViewById( R.id.message) ;
    }

    public void onSendMessage_explicitly( View view ) {
        // extract string from the edit text control
        String etextString = editText.getText().toString();

        // create an intent to start the other activity
        Intent intent = new Intent( this, ReceiveMessageActivity.class );

        // attach key/value pair to the intent
        intent.putExtra( ReceiveMessageActivity.EXTRA_MESSAGE, etextString );

        // start the receive message activity
        startActivity( intent );
    }

    public void onSendMessage_implicitly( View view ) {
        // get the message fromm the EditText whose id is R.id.message
        String editTextString = editText.getText().toString();

        Intent intent = new Intent( Intent.ACTION_SEND );
        intent.setType( "text/plain" );

        intent.putExtra( Intent.EXTRA_TEXT, editTextString );
        startActivity( intent );
    }
}
