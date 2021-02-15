import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GitterSpiel extends JFrame {
	int width = this.getWidth();
	int height = this.getHeight();
	int px = 20;
	int py = 20;
	Color farbe = Color.black;
	int punkte = 0;
	int i = 20;
	int hindernissx = 0;
	int hindernissy = 0;
	private JPanel contentPane;
	int cell[][] = new int[61][61];

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GitterSpiel frame = new GitterSpiel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GitterSpiel() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				System.out.println(y);
				System.out.println(x);
				if (x > 150 && y > 60 && x < 1170 && y < 880) {
					x = (x - 130) / 20;
					y = (y - 40) / 20;
					hindernissx = x;
					hindernissy = y;
					cell[x][y] = 1;
					repaint();
				}
			}

		});
		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("KeyCode=" + e.getKeyCode());
				if (e.getKeyCode() == 39) {
					contentPane.setBackground(Color.white);
					nachRechtsGehen(i);

				}
				if (e.getKeyCode() == 37) {
					contentPane.setBackground(Color.white);
					nachLinksGehen(i);

				}
				if (e.getKeyCode() == 40) {
					contentPane.setBackground(Color.white);
					nachUnten(i);

				}
				if (e.getKeyCode() == 38) {
					contentPane.setBackground(Color.white);
					nachOben(i);

				}
			}

		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 900);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton rechts = new JButton("Rechts");
		rechts.setFocusable(false);
		rechts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nachRechtsGehen(i);

			}
		});
		rechts.setBounds(10, 11, 89, 23);
		contentPane.add(rechts);
		MalPanel panel = new MalPanel(this);
		panel.setBounds(120, 10, this.getWidth() - 159, this.getHeight() - 59);
		contentPane.add(panel);

		JButton btnNewButton_1 = new JButton("nach unten");
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nachUnten(i);
			}
		});
		btnNewButton_1.setBounds(10, 113, 89, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Links");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nachLinksGehen(i);
			}
		});
		btnNewButton_2.setBounds(10, 45, 89, 23);
		btnNewButton_2.setFocusable(false);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton = new JButton("Oben");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nachOben(i);
			}
		});
		btnNewButton.setBounds(10, 79, 89, 23);
		contentPane.add(btnNewButton);

	}

	public void inizcell() {
		for (int i = 0; i < 61; i++) {
			for (int j = 0; j < 61; j++) {
				cell[i][j] = 0;
			}
		}
	}

	protected void nachLinksGehen(int weiter) {
		System.out.println(px);
		System.out.println(py);
		if (cell[(px - weiter) / 20][py / 20] == 0)
			if (px - weiter > 0)
				px = px - weiter;
			else
				px = 1020;
		player();
		repaint();
	}

	protected void wechsleFarbe(Color c) {
		farbe = c;
		repaint();
	}

	protected void nachUnten(int weiter) {
		if (py + 20 + weiter <= 840)
			py = py + weiter;
		else
			py = 20;
		player();
		repaint();

	}

	public void nachRechtsGehen(int weiter) {
		if (px + 20 + weiter <= 1040)
			px = px + weiter;
		else
			px = 20;
		player();
		repaint();
	}

	public void nachOben(int weiter) {
		if (py + 20 - weiter >= 40)
			py = py - weiter;
		else
			py = 820;
		player();
		repaint();
	}

	public void player() {
//		KI.move();
	}

}