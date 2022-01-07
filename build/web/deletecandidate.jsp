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
     +"<table><tr><th>Candidate Id: </th><td>"+candidate.getCandidateId()+"</td></tr>"
     +"<tr><th>Candidate Name: </th><td>"+ candidate.getCandidateName()+"</td></tr>"
     +"<tr><th>City: </th><td>"+ candidate.getCity()+"</td></tr>"
       +"<tr><th>Party: </th><td>"+ candidate.getParty()+"</td></tr>"
       /*"<tr><td colspan='2'><input type='file' name='files' value='Update Image'></td></tr>"+*/
   +"<tr><th></th><th><input type='button'  value='Delete candidate' onclick='deletecandidate()' id='deletecnd' ></th></tr></table></form>");
       out.println(displayBlock);
     }


     %>
