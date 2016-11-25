public class WcDistance extends WcPoint {

	public WcDistance(double x, double y) {
		super(x, y);
	}

	public WcDistance(double x) {
		super(x, x);
	}

	public int getDistancePixelX() {
		return getPixelX();
	}
	
	public int getDistancePixelY() {
		return getPixelY();
	}

	public int getSmalerDistance() {
		if (getPixelX() < getPixelY()) {
			return getPixelX();
		} else {
			return getPixelY();
		}
	}
	
	public int getBiggerDistance() {
		if (getPixelX() > getPixelY()) {
			return getPixelX();
		} else {
			return getPixelY();
		}
	}
}
