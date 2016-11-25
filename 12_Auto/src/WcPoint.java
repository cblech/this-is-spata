
public class WcPoint extends WcGraphics {

	double x;
	double y;

	public static int maxPixelX;
	public static int maxPixelY;
	
	public static int actualSiceX;
	public static int actualSiceY;

	WcPoint(double x, double y) {

		this.x = x;
		this.y = y;
	}

	public int getPixelX() {
		return (int) (this.x * this.maxPixelX)+(actualSiceX-maxPixelX)/2;

	}

	public int getPixelY() {
		return (int) (this.y * this.maxPixelY)+(actualSiceY-maxPixelY)/2;
	}

}
