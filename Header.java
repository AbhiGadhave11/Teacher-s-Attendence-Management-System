import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.io.IOException;
import java.sql.*;


class Start extends JFrame implements ActionListener
{
	ImageIcon iobj;
	JButton bobj,bobj1,bobj2;
	JTextField tobj,tobj1;
	JLabel lobj1,lobj2,lobj3,lobj4;

	public Start(String str)
	{
		setBounds(200,100,1000,500);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		iobj = new ImageIcon(ClassLoader.getSystemResource("Logo.jpg"));
        JLabel lobj = new JLabel(iobj);
        lobj.setBounds(0,-44,500,550);
		add(lobj);


		lobj1 = new JLabel("Enter the UserName");
		lobj1.setBackground(Color.WHITE);
		lobj1.setBounds(600,125,350,50);
		Font fobj = new Font("sans-serif",Font.BOLD,15);
		lobj1.setFont(fobj);
		lobj1.setForeground(new Color(30,144,254));
		add(lobj1);

		lobj4 = new JLabel("Enter the Password");
		lobj4.setBackground(Color.WHITE);
		lobj4.setBounds(600,190,450,50);
		lobj4.setFont(fobj);
		lobj4.setForeground(new Color(30,144,254));
		add(lobj4);
		
		
		lobj3  = new JLabel("!!! WELCOME TO PCCOE ATTENDENCE LOGIN PORTAL!!!");
		lobj3.setBackground(Color.WHITE);
		lobj3.setBounds(120,20,800,35);
		lobj3.setForeground(Color.MAGENTA);
		Font fobj5 = new Font("sans-serif",Font.BOLD|Font.ITALIC,25);
		lobj3.setFont(fobj5);

		add(lobj3);

		lobj2 = new JLabel("Login Here...");
		Font  fobj2  = new Font(Font.DIALOG_INPUT,  Font.BOLD|Font.ITALIC, 20);
		lobj2.setBackground(Color.WHITE);
		lobj2.setBounds(575,80,300,50);
		lobj2.setForeground(Color.DARK_GRAY);
		lobj2.setFont(fobj2);
		add(lobj2);

		
		tobj = new JTextField();
		Font fobj3 = new Font("Times New Roman",Font.BOLD,18);
		tobj.setBounds(560,170,300,25);
		tobj.setFont(fobj3);
		tobj.setToolTipText("Enter USERNAME");
		tobj.setHorizontalAlignment(JTextField.CENTER);
		tobj.setForeground(Color.DARK_GRAY);
		add(tobj);

		tobj1 = new JPasswordField(15); 
		tobj1.setBounds(560,230,300,25);
		tobj1.setFont(fobj3);
		tobj1.setToolTipText("Enter Password");
		tobj1.setHorizontalAlignment(JTextField.CENTER);
		tobj1.setForeground(Color.DARK_GRAY);
		add(tobj1);

		bobj = new JButton("RESET");
		bobj.setBackground(Color.GREEN);
		bobj.setBounds(560,300,100,30);
		Font fobj4 = new Font("sans-serif",Font.BOLD,15);
		bobj.setFont(fobj4);
		add(bobj);

		bobj1 = new JButton("Login");
		bobj1.setBounds(760,300,100,30);
		bobj1.setBackground(Color.GREEN);
		bobj1.setFont(fobj4);
		add(bobj1);

		bobj2 = new JButton("EXIT");
		bobj2.setBounds(660,360,100,30);
		bobj2.setBackground(Color.GREEN);
		bobj2.setFont(fobj4);
		add(bobj2);

		bobj2.addActionListener(this);
		bobj1.addActionListener(this);
		bobj.addActionListener(this);

		setVisible(true);

	}

	public void actionPerformed(ActionEvent e)
	{
		Object obj = e.getSource();

		if(obj == bobj)
		{
			setVisible(false);
			Start sobj = new Start("Quiz");

		}
		if(obj == bobj2)
		{
			System.exit(0);
		}
		else if(obj == bobj1)
		{
			String user = tobj. getText();
			String pass = tobj1.getText();
			if(user.equals("system") && pass.equals("pccoe"))
			{
				setVisible(false);

				NextPage1 nobj = new NextPage1();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Invalid Username and Password");

			}
		}
	}
}

class Header
{
	public static void main(String Arg[])
	{
		Start sobj = new Start("Quiz");
	}
}