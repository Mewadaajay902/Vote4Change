
package evoting.dao;
import evoting.dbutil.DBConnection;
import evoting.dto.CandidateDto;
import evoting.dto.UserDetails;
import evoting.dto.UserDto;
import java.io.IOException;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

public class UserDao 
{
    private static PreparedStatement ps,ps3,ps4,ps5,ps6,ps7,ps8,ps9;
    static
    {
        try
        {
            ps=DBConnection.getConnection().prepareStatement("Select * from user_details where adhar_no=? and password=?");
             ps3=DBConnection.getConnection().prepareStatement("select * from user_details where user_type=?");
            ps4=DBConnection.getConnection().prepareStatement("select adhar_no from user_details where user_type='Voter'");
             ps5=DBConnection.getConnection().prepareStatement("Select candidate_id,username,party,symbol from candidate,user_details where candidate.user_id=user_details.adhar_no and candidate.city=(select city from user_details where adhar_no=?) ");
             ps6=DBConnection.getConnection().prepareStatement("select * from user_details where adhar_no=?");
       ps7=DBConnection.getConnection().prepareStatement("delete from voting where user_id=?");
     ps8=DBConnection.getConnection().prepareStatement("delete from user_details where adhar_no=?");
       ps9=DBConnection.getConnection().prepareStatement("update user_details set password=?,username=?,address=?,city=?,email=?,mobile_no=? where adhar_no=? ");
        }
        
        catch(SQLException e){
            if(DBConnection.getConnection()!=null)
            System.out.println("not null");
            e.printStackTrace();
        }
        catch(Exception ex)
        {
            System.out.println("Error in db comm:"+ex);
        }
    }
    public static String validateUser(UserDto user)throws SQLException
    {
        ps.setString(1,user.getUserid());
        ps.setString(2,user.getPassword());
        ResultSet rs=ps.executeQuery();
                if(rs.next())
                {
                    return rs.getString(8);
                }
                else
                {   
                    return null;
                }
    }
    public static ArrayList<CandidateDto> viewCandidate(String userId)throws SQLException,IOException
    {
        ArrayList<CandidateDto> candidate=new ArrayList<>();
        ps5.setString(1,userId);
        ResultSet rs=ps5.executeQuery();
        Blob blob;
        byte[] imageBytes;
        String base64Image;
        while(rs.next())
                {
                    blob=rs.getBlob(4);
                    imageBytes=blob.getBytes(1L,(int)blob.length());
                    base64Image=Base64.getEncoder().encodeToString(imageBytes);
                    candidate.add(new CandidateDto(rs.getString(1),rs.getString(2),rs.getString(3),base64Image));
                }
        return candidate;                   
                }
    
        
 public static ArrayList<UserDetails> viewUser() throws SQLException
  {
    ps3.setString(1,"Voter");
    ResultSet rs= ps3.executeQuery();
    ArrayList<UserDetails> userD= new ArrayList<>();
    //userDetails user= new userDetails();
    while(rs.next())
    {
       
      userD.add( new UserDetails(rs.getString(3),rs.getString(1),rs.getString(6),rs.getString(4),rs.getLong(7),rs.getString(5),rs.getString(2)));
    
     
    }
    return userD;
  }
    
 
 
 


 
public static ArrayList<String> getAdhar() throws SQLException
  {
      ArrayList<String> adharId= new ArrayList<>();
     ResultSet rs= ps4.executeQuery();
     while(rs.next())
     {
         adharId.add(rs.getString(1));
     }
     return adharId;
  }
  



 
 public static UserDetails getDetailsByAdhar(String adharNo) throws SQLException
  {
  ps6.setString(1, adharNo);
   ResultSet rs= ps6.executeQuery();
   UserDetails user= new UserDetails();
   while(rs.next())
   {
    user.setPassword(rs.getString(2));
    user.setAddress(rs.getString(4));
    user.setCity(rs.getString(5));
    user.setEmail(rs.getString(6));
    user.setMobile(rs.getLong(7));
    user.setUsername(rs.getString(3));
    return user;
   }
   return null;
  }





 
 public static boolean deleteUser(String adharNo) throws SQLException
  {
    ps7.setString(1, adharNo);
    ps8.setString(1, adharNo);
    int result= ps7.executeUpdate();
    int result1= ps8.executeUpdate();
    if(result>0 && result1>0)
    {
    return true;
    }
    return false;
  }

public static boolean updateUser(UserDetails user) throws SQLException, IOException
      {
         ps9.setString(1, user.getPassword());
         ps9.setString(2, user.getUsername());
         ps9.setString(3, user.getAddress());
         ps9.setString(4, user.getCity());
         ps9.setString(5, user.getEmail());
         ps9.setDouble(6, user.getMobile());
         ps9.setString(7, user.getUserid());

          int result= ps9.executeUpdate();
          return (result!=0);
      }
    
    
    }

