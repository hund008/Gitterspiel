import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MalPanel extends JPanel {
	GitterSpiel frame;

	public MalPanel(GitterSpiel frame) {
		this.frame = frame;
		frame.inizcell();
	}

	public void paintComponent(Graphics g) {
		for (int i = 0; i < 60; i++) {
			g.drawLine(20, 20 + i * 20, 1200, 20 + i * 20);
			g.drawLine(20 + i * 20, 20, 20 + i * 20, 850);
		}
		for (int i = 0; i < 61; i++) {
			for (int j = 0; j < 61; j++) {
				if (frame.cell[i][j] == 1)
					g.fillRect(i * 20, j * 20, 20, 20);
			}
		}
		g.drawOval(frame.px, frame.py, 20, 20);
		g.fillOval(frame.px, frame.py, 20, 20);
//		g.setColor(Color.red);
//		g.fillOval(KI.dx, KI.dy, 20, 20);
		g.setColor(Color.black);

	}
}