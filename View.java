import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.io.IOException;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

class View1 extends JFrame implements ActionListener
{

	JButton bobj,bobj2;
	JFrame frame1;
	JLabel lobj3;
	Font fobj4,fobj5;
	JTextField tobj,tobj1,tobj3;
	JComboBox c1;
	static JTable table;
	String from;
    String[] columnNames = {"ID_Number", "Date", "Entry_Time","Exit_Time"};
	public View1()
	{
		setBounds(330,120,550,520);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		lobj3  = new JLabel("!!! View Your Attendence !!!");
		lobj3.setBackground(Color.WHITE);
		lobj3.setBounds(60,20,800,35);
		lobj3.setForeground(Color.MAGENTA);
		Font fobj5 = new Font("sans-serif",Font.BOLD|Font.ITALIC,28);
		lobj3.setFont(fobj5);
		add(lobj3);

		lobj3  = new JLabel("Enter ID Number");
		lobj3.setBackground(Color.WHITE);
		lobj3.setBounds(100,90,500,35);
		lobj3.setForeground(Color.GREEN);
		Font fobj1 = new Font("sans-serif",Font.BOLD|Font.ITALIC,23);
		lobj3.setFont(fobj1);
		add(lobj3);

		tobj3 = new JTextField();
		Font fobj3 = new Font("Times New Roman",Font.BOLD,18);
		tobj3.setBounds(330,90,120,30);
		tobj3.setFont(fobj3);
		tobj3.setHorizontalAlignment(JTextField.CENTER);
		tobj3.setForeground(Color.DARK_GRAY);
		add(tobj3);

		lobj3  = new JLabel("Enter First Name");
		lobj3.setBackground(Color.WHITE);
		lobj3.setBounds(100,140,500,35);
		lobj3.setForeground(Color.GREEN);
		lobj3.setFont(fobj1);
		add(lobj3);

		tobj = new JTextField();
		tobj.setBounds(330,140,120,30);
		tobj.setFont(fobj3);
		tobj.setHorizontalAlignment(JTextField.CENTER);
		tobj.setForeground(Color.DARK_GRAY);
		add(tobj);

		lobj3  = new JLabel("Enter Last Name");
		lobj3.setBackground(Color.WHITE);
		lobj3.setBounds(100,190,500,35);
		lobj3.setForeground(Color.GREEN);
		lobj3.setFont(fobj1);
		add(lobj3);

		tobj = new JTextField();
		tobj.setBounds(330,190,120,30);
		tobj.setFont(fobj3);
		tobj.setHorizontalAlignment(JTextField.CENTER);
		tobj.setForeground(Color.DARK_GRAY);
		add(tobj);

		lobj3  = new JLabel("Enter User Name");
		lobj3.setBackground(Color.WHITE);
		lobj3.setBounds(100,240,500,35);
		lobj3.setForeground(Color.GREEN);
		lobj3.setFont(fobj1);
		add(lobj3);

		tobj = new JTextField();
		tobj.setBounds(330,240,120,30);
		tobj.setFont(fobj3);
		tobj.setHorizontalAlignment(JTextField.CENTER);
		tobj.setForeground(Color.DARK_GRAY);
		add(tobj);

		lobj3  = new JLabel("Enter Password");
		lobj3.setBackground(Color.WHITE);
		lobj3.setBounds(100,290,500,35);
		lobj3.setForeground(Color.GREEN);
		lobj3.setFont(fobj1);
		add(lobj3);

		tobj1 = new JPasswordField(15); 
		tobj1.setBounds(330,290,120,30);
		tobj1.setFont(fobj3);
		tobj1.setHorizontalAlignment(JTextField.CENTER);
		tobj1.setForeground(Color.DARK_GRAY);
		add(tobj1);

		bobj = new JButton("View Attendence");
		bobj.setBackground(Color.GREEN);
		bobj.setBounds(250,350,250,70);
		Font fobj4 = new Font("sans-serif",Font.BOLD,18);
		bobj.setFont(fobj4);
		add(bobj);

		bobj2 = new JButton("Back");
		bobj2.setBackground(Color.GREEN);
		bobj2.setBounds(50,350,150,70);
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
			String user = tobj. getText();
			String pass = tobj1.getText();
			if(user.equals("system") && pass.equals("pccoe"))
			{
				frame1 = new JFrame("Database Search Result");
				frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame1.setLayout(new BorderLayout());
				DefaultTableModel model = new DefaultTableModel();
				model.setColumnIdentifiers(columnNames);
				table = new JTable();
				table.setModel(model); 
				table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
				table.setFillsViewportHeight(true);
				JScrollPane scroll = new JScrollPane(table);
				scroll.setHorizontalScrollBarPolicy(
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scroll.setVerticalScrollBarPolicy(
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				String ID_Number = "";
				String date = "";
				String Entry_Time = "";
				String Exit_Time = "";
				String id = tobj3. getText();
				int idn = Integer.parseInt(id);
				try
		      	{
		         
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","root","root");


		            Statement stmt = conn.createStatement();
		            //ResultSet rs = stmt.executeQuery("SELECT *FROM Attendance where ID_Number="+idn);
		          	ResultSet rs = stmt.executeQuery("SELECT *FROM "+"Entry"+" NATURAL JOIN "+"Exits where ID_Number="+idn);
		          	int i = 0;
		            while (rs.next()) 
		            {
		                ID_Number = rs.getString("ID_Number");

		                date = rs.getString("Entry_Date");

		                Entry_Time = rs.getString("Entry_Time");

		                Exit_Time = rs.getString("Exit_Time");

		                model.addRow(new Object[]{ID_Number,date, Entry_Time,Exit_Time});
		                i++;
		                
		            }
		            if(i == 0)
		            {
		            	JOptionPane.showMessageDialog(null, "There Is No Such Entry In The Database");

		            }
		            else
		            {
		            	frame1.add(scroll);
						frame1.setVisible(true);
						frame1.setSize(400,300);
		            }
		            
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
	
class View 
{
	public static void main(String[] args) throws Exception
	{
	    View1 iobj = new View1();            
	}
}