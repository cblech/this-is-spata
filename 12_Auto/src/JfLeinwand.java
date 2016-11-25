
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class JfLeinwand extends JFrame {
	private JPanel contentPane;

	ArrayList<WcGraphics> liste = new ArrayList<WcGraphics>();

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JfLeinwand frame = new JfLeinwand();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JfLeinwand() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// oberes Rechteck
		WcPoint p1 = new WcPoint(0.4, 0.3);
		WcPoint p2 = new WcPoint(0.5, 0.4);

		// unteres Linkseck
		WcPoint p3 = new WcPoint(0.15, 0.4);
		WcPoint p4 = new WcPoint(0.8, 0.6);

		// Verbindungslinie
		WcCircle c1 = new WcCircle(new WcPoint(0.3, 0.6), 0.1, null, Color.black);
		WcCircle c2 = new WcCircle(new WcPoint(0.7, 0.6), 0.1, null, Color.black);

		// WcGraphics-Shapes in Liste packen
		liste.add(new WcRectangle(p1, p2, Color.black, null));
		liste.add(new WcRectangle(p3, p4, Color.black, null));
		liste.add(c1);
		liste.add(c2);

		JLabel lbl_malen = new JLabel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				
				WcPoint.actualSiceX = this.getWidth();
				WcPoint.actualSiceY = this.getHeight();

				if (this.getWidth() < getHeight()) {
					WcPoint.maxPixelY = getWidth();
					WcPoint.maxPixelX = getWidth();
				} else {
					WcPoint.maxPixelY = getHeight();
					WcPoint.maxPixelX = getHeight();
				}

				for (WcGraphics r : liste) {
					r.draw(g);
				}

				this.setBounds(0, 0, contentPane.getWidth(), contentPane.getHeight());
			}
		};

		lbl_malen.setBounds(0, 0, this.getWidth(), this.getHeight());
		contentPane.add(lbl_malen);
	}
}