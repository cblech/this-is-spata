//import java.awt.Graphics;
//import java.util.ArrayList;
//
//public class WcContainer extends WcGraphics {
//	ArrayList<WcGraphics> list = new ArrayList<>();
//	WcPoint pos1;
//	WcPoint pos2;
//
//	public WcContainer(WcPoint pos1, WcPoint pos2) {
//		this.pos1 = pos1;
//		this.pos2 = pos2;
//	}
//
//	@Override
//	public void draw(Graphics g) {
//		int x = pos1.getPixelX();
//		int y = pos1.getPixelY();
//		int width = pos2.getPixelX() - pos1.getPixelX();
//		int height = pos2.getPixelY() - pos1.getPixelY();
//
//		int currentMaxPixelX = WcPoint.maxPixelX;
//		int currentMaxPixelY = WcPoint.maxPixelY;
//		int currentContainerModifierX = WcPoint.containerModifierX;
//		int currentContainerModifierY = WcPoint.containerModifierY;
//		
//		WcPoint.maxPixelX = width;
//		WcPoint.maxPixelY = height;
//		WcPoint.containerModifierX = x;
//		WcPoint.containerModifierY = y;
//
//		for (WcGraphics wcGraphic : list) {
//			wcGraphic.draw(g);
//		}
//		
//		WcPoint.maxPixelX=currentMaxPixelX ;
//		WcPoint.maxPixelY=currentMaxPixelY;
//		WcPoint.containerModifierX=currentContainerModifierX;
//		WcPoint.containerModifierY=currentContainerModifierY;
//	}
//
//	public void add(WcGraphics gr) {
//		list.add(gr);
//	}
//}
//