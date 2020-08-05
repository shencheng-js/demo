package com.tjl.view;

import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.SpringLayout;

import com.tjl.bean.Student;
import com.tjl.operate.Studentoperate_imp;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class studentmanage extends JFrame {
	private JTextField mysno;
	private JTextField mysname;
	private JTextField myclass;
	private JTextField mysex;
	private JTextField myage;
	private JTextField mygpa;
	private JTextField myrank;

	private int sno;
	private String sname;
	private int Sclass;
	private int sex;
	private String sexString;
	private int age;
	private double gpa;
	
	Studentoperate_imp aImp = new Studentoperate_imp();
	
	private boolean flag = true;
	/**
	 * Create the panel.
	 */
	public studentmanage() {
		setSize(507, 301);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);

		setTitle("学生管理系统");
		
		JLabel lblNewLabel = new JLabel("学号:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 24, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 44, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("姓名:");
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_1, 0, SpringLayout.EAST, lblNewLabel);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("班级号:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 111, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -26, SpringLayout.NORTH, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_2, 0, SpringLayout.EAST, lblNewLabel);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("性别");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 24, SpringLayout.SOUTH, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_3, 0, SpringLayout.EAST, lblNewLabel);
		getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("年龄:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 0, SpringLayout.NORTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_4, -172, SpringLayout.EAST, getContentPane());
		getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("GPA;");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 0, SpringLayout.NORTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_5, 0, SpringLayout.WEST, lblNewLabel_4);
		getContentPane().add(lblNewLabel_5);

		mysno = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, mysno, -3, SpringLayout.NORTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, mysno, 24, SpringLayout.EAST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, mysno, 149, SpringLayout.EAST, lblNewLabel);
		getContentPane().add(mysno);
		mysno.setColumns(10);

		mysname = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, mysname, -3, SpringLayout.NORTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, mysname, 0, SpringLayout.WEST, mysno);
		springLayout.putConstraint(SpringLayout.EAST, mysname, -39, SpringLayout.EAST, mysno);
		getContentPane().add(mysname);
		mysname.setColumns(10);

		myclass = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, myclass, -3, SpringLayout.NORTH, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.WEST, myclass, 0, SpringLayout.WEST, mysno);
		springLayout.putConstraint(SpringLayout.EAST, myclass, 0, SpringLayout.EAST, mysno);
		getContentPane().add(myclass);
		myclass.setColumns(10);

		mysex = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, mysex, 0, SpringLayout.NORTH, lblNewLabel_3);
		springLayout.putConstraint(SpringLayout.WEST, mysex, 0, SpringLayout.WEST, mysno);
		getContentPane().add(mysex);
		mysex.setColumns(3);

		myage = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, myage, 0, SpringLayout.NORTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, myage, 22, SpringLayout.EAST, lblNewLabel_4);
		getContentPane().add(myage);
		myage.setColumns(3);

		JLabel lblNewLabel_6 = new JLabel("排名:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 0, SpringLayout.NORTH, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_6, 0, SpringLayout.EAST, lblNewLabel_4);
		getContentPane().add(lblNewLabel_6);

		mygpa = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, mygpa, -3, SpringLayout.NORTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.EAST, mygpa, 0, SpringLayout.EAST, myage);
		getContentPane().add(mygpa);
		mygpa.setColumns(3);

		myrank = new JTextField();
		myrank.setEditable(false);
		springLayout.putConstraint(SpringLayout.WEST, myrank, 0, SpringLayout.WEST, myage);
		springLayout.putConstraint(SpringLayout.SOUTH, myrank, 0, SpringLayout.SOUTH, lblNewLabel_2);
		myrank.setColumns(3);
		getContentPane().add(myrank);

		JButton myadd = new JButton("添加");
		getContentPane().add(myadd);

		JButton mydelete = new JButton("删除");
		springLayout.putConstraint(SpringLayout.SOUTH, mydelete, -14, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, myadd, 0, SpringLayout.NORTH, mydelete);
		springLayout.putConstraint(SpringLayout.EAST, myadd, -37, SpringLayout.WEST, mydelete);
		getContentPane().add(mydelete);

		JButton myupdate = new JButton("修改");
		springLayout.putConstraint(SpringLayout.EAST, mydelete, -38, SpringLayout.WEST, myupdate);
		springLayout.putConstraint(SpringLayout.EAST, myupdate, 0, SpringLayout.EAST, lblNewLabel_5);
		getContentPane().add(myupdate);

		JButton myselect = new JButton("查询");
		springLayout.putConstraint(SpringLayout.NORTH, myupdate, 0, SpringLayout.NORTH, myselect);
		springLayout.putConstraint(SpringLayout.NORTH, myselect, 84, SpringLayout.SOUTH, myrank);
		springLayout.putConstraint(SpringLayout.EAST, myselect, -68, SpringLayout.EAST, getContentPane());
		getContentPane().add(myselect);
		setVisible(true);

		myadd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				
				sno=Integer.parseInt(mysno.getText());
				sname=mysname.getText();
				sex= Integer.parseInt( mysex.getText() );
				Sclass=Integer.parseInt(myclass.getText());
				age=Integer.parseInt(myage.getText());
				gpa=Double.parseDouble(mygpa.getText());
				Student aStudent = new Student(sno, sname, Sclass, sex, age, gpa);
				flag= aImp.insert(aStudent);
				if (flag) {
					JOptionPane.showMessageDialog(null,"学生信息插入成功" );
				}
				else {
					JOptionPane.showMessageDialog(null,"学生信息插入失败,检查后重试!" );

				}
			}
		});

		mydelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				sno=Integer.parseInt(mysno.getText());
				flag= aImp.delete(sno);
				if (flag) {
					JOptionPane.showMessageDialog(null,"学生信息删除成功" );
				}
				else {
					JOptionPane.showMessageDialog(null,"学生信息删除失败,检查后重试!" );

				}
			}
		});

		myupdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根

				sno=Integer.parseInt(mysno.getText());
				sname=mysname.getText();
				String aString=mysex.getText();
				if (aString.equals("男")) {
					sex=1;
				}else if (aString.equals("女")) {
					sex=0;
				}else if(Integer.parseInt(aString)==1||Integer.parseInt(aString)==0){
					sex= Integer.parseInt(aString);
				}else {
					flag=false;
				}
				
				Sclass=Integer.parseInt(myclass.getText());
				age=Integer.parseInt(myage.getText());
				gpa=Double.parseDouble(mygpa.getText());
				Student aStudent = new Student(sno, sname, Sclass, sex, age, gpa);
				if (flag) {
					flag = aImp.update(aStudent);
				}
				
				
				if (flag) {
					JOptionPane.showMessageDialog(null,"学生信息修改成功" );
				}
				else {
					JOptionPane.showMessageDialog(null,"学生信息修改失败,检查后重试!" );

				}
			}
		});

		myselect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				sno=Integer.parseInt(mysno.getText());
				Student retStudent = new Student();
				retStudent = aImp.select(sno);
				myrank.setText(String.valueOf(aImp.Ranking(sno)));
				myage.setText(String.valueOf(retStudent.getAge()));;
				mysname.setText(retStudent.getSname());
				mysno.setText(String.valueOf(retStudent.getSno()));
				myclass.setText(String.valueOf(retStudent.getSclass()));
				mygpa.setText(String.valueOf(retStudent.getGpa()));
				mysex.setText("男");
				if (retStudent.getSex()==0) {
					mysex.setText("女");
				}
			}
		});
	}
}
