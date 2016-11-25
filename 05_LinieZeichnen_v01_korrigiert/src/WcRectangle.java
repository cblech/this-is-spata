import java.awt.Color;
import java.awt.Graphics;

public class WcRectangle extends WcGraphics{
	WcPoint pos1;
	WcPoint pos2;
	Color frameColor = null;
	Color fillColor = Color.black;

	public WcRectangle(WcPoint pos1, WcPoint pos2) {
		this.pos1 = pos1;
		this.pos2 = pos2;
	}

	public WcRectangle(WcPoint pos1, WcPoint pos2, Color fillColor, Color frameColor) {
		this.pos1 = pos1;
		this.pos2 = pos2;
		this.fillColor = fillColor;
		this.frameColor = frameColor;
	}
	
	@Override
	public void draw(Graphics g) {
		if (fillColor != null) {
			g.setColor(fillColor);
			g.fillRect(pos1.getPixelX(), pos1.getPixelY(), pos2.getPixelX() - pos1.getPixelX(),
					pos2.getPixelY() - pos1.getPixelY());
		}
		if (frameColor != null) {
			g.setColor(frameColor);
			g.drawRect(pos1.getPixelX(), pos1.getPixelY(), pos2.getPixelX() - pos1.getPixelX(),
					pos2.getPixelY() - pos1.getPixelY());
		}
	}
}
