package homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class carFuel {

    public static void main(String[] args) {
        JFrame jf = new JFrame("动态规划汽车加油");
        jf.setSize(800, 800);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GridBagLayout gridBag = new GridBagLayout();
        JPanel panel = new JPanel(gridBag);
        jf.add(panel);
        GridBagConstraints c = null; // 约束
		Font f1 = new Font(Font.DIALOG, Font.BOLD, 20);
		Font f2 = new Font(Font.SANS_SERIF, Font.BOLD, 20);

		JLabel tip1 = new JLabel("距离终点距离:");
		tip1.setFont(f2);

		JLabel tip2 = new JLabel("起始油量:");
		tip2.setFont(f2);

		JLabel tip3 = new JLabel("加油站数量:");
		tip3.setFont(f2);

		JLabel tip4 = new JLabel("加油站距离及储备油量");
		tip4.setFont(f2);

		JLabel tip5 = new JLabel("结果");
		tip5.setFont(f2);

		c = new GridBagConstraints();
		gridBag.addLayoutComponent(tip1, c);

		c = new GridBagConstraints();
		JTextField target = new JTextField("100", 5);
		target.setFont(f2);
		gridBag.addLayoutComponent(target, c);

		c = new GridBagConstraints();
		gridBag.addLayoutComponent(tip2, c);

		c = new GridBagConstraints();
		JTextField startfuel = new JTextField("10", 5);
		startfuel.setFont(f2);
		gridBag.addLayoutComponent(startfuel, c);

		c = new GridBagConstraints();
		gridBag.addLayoutComponent(tip3, c);

		c.gridwidth = GridBagConstraints.REMAINDER;
		c.fill = GridBagConstraints.BOTH;
		JTextField fuelstations = new JTextField("4", 5);
		fuelstations.setFont(f2);
		gridBag.addLayoutComponent(fuelstations, c);

		c = new GridBagConstraints();
		c.gridheight = 2;
		c.fill = GridBagConstraints.BOTH;
		gridBag.addLayoutComponent(tip4, c);

		// 创建一个 5 行 10 列的文本区域
		final JTextArea textArea = new JTextArea("10 60\r\n" + "20 30\r\n" + "30 30\r\n" + "60 40\r\n" + "", 9, 3);
		textArea.setFont(f1);
		// 设置自动换行
		textArea.setLineWrap(true);
		c = new GridBagConstraints();
		c.gridheight = 2;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.fill = GridBagConstraints.BOTH;
		gridBag.addLayoutComponent(textArea, c);

		c = new GridBagConstraints();
		gridBag.addLayoutComponent(tip5, c);

		c = new GridBagConstraints();
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.fill = GridBagConstraints.BOTH;
		JTextField result = new JTextField(20);
		result.setFont(f2);
		gridBag.addLayoutComponent(result, c);

		// 创建一个提交按钮，点击按钮获取输入文本
		JButton btn = new JButton("计算");
		c = new GridBagConstraints();
		gridBag.addLayoutComponent(btn, c);

		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String aString = textArea.getText();
				int b = Integer.parseInt(target.getText());
				int c = Integer.parseInt(startfuel.getText());
				int d = Integer.parseInt(fuelstations.getText());
				int answer = calcul(aString, b, c, d);
				if (answer == -1) {
					result.setText("无法到达");
				} else {
					result.setText("可以停" + answer + "次车到达");
				}

			}
		});

		panel.add(tip1);
		panel.add(target);
		panel.add(tip2);
		panel.add(startfuel);
		panel.add(tip3);
		panel.add(fuelstations);
		panel.add(tip4);
		panel.add(textArea);
		panel.add(tip5);
		panel.add(result);
		panel.add(btn);
		jf.pack();
		jf.setVisible(true);
	}

	public static int calcul(String a, int b, int c, int d) {
		Scanner in = new Scanner(a);
		int target = b;// 总长度
		int startFuel = c;// 起始油量
		int stationsSize = d;// 加油站数量
		int[][] stations = new int[stationsSize + 1][2];
		int[] dp = new int[stationsSize + 1];
		for (int i = 0; i < stationsSize; i++) {
			stations[i][0] = in.nextInt();
			stations[i][1] = in.nextInt();
		}

		dp[0] = startFuel;
		for (int i = 0; i < stationsSize; i++) {// 到达第几个加油站
			for (int t = i; t >= 0; t--) {// 最多停 i 次,计算停 t 次的最长行驶里程
				if (dp[t] >= stations[i][0]) {// 前t次能够到达当前加油站

					dp[t + 1] = Math.max(dp[t + 1], dp[t] + stations[i][1]);

				}
			}
		}

		for (int i = 0; i <= stationsSize; i++) {
			if (dp[i] >= target) {
				return i;
			}
		}

		return -1;

	}
}