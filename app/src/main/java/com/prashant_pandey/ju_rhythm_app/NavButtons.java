package com.yoavi.materialtest1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Chikki on 1/16/2017.
 */

public class NavButtons extends Activity implements View.OnClickListener {
    Button home, Events, maps, Sponsors, ContactUs,Developers,Feedback;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button);

        home=(Button)findViewById(R.id.home);
        home.setOnClickListener(this);

        Events=(Button)findViewById(R.id.event);
        Events.setOnClickListener(this);

        maps=(Button)findViewById(R.id.maps);
        maps.setOnClickListener(this);

        Sponsors=(Button)findViewById(R.id.sponsors);
        Sponsors.setOnClickListener(this);

        ContactUs=(Button)findViewById(R.id.contact);
        ContactUs.setOnClickListener(this);

        Developers=(Button)findViewById(R.id.developers);
        Developers.setOnClickListener(this);

        Feedback=(Button)findViewById(R.id.feedback);
        Feedback.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        DrawerLayout mDrawerLayout;
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        mDrawerLayout.closeDrawers();
        switch (v.getId()){
            case R.id.home:
            {

                Toast.makeText(getApplicationContext(),"Clicked on home",Toast.LENGTH_LONG).show();
                //Intent i = new Intent(this, Homepage_MainActivity.class);
                //startActivity(i);
                break;
            }
            case R.id.event:
            {
                Toast.makeText(getParent(),"Clicked on Event",Toast.LENGTH_LONG).show();
                //Intent i = new Intent(this, Homepage_MainActivity.class);
                //startActivity(i);
                break;
            }
            case R.id.maps:
            {
                Toast.makeText(this,"Clicked on maps",Toast.LENGTH_SHORT).show();
            }
            case R.id.sponsors:
            {
                Toast.makeText(this,"Clicked on sponsors",Toast.LENGTH_LONG).show();
                //Intent i = new Intent(this, Homepage_MainActivity.class);
                //startActivity(i);
                break;
            }
            case R.id.contact:
            {
                Toast.makeText(this,"Clicked on contactus",Toast.LENGTH_LONG).show();
                //Intent i = new Intent(this, Homepage_MainActivity.class);
                //startActivity(i);
                break;
            }
            case R.id.developers:
            {
                Toast.makeText(this,"Clicked on developers",Toast.LENGTH_LONG).show();
                //Intent i = new Intent(this, Homepage_MainActivity.class);
                //startActivity(i);
                break;
            }
            case R.id.feedback:
            {
                Toast.makeText(this,"Clicked on feedback",Toast.LENGTH_LONG).show();
                //Intent i = new Intent(this, Homepage_MainActivity.class);
                //startActivity(i);
                break;
            }
        }

    }
}
