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
     if(result.equals("candidateList"))
     {
       ArrayList<String> candidateId= (ArrayList) request.getAttribute("candidateId");
       
       for(String c: candidateId)
       {
      displayBlock.append("<option value='"+c+"'>"+c+"</option>");
       }
       out.println(displayBlock);
     }
     else if(result.equals("details"))
     {
     CandidateDetails candidate= (CandidateDetails) request.getAttribute("candidate");
     //out.println(candidate.getCandidateId());
       displayBlock.append("<form method='POST' enctype='mutlipart/form-data' id='fileUploadForm'>"
     +"<table><tr><th>Candiadte Id:</th><td>"+ candidate.getCandidateId()+"</td></tr>"
     +"<tr><th>Candidate Name:</th><td><input type='text' id='cname' value='"+ candidate.getCandidateName()+"'></td></tr>"
     +"<tr><th>City:</th><td><input type='text' id='city' value='"+ candidate.getCity()+"'></td></tr>"
       +"<tr><th>Party:</th><td><input type='text' id='party' value='"+ candidate.getParty()+"'></td></tr>"
       +"<tr><th>Symbol:</th><td id='image'>"+"<img src='data:image/jpg;base64,"+ candidate.getSymbol()+"'style='width:300px; heigth:200px;'></td></tr>"
       +"<tr><td colspan='2'><input type='file' name='files' value='Update Image'></td></tr>"+
      "<tr><th><input type='button' value='Update candidate' onclick='updatecandidate()' id='updatecnd'></th></tr></table></form>");
       out.println(displayBlock);
     }


     %>