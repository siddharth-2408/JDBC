package testdatabase;
/**
 *
 * @author rajes
 */
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Type4Update
{
    public static void main(String[] args) 
    {
    Connection con = null;
    Statement st = null;
    
    try
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver Loaded");
        
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdatabase","root","root");
        System.out.println("Connected");
        
        st = con.createStatement();
        String query= "UPDATE emp SET empsalary = 100000 where empid=105";
        
        int i = st.executeUpdate(query);
        if(i>0)
            System.out.println(i+" Record Updated");
        else
            System.out.println("Record Updation Failed");
        con.close();
    }
    catch(ClassNotFoundException | SQLException e)
    {
        System.out.println(e);
    }
    }
    
}
