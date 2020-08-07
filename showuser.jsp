<%@page import="java.util.ArrayList"%>
<%@page import="evoting.dto.UserDetails"%>

<%
 String userid=(String) session.getAttribute("userid");
 if(userid==null)
 {
   response.sendRedirect("accessdenied.html");
 }
 ArrayList <UserDetails> candidate= (ArrayList) request.getAttribute("userDetails");
 StringBuffer displayBuffer = new StringBuffer();
 //displayBuffer.append("");
 for(UserDetails cnd: candidate)
 { displayBuffer.append("<table>"
          +"<tr><th></th><td></td></tr>"
         +"<tr><th>User Name: </th><td>"+cnd.getUsername()+"</td></tr>"
     +"<tr><th>UserId: </th><td>"+cnd.getUserid()+"</td></tr>"
             //+"<tr><th>User Name:</th><td>"+cnd.getUsername()+"</td></tr>"
             +"<tr><th>Password: </th><td>"+cnd.getPassword()+"</td></tr>"
             +"<tr><th>Address: </th><td>"+cnd.getAddress()+"</td></tr>"
             +"<tr><th>City: </th><td>"+cnd.getCity()+"</td></tr>"
             +"<tr><th>Email: </th><td>"+cnd.getEmail()+"</td></tr>"
              +"<tr><th>Mobile: </th><td>"+cnd.getMobile()+"</td></tr>" 
                     
   +"</table> :::::::   ");
 }
             out.println(displayBuffer);
%>
