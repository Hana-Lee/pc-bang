package kr.co.leehana.view;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Hana Lee
 * @since 2015-11-13 20-06
 */
public class ManageView extends JFrame {

	private static final long serialVersionUID = -7777187062556506831L;
	private static final int width = 1600;
	private static final int height = 900;

	public ManageView() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(width, height);
		setTitle("관리 화면");
		setLayout(null);

		setCenterLocation();

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, width, height);
		layeredPane.setLayout(null);

		JPanel mainPanel = new MainPanel();
		mainPanel.setLayout(null);
		mainPanel.setBounds(0, -30, width, height);

		ClockPanel clockPanel = new ClockPanel();
		clockPanel.setLayout(null);
		clockPanel.setBounds(15, 20, 179, 149);
		clockPanel.setOpaque(false);
		new Thread(clockPanel).start();

		ClockMessage clockMessage = new ClockMessage();
		clockMessage.setBounds(80, 53, 100, 100);
		clockMessage.setOpaque(false);
		new Thread(clockMessage).start();

		layeredPane.add(mainPanel, new Integer(0));
		layeredPane.add(clockPanel, new Integer(1));
		layeredPane.add(clockMessage, new Integer(2));

		add(layeredPane);

		setVisible(true);
	}

	private void setCenterLocation() {
		Dimension frameSize = this.getSize();
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2);
	}

	class MainPanel extends JPanel {
		private Image image;

		public MainPanel() {
			image = Toolkit.getDefaultToolkit().createImage(ManageView.class.getResource("/img/mainHud_back.png"));
		}

		@Override
		public void paint(Graphics g) {
			g.drawImage(image, 0, 0, this);
		}

		@Override
		public void update(Graphics g) {
			super.update(g);
		}
	}

	class ClockPanel extends JPanel implements Runnable {

		private Image[] images = new Image[4];
		private int i = 1;

		public ClockPanel() {
			images[1] = Toolkit.getDefaultToolkit().createImage(ManageView.class.getResource("/img/cl1.png"));
			images[2] = Toolkit.getDefaultToolkit().createImage(ManageView.class.getResource("/img/cl2.png"));
			images[3] = Toolkit.getDefaultToolkit().createImage(ManageView.class.getResource("/img/cl3.png"));

			images[0] = images[1];
		}

		@Override
		public void paint(Graphics g) {
			g.drawImage(images[0], 0, 0, this);
		}

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(10000);

					switch (i) {
						case 1:
							images[0] = images[i];
							i++;
							repaint();
							break;
						case 2:
							images[0] = images[i];
							i++;
							repaint();
							break;
						case 3:
							images[0] = images[i];
							i = 1;
							repaint();
							break;
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	class ClockMessage extends JPanel implements Runnable {

		private int ampmCode = Calendar.getInstance().get(Calendar.AM_PM);
		private String[] ampmValues = {"AM", "PM"};
		private String timeValue = new SimpleDateFormat("hh:mm:ss").format(new Date());
		private JLabel timeLabel;
		private JLabel ampmLabel;

		public ClockMessage() {
			init();
		}

		private void init() {
			this.setLayout(null);
			timeLabel = new JLabel(timeValue);
			timeLabel.setBounds(0, 0, 100, 20);
			timeLabel.setForeground(new Color(36, 205, 198));
			timeLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));

			ampmLabel = new JLabel(ampmValues[ampmCode]);
			ampmLabel.setBounds(15, 20, 100, 30);
			ampmLabel.setForeground(new Color(36, 205, 198));
			ampmLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
//			ampmLabel.setFont(new Font("배달의민족 한나는 열한살", Font.BOLD, 12));
//			ampmLabel.setFont(new Font("배달의민족 주아", Font.BOLD, 12));

			add(timeLabel, BorderLayout.NORTH);
			add(ampmLabel, BorderLayout.CENTER);
		}

		@Override
		public void run() {
			do {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				timeLabel.setText(new SimpleDateFormat("hh:mm:ss").format(new Date()));
			} while (true);
		}
	}


	public static void main(String[] args) {
		new ManageView();
	}
}
