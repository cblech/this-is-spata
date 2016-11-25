import java.awt.Color;
import java.awt.Graphics;

public class WcLine extends WcGraphics{
	WcPoint start, ziel;

	public WcLine(WcPoint p1, WcPoint p2) {
		this.start = p1;
		this.ziel = p2;
	}

	public WcLine(double startx, double starty, double zielx, double ziely) {
		this.start = new WcPoint(startx, starty);
		this.ziel = new WcPoint(zielx, ziely);
	}
	
	@Override
	public void draw(Graphics g){
		//g.setColor(Color.getHSBColor((float)(Math.random()*260), (float)(Math.random()), (float)(Math.random())));
		g.setColor(Color.black);
		g.drawLine(start.getPixelX(), start.getPixelY(), ziel.getPixelX(), ziel.getPixelY());
	}
}
