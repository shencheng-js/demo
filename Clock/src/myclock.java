
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.Border;

/*
 * 两大板块:
 * 一类画钟,一类则是各种文本框及按钮等~~~
 * 画钟利用了Graphics2D
 * 文本框等,添加监听器,等等
 * 设定时间时为了界面简洁未添加设置日期功能
 * 
 */
public class myclock extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 字体设置
	public Font f1 = new Font("微软雅黑", Font.BOLD, 40);// 时间与秒表数字显示
	public Font f2 = new Font("微软雅黑", Font.BOLD, 15);// 小字体且加粗字体
	public Font f3 = new Font("微软雅黑", Font.PLAIN, 20);// 大字体
	public Font f4 = new Font("微软雅黑", Font.BOLD, 25);// 大且加粗字体

	public JLabel nowtime = new JLabel("00:00:00", JLabel.CENTER);
	public JLabel nowdate = new JLabel("  时间等待载入中~~~");
	public JLabel Stopwatch = new JLabel("00:00:00", JLabel.CENTER);// 秒表显示

	// 两个文本区域
	public JTextArea stopArea = new JTextArea(4, 9);// 秒表计次
	public JTextField mytime = new JTextField("示例:7:20:40", 1);// 设定时间

	// 时钟
	public Graphics2D g;

	public JButton sure, resert, BJS, cHOOSE;
	Border myBorder;
	Border myBorder1;

	public int hour = 0;
	public int min = 0;
	public int sec = 0;
	public int times = 1;

	public int millisecond = 0;// 秒表处为10ms一单位
	public boolean flag = false;// 判断秒表当前静止或走动
	public int miao_fen = 0;
	public int miao_miao = 0;
	public int miao_millmiao = 0;
	public int[] time;// 容纳读入的时间
	public Date now = new Date();

	public boolean BJSflag;

	final double PI = Math.PI;
	public String textTime = "";
	public String StopwatchTime = "";

	@SuppressWarnings("deprecation")
	public myclock() {

		stopArea.setLineWrap(true);
		stopArea.setLocation(50, 320);
		stopArea.setSize(300, 90);
		stopArea.setVisible(true);
		stopArea.setFont(f2);
		stopArea.setEditable(false);
		add(stopArea);

		nowtime.setBounds(400, 40, 260, 65);
		nowtime.setFont(f1);
		myBorder = BorderFactory.createLineBorder(Color.blue, 2);
		myBorder1 = BorderFactory.createTitledBorder(myBorder, "TIME");
		nowtime.setBorder(myBorder1);
		add(nowtime);

		nowdate.setBounds(380, 120, 300, 50);
		nowdate.setFont(f4);
		add(nowdate);

		Stopwatch.setBounds(400, 180, 260, 70);
		Stopwatch.setFont(f1);
		myBorder = BorderFactory.createLineBorder(Color.red, 3);
		myBorder1 = BorderFactory.createTitledBorder(myBorder, "秒表");
		Stopwatch.setBorder(myBorder1);
		add(Stopwatch);
		
		
		sure = new JButton("启动");// 按下后变为暂停,反之亦然
		sure.setFont(f2);
		sure.setBounds(420, 260, 100, 50);
		sure.setVisible(true);
		sure.setBackground(Color.green);
		sure.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根

				if (!flag) {// 现在是绿色
					flag = !flag;
					showStopwatch();
					sure.setText("停止");
					sure.setBackground(Color.red);
					resert.setEnabled(true);

					if (millisecond != 0) {
						resert.setText("计次");
					}

				} else {// 现在是红色
					flag = !flag;
					showStopwatch();
					sure.setText("启动");
					sure.setBackground(Color.green);

					if (millisecond == 0) {
						resert.setEnabled(false);
						resert.setText("计次");
						
					} else {
						resert.setEnabled(true);
						resert.setText("复位");
						
					}
				}

			}
		});
		add(sure);

		resert = new JButton("计次");
		resert.setFont(f2);
		resert.setBounds(540, 260, 100, 50);
		resert.setVisible(true);
		resert.setBackground(Color.gray);
		resert.setEnabled(false);
		resert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if (!flag) {// 静止状态,目前没动
					if (millisecond != 0) {
						resert.setText("计次");
						resert.setEnabled(true);
						millisecond = 0;
						Stopwatch.setText("00:00:00");
						times = 1;
						stopArea.setText("");
						resert.setEnabled(false);
					}
				} else {
					stopArea.append(times + " . " + StopwatchTime + "   ");
					times++;
					if (times % 3 == 1) {
						stopArea.append("\n");
					}

				}
			}
		});
		add(resert);

		mytime.setBounds(420, 312, 220, 45);
		mytime.setFont(f3);
		myBorder = BorderFactory.createLineBorder(Color.gray, 2);
		myBorder1 = BorderFactory.createTitledBorder(myBorder, "设定时间");
		mytime.setBorder(myBorder1);
		add(mytime);

		BJS = new JButton("北京时间");
		BJS.setFont(f2);
		BJS.setBounds(420, 360, 100, 50);
		BJS.setVisible(true);
		BJS.setBackground(Color.yellow);
		BJS.setEnabled(true);
		BJS.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				hour = now.getHours();
				min = now.getMinutes();
				sec = now.getSeconds();
				showBJS();
				BJSflag = true;
			}
		});
		add(BJS);

		cHOOSE = new JButton("设置时间");
		cHOOSE.setFont(f2);
		cHOOSE.setBounds(540, 360, 100, 50);
		cHOOSE.setVisible(true);
		cHOOSE.setBackground(Color.gray);
		cHOOSE.setEnabled(true);
		cHOOSE.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				
				String timestrString = mytime.getText();
				String[] timemedium = new String[4];
				time = new int[6];
				boolean newflag = true;

				Scanner in = new Scanner(timestrString);
				timemedium = timestrString.split(":");
				if (timemedium.length != 3) {
					newflag = false;
				}

				for (int i = 0; i < timemedium.length && newflag; i++) {
					time[i] = Integer.parseInt(timemedium[i]);
					if (time[i] < 0) {
						newflag = false;
					}
				}
				if (time[0] > 24 || time[1] > 60 || time[2] > 60) {
					newflag = false;
				}
				if (newflag) {
					hour = time[0];
					min = time[1];
					sec = time[2];
					shownowtime();
					BJSflag = false;
				} else {
					mytime.setText("输入时间有误,请按格式输入!");
				}
				
			}
		});
		add(cHOOSE);

		setVisible(true);

	}

	public void paintComponent(Graphics g1) {
		double x, y;
		super.paintComponent(g1);
		g = (Graphics2D) g1;
		// 反锯齿开关开
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// 画表盘
		g.setStroke(new BasicStroke(2, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND));
		g.setPaint(Color.RED);
		g.drawOval(75, 39, 250, 250);
		g.setColor(Color.black);
		g.fillOval(195, 160, 10, 10);

		for (int i = 0; i < 60; i++) {
			double[] coord = new double[2];
			coord = dot_coord(i * 2 * PI / 60);
			x = coord[0];
			y = coord[1];

			if (i % 5 == 0)//
			{
				g.fillOval((int) (x - 3.5 + 200), (int) (y - 3.5 + 165), 7, 7);

			} else// 其他小点
			{
				g.fillOval((int) (x - 2.5 + 200), (int) (y - 2.5 + 165), 5, 5);
			}
		}

		// 画四个数字
		g.setFont(f4);
		g.drawString("3", 300, 171);
		g.drawString("6", 195, 273);
		g.drawString("9", 91, 171);
		g.drawString("12", 190, 68);

		g.setFont(f2);
		g.drawString("1", 245, 80);
		g.drawString("2", 285, 116);
		g.drawString("4", 285, 222);
		g.drawString("5", 245, 262);
		g.drawString("7", 140, 262);
		g.drawString("8", 110, 222);
		g.drawString("10", 110, 116);
		g.drawString("11", 140, 80);

		// 画时针，分针，秒针
		hour_painter(hour * 3600 + min * 60 + sec, g);// 时针走过的秒数
		min_painter(min * 60 + sec, g);// 分针走过的秒数
		sec_painter(sec, g);// 秒针走过的秒数
	}

	public void showBJS() {//北京时间展示
		new Thread() {
			@SuppressWarnings("deprecation")//&& BJSflag
			public void run() {
				while (true && BJSflag) {
					now = new Date();
					hour = now.getHours();
					min = now.getMinutes();
					sec = now.getSeconds();
					try {
						Thread.sleep(1);// 刷新率
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
					showTexttime();

					repaint();
				}
			}
		}.start();
	}

	public void shownowtime() {//设置的时间展示
		new Thread() {
			@SuppressWarnings("deprecation")//&& !BJSflag防止跳变
			public void run() {
				while (true && !BJSflag) {

					try {
						Thread.sleep(1000);// 刷新率
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}

					showTexttime();

					repaint();

					sec++;

					if (sec == 60) {
						sec = 0;
						min++;
						if (min == 60) {
							min = 0;
							hour++;
							if (hour == 24) {
								hour = 0;
							}
						}
					}
				}
			}
		}.start();
	}

	public void showStopwatch() {//秒表时间跑动
		new Thread() {
			@SuppressWarnings("deprecation")
			public void run() {
				while (flag) {
					millisecond += 1;
					try {
						Thread.sleep(10);// 刷新率
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
					showStopwatchTime(1);
				}
			}
		}.start();
	}

	public void hour_painter(int second, Graphics2D g) {// second表示当前时间的时针相对00:00:00走了多少秒
		double x, y, angle;
		angle = second * PI / 21600;
		x = 200 + 55 * Math.sin(angle);
		y = 165 - 55 * Math.cos(angle);
		g.setStroke(new BasicStroke(5, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND));
		g.setPaint(Color.blue);
		g.drawLine(200, 165, (int) x, (int) y);
	}

	public void min_painter(int second, Graphics2D g) {
		double x, y, angle;
		angle = second * PI / 1800;
		x = 200 + 75 * Math.sin(angle);
		y = 165 - 75 * Math.cos(angle);
		g.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND));
		g.setPaint(Color.red);
		g.drawLine(200, 165, (int) x, (int) y);
	}

	public void sec_painter(int second, Graphics2D g) {// second表示当前时间的秒针相对00:00:00走了多少秒
		double x, y, x1, y1, angle;
		angle = second * PI / 30;
		x = 200 + 90 * Math.sin(angle);
		y = 165 - 90 * Math.cos(angle);
		x1 = 200 + 15 * Math.sin(angle + PI);
		y1 = 165 - 15 * Math.cos(angle + PI);
		g.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
		g.setPaint(Color.black);
		g.drawLine((int) x1, (int) y1, (int) x, (int) y);

	}

	public double[] dot_coord(double angle) {//计算对应点位在屏幕上的位置
		double[] coord = new double[2];
		coord[0] = 120 * Math.cos(angle);// 横坐标
		coord[1] = 120 * Math.sin(angle);// 纵坐标
		return coord;
	}

	public void showStopwatchTime(int state) {//显示秒表时间
		if (state == -1) {
			Stopwatch.setText("00:00:00");
			millisecond = 0;
			return;
		}
		StopwatchTime = "";
		miao_millmiao = millisecond % 100;
		miao_miao = millisecond / 100;
		miao_fen = miao_miao / 60;
		miao_miao -= miao_fen * 60;

		if (miao_fen < 10) {
			StopwatchTime += ("0" + Integer.toString(miao_fen));
		} else {
			StopwatchTime += miao_fen;
		}
		miao_fen = 0;
		StopwatchTime += ":";

		if (miao_miao < 10) {
			StopwatchTime += ("0" + miao_miao);
		} else {
			StopwatchTime += miao_miao;
		}
		miao_miao = 0;
		StopwatchTime += ":";
		StopwatchTime += miao_millmiao;

		Stopwatch.setText(StopwatchTime);

	}

	@SuppressWarnings("deprecation")
	public void showTexttime() {//电子钟式表示时间
		String date;
		int hour_temp = hour, min_temp = min, sec_temp = sec;
		sec_temp += 1;
		if (sec_temp >= 60) {
			sec_temp = 0;
			min_temp += 1;
		}
		if (min_temp >= 60) {
			min_temp = 0;
			hour_temp += 1;
		}
		if (hour_temp < 10)
			textTime = "0" + hour_temp + ":";
		else
			textTime = "" + hour_temp + ":";

		if (min_temp < 10)
			textTime = textTime + "0" + min_temp + ":";
		else
			textTime = textTime + "" + min_temp + ":";
		textTime = textTime + "" + sec_temp;
		/*
		 * if (sec < 10) textTime = textTime + "0" + sec_temp; else
		 * 
		 */

		date = " " + (now.getYear() + 1900) + "年" + (now.getMonth() + 1) + "月" + now.getDate() + "日   " + "星期";
		switch (now.getDay()) {
		case 1:
			date += "一";
			break;
		case 2:
			date += "二";
			break;
		case 3:
			date += "三";
			break;
		case 4:
			date += "四";
			break;
		case 5:
			date += "五";
			break;
		case 6:
			date += "六";
			break;
		case 7:
			date += "日";
			break;
		}
		date += "  ";
		textTime = "  " + textTime;
		nowtime.setText(textTime);
		nowdate.setText(date);
	}

	public static void main(String args[]) {
		myclock c = new myclock();

		JFrame fjFrame = new JFrame("时钟");
		ImageIcon icon = new ImageIcon("clock.png"); // 图片和项目同一路径，故不用图片的路径 //BorderLayout.CENTER
		fjFrame.setIconImage(icon.getImage());
		fjFrame.setSize(700, 470);
		fjFrame.setResizable(true);
		fjFrame.add(c);
		fjFrame.setLocationRelativeTo(null);
		fjFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fjFrame.setVisible(true);
	}
}