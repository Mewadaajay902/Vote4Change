package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import evoting.dto.CandidateDto;

public final class showcandidate_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <link href=\"stylesheet/showcandidate.css\" type=\"text/css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"stylesheet/backgroundimage.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"stylesheet/pageheader.css\" rel=\"stylesheet\">\r\n");
      out.write("        <script src=\"jsscript/vote.js\"></script>\r\n");
      out.write("        <script src=\"jsscript/jquery.js\"></script>\r\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js\"></script>\r\n");
      out.write("        <title>show candidate</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("     ");

          String userid=(String)session.getAttribute("userid");
          
    if(userid==null)
            {
                response.sendRedirect("accessdenied.html");
                return;
            }
          System.out.println("show candidate jsp");
          StringBuffer displayBlock=new StringBuffer("<div class='sticky'><div class='candidate'>VOTE FOR CHANGE</div> "
                  + "<br><div class='subcandidate'>Whom do you want to vote ?</div>"
                  +"<div class='logout'><a href='login.html'>logout</a></div>" 
                  +"</div></div><div class='buttons'>");
          ArrayList<CandidateDto> candidate=(ArrayList)request.getAttribute("candidateList");
          //System.out.println(candidate);
          for(CandidateDto c:candidate)
          {
          displayBlock.append("<input id='"+c.getCandidateId()+"' value='"+c.getCandidateId()+"' name='flat' type='radio' onclick='addvote()' />");
          displayBlock.append("<label for='"+c.getCandidateId()+"'><img src='data:image/jpg;base64,"+c.getSymbol()+"' style='width:300px;height:200px;'/></label>"
                  + "<br/><div class='candidateprofile'><p>Candidate Id:"+c.getCandidateId()+"<br/>"
                 +"Candidate Name:"+c.getCandidateName()+"<br/>"
                         + " Party:"+c.getParty()+"</label><br/></div>");
          }
          
          displayBlock.append("<div align='center'><h4><a href='voteractions.jsp'>Profile</a></h4><div>");
          out.println(displayBlock);
      
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("</div> \r\n");
      out.write(" </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
