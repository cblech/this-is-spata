
import java.awt.Graphics;
import java.awt.Color;

public class WcCircle_bak extends WcGraphics {
	private int durchmesser;
	private int centerX;
	private int centerY;

	private Color frameColor;
	private Color fillColor;

	public WcCircle_bak(int centerX, int centerY, int durchmesser, Color frameColor, Color fillColor) {
		this.durchmesser = durchmesser;
		this.centerX = centerX;
		this.centerY = centerY;

	}

	public void draw(Graphics g) {
		g.setColor(frameColor);
		g.drawOval(centerX, centerY, durchmesser, durchmesser);
		g.setColor(fillColor);
	}
}
