
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JfLeinwand extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    WcPoligon auto = new WcPoligon();
    WcKreis reifen1 = new WcKreis(new WcPoint(0.3, 0.6), new WcDistance(0.2), getContentPane().getBackground(), Color.black);
    WcKreis reifen2 = new WcKreis(new WcPoint(0.7, 0.6), new WcDistance(0.2), getContentPane().getBackground(), Color.black);

    WcProgressBar bar;
    JSlider sl = new JSlider();

    ArrayList<WcGraphics> list = new ArrayList<WcGraphics>();

    public static int cpw;

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

        auto.addPoint(0.15, 0.60);
        auto.addPoint(0.20, 0.40);
        auto.addPoint(0.30, 0.40);
        auto.addPoint(0.45, 0.20);
        auto.addPoint(0.65, 0.20);
        auto.addPoint(0.70, 0.40);
        auto.addPoint(0.85, 0.40);
        auto.addPoint(0.85, 0.60);

        list.add(auto);
        list.add(reifen1);
        list.add(reifen2);

        // modifizierte JLabel-Klasse ------------------------------------------
        JLabel lbl_malen = new JLabel() {

            /**
             *
             */
            private static final long serialVersionUID = 1L;

            @Override
            protected void paintComponent(Graphics g) {

                super.paintComponent(g);
                JfLeinwand.cpw = contentPane.getWidth();

                // 1) rhh: Label an Fenstergr��e anpassen
                setBounds(0, 100, contentPane.getWidth(), contentPane.getHeight() - 100);

                // 2) rhh: Labelgr��e an WcPoint-Klasse zur Umrechnung
                // weiterleiten
                WcPoint.maxPixelX = this.getWidth();
                WcPoint.maxPixelY = this.getHeight();

                g.setColor(Color.black);
                for (WcGraphics graphic : list) {
                    graphic.draw(g);
                }
            }
        };
        // --------------------------------------------------------------------
        lbl_malen.setBounds(0, 0, 1, 1);
        contentPane.add(lbl_malen);

        bar = new WcProgressBar(contentPane);

        bar.setBounds(0, 0, 343, 100);

        contentPane.add(bar);

        sl.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent arg0) {
                dochange();
            }
        });

        contentPane.add(sl);
        sl.setSize(484, 31);
        sl.setLocation(0, 100);

    }

    public void dochange() {
        bar.setProgress(sl.getValue());
        repaint();
    }
}
