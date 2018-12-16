package lwtech.joan.lwtechjoanpoonquiz5;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends ListActivity {

    private static String[] str = {"one mississippi", "two mississippi", "three mississippi", "four mississippi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ArrayAdapter<String> items = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MainActivity.str);

        ListView listView = getListView();
        listView.setAdapter(items);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, str[position] +"", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
