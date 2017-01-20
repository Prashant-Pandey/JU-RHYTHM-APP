package com.yoavi.materialtest1;

import android.app.SearchManager;
import android.content.Intent;
import android.provider.SearchRecentSuggestions;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

public class SearchResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        Toolbar Search_toolbar =(Toolbar)findViewById(R.id.search_result);
        setSupportActionBar(Search_toolbar);

        String query= new String();
        Intent search = getIntent();
        if(Intent.ACTION_SEARCH.equals(search.getAction())){

            query = search.getStringExtra(SearchManager.QUERY);
            getSupportActionBar().setTitle(query);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            Toast.makeText(SearchResultsActivity.this,query,Toast.LENGTH_LONG).show();

            SearchRecentSuggestions searchRecentSuggestions = new SearchRecentSuggestions(this,SearchableProvider.AUTHORITY,SearchableProvider.MODE);
            searchRecentSuggestions.saveRecentQuery(query,null);
        }
    }
}
