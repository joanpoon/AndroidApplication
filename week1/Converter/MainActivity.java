package lwtech.csd230.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickConvert( View view ) {
        // get a reference to the EditText widget.
        // It's where we get the input for the conversion.
        // Store it in a variable named fromStr.
        EditText edtText = findViewById( R.id.etextFrom );
        String fromStr = edtText.getText().toString();

        // get a reference to the TextView widget.
        // It's where we store the output for the converted value
        TextView txtView = findViewById( R.id.tviewTo );

        // get a string from the spinner that describes the
        // conversion
        Spinner spinner = (Spinner) findViewById( R.id.spnConvert );
        String convStr = spinner.getSelectedItem().toString();

        // TODO - perform the conversion here, storing the 
        // result in result
        long result = 0;
        long numberInput = Long.parseLong(fromStr);

        switch(convStr){
            case "yards to meters":
                result = numberInput * 0.9144;
                break;
            case "meters to yards":
                result = numberInput * 1.094;
                break;
            case "miles to kilometers":
                result = numberInput * 1.609;
                break;
            case "kilometers to miles":
                result = numberInput * 0.6214;
                break;
        }

        // store the converted value as a string in the
        // TextView
        txtView.setText( Long.toString( result ));
    }
}
