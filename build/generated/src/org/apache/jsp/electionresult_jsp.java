package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;
import java.util.function.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import evoting.dto.CandidateDetails;
import java.util.Map;

public final class electionresult_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

     String userid=(String)session.getAttribute("userid");
    if(userid==null)
            {
                response.sendRedirect("accessdenied.html");
                return;
            }
    Map<CandidateDetails,Integer> result=(Map)request.getAttribute("result");
    int votecount=(int)request.getAttribute("votecount");
    Iterator i=result.entrySet().iterator();
    StringBuffer displayBlock = new StringBuffer("<table>");
    displayBlock.append("<tr><th>Candidate Id</th><th>Candidate Name</th><th>Party</th><th>Symbol</th><th>Voting Count</th><th>Vote %</th></tr>");
    int count=1;
    while(i.hasNext())
    {
        Map.Entry<CandidateDetails,Integer> e=(Map.Entry)i.next();
        displayBlock.append("<tr id='"+("tr"+count)+"' style='outline: thin solid'><td>"+e.getKey().getCandidateId()+"</td><td>"+e.getKey().getCandidateName()+"</td><td>"+e.getKey().getParty()+"</td><td><img src='data:image/jpg;base64,"+e.getKey().getSymbol()+"' style='width:300px;height:200px;'/></td><td>"+e.getValue()+"</td><td>"+((e.getValue()*100.0)/votecount)+"%</td></tr>");
        count++;
    }
    displayBlock.append("</table>");
    out.println(displayBlock);

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
