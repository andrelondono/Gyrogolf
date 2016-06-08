

package com.example.andre.gyrogolf;                                                                        
                                                                                                           
import android.app.Activity;                                                                               
import android.content.Intent;                                                                             
import android.graphics.drawable.Drawable;                                                                 
import android.graphics.drawable.PictureDrawable;                                                          
import android.os.CountDownTimer;                                                                          
import android.provider.Settings;                                                                          
import android.view.SurfaceHolder;                                                                         
import android.view.SurfaceView;                                                                           
import android.view.View;                                                                                  
import android.view.MotionEvent;                                                                           
import android.graphics.*;                                                                                 
import android.content.Context;                                                                            
import java.io.*;                                                                                          
import java.util.ArrayList;                                                                                
import java.util.List;                                                                                     
import java.util.Timer;                                                                                    
import android.os.CountDownTimer;                                                                          
                                                                                                           
import android.content.res.Resources;                                                                      
import android.view.ViewGroup;                                                                             
import android.widget.TextView;                                                                            
                                                                                                           
import org.w3c.dom.Text;                                                                                   
                                                                                                           
/**                                                                                                        
 * Created by andre on 5/25/16.                                                                            
 */                                                                                                        
public class BallView extends View{                                                                        
     //make sure hole and ball is not overlapping with obstacle                                            
    //make sure ball does not spawn outside of bounds                                                      
                                                                                                           
                                                                                                           
    private int xMin = 0;          // This view's bounds                                                   
    private int xMax;                                                                                      
    private int yMin = 0;                                                                                  
    private int yMax;                                                                                      
    //boolean canDraw = false;                                                                             
    private int scores;
    private final float FRICTION = (float) (new Float(-.5));
                                                                                                           
   // Bitmap mBitmap; //BitmapFactory.decodeFile("/Users/andre/AndroidStudioProjects/Gyrogolf/app/src/main/
    //File f = new File("/data/data/com.example.andre.gyrogolf/res/drawable/green.jpg");                   
  //  Bitmap mBitmap;// = BitmapFactory.decodeResource(this.getResources(),R.drawable.green);              
    private float ballRadius = 80; // Ball's radius                                                        
    private float ballX = ballRadius + 20;  // Ball's center (x,y)                                         
    private float ballY = ballRadius + 40;                                                                 
    private float ballSpeedX = 5;  // Ball's speed (x,y)                                                   
    private float ballSpeedY = 3;                                                                          
    public float previousX;                                                                                
    public float previousY;                                                                                
    private float holeX;                                                                                   
    private float holeY;                                                                                   
    private float holeRadius = 100;                                                                        
    private RectF ballBounds;      // Needed for Canvas.drawOval                                           
    private Paint paint;                                                                                   
     private Paint paintb;                                                                                 
    private Paint painto;                                                                                  
    private RectF holeBounds;                                                                              
   // Timer time = new Timer();                                                                            
    private TextView time;                                                                                 
   // int time = 1000;                                                                                     
    private List<Obstacle> obsList;                                                                        
                                                                                                           
    // The paint used for drawing                                                                          
                                                                                                           
