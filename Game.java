package com.example.andre.gyrogolf; /**
 * Created by andre on 5/17/16.
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;


public class Game extends Activity implements GestureDetector.OnGestureListener {


    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //turn title off
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //set to full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(new GamePanel(this));
    }

    protected void onStart() {

    }

    public void setContentView(View v) {

    }

    public boolean onFling(MotionEvent e1, MotionEvent e2, float VelocityX, float velocityY) {

    }

    public void onLongPress(MotionEvent e3) {
    }

    public boolean onScroll(MotionEvent e4, MotionEvent e5, float distanceX, float distanceY) {

    }

    public void onShowPress(MotionEvent e6) {

    }

    public boolean onSingleTapUp(MotionEvent e7) {

    }

    public boolean onDown(MotionEvent e8) {

    }


}
