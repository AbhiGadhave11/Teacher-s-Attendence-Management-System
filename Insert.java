import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.io.IOException;
import java.sql.*;


class Insert1 extends JFrame implements ActionListener
{
	JButton bobj,bobj1,bobj2;
	JTextField tobj,tobj1,tobj2,tobj3,tobj4,tobj5;
	JLabel lobj1,lobj2,lobj3,lobj4;
	
	public Insert1()
	{
		setBounds(330,120,550,520);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		lobj3  = new JLabel("!!! Insert New Entry !!!");
		lobj3.setBackground(Color.WHITE);
		lobj3.setBounds(90,20,800,35);
		lobj3.setForeground(Color.MAGENTA);
		Font fobj5 = new Font("sans-serif",Font.BOLD|Font.ITALIC,30);
		lobj3.setFont(fobj5);
		add(lobj3);

		lobj3  = new JLabel("Enter ID Number");
		lobj3.setBackground(Color.WHITE);
		lobj3.setBounds(100,90,500,35);
		lobj3.setForeground(Color.GREEN);
		Font fobj1 = new Font("sans-serif",Font.BOLD|Font.ITALIC,23);
		lobj3.setFont(fobj1);
		add(lobj3);

		tobj = new JTextField();
		Font fobj3 = new Font("Times New Roman",Font.BOLD,18);
		tobj.setBounds(330,90,120,30);
		tobj.setFont(fobj3);
		tobj.setHorizontalAlignment(JTextField.CENTER);
		tobj.setForeground(Color.DARK_GRAY);
		add(tobj);

		lobj3  = new JLabel("Enter First Name");
		lobj3.setBackground(Color.WHITE);
		lobj3.setBounds(100,140,500,35);
		lobj3.setForeground(Color.GREEN);
		lobj3.setFont(fobj1);
		add(lobj3);

		tobj1 = new JTextField();
		tobj1.setBounds(330,140,120,30);
		tobj1.setFont(fobj3);
		tobj1.setHorizontalAlignment(JTextField.CENTER);
		tobj1.setForeground(Color.DARK_GRAY);
		add(tobj1);

		lobj3  = new JLabel("Enter Last Name");
		lobj3.setBackground(Color.WHITE);
		lobj3.setBounds(100,190,500,35);
		lobj3.setForeground(Color.GREEN);
		lobj3.setFont(fobj1);
		add(lobj3);

		tobj2 = new JTextField();
		tobj2.setBounds(330,190,120,30);
		tobj2.setFont(fobj3);
		tobj2.setHorizontalAlignment(JTextField.CENTER);
		tobj2.setForeground(Color.DARK_GRAY);
		add(tobj2);

		lobj3  = new JLabel("Enter Age");
		lobj3.setBackground(Color.WHITE);
		lobj3.setBounds(100,240,500,35);
		lobj3.setForeground(Color.GREEN);
		lobj3.setFont(fobj1);
		add(lobj3);

		tobj3 = new JTextField();
		tobj3.setBounds(330,240,120,30);
		tobj3.setFont(fobj3);
		tobj3.setHorizontalAlignment(JTextField.CENTER);
		tobj3.setForeground(Color.DARK_GRAY);
		add(tobj3);

		lobj3  = new JLabel("Enter User Name");
		lobj3.setBackground(Color.WHITE);
		lobj3.setBounds(100,290,500,35);
		lobj3.setForeground(Color.GREEN);
		lobj3.setFont(fobj1);
		add(lobj3);

		tobj4 = new JTextField();
		tobj4.setBounds(330,290,120,30);
		tobj4.setFont(fobj3);
		tobj4.setHorizontalAlignment(JTextField.CENTER);
		tobj4.setForeground(Color.DARK_GRAY);
		add(tobj4);

		lobj3  = new JLabel("Enter Password");
		lobj3.setBackground(Color.WHITE);
		lobj3.setBounds(100,340,500,35);
		lobj3.setForeground(Color.GREEN);
		lobj3.setFont(fobj1);
		add(lobj3);

		tobj5 = new JPasswordField(15); 
		tobj5.setBounds(330,340,120,30);
		tobj5.setFont(fobj3);
		tobj5.setHorizontalAlignment(JTextField.CENTER);
		tobj5.setForeground(Color.DARK_GRAY);
		add(tobj5);

		bobj = new JButton("Insert Entry");
		bobj.setBackground(Color.GREEN);
		bobj.setBounds(250,400,250,70);
		Font fobj4 = new Font("sans-serif",Font.BOLD,18);
		bobj.setFont(fobj4);
		add(bobj);

		bobj2 = new JButton("Back");
		bobj2.setBackground(Color.GREEN);
		bobj2.setBounds(50,400,150,70);
		bobj2.setFont(fobj4);
		add(bobj2);

		
		bobj.addActionListener(this);
		bobj2.addActionListener(this);
		
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		Object obj = e.getSource();
		if(obj == bobj)
		{
			String user = tobj4. getText();
			String pass = tobj5.getText();
			if(user.equals("system") && pass.equals("pccoe"))
			{
				try
		      	{
		         
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","root","root");

		            //PreparedStatement ps = null;
		            String idn = tobj.getText();
		            String fname = tobj1.getText();
		            String lname = tobj2.getText();
		            String sage = tobj3.getText();
		            int age = Integer.parseInt(sage);
		            int id = Integer.parseInt(idn); 
		            Statement stmt = conn.createStatement();
		            String data = "Insert into Basic_Details values("+id+",'"+fname+"',"+"'"+lname+"',"+age+");";
		           	stmt.executeUpdate(data);
		           	//Insert int stud values(101,'Abhi','Gadhave',19);

		           	JOptionPane.showMessageDialog(null, "!!! Entry Inserted Successfully !!!");

		            
		        } 
		        catch(SQLIntegrityConstraintViolationException eobj)
		        {
		        	JOptionPane.showMessageDialog(null, "ID Number is already present in database please enter the another ID");
		        }
		        catch (Exception eo) 
		        {
		            eo.printStackTrace();
		            System.out.println("Exception occured : "+eo+"\n");
		        } 
		       	
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Invalid Username and Password");

			}
		}
		else
		{
			setVisible(false);
			NextPage1 nobj = new NextPage1();
		}

	
	}
}

class Insert
{
	public static void main(String Arg[])
	{
		Insert1 iobj = new Insert1(); 
	}

}
