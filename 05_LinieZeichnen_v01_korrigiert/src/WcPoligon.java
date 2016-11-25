import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;

public class WcPoligon extends WcGraphics{

	ArrayList<WcPoint> points = new ArrayList<>();
	private Color fillColor = null;
	private Color frameColor = Color.black;
	
	
	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}

	public Color getFrameColor() {
		return frameColor;
	}

	public void setFrameColor(Color frameColor) {
		this.frameColor = frameColor;
	}

	
	
	public WcPoligon() {
		
	}
	
	public WcPoligon(ArrayList<WcPoint> points) {
		this.points = points;
	}
	
	public int addPoint(double x, double y){
		return addPoint(new WcPoint(x, y));
	}
	
	public int addPoint(WcPoint point){
		points.add(point);
		return points.indexOf(point);
	}
	
	public Polygon getPoli(){
		return getPoli(this);
	}
	
	public static Polygon getPoli(WcPoligon p){
		
		int[] arrx = new int[p.points.size()];
		int[] arry = new int[p.points.size()];
		
		int i = 0;
		
		for (WcPoint point : p.points) {
			
			arrx[i] = point.getPixelX();
			arry[i] = point.getPixelY();
			
			i++;
		}
		
		return new Polygon(arrx,arry,arrx.length);
	}

	@Override
	public void draw(Graphics g) {
		if (fillColor != null) {
			g.setColor(fillColor);
			g.fillPolygon(getPoli());
		}
		if (frameColor != null) {
			g.setColor(frameColor);
			g.drawPolygon(getPoli());
		}
	}
}