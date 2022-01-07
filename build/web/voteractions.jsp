<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="jsscript/vote.js"></script>
        <script src="jsscript/registration.js"></script>
        <script src="jsscript/login.js"></script>
        <script src="jsscript/adminoption.js"></script>
        <script src="jsscript/jquery.js"></script>
        
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <link href="stylesheet/backgroundimage.css" rel="stylesheet">
        <link href="stylesheet/pageheader.css" rel="stylesheet">
        <link href="stylesheet/admin.css" rel="stylesheet">
        <link href="stylesheet/result.css" rel="stylesheet">
        <title>Voter Action page</title>
    </head>
    <body>
        <%
            String userid=(String)session.getAttribute("userid");
            if(userid==null)
            {
                response.sendRedirect("accessdenied.html");
                return;
            }
            out.println("<div class='sticky'><div class='candidate'>VOTE FOR CHANGE</div><br>"+
        "<div class='subcandidate'>Voter Actions Page</div><br><br>"+
                    "<div class='logout'><a href='login.html'>logout</a></div></div>"+
            "<div class='container'>"+          
            /*"<div id='dv3' onclick='showcandidate()'><img src='images/candidate.jpg' height='250px' width='250px'><br><h3>See Candidate</h3></div>"+*/        
            "<div id='dv3' onclick='updatevoterform()'><img src='images/update1.jpg' height='250px' width='250px'><br><h3>Update Profile</h3></div>"+
            "<br><br><div align='center' id='result'></div>"+"</div>");
            
        %>
    </body>
</html>

