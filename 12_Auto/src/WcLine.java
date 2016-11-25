

import java.awt.Graphics;

public class WcLine extends WcGraphics{

	WcPoint start;
	WcPoint ziel;

	public WcLine(WcPoint start, WcPoint ziel) {
		this.start = start;
		this.ziel = ziel;
	}

	public WcLine(double startx, double starty, double zielx, double ziely) {

		// TRICK:   // this(new WcPoint(starty, startx), new WcPoint(zielx, ziely));
		
		start = new WcPoint(startx, starty);
		ziel = new WcPoint(zielx, ziely);
	}

	@Override  // optional...
	public void draw(Graphics g) {
		g.drawLine(start.getPixelX(), start.getPixelY(), ziel.getPixelX(), ziel.getPixelY());

	}
}