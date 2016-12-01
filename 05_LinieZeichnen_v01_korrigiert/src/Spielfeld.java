import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Spielfeld extends WcGraphics {
	ArrayList<WcGraphics> list = new ArrayList<WcGraphics>();

	WcRectangle[][] feld = new WcRectangle[10][10];

	public Spielfeld() {
		for (int i = 0; i < feld.length; i++) {
			for (int j = 0; j < feld[i].length; j++) {
				feld[i][j] = new WcRectangle(new WcPoint((double) i / 10, (double) j / 10),
						new WcPoint(((double) i + 1) / 10, ((double) j + 1) / 10), null, Color.black);
				list.add(feld[i][j]);
			}
		}
	}

	@Override
	public void draw(Graphics g) {
		for (WcGraphics graphic : list) {
			graphic.draw(g);
		}
	}
}