import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.io.IOException;
import java.sql.*;

class NextPage1 extends JFrame implements ActionListener
{
	JButton bobj,bobj1,bobj2,bobj3;
	JLabel lobj3;
	Font fobj4,fobj5;
	public NextPage1()
	{
		setBounds(240,100,1000,520);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		bobj = new JButton("Give Attendence");
		bobj.setBackground(Color.GREEN);
		bobj.setBounds(0,0,300,120);
		Font fobj4 = new Font("sans-serif",Font.BOLD,22);
		bobj.setFont(fobj4);
		add(bobj);
		bobj1 = new JButton("New Entry");
		bobj1.setBackground(Color.GREEN);
		bobj1.setBounds(0,120,300,120);
		bobj1.setFont(fobj4);
		add(bobj1);

		bobj2 = new JButton("View Attendence");
		bobj2.setBackground(Color.GREEN);
		bobj2.setBounds(0,240,300,120);
		bobj2.setFont(fobj4);
		add(bobj2);

		bobj3 = new JButton("Exit");
		bobj3.setBackground(Color.GREEN);
		bobj3.setBounds(0,360,300,120);
		bobj3.setFont(fobj4);
		add(bobj3);

		lobj3  = new JLabel("!!! WELCOME TO PCCOE ATTENDENCE LOGIN PORTAL!!!");
		lobj3.setBackground(Color.WHITE);
		lobj3.setBounds(310,20,800,35);
		lobj3.setForeground(Color.MAGENTA);
		Font fobj5 = new Font("sans-serif",Font.BOLD|Font.ITALIC,22);
		lobj3.setFont(fobj5);
		add(lobj3);

		lobj3  = new JLabel("!!! OUR TEAM MEMBERS !!!");
		lobj3.setBackground(Color.WHITE);
		lobj3.setBounds(500,70,800,35);
		lobj3.setForeground(Color.MAGENTA);
		Font fobj1 = new Font("sans-serif",Font.BOLD|Font.ITALIC,25);
		lobj3.setFont(fobj1);
		add(lobj3);


		lobj3  = new JLabel("SYCOA145 Manisha Gadale");
		lobj3.setBackground(Color.WHITE);
		lobj3.setBounds(550,115,800,35);
		lobj3.setForeground(new Color(40, 40,40));
		Font fobj = new Font("sans-serif",Font.BOLD|Font.ITALIC,20);
		lobj3.setFont(fobj);
		add(lobj3);

		lobj3  = new JLabel("SYCOA146 Abhijit Gadhave");
		lobj3.setBackground(Color.WHITE);
		lobj3.setBounds(550,150,800,35);
		lobj3.setForeground(new Color(40, 40,40));
		lobj3.setFont(fobj);
		add(lobj3);

		lobj3  = new JLabel("SYCOA155 Yash Patel");
		lobj3.setBackground(Color.WHITE);
		lobj3.setBounds(550,185,800,35);
		lobj3.setForeground(new Color(40, 40,40));
		lobj3.setFont(fobj);
		add(lobj3);

		lobj3  = new JLabel(" Guided By :- ");
		lobj3.setBackground(Color.WHITE);
		lobj3.setBounds(560,240,800,35);
		lobj3.setForeground(Color.MAGENTA);
		Font fobj2 = new Font("sans-serif",Font.BOLD|Font.ITALIC,29);
		lobj3.setFont(fobj2);
		add(lobj3);

		lobj3  = new JLabel("Prof. Rahul Patil ");
		lobj3.setBackground(Color.WHITE);
		lobj3.setBounds(550,290,800,35);
		lobj3.setForeground(new Color(40, 40,40));
		lobj3.setFont(fobj);
		add(lobj3);

		lobj3  = new JLabel("Prof. Namrata Gawande");
		lobj3.setBackground(Color.WHITE);
		lobj3.setBounds(550,330,800,35);
		lobj3.setForeground(new Color(40, 40,40));
		lobj3.setFont(fobj);
		add(lobj3);

		lobj3  = new JLabel("Dr. Manjiri Ranjanikar");
		lobj3.setBackground(Color.WHITE);
		lobj3.setBounds(550,370,800,35);
		lobj3.setForeground(new Color(40, 40,40));
		lobj3.setFont(fobj);
		add(lobj3);

		bobj2.addActionListener(this);
		bobj1.addActionListener(this);
		bobj.addActionListener(this);
		bobj3.addActionListener(this);


		setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		Object obj = e.getSource();

		if(obj == bobj)
		{
			setVisible(false);
			Give1 gobj = new Give1();

		}
		if(obj == bobj3)
		{
			setVisible(false);
			System.exit(0);
		}
		else if(obj == bobj1)
		{
			setVisible(false);
			Insert1 iobj = new Insert1();
		}
		else if(obj == bobj2)
		{
			setVisible(false);
			View1 vobj = new View1();
		}

	}
}

class NextPage
{
	public static void main(String Arg[])
	{
		NextPage1  nobj = new NextPage1();
	}
}
