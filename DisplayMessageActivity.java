package com.example.andre.gyrogolf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {

    private static Button button_sbm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OnClickButtonListener();
    }
    //public void play(View view){
       // Intent newActivity = new Intent(this, DisplayMessageActivity.class);
        //startAcitivity(newActivity);
    //}

   /* public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu_main_screen, menu);

        return true;

    }
    */

    public void OnClickButtonListener(){
        button_sbm = (Button)findViewById(R.id.button);
        button_sbm.setOnClickListener(new View.OnClickListener() {
                                          public void onClick(View v) {
                                              Intent intent = new Intent("com.example.andre.gyrogolf.DisplayMessageActivity");
                                              startActivity(intent);
                                          }
                                      }

        );

    }



    protected void onStart() {
        super.onStart();

    }


    @Override
    protected void onResume() {
        super.onResume();

    }


    @Override
    protected void onPause() {
        super.onPause();

    }


    @Override
    protected void onStop() {
        super.onStop();

    }


    @Override
    protected void onRestart() {
        super.onRestart();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }




   /* public boolean onOptionsItemSelected(MenuItem item){

        int id =item.getID();

        if(id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemsSelected(item);

    }
    */

}


