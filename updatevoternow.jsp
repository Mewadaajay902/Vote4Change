



<%@page 
import="evoting.dto.UserDetails"%>
<%
            String userid=(String)session.getAttribute("userid");
            if(userid==null)
            {
                response.sendRedirect("accessdenied.html");
                return;
            }
            UserDetails candidate =(UserDetails) request.getAttribute("user");
           // out.println(candidate);
            StringBuffer displayBlock= new StringBuffer();
           displayBlock.append("<form method='POST' enctype='mutlipart/form-data' id='fileUploadForm'>"                 
     +"<table><tr><th>Username:</th><td><input type='text' id='username' value='"+ candidate.getUsername()+"'></td></tr>"
     +"<tr><th>City:</th><td><input type='text' id='city' value='"+ candidate.getCity()+"'></td></tr>"
     +"<tr><th>Email:</th><td><input type='text' id='email' value='"+ candidate.getEmail()+"'></td></tr>"
       +"<tr><th>Mobile:</th><td><input type='text' id='mobile' value='"+ candidate.getMobile()+"'></td></tr>"
       +"<tr><th>password:</th><td><input type='text' id='password' value='"+ candidate.getPassword()+"'></td></tr>"
        +"<tr><th>Address:</th><td><input type='text' id='address' value='"+ candidate.getAddress()+"'></td></tr>"
       +"<tr><th><input type='button' value='Update candidate' onclick='updatecandidate()' id='updatecnd'></th></tr></table></form>");
       out.println(displayBlock);
            %>
   