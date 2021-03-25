package com.example.lotterytoolbardev;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;


public class MainActivity extends AppCompatActivity {

    private ShareActionProvider shareActionProvider;
    public final static String YOUTUBEID = "ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Getting the Toolbar
        Toolbar toolbar = findViewById(R.id.tbDev);

        // Setting the title
        toolbar.setTitle("Toolbar Development");

        // Placing Toolbar instead of Actionbar
        setSupportActionBar(toolbar);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        // Locate MenuItem with ShareActionProvider
        MenuItem menuItem = menu.findItem(R.id.mnuShare);
        // Fetch and store ShareActionProvider
        shareActionProvider =
                (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        // Return true to display menu
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String youTubeVideoID = "6G-Rg9huy90";

        switch (item.getItemId()) {
            case R.id.mnuVideo:
                Intent myIntent = new Intent(MainActivity.this, YouTubeActivity.class);
                myIntent.putExtra(YOUTUBEID, youTubeVideoID);
                startActivity(myIntent);
                break;

            case R.id.mnuShare:
                setShareActionIntent("Do you like to play Euro Millions?");
                break;

            case R.id.mnuQuit:
                finish();
                break;
        }
        return true;
    }


    private void setShareActionIntent(String text) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);

        if (shareActionProvider != null) {
            // Call to update the share intent
            shareActionProvider.setShareIntent(intent);
        }
    }

}