    // Constructor                                                                                         
    public BallView(Context context) {                                                                     
        super(context);                                                                                    
        ballBounds = new RectF();                                                                          
        holeBounds = new RectF();                                                                          
        paint = new Paint();                                                                               
        paintb = new Paint();                                                                              
        painto = new Paint();                                                                              
        obsList = new ArrayList<Obstacle>();                                                               
        this.setFocusableInTouchMode(true);                                                                
                                                                                                           
    }                                                                                                      
                                                                                                           
                                                                                                           
     /* new CountDownTimer(30000, 1000);  {                                                                
                                                                                                           
         public void onTick(long millisUntilFinished) {                                                    
            time.setText("seconds remaining: " + millisUntilFinished / 1000);                              
         }                                                                                                 
                                                                                                           
         public void onFinish() {                                                                          
             time.setText("done!");                                                                        
         }                                                                                                 
      }.start();                                                                                           
        */                                                                                                 
                                                                                                           
                                                                                                           
    // Called back to draw the view. Also called by invalidate().                                          
    @Override                                                                                              
    protected void onDraw(Canvas canvas) {                                                                 
        super.onDraw(canvas);                                                                              
       // Bitmap temp;                                                                                     
        // draw background                                                                                 
                                                                                                           
       // System.out.println(mBitmap);                                                                     
      //  temp =  BitmapFactory.decodeResource(this.getResources(),R.drawable.greenb);                     
       // mBitmap = Bitmap.createScaledBitmap(temp, canvas.getWidth(), canvas.getHeight(), true);          
        //canvas.drawBitmap(mBitmap,0,0,null);                                                             
       canvas.drawColor(Color.GREEN);                                                                      
      //  canvas.drawColor(#009900);                                                                       
                                                                                                           
        //draw the hole                                                                                    
        holeBounds.set(holeX-holeRadius, holeY-holeRadius, holeX+holeRadius, holeY+holeRadius);            
        paintb.setColor(Color.BLACK);                                                                      
        canvas.drawOval(holeBounds, paintb);                                                               
                                                                                                           
        // Draw the ball                                                                                   
        ballBounds.set(ballX-ballRadius, ballY-ballRadius, ballX+ballRadius, ballY+ballRadius);            
        paint.setColor(Color.WHITE);                                                                       
                                                                                                           
        canvas.drawOval(ballBounds, paint);                                                                
                                                                                                           
        painto.setColor(Color.DKGRAY);                                                                     
        for(Obstacle o : obsList) {                                                                        
                    o.draw(canvas, painto);                                                                
                }                                                                                          
                                                                                                           
                                                                                                           
        canvas.drawText("Scores: "+scores ,1000, 30, paintb );                                             
        canvas.drawText("TimeLeft: " + time, 950, 50, paintb);                                             
                                                                                                           
                                                                                                           
        // Update the position of the ball, including collision detection and reaction.                    
        update();                                                                                          
                                                                                                           
        // Delay                                                                                           
        try {                                                                                              
            Thread.sleep(30);                                                                              
        } catch (InterruptedException e) { }                                                               
                                                                                                           
        invalidate();  // Force a re-draw                                                                  
    }                                                                                                      
                                                                                                           
    // Detect collision and update the position of the ball.                                               
    private void update() {                                                                                
        // Get new (x,y) position                                                                          
        ballX += ballSpeedX;
        if(Math.abs(ballSpeedX) > FRICTION) {
          if(ballSpeedX > 0)
            ballSpeedX += FRICTION;
          else
            ballSpeedX -= FRICTION;
        } else
          ballSpeedX = 0;
        ballY += ballSpeedY;  
        if(Math.abs(ballSpeedY) > FRICTION) {
          if(ballSpeedY > 0)
            ballSpeedY += FRICTION;
          else
            ballSpeedY -= FRICTION;
        } else
          ballSpeedY = 0;

        // Detect collision and react                                                                      
       // this.checkObsCollision(ballX, ballY, ballRadius);                                                
           if (checkObsCollision(ballX, ballY, ballRadius) == 1) {                                         
               ballSpeedX = -ballSpeedX;                                                                   
           }                                                                                               
           else if(checkObsCollision(ballX, ballY, ballRadius) == 2) {                                     
               ballSpeedY = -ballSpeedY;                                                                   
           }                                                                                               
                                                                                                           
                                                                                                           
        if (ballX + ballRadius > xMax) {                                                                   
            ballSpeedX = -ballSpeedX;                                                                      
            ballX = xMax-ballRadius;                                                                       
        } else if (ballX - ballRadius < xMin) {                                                            
            ballSpeedX = -ballSpeedX;                                                                      
            ballX = xMin+ballRadius;                                                                       
        }                                                                                                  
        if (ballY + ballRadius > yMax) {                                                                   
            ballSpeedY = -ballSpeedY;                                                                      
            ballY = yMax - ballRadius;                                                                     
        } else if (ballY - ballRadius < yMin) {                                                            
            ballSpeedY = -ballSpeedY;                                                                      
            ballY = yMin + ballRadius;                                                                     
        }                                                                                                  
                                                                                                           
        if(Math.abs(ballX-holeX)<= 20 && Math.abs(ballY-holeY)<= 20){                                      
            System.out.println("match");                                                                   
            scores++;                                                                                      
            obsList.clear();                                                                               
            this.onSizeChanged(xMax+1, yMax+1, 0, 0);                                                      
                                                                                                           
        }                                                                                                  
                                                                                                           
                                                                                                           
    }                                                                                                      
      private int checkObsCollision(float ballX, float ballY, float ballRadius) {                          
                                                                                                           
          for (int i = 0; i < obsList.size(); i++) {                                                       
              if (obsList.get(i).contact(ballX, ballY, ballRadius) != 0) {                                 
                  return obsList.get(i).contact(ballX, ballY, ballRadius);                                 
              }                                                                                            
          }                                                                                                
          return 0;                                                                                        
      }                                                                                                    
                                                                                                           
