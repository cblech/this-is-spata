import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class WcProgressBar extends JLabel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	
	float progress;

	
	public WcProgressBar(JPanel contentPane) {
		this.contentPane = contentPane;
		setProgress(50);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBounds(0, 0, contentPane.getWidth(), 100);
		g.setColor(Color.black);
		//g.drawRect(this.getX(), this.getY(), this.getWidth()-1, this.getHeight()-1);
		
		drawWideRect(g,this.getX(), this.getY(), this.getWidth()-1, this.getHeight()-1, 3);
		
		g.setColor(Color.pink);

		//g.setColor(Color.getHSBColor((float)(Math.random()*260), (float)(Math.random()), (float)(Math.random())));
		g.fillRect(this.getX()+5, this.getY()+5,(int) (((this.getWidth()-15-this.getY()+5)*progress)), this.getHeight()-10);
		
		g.setColor(Color.black);
	}
	
	public void drawWideRect(Graphics g, int sx,int sy,int zx,int zy,int lineSice){
		for (int i = 0; i < lineSice; i++) {
			
			g.drawRect(sx+i, sy+i, zx-i-i, zy-i-i);
		}
		
	}

	public void setProgress(float progress) {
		this.progress = progress;
		if (this.progress>1) this.progress = 1;
	}

	public void setProgress(int progress) {
		this.progress =(float) (progress)/100;
		if (this.progress>1) this.progress = 1;
	}
}
