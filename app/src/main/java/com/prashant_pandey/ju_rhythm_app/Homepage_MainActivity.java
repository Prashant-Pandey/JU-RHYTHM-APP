package com.yoavi.materialtest1;

import android.app.SearchManager;
import android.provider.SearchRecentSuggestions;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class Homepage_MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage_main);

        Toolbar my_toolbar =(Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(my_toolbar);
        getSupportActionBar().setTitle(R.string.my_title);
        getSupportActionBar().setSubtitle(R.string.my_subtitle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationDrawer navigationdrawer=(navigationDrawer) getSupportFragmentManager().findFragmentById(R.id.drawer);
        navigationdrawer.setUp(R.id.drawer,(DrawerLayout) findViewById(R.id.drawerlayout),my_toolbar);

        recyclerView=(RecyclerView) findViewById(R.id.recycler_view);
        layoutManager=new LinearLayoutManager(Homepage_MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        customAdapter= new CustomAdapter(this);
        recyclerView.setAdapter(customAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu,menu);

        SearchView searchView = (SearchView)menu.findItem(R.id.menu_search).getActionView();
        SearchManager searchManager=(SearchManager)getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_1:

                SearchRecentSuggestions searchRecentSuggestion = new SearchRecentSuggestions(this,SearchableProvider.AUTHORITY,SearchableProvider.MODE);
                searchRecentSuggestion.clearHistory();
                Toast.makeText(Homepage_MainActivity.this,"Opening Settings",Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu_2:
                Toast.makeText(Homepage_MainActivity.this,"FAQs",Toast.LENGTH_SHORT).show();
                break;


        }
        return super.onOptionsItemSelected(item);
    }

   // @Override
    //public void onBackPressed() {
      //  DrawerLayout drawer = (DrawerLayout) findViewById(R.id.dr);
        //if (drawer.isDrawerOpen(GravityCompat.START)) {
   //         drawer.closeDrawer(GravityCompat.START);
     //   } else {
       //     super.onBackPressed();
        //}
    //}
}
