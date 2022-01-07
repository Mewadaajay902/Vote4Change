/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evoting.controller;

import evoting.dao.UserDao;
import evoting.dto.UserDetails;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Genius
 */
public class ShowUserControllerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          
            /* TODO output your page here. You may use following sample code. */
             
            
            /* TODO output your page here. You may use following sample code. */
             RequestDispatcher rd=null;
             try{
             String data=(String) request.getParameter("data");
              HttpSession session= request.getSession();
             String userid= (String) session.getAttribute("userid");
              //out.println(userid);
              System.out.println(userid);
              if(userid==null)
              {
               session.invalidate();
               response.sendRedirect("accessdenied.html");
               return;
              }
              
                if(data!=null&& data.equals("cid"))
                {
                 ArrayList <String> adharId= UserDao.getAdhar();
                 for(String c: adharId)
                 {
                     System.out.println(c);
                 }
                 request.setAttribute("adharId",adharId);
                   request.setAttribute("result", "adharIdList");
                   
                }
                else
                {
                  UserDetails candidate= UserDao.getDetailsByAdhar(data);
                  //String uname= candidateDao.getUsernameId(candidate.getUserId());
                  //candidate.setCandidateName(uname);
                  request.setAttribute("result", "details");
                  request.setAttribute("candidate", candidate);
                 
                }
                rd= request.getRequestDispatcher("deleteuser.jsp");
              }
              catch(Exception e)
              {
                request.setAttribute("exception", e);
                rd= request.getRequestDispatcher("showexception.jsp");
              }
              finally
              {
               rd.forward(request, response);
              }
           
           
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
