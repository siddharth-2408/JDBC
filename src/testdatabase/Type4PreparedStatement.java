package testdatabase;
/**
 *
 * @author rajes
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Type4PreparedStatement
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Id:- ");
        int id = sc.nextInt();
        
        System.out.print("Enter Name:- ");
        String empname = sc.next();
        
        System.out.print("Enter Salary:- ");
        int empsalary = sc.nextInt();
        
        System.out.print("Enter City:- ");
        String empcity = sc.next();
        
        
        Connection con = null;
        PreparedStatement pst = null;
    
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
        
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdatabase","root","root");
            System.out.println("Connected");
        
            pst = con.prepareStatement("INSERT INTO emp VALUES(?,?,?,?)");
            
            pst.setInt(1, id);
            pst.setString(2, empname);
            pst.setInt(3, empsalary);
            pst.setString(4, empcity);
        
            int i = pst.executeUpdate();
            if(i>0)
                System.out.println(i+" Record Inserted");
            else
                System.out.println("Record Insertion Failed");
            con.close();
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
        }
    } 
}
