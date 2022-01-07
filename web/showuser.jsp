<%@page import="java.util.ArrayList"%>
<%@page import="evoting.dto.UserDetails"%>

<%
 String userid=(String) session.getAttribute("userid");
 if(userid==null)
 {
   response.sendRedirect("accessdenied.html");
 }
 ArrayList <UserDetails> candidate= (ArrayList) request.getAttribute("userDetails");
 //StringBuffer displayBuffer = new StringBuffer();
 //displayBuffer.append("");
 /*for(UserDetails cnd: candidate)
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
 }*/
 
 StringBuffer displayBlock = new StringBuffer("<table style'background-color:#00FF00' style='width:100%' border='5' bordercolor='white' cellspacing='3px' cellpadding='5px' align='center'>");
 displayBlock.append("<tr bgcolor='black' style='height:50px' ><td align='center' >SNo.</td><td align='center'>user name</td><td align='center'>user id</td><td align='center'>password</td><td align='center'>address</td><td align='center'>city</td><td align='center'>email id</td><td align='center'>mobile</td></tr>");
 int count=1;
 for(UserDetails cnd: candidate)
    {
        
        displayBlock.append("<tr  style='outline: thin solid' ><td align='center'>"+count+"</td><td align='center'>"+cnd.getUsername()+"</td><td align='center'>"+cnd.getUserid()+"</td><td align='center'>"+cnd.getPassword()+"</td><td align='center'>"+cnd.getAddress()+"</td><td align='center'>"+cnd.getCity()+"</td><td align='center'>"+cnd.getEmail()+"</td><td align='center'>"+cnd.getMobile()+"</td></tr>");
        count++;
    }
    displayBlock.append("</table>");           




 out.println(displayBlock);
%>
