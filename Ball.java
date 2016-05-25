
public class Ball {
	private double xCoord, yCoord;
	private double xVel, yVel;
	private double accelX, accelY;
	private final double FRICTION = -.1;
	
	public Ball(double xCoord, double yCoord) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		xVel = 0;
		yVel = 0;
		accelX = 0;
		accelY = 0;
	}
	public double getXCoord() {
		return xCoord;
	}
	public void setXCoord(double xCoord) {
		this.xCoord = xCoord;
	}
	public double getYCoord() {
		return yCoord;
	}
	public void setYCoord(double yCoord) {
		this.yCoord = yCoord;
	}
	public double getXVel() {
		return xVel;
	}
	public void setXVel(double xVel) {
		this.xVel = xVel;
	}
	public double getYVel() {
		return yVel;
	}
	public void setYVel(double yVel) {
		this.yVel = yVel;
	}
	public double getAccelX() {
		return accelX;
	}
	public void setAccelX(double accelX) {
		this.accelX = accelX;
	}
	public double getAccelY() {
		return accelY;
	}
	public void setAccelY(double accelY) {
		this.accelY = accelY;
	}
	
	public void putt(double accelX, double accelY) {
		this.accelX = accelX;
		this.accelY = accelY;
	}
	public void move(){
		this.setXVel(xVel += accelX);
		this.setYVel(yVel += accelY);
		this.setXCoord(xCoord += xVel);
		this.setYCoord(yCoord += yVel);
		if(accelX > 0)
			this.setAccelX(accelX += FRICTION);
		if(accelX < 0)
			this.setAccelY(accelX -= FRICTION);
		if(accelX >= FRICTION)
			this.setAccelX(0.0);
		if(accelY > 0)
			this.setAccelX(accelY += FRICTION);
		if(accelY < 0)
			this.setAccelY(accelY -= FRICTION);
		if(accelY >= FRICTION)
			this.setAccelX(0.0);
		
		
	}
}
