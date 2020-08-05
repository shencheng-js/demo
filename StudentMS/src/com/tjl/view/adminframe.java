package com.tjl.view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.AcceptPendingException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SpringLayout;

import com.tjl.bean.User;
import com.tjl.operate.Useroperate_imp;

public class adminframe extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField sno_text;

	/**
	 * Create the panel.
	 */
	public adminframe() {
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		setVisible(true);
		setSize(490,232);
		setTitle("管理员界面");
		JLabel lblNewLabel = new JLabel("注册新学生名:");
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 3, SpringLayout.NORTH, textField);
		springLayout.putConstraint(SpringLayout.NORTH, textField, 36, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, textField, 224, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, textField, 395, SpringLayout.WEST, this);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("学生账户密码:");
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 67, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 85, SpringLayout.WEST, this);
		getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_1, 64, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, textField_1, 224, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, textField_1, 395, SpringLayout.WEST, this);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("注册");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 36, SpringLayout.SOUTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -294, SpringLayout.EAST, getContentPane());
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("学生信息管理");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, 0, SpringLayout.NORTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, 77, SpringLayout.EAST, btnNewButton);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("学生学号:");
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -6, SpringLayout.NORTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_2, 0, SpringLayout.EAST, lblNewLabel);
		getContentPane().add(lblNewLabel_2);
		
		sno_text = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, sno_text, 3, SpringLayout.SOUTH, textField_1);
		springLayout.putConstraint(SpringLayout.WEST, sno_text, 0, SpringLayout.WEST, textField);
		springLayout.putConstraint(SpringLayout.EAST, sno_text, 0, SpringLayout.EAST, textField);
		getContentPane().add(sno_text);
		sno_text.setColumns(10);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				User myUser = new User(textField.getText(),textField_1.getText(),Integer.parseInt(sno_text.getText()));
				Useroperate_imp aImp = new Useroperate_imp();
				boolean flag= aImp.insert(myUser);
				if (flag) {
					JOptionPane.showMessageDialog(null,"插入成功" );
				}
				else {
					JOptionPane.showMessageDialog(null,"插入失败,请重试!" );
				}
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				new studentmanage();
			}
		});
	}
}
