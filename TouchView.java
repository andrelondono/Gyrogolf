package com.example.andre.gyrogolf;

import android.view.MotionEvent;

/**
 * Created by andre on 5/19/16.
 */
public class TouchView {
    private Drawable mIcon;
    private float mPosX;
    private float mPosY;

    private float mLastTouchX;
    private float mLastTouchY;
    private MotionEvent m;

    public TouchView(Context context) {
        this(context, null, 0);
    }

    public TouchView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TouchView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mIcon = context.getResources().getDrawable(R.drawable.icon);
        mIcon.setBounds(0, 0, mIcon.getIntrinsicWidth(), mIcon.getIntrinsicHeight());
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        canvas.translate(mPosX, mPosY);
        mIcon.draw(canvas);
        canvas.restore();
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        // when a user place ginger on screen triggers on touch event
        public boolean onTouchEvent(MotionEvent event){

            int action = MotionEventCompat.getActionMasked(event);

            switch(action) {
                case (MotionEvent.ACTION_DOWN) :
                    Log.d(DEBUG_TAG,"Action was DOWN");
                    return true;
                case (MotionEvent.ACTION_MOVE) :
                    Log.d(DEBUG_TAG,"Action was MOVE");
                    return true;
                case (MotionEvent.ACTION_UP) :
                    Log.d(DEBUG_TAG,"Action was UP");
                    return true;
                case (MotionEvent.ACTION_CANCEL) :
                    Log.d(DEBUG_TAG,"Action was CANCEL");
                    return true;
                case (MotionEvent.ACTION_OUTSIDE) :
                    Log.d(DEBUG_TAG,"Movement occurred outside bounds " +
                            "of current screen element");
                    return true;
                default :
                    return super.onTouchEvent(event);
            }
            return true;
    }
}
}
