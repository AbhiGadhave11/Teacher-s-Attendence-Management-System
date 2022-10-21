import java.sql.*;
//import java.util.*;
//import com.mysql.jdbc.*;
//import java.sql.*;


class DataBase 
{
   public static void main(String args[]) 
   {
      try
      {
         
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Assignment_2","root","root");
            //Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/PPA26?user=root&password=123");


            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT *FROM Account");
          
            while (rs.next()) 
            {
                System.out.print("Acc_No: " + rs.getInt("Acc_no"));
                System.out.println();
                System.out.println("Branch Name : "+rs.getString("branch_name"));
                System.out.println();
                System.out.print("Balance : " + rs.getInt("balance"));
                System.out.println();
                
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            System.out.print("Exception occured : "+e+"\n");
        } 

    }
}
