package testdatabase;
/**
 *
 * @author rajes
 */
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Type4Select 
{
    public static void main(String[] args) 
    {
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    
    try
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver Loaded");
        
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdatabase","root","root");
        System.out.println("Connected");
        
        st = con.createStatement();
        String query= "Select * from emp";
        
        rs = st.executeQuery(query);
        while(rs.next())
        {
            System.out.print(rs.getString(1)+"\t");
            System.out.print(rs.getString(2)+"\t");
            System.out.print(rs.getString(3)+"\t");
            System.out.println(rs.getString(4));
        }
        con.close();
    }
    catch(ClassNotFoundException | SQLException e)
    {
        System.out.println(e);
    }
    }
    
}
