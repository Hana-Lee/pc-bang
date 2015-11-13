package kr.co.leehana.view.panel;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Hana Lee
 * @since 2015-11-14 00-33
 */
public class ClockMessage extends JPanel implements Runnable {

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
