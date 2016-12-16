import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JfLeinwand extends JFrame {
	/**
	 * Schiffe Versenken
	 */
	private static final long serialVersionUID = 1L;

	ArrayList<WcGraphics> list = new ArrayList<WcGraphics>();
	
	WcRectangle[][] feld = new WcRectangle[10][10];
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */

	public JfLeinwand() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
			for (int i = 0; i < feld.length; i++) {
				for (int j = 0; j < feld[i].length; j++) {
					feld[i][j] = new WcRectangle(new WcPoint((double) i / feld.length, (double) j / feld.length),
							new WcPoint(((double) i + 1) / feld.length, ((double) j + 1) / feld.length), null, Color.black);
					list.add(feld[i][j]);
				}
			}
		
		


		// modifizierte JLabel-Klasse ------------------------------------------
		JLabel lbl_malen = new JLabel() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {

				super.paintComponent(g);

				// 1) rhh: Label an Fenstergröße anpassen
				setBounds(0, 0, contentPane.getWidth(), contentPane.getHeight());

				// 2) rhh: Labelgröße an WcPoint-Klasse zur Umrechnung
				// weiterleiten
				WcPoint.maxPixelX = this.getWidth() - 1; // -1 to improve
				WcPoint.maxPixelY = this.getHeight() - 1; // alignment

				g.setColor(Color.black);
				for (WcGraphics graphic : list) {
					graphic.draw(g);
				}
			}
		};
		// --------------------------------------------------------------------
		lbl_malen.setBounds(0, 0, 1, 1);
		contentPane.add(lbl_malen);
	}
}
