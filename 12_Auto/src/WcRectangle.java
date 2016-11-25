 

import java.awt.Color;
import java.awt.Graphics;

public class WcRectangle extends WcGraphics{

	private WcPoint pos1;
	private WcPoint pos2;
	
	private Color frameColor;
	private Color fillColor;
	
		
	public WcRectangle (WcPoint ol, WcPoint ur, Color frameColor, Color fillColor){
		this.pos1 = ol;
		this.pos2 = ur;
		
		this.frameColor = frameColor;
		this.fillColor = fillColor;
		
	}
	
	@Override  // optional
	public void draw(Graphics g){
	
		int x = pos1.getPixelX();
		int y = pos1.getPixelY();
		int width = pos2.getPixelX() - pos1.getPixelX();
		int height = pos2.getPixelY() - pos1.getPixelY();
		
		if (fillColor != null){
			g.setColor(fillColor);
			g.fillRect(x, y, width, height);
			
		}
		
		if(frameColor != null){
			g.setColor(frameColor);
			g.drawRect(x, y, width, height);
			
		}
		
		
	}
}
