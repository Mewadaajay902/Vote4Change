/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evoting.dao;

import evoting.dbutil.DBConnection;
import evoting.dto.AddCandidateDto;
import evoting.dto.CandidateDetails;
import evoting.dto.updatecandidateDto;
import java.io.IOException;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Base64.Encoder;

/**
 *
 * @author Genius
 */
public class CandidateDao {
    private static Statement st,st2,st3;
    private static PreparedStatement ps,ps1,ps2,ps3,ps4;
    
    static
    {
        try
        {
            st=DBConnection.getConnection().createStatement();
            st2=DBConnection.getConnection().createStatement();
            st3=DBConnection.getConnection().createStatement();

            ps=DBConnection.getConnection().prepareStatement("Select username from user_details where adhar_no=?");
           ps1=DBConnection.getConnection().prepareStatement("insert into candidate values(?,?,?,?,?)");
           ps2=DBConnection.getConnection().prepareStatement("Select * from candidate where candidate_id=?");
           ps3=DBConnection.getConnection().prepareStatement("update candidate set party=?,city=?,symbol=? where candidate_id=?");
           ps4=DBConnection.getConnection().prepareStatement("delete from candidate where candidate_id=?");
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        
    }
        public static String getNewCandidateId() throws SQLException
        {
            ResultSet rs=st.executeQuery("Select count(*) from candidate");
            if(rs.next())
                return "C"+(100+(rs.getInt(1)+1));
            else
            {
                return "C101";
            }
        }
        public static String getUsernameById(String uid)throws SQLException
        {
            ps.setString(1,uid);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
                return rs.getString(1);
            return null;
        }


        public static ArrayList<String> getCity() throws SQLException
        {
            ResultSet rs=st2.executeQuery("select unique city from user_details");
            ArrayList<String> city=new ArrayList<>();
            while(rs.next())
                city.add(rs.getString(1));
            return city;
            
        
        } 
        public static boolean addCandidate(AddCandidateDto candidate) throws Exception
        {
            ps1.setString(1, candidate.getCandidateId());
            ps1.setString(2, candidate.getParty());
            ps1.setBinaryStream(4, candidate.getSymbol(),candidate.getSymbol().available());
            ps1.setString(5, candidate.getCity());
            ps1.setString(3, candidate.getUserId());
            return (ps1.executeUpdate()!=0);       
        }
        public static ArrayList<String> getCandidateId()throws SQLException
        {
            ResultSet rs=st3.executeQuery("select candidate_id from candidate");
            ArrayList<String> id=new ArrayList<>();
            while(rs.next())
            {
                id.add(rs.getString(1));
            }
            return id;
        }
        
        public static CandidateDetails getDetailsById(String cid)throws SQLException
        {
            ps2.setString(1,cid);
            ResultSet rs=ps2.executeQuery();
            CandidateDetails candidate=new CandidateDetails();
            Blob blob;
            byte[] imageBytes;
            String base64Image;
            if(rs.next())
            {
                blob=rs.getBlob(4);
                imageBytes=blob.getBytes(1L,(int)blob.length());
                Encoder ec=Base64.getEncoder();
                base64Image=ec.encodeToString(imageBytes);
                candidate.setSymbol(base64Image);
                candidate.setCandidateId(cid);
                candidate.setParty(rs.getString(2));
                 candidate.setUserId(rs.getString(3));
                 candidate.setCity(rs.getString(5));              
            }
            return candidate;
        }
      public static boolean updateCandidate(updatecandidateDto cnd) throws SQLException, IOException
      {
         ps3.setString(4, cnd.getCandidateId());
         ps3.setString(1, cnd.getParty());
         ps3.setString(2, cnd.getCity());
         ps3.setBinaryStream(3, cnd.getSymbol(), cnd.getSymbol().available());
          int result= ps3.executeUpdate();
          return (result!=0);
      }
        
       public static boolean deleteCandidate(String candidateId)throws SQLException
       {
        ps4.setString(1, candidateId);
        int result=ps4.executeUpdate();
        if(result>0)
    {
    return true;
    }
    return false;   
       }
        
}
    

