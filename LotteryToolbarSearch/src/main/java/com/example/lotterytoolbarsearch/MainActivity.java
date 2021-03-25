package com.example.lotterytoolbarsearch;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter adapter;

    // GUI controls
    private Toolbar tbSearch;
    private ListView lvPlayers;
    private TextView tvNoResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Getting references to the Toolbar, ListView and TextView
        tbSearch = findViewById(R.id.tbSearch);
        // Set Toolbar as ActionBar
        if (tbSearch != null)
            setSupportActionBar(tbSearch);

        lvPlayers = findViewById(R.id.lvPlayers);
        tvNoResults = findViewById(R.id.tvNoResults);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.players));
        lvPlayers.setAdapter(adapter);
        lvPlayers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });
        // TextView Message about "No results"
        lvPlayers.setEmptyView(tvNoResults);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem mSearch = menu.findItem(R.id.appSearchBar);
        SearchView mSearchView = (SearchView) mSearch.getActionView();
        mSearchView.setQueryHint("Search");
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // This method can be used when a query is submitted e.g.
                // creating search history using SQLite DB
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Called when the query text is changed by the user
                adapter.getFilter().filter(newText);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}