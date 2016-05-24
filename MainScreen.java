package com.example.andre.gyrogolf; /**
 * Created by andre on 5/20/16.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;


public class MainScreen extends ActionBarActivity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        }

    public void play(View view){
        Intent newActivity = new Intent(this, DisplayMessageActivity.class);
        startAcitivity(newActivity);
    }

    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu_main_screen, menu);

            return true;

    }


    public boolean onOptionsItemSelected(MenuItem item){

        int id =item.getID();

        if(id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemsSelected(item);

    }
}
