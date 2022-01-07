
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <link href="stylesheet/backgroundimage.css" rel="stylesheet">
         <link href="stylesheet/pageheader.css" rel="stylesheet">
         <meta http-equiv="Content-Type" content="text/html"; charset=utf-8">
         <title>Show Exception Page</title>
    </head>
    <body>
        <br>
        <div class="candidate">VOTE FOR CHANGE</div>
        <br>
        <div class="subcandidate">Please Try again later</div>
        <%
            Exception ex=(Exception)request.getAttribute("exception");
            System.out.println(ex);
            out.println(ex);
        %>    
    </body>
</html>
