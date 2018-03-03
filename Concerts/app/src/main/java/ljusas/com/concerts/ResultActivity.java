package ljusas.com.concerts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ResultActivity extends AppCompatActivity {

    ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        String[] data =  (String[]) getIntent().getExtras().get("data");

        ListView listView = (ListView) findViewById(R.id.result_listview);

        adapter = new ArrayAdapter<String>(this, R.layout.list_item, data);
        listView.setAdapter(adapter);
    }
}
