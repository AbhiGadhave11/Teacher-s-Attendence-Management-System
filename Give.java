import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.io.IOException;
import java.text.*;
import java.util.Calendar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

class Give1 extends JFrame implements ActionListener
{
	JButton bobj,bobj1,bobj2,bobj3;
	JLabel lobj3;
	Font fobj4,fobj5;
	JTextField tobj,tobj1;
	public Give1()
	{
		setBounds(330,120,700,420);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		lobj3  = new JLabel("!!! Give Your Attendence !!!");
		lobj3.setBackground(Color.WHITE);
		lobj3.setBounds(150,20,800,35);
		lobj3.setForeground(Color.MAGENTA);
		Font fobj5 = new Font("sans-serif",Font.BOLD|Font.ITALIC,28);
		lobj3.setFont(fobj5);
		add(lobj3);

		lobj3  = new JLabel("Enter ID Number");
		lobj3.setBackground(Color.WHITE);
		lobj3.setBounds(220,70,500,35);
		lobj3.setForeground(Color.GREEN);
		Font fobj1 = new Font("sans-serif",Font.BOLD|Font.ITALIC,23);
		lobj3.setFont(fobj1);
		add(lobj3);

		tobj = new JTextField();
		Font fobj3 = new Font("Times New Roman",Font.BOLD,18);
		tobj.setBounds(250,110,150,30);
		tobj.setFont(fobj3);
		tobj.setHorizontalAlignment(JTextField.CENTER);
		tobj.setForeground(Color.DARK_GRAY);
		add(tobj);

		lobj3  = new JLabel("Enter The First Name");
		lobj3.setBackground(Color.WHITE);
		lobj3.setBounds(190,150,500,35);
		lobj3.setForeground(Color.GREEN);
		lobj3.setFont(fobj1);
		add(lobj3);

		tobj1 = new JTextField(15); 
		tobj1.setBounds(250,190,150,30);
		tobj1.setFont(fobj3);
		tobj1.setHorizontalAlignment(JTextField.CENTER);
		tobj1.setForeground(Color.DARK_GRAY);
		add(tobj1);

		bobj = new JButton("FOR EXIT");
		bobj.setBackground(Color.GREEN);
		bobj.setBounds(450,250,150,70);
		Font fobj4 = new Font("sans-serif",Font.BOLD,18);
		bobj.setFont(fobj4);
		add(bobj);
		
		bobj1 = new JButton("FOR ENTRY");
		bobj1.setBackground(Color.GREEN);
		bobj1.setBounds(250,250,150,70);
		bobj1.setFont(fobj4);
		add(bobj1);

		bobj2 = new JButton("Back");
		bobj2.setBackground(Color.GREEN);
		bobj2.setBounds(50,250,150,70);
		bobj2.setFont(fobj4);
		add(bobj2);

		bobj.addActionListener(this);
		bobj1.addActionListener(this);
		bobj2.addActionListener(this);
		setVisible(true);

		//Abhijit Kailas Gadhave.


		
	}

	public void actionPerformed(ActionEvent e)
	{
		Object obj = e.getSource();
		
		if(obj == bobj1)
		{
			
			String idn = tobj.getText();
		    int id = Integer.parseInt(idn);
		        
			try
		    {
		    	
		         
		        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","root","root");

		        Statement stmt = conn.createStatement();
		        ResultSet rs = stmt.executeQuery("SELECT *FROM Basic_Details where ID_Number="+id);
		        int i = 0;
		        while (rs.next()) 
		        {
		                i++;
		                
		        }
		        if(i != 0)
		        {
		        	Date dated = new Date();
					SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
					String Data = formatter.format(dated);
					Data = Data.trim();
			        String[] newStr = Data.split("\\s+");
			        String Dates = newStr[0];
			        String Time = newStr[1];
			        
			        String[] arrOfDate = Dates.split("-");
			        String NewDate = arrOfDate[2]+"-"+arrOfDate[1]+"-"+arrOfDate[0];


		            String data = "Insert into Entry values("+id+",'"+NewDate+"',"+"'"+Time+"'"+");";
		           	stmt.executeUpdate(data);
		           
		           	JOptionPane.showMessageDialog(null, "!!! Entry Inserted Successfully !!!");

		           	conn.close();
		           	stmt.close();

		        }
		        else
		        {
		        	JOptionPane.showMessageDialog(null, "Enter the Correct Information");

		        }


		    } 
		    catch (Exception eo) 
		    {
		        eo.printStackTrace();
		        System.out.println("Exception occured : "+eo+"\n");
		    } 


		}
		else if(obj == bobj)
		{
			String idn = tobj.getText();

		    if(idn == "")
		    {
				JOptionPane.showMessageDialog(null, "!!! You are Not Entered Data !!!");

		    }
		    else
		    {
				try
			    {
			         
			        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","root","root");

			        Statement stmt = conn.createStatement();
			        
			        
			        
			        	int id = Integer.parseInt(idn);
				        ResultSet rs = stmt.executeQuery("SELECT *FROM Basic_Details where ID_Number="+id);
				        int i = 0,j = 0;
				        while (rs.next()) 
				        {
				                i++;
				                
				        }
				        rs = stmt.executeQuery("SELECT *FROM Entry where ID_Number="+id);
				        while (rs.next()) 
				        {
				            j++;
				                
				        }
				        if(i != 0 && j!=0)
				        {
				        	Date dated = new Date();
							SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
							String Data = formatter.format(dated);
							Data = Data.trim();
					        String[] newStr = Data.split("\\s+");
					        String Dates = newStr[0];
					        String Time = newStr[1];
					        String[] arrOfDate = Dates.split("-");
					        String NewDate = arrOfDate[2]+"-"+arrOfDate[1]+"-"+arrOfDate[0];

				            String data = "Insert into Exits values("+id+",'"+NewDate+"',"+"'"+Time+"'"+");";
				           	stmt.executeUpdate(data);
				           	
					        JOptionPane.showMessageDialog(null, "!!! Data Inserted Successfully !!!");


				        }
				        else if(i!=0 && j == 0)
				        {
				        	JOptionPane.showMessageDialog(null, "You are Not Entered Today's Entry");

				        }
				        else
				        {
				        	JOptionPane.showMessageDialog(null, "Enter the Correct Information");

				        }

				        conn.close();
				        stmt.close();

				    
				} 
				catch (Exception eo) 
				{
				    eo.printStackTrace();
				    System.out.println("Exception occured : "+eo+"\n");
				}
			}
		}
		else if(obj == bobj2)
		{
			setVisible(false);
			NextPage1 nobj = new NextPage1();
		}

	}
}

class Give 
{
	public static void main(String Arg[])
	{
		Give1 gobj = new Give1();
	}
}