package com.tjl.view;

import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SpringLayout;

import com.tjl.bean.User;
import com.tjl.operate.Useroperate_imp;

public class main1 extends JFrame {
	private JTextField account;
	private JTextField password;

	/**
	 * Create the panel.
	 */
	public main1() {
		setTitle("登陆界面");
		SpringLayout springLayout = new SpringLayout();
		
		JLabel lblNewLabel = new JLabel("请输入用户名:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 68, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 69, SpringLayout.WEST, this);
		add(lblNewLabel);
		
		account = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, account, 65, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, account, 185, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, account, 355, SpringLayout.WEST, this);
		add(account);
		account.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("请输入密码:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 125, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 69, SpringLayout.WEST, this);
		add(lblNewLabel_1);
		
		password = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, password, 122, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, password, 185, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, password, 355, SpringLayout.WEST, this);
		add(password);
		password.setColumns(10);
		
		JButton btnNewButton = new JButton("登录");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 208, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 185, SpringLayout.WEST, this);
		add(btnNewButton);

		setLayout(springLayout);
		setVisible(true);
		setSize(450,300);
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				
				String count1=account.getText();
				String password1=password.getText();
				User tryUser = new User(count1,password1);
				Useroperate_imp loginImp = new Useroperate_imp();
				int flag=loginImp.login(tryUser);

				if (flag==1) {
					JOptionPane.showMessageDialog(null,count1+"管理员你好,已登录成功！" );
					new adminframe();
					
				}
				else if (flag<0) {
					JOptionPane.showMessageDialog(null,"登录失败,请检查账号及密码." );
				}
				else {
					JOptionPane.showMessageDialog(null,count1+"同学登录成功！" );
					new studentframe(flag);
					
				}
			}
		});
	}

	public static void main(String[] args) {
		new main1();
	}
}
