package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import evoting.dto.CandidateDto;

public final class votedenied_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link href=\"stylesheet/backgroundimage.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"stylesheet/pageheader.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"stylesheet/showcandidate.css\" rel=\"stylesheet\">\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Vote Denied</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");

            String userid=(String)session.getAttribute("userid");
            System.out.println("Vote Denied Jsp");
            if(userid==null)
            { 
                session.invalidate();
                response.sendRedirect("accessdenied.html");
            }
            CandidateDto candidate=(CandidateDto)request.getAttribute("candidate");
            StringBuffer displayBlock=new StringBuffer("<div class='sticky'><div class='candidate'>VOTE FOR CHANGE</div><br>");
            displayBlock.append("<div class='subcandidate'>Your Vote Already Taken </div>"
                    + "<div class='logout'><a href='login.html'>logout</a></div></div>");
            displayBlock.append("<br/><br/><div class='candidateprofile'>You are voted For:</div>");
            displayBlock.append("<br/><div class='candidateprofile'><table align='center' style='color:white; font-size:25px;'><tr><td align='right'>Candidate Id:</td><td align='left'><strong>"
                 +candidate.getCandidateId()+"</strong></td></tr>"
                 +"<tr><td align='right'>Candidate Name:</td><td align='left'><strong>"+candidate.getCandidateName()+"</strong></td></tr>"
                 + "<tr><td align='right'> Party:</td><td align='left'><strong>"+candidate.getParty()+"</strong></td></tr></table></div>");
            displayBlock.append("<div class='candidateprofile' for='"+candidate.getCandidateId()+"'><br>Symbol:<br><br><img src='data:image/jpg;base64,"
                 +candidate.getSymbol()+"' style='width:200px;height:200px;'/></div>");
            displayBlock.append("<div align='center'><h2 id='logout'><a href='LoginControllerServlet?logout=logout'>Logout</a></h2><div>");
            out.println(displayBlock);    
        
      out.write("\r\n");
      out.write("    </body>\r\n");
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
