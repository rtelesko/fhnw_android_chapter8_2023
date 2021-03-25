package com.example.lotterytoolbarstart;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Getting the Toolbar
        Toolbar tbExample = findViewById(R.id.tbExample);

        // Setting the title
        tbExample.setTitle("Toolbar Start");

        // See steps for replacing AppBar with Toolbar: https://developer.android.com/training/appbar/setting-up
        setSupportActionBar(tbExample);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.mnuShare:
                Toast.makeText(this, "You clicked 'Share Content'", Toast.LENGTH_SHORT).show();
                break;

            case R.id.mnuVideo:
                Toast.makeText(this, "You clicked 'Youtube Video'", Toast.LENGTH_SHORT).show();
                break;

            case R.id.mnuQuit:
                Toast.makeText(this, "You clicked 'Quit'", Toast.LENGTH_SHORT).show();
                finish();
                break;

        }
        return true;
    }
}