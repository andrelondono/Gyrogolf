import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Green {
	private GreenCanvas canvas;
	private final int DELAY = 100;
	private Timer time;
	
	public Green(GreenCanvas canvas) {
		this.canvas = canvas;
		startTimer();
	}
	private void startTimer() {
		time = new Timer(DELAY, new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				canvas.repaint();
			}
		});
		time.start();
	}
}