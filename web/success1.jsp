<%
String userid= (String) session.getAttribute("userid");
if(userid==null)
{
  response.sendRedirect("accessdenied.html");
  return;
}
String result=(String) request.getAttribute("result");
out.println(result);
if(result.equals("success"))
{
 out.println("delete");
}
else
    out.println("notDeleted");

//out.println("success");
%>