import java.awt.Color;
import java.awt.Graphics;

public class WcKreis extends WcGraphics {

	WcPoint centerPoint;
	WcDistance radius;

	Color fillColor = null;
	Color frameColor = Color.black;

	public WcKreis(WcPoint center, WcDistance radius) {
		this.centerPoint = center;
		this.radius = radius;
	}

	public WcKreis(WcPoint center, WcDistance radius, Color fillColor, Color frameColor) {
		this.centerPoint = center;
		this.radius = radius;
		this.fillColor = fillColor;
		this.frameColor = frameColor;
	}

	@Override
	public void draw(Graphics g) {
		int radPix = radius.getSmalerDistance();
		if (fillColor != null) {
			g.setColor(fillColor);
			g.fillOval(centerPoint.getPixelX()-(radius.getSmalerDistance()/2), centerPoint.getPixelY()-(radius.getSmalerDistance()/2), radPix, radPix);
		}
		if (frameColor != null) {
			g.setColor(frameColor);
			g.drawOval(centerPoint.getPixelX()-(radius.getSmalerDistance()/2), centerPoint.getPixelY()-(radius.getSmalerDistance()/2), radPix, radPix);
		}
	}
}
