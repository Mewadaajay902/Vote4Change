<%@page import="evoting.dto.UserDetails"%>
<%@page import="evoting.dto.CandidateDetails" %> 
<%@page import="java.util.ArrayList" %>
<%
    String userid= (String)session.getAttribute("userid");
     if(userid== null)
     {
         response.sendRedirect("accessdenied.html");
          return;
     }
     String result=(String) request.getAttribute("result");
     StringBuffer displayBlock=new StringBuffer("");
     if(result.equals("adharIdList"))
     {
       ArrayList<String> candidateId= (ArrayList) request.getAttribute("adharId");
       for(String c: candidateId)
       {
      displayBlock.append("<option value='"+c+"'>"+c+"</option>");
       }
       out.println(displayBlock);
     }
     else if(result.equals("details"))
     {
     UserDetails candidate= (UserDetails) request.getAttribute("candidate");
     String str="";
     displayBlock.append("<form><table allign='center'>"
             +"<tr><th>Username:</th><td>"+candidate.getUsername()+"</td></tr>"
     +"<tr><th>Address:</th><td>"+candidate.getAddress()+"</td></tr>"
             +"<tr ><th >City:</th><td>"+candidate.getCity()+"</td></tr>"
             +"<tr ><th >Email:</th><td>"+candidate.getEmail()+"</td></tr>"
             +"<tr ><th >Mobile:</th><td>"+candidate.getMobile()+"</td></tr>"
             +"<tr><th>Password:</th><td>"+candidate.getPassword()+"</td></tr>"
             //+"<tr><td>Username:</th><td>"+candidate.getUsername()+"</td></tr>"
             
                     +"<tr ><th></th><th ><input type='button' value='Delete User' onclick='deletecandidate()' id='deletecnd' ></th></tr>"        
   +"</table></form>");
             out.println(displayBlock);
             
     }
    %>
