public class Obstacle {

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
		if(xBounce(ballX, ballY, width, height))
			return 1;
		else if(yBounce(ballX, ballY, width, height))
			return 2;
		else
			return 0;
	}
	public boolean xBounce(float xCoord, float yCoord, float rad) {
		if (ballX + rad > leftVert && ballX + rad < rightVert){
			if (ballY > top && ballY < bottom)
				return true;
		}
		else if (ballX - rad > leftVert && ballX - rad < rightVert){
			if (ballY > top && ballY < bottom)
				return true;
		}
		else
			return false;
	}
	public boolean yBounce(float xCoord, float yCoord, float rad) {
		if (ballY + rad > top && ballY + rad < bottom){
			if (ballX > leftVert && ballX < rightVert)
				return true;
		}
		else if (ballY - rad > top && ballY - rad < bottom) {
			if (ballX > leftVert && ballX < rightVert)
				return true;
		}
		else
			return false;
	}

	public float getXCoord() {
		return xCoord;
	}
	public float getYCoord() {
		return yCoord;
	}

	public change(float xCoord, float yCoord, float width, float height) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.width = width;
		this.height = height;
		leftVert = xCoord - (width / 2);
		rightVert = leftVert + width;
		top = yCoord - (height / 2);
		bottom = top + height;
	}
	public void draw(Canvas canvas, Paint paint) {
		canvas.drawRect(leftVert, top, rightVert, bottom, paint);
	}
}
