package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import evoting.dto.CandidateDto;
import evoting.dao.VoteDao;

public final class votingresponse_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <link href=\"stylesheet/backgroundimage.css\" type=\"text/css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"stylesheet/showcandidate.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"stylesheet/pageheader.css\" rel=\"stylesheet\">\r\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js\"></script>\r\n");
      out.write("        <title>Voting Response</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");

           String userid=(String)session.getAttribute("userid");
           
            if(userid==null)
            {
                response.sendRedirect("accessdenied.jsp");
            }
            else
            {
           String cid=VoteDao.getCandidateId(userid);
           StringBuffer displayBlock=new StringBuffer("");
           displayBlock.append("<div class='sticky'><div class='candidate'>VOTE FOR CHANGE</div><br> ");
		if(cid==null)
                {
                    displayBlock.append("<br><div class='subcandidate'>Sorry your Vote is not added!</div>");
                    displayBlock.append("<div class='logout'><a href='logout.html'>logout</a></div></div>");
                    displayBlock.append("<div><h4 id='logout'><a href='LoginControllerServlet?logout=logout'>Logout</a></h4></div>");
                    out.println(displayBlock);
                }
                else
                {
                    CandidateDto candidate=VoteDao.getVote(cid);
		    System.out.println(candidate);
                    displayBlock.append("<div class='subcandidate' >Thank you for Voting!!</div><br>");
                    displayBlock.append("<div class='logout'><a href='login.html'>logout</a></div></div>");
                    displayBlock.append("<div class='candidateprofile'>Your Vote Added Successfully!!</div>");
                    displayBlock.append("<div class='candidateprofile' id='"+candidate.getCandidateId()+"'>"
                            + "<strong>You are Voted to :</strong><br/><img src='data:image/jpg;base64,"
                 +candidate.getSymbol()+"' style='width:200px;height:200px;'/><br/><div class='candidateprofile'><p>Candidate Id:"
                 +candidate.getCandidateId()+"<br/>"
                 +"Candidate Name:"+candidate.getCandidateName()+"<br/>"
                 + " Party:"+candidate.getParty()+"</div><br/></div>");
                    //displayBlock.append("<h2 id='logout'><a href='LoginControllerServlet?logout=logout'>Logout</a></h2>");
                displayBlock.append("<div align='center' id='logout'><h2><a href='voteractions.jsp'>Manage Profile</a></h2><div>");
                }
                out.println(displayBlock);
            }
        
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