          /* for(Obstacle o : obsList) {                                                                   
                if (o.contact(ballX, ballY, ballRadius) != 0) {                                            
                    return o.contact(ballX, ballY, ballRadius);                                            
                }                                                                                          
            }                                                                                              
            return 0;                                                                                      
        }                                                                                                  
         */                                                                                                
                                                                                                           
    // Called back when the view is first created or its size changes.                                     
    @Override                                                                                              
    public void onSizeChanged(int w, int h, int oldW, int oldH) {                                          
        // Set the movement bounds for the ball                                                            
        xMax = w-1;                                                                                        
        yMax = h-1;                                                                                        
        holeX = new Float(Math.random()* (xMax - 200) + 100);                                              
        holeY = new Float(Math.random()* (yMax - 200) + 100);                                              
        generateObstacles();                                                                               
    }                                                                                                      
                                                                                                           
    private void generateObstacles() {                                                                                                                                                                
         int longSide = (int)(xMax / 2);                                                                                                                                                           
         int shortSide = longSide / 4;                                                                                                                                                             
         int squareSide = longSide / 2;                                                                                                                                                            
         for (int i = 0; i < 2; i++) {                                                                                                                                                             
             if (Math.random() > .5) {                                                                                                                                                             
                 Obstacle o = new Obstacle((float) (new Float(Math.random() * xMax)), (float) (new Float(Math.random() * yMax)),(float)( new Float(longSide)), (float) (new Float(shortSide)));    
                 if(o.contact(ballX, ballY, ballRadius) != 0 && o.contact(holeX, holeY, holeRadius) != 0)
                    continue;
                 obsList.add(o);                                                                                                                                                                   
             }                                                                                                                                                                                     
             if (Math.random() <= .5) {                                                                                                                                                            
                 Obstacle o = new Obstacle( (float) (new Float(Math.random() * xMax)),(float) (new Float(Math.random() * yMax)), (float) (new Float(shortSide)), (float)( new Float(longSide)));   
                 if(o.contact(ballX, ballY, ballRadius) != 0 && o.contact(holeX, holeY, holeRadius) != 0)
                    continue;
                 obsList.add(o);                                                                                                                                                                   
             }                                                                                                                                                                                     
         }                                                                                                                                                                                         
         if (Math.random() > .4) {                                                                                                                                                                 
        //     obsList.add(new Obstacle(Math.random() * xMax, Math.random() * yMax, squareSide, squareSide));                                                                                      
           Obstacle a = new Obstacle( (float) (new Float(Math.random() * xMax)),(float) (new Float(Math.random() * yMax)), (float) (new Float(squareSide)), (float)( new Float(squareSide)));     
           if(a.contact(ballX, ballY, ballRadius) != 0 && a.contact(holeX, holeY, holeRadius) != 0)
              return;
           obsList.add(a);
           
         }                                                                                                                                                                                         
     }                                                                                                                                                                                             
                                                                                                           
                                                                                                           
                                                                                                         
    // Touch-input handler                                                                                 
    @Override                                                                                              
    public boolean onTouchEvent(MotionEvent event) {                                                       
        float currentX = event.getX();                                                                     
        float currentY = event.getY();                                                                     
        float deltaX, deltaY;                                                                              
        float scalingFactor = 10.0f / ((xMax > yMax) ? yMax : xMax);                                       
        switch (event.getAction()) {                                                                       
            case MotionEvent.ACTION_MOVE:                                                                  
                // Modify rotational angles according to movement                                          
                deltaX = currentX - previousX;                                                             
                deltaY = currentY - previousY;                                                             
                ballSpeedX += deltaX * scalingFactor;                                                      
                ballSpeedY += deltaY * scalingFactor;                                                      
        }                                                                                                  
        // Save current x, y                                                                               
        previousX = currentX;                                                                              
        previousY = currentY;                                                                              
        return true;  // Event handled                                                                     
    }                                                                                                      
                                                                                                           
                                                                                                           
}                                                                                                          
                                                                                                           
                                                                                                           
                                                                                                           
                                                                                                           
                                                                                                           
















