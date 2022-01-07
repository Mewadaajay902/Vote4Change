/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evoting.controller;

import evoting.dao.UserDao;
import evoting.dto.UserDetails;
import java.io.IOException;
import static java.lang.System.out;
import java.sql.SQLException;
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
public class UserDetailsControllerServlet extends HttpServlet {

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
        try
        {
        RequestDispatcher rd=null;
            HttpSession session= request.getSession();
             String userid= (String) session.getAttribute("userid");  //in slide it is request.getAttribute("userid");
                String cid=(String) request.getParameter("cid");
                out.println(cid);
             if(userid== null && cid.equals("cid")!= true)
               {
                 session.invalidate();
                 response.sendRedirect("accessdenied.html");
               }
             else  if(cid.equals("cid"))
            {
                out.println("success");
             ArrayList<UserDetails> user= UserDao.viewUser();
             if(user!=null)
             {   out.println("notnull");
                 request.setAttribute("userDetails", user);
               rd= request.getRequestDispatcher("showuser.jsp");
               rd.forward(request, response);
             }
             else
             {
                 out.println("null");
                 rd= request.getRequestDispatcher("showexception.jsp");
               rd.forward(request, response);
             }
            }
           
           
        } catch (SQLException ex) {
            //Logger.getLogger(UserDetailsControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            System.out.println(ex);
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
