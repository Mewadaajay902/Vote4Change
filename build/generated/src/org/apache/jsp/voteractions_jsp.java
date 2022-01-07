package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class voteractions_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <script src=\"jsscript/vote.js\"></script>\n");
      out.write("        <script src=\"jsscript/registration.js\"></script>\n");
      out.write("        <script src=\"jsscript/login.js\"></script>\n");
      out.write("        <script src=\"jsscript/adminoption.js\"></script>\n");
      out.write("        <script src=\"jsscript/jquery.js\"></script>\n");
      out.write("        \n");
      out.write("        <script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>\n");
      out.write("        <link href=\"stylesheet/backgroundimage.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"stylesheet/pageheader.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"stylesheet/admin.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"stylesheet/result.css\" rel=\"stylesheet\">\n");
      out.write("        <title>Voter Action page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

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
            "<div id='dv3' onclick='rediectvotingpage()'><img src='images/vote2.webp.jpg' height='250px' width='250px'><br><h3>Cast Vote</h3></div>"+
            "<div id='dv3' onclick='showcandidate()'><img src='images/candidate.jpg' height='250px' width='250px'><br><h3>See Candidate</h3></div>"+        
            "<div id='dv3' onclick='updatevoterform()'><img src='images/update1.jpg' height='250px' width='250px'><br><h3>Update Profile</h3></div>"+
            "<br><br><div align='center' id='result'></div>"+"</div>");
            
        
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
