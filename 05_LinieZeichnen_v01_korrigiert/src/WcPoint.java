public class WcPoint {

	private double x;
	private double y;

	public static int maxPixelX;
	public static int maxPixelY;

	public static int containerModifierX = 0;
	public static int containerModifierY = 0;

	public WcPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public int getPixelX() {
		int truepixel = (int) (maxPixelX * x);
		return truepixel + containerModifierX;
	}

	public int getPixelY() {
		int truepixel = (int) (maxPixelY * y);
		return truepixel + containerModifierY;
	}
}
