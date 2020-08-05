package com.tjl.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.tjl.bean.Student;
import com.tjl.operate.Studentoperate_imp;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class studentframe extends JFrame {

	private JPanel contentPane;
	private JTextField snum;
	private JTextField sname;
	private JTextField usex;
	private JTextField sclass;
	private JTextField sage;
	private JTextField sgpa;
	private JTextField srank;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public studentframe(int a) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 400, 500,400);
		contentPane = new JPanel();
		setTitle("个人信息");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		Studentoperate_imp aImp= new Studentoperate_imp();
		Student myStudent = aImp.select(a);
		setSize(400,251);
		setVisible(true);

		JLabel lblNewLabel = new JLabel("学号:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 26, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 22, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("姓名:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 24, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("性别:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 21, SpringLayout.SOUTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("班级号:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 40, SpringLayout.SOUTH, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_3, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("年龄:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 0, SpringLayout.NORTH, lblNewLabel);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("GPA:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 0, SpringLayout.NORTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_5, 0, SpringLayout.WEST, lblNewLabel_4);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("排名;");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 0, SpringLayout.NORTH, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_6, 0, SpringLayout.EAST, lblNewLabel_4);
		contentPane.add(lblNewLabel_6);
		
		snum = new JTextField();
		snum.setHorizontalAlignment(SwingConstants.CENTER);
		snum.setEditable(false);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_4, 65, SpringLayout.EAST, snum);
		sl_contentPane.putConstraint(SpringLayout.NORTH, snum, -3, SpringLayout.NORTH, lblNewLabel);
		contentPane.add(snum);
		snum.setColumns(10);
		snum.setText(String.valueOf(myStudent.getSno()));
		
		sname = new JTextField();
		sname.setHorizontalAlignment(SwingConstants.CENTER);
		sname.setEditable(false);
		sl_contentPane.putConstraint(SpringLayout.EAST, snum, 0, SpringLayout.EAST, sname);
		sl_contentPane.putConstraint(SpringLayout.NORTH, sname, -3, SpringLayout.NORTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, sname, 6, SpringLayout.EAST, lblNewLabel_1);
		contentPane.add(sname);
		sname.setColumns(10);
		sname.setText(String.valueOf(myStudent.getSname()));
		
		usex = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, usex, -3, SpringLayout.NORTH, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, usex, 6, SpringLayout.EAST, lblNewLabel_2);
		usex.setHorizontalAlignment(SwingConstants.CENTER);
		usex.setEditable(false);
		contentPane.add(usex);
		usex.setColumns(4);
		if (myStudent.getSex()==1) {
			usex.setText("男");
		}
		else {
			usex.setText("女");
		}
		
		sclass = new JTextField();
		sclass.setEditable(false);
		sl_contentPane.putConstraint(SpringLayout.NORTH, sclass, -3, SpringLayout.NORTH, lblNewLabel_3);
		sl_contentPane.putConstraint(SpringLayout.WEST, sclass, 6, SpringLayout.EAST, lblNewLabel_3);
		contentPane.add(sclass);
		sclass.setColumns(10);
		sclass.setText(String.valueOf(myStudent.getSclass()));
		
		sage = new JTextField();
		sage.setEditable(false);
		sl_contentPane.putConstraint(SpringLayout.WEST, sage, 6, SpringLayout.EAST, lblNewLabel_4);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, sage, 0, SpringLayout.SOUTH, lblNewLabel);
		contentPane.add(sage);
		sage.setColumns(2);
		sage.setText(String.valueOf(myStudent.getAge()));
		
		sgpa = new JTextField();
		sgpa.setEditable(false);
		sl_contentPane.putConstraint(SpringLayout.WEST, sgpa, 6, SpringLayout.EAST, lblNewLabel_5);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, sgpa, 0, SpringLayout.SOUTH, lblNewLabel_1);
		contentPane.add(sgpa);
		sgpa.setColumns(3);
		sgpa.setText(String.valueOf(myStudent.getGpa()));
		
		srank = new JTextField();
		srank.setEditable(false);
		sl_contentPane.putConstraint(SpringLayout.NORTH, srank, 0, SpringLayout.NORTH, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, srank, 6, SpringLayout.EAST, lblNewLabel_6);
		contentPane.add(srank);
		srank.setColumns(2);
		srank.setText(String.valueOf(aImp.Ranking(a)));
		
		
	}
}
