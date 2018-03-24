package ljusas.com.concerts;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ljusas.com.concerts.net.MyService;
import ljusas.com.concerts.net.model.Event;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Email = new Intent(Intent.ACTION_SEND);
                Email.setType("text/email");
                Email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"ljusa@sbb.rs"});  //developer 's email
                Email.putExtra(Intent.EXTRA_SUBJECT,
                        getString(R.string.subject)); // Email 's Subject
                Email.putExtra(Intent.EXTRA_TEXT, getString(R.string.developer) + "");  //Email 's Greeting text
                startActivity(Intent.createChooser(Email, getString(R.string.feedback)));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        final EditText input = (EditText) findViewById(R.id.input_artist);

        Button metallicaB = (Button)findViewById(R.id.button_metallica);
        metallicaB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getArtistByName(input.getText().toString());
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                break;
            case R.id.action_show_image:
                showRandomImage();
                break;
            case R.id.action_about:
                dialog = new AboutDialog(MainActivity.this).prepareDialog();
                dialog.show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showRandomImage() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.band_layout);

        ImageView image = (ImageView) dialog.findViewById(R.id.band_image);

        Picasso.with(this).load("https://source.unsplash.com/random").into(image);

        dialog.show();
    }

    private void getArtistByName(String name){
        Map<String, String> query = new HashMap<String, String>();
        query.put("app_id", "test");

        Call<List<Event>> call = MyService.apiInterface().getArtistByName(name, query);
        call.enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {

                if (response.code() == 200){
                    List<Event> events = response.body();

                    if (events.size() > 0){

                        String[] data = new String[events.size()];

                        for (int i=0; i<events.size();i++){
                            data[i] = events.get(i).getVenue().getName()+" : "+events.get(i).getDatetime();
                        }

                        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                        intent.putExtra("data", data);
                        startActivity(intent);
                        Toast.makeText(MainActivity.this, "Prikaz liste koncerata", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(MainActivity.this, "Nema koncerata", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {
                //u slucaju da je nesto poslo po zlu, ispisemo sta nije u redu tj sta je poruka greske
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
