package com.example.andre.gyrogolf;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by andre on 6/3/16.
 */
public class Obstacle {

    //make sure obstacles dont spawn over hole
    //detect ball collision with obstacles
    //make sure hole doesnt spawn outside of bounds

    private float xCoord;
    private float yCoord;
    private float width;
    private float height;
    private float leftVert;
    private float rightVert;
    private float top;
    private float bottom;

    public Obstacle(float xCoord, float yCoord, float width, float height) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.width = width;
        this.height = height;
        leftVert = xCoord - (width / 2);
        rightVert = leftVert + width;
        top = yCoord - (height / 2);
        bottom = top + height;
    }

    public int contact(float ballX, float ballY, float rad) {
        if (xBounce(ballX, ballY, rad))
            return 1;
        else if(yBounce(ballX, ballY, rad))
            return 2;
        else
            return 0;

    }


    public boolean xBounce(float ballX, float ballY, float rad) {
        if (ballX + rad > leftVert && ballX + rad < rightVert){
            if (ballY > top && ballY < bottom) {
                System.out.println("&&&&&&&&&&& SOMETHING IS HAPPENING &&&&&&&&&&");
                return true;
            }
        }
        else if (ballX - rad > leftVert && ballX - rad < rightVert){
            if (ballY > top && ballY < bottom) {
                System.out.println("&&&&&&&&&&& SOMETHING IS HAPPENING &&&&&&&&&&");
                return true;
            }
        }
            return false;
    }
    public boolean yBounce(float ballX, float ballY, float rad) {
        if (ballY + rad > top && ballY + rad < bottom){
            if (ballX > leftVert && ballX < rightVert) {
                System.out.println("&&&&&&&&&&& SOMETHING IS HAPPENING &&&&&&&&&&");
                return true;
            }
        }
        else if (ballY - rad > top && ballY - rad < bottom) {
            if (ballX > leftVert && ballX < rightVert) {
                System.out.println("&&&&&&&&&&& SOMETHING IS HAPPENING &&&&&&&&&&");
                return true;
            }
        }

            return false;
    }





