 

import java.awt.Color;
import java.awt.Graphics;

public class WcCircle extends WcGraphics{

	private WcPoint wcCenter;
	private double wcRadius;
	
	private Color frameColor;
	private Color fillColor;
	
		
	public WcCircle (WcPoint wcCenter, double wcRadius, Color frameColor, Color fillColor){
		this.wcCenter = wcCenter;
		this.wcRadius = wcRadius;
		
		this.frameColor = frameColor;
		this.fillColor = fillColor;
		
	}
	
	@Override  // optional
	public void draw(Graphics g){
	
		// Ursprung von Mitte in obere, linke Ecke verschieben
		int x = wcCenter.getPixelX() - (int)(wcRadius * WcPoint.maxPixelX);
		int y = wcCenter.getPixelY() - (int)(wcRadius * WcPoint.maxPixelY);
		
		// Höhe und Breite aus Radius berechnen
		int width = (int)(2 * wcRadius * WcPoint.maxPixelX);
		int height = (int)(2 * wcRadius * WcPoint.maxPixelY);
		
		if (fillColor != null){
			g.setColor(fillColor);
			g.fillOval(x, y, width, height);
			
		}
		
		if(frameColor != null){
			g.setColor(frameColor);
			g.drawOval(x, y, width, height);
			
		}
		
		
		
	}
}
