package evoting.dbutil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection
{
    private static Connection conn;
    static 
    {
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-21CMEF8:1521/XE","e_voting_db","evoting");
            System.out.println("connection opened !");
        }
        catch(Exception ex)
        {
            System.out.println("Error connecting to the Database:"+ex);
        }
    }
    public static Connection getConnection()
    {
        return conn;
    }
    public static void closeConnection()
    {
        if(conn!=null)
        {
            try
            {
                conn.close();
                System.out.println("Disconnected Successfully from the Database");
            }
            catch(SQLException ex)
            {
                System.out.println("Error in disconnecting from the db:"+ex);
            }
            }
        }
    
}