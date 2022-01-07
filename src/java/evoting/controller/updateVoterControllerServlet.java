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
import java.sql.SQLException;
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
public class updateVoterControllerServlet extends HttpServlet {

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
          try (PrintWriter out = response.getWriter()) {
           
             RequestDispatcher rd=null;
            HttpSession session= request.getSession();
             String userid= (String) session.getAttribute("userid");  //in slide it is request.getAttribute("userid");
             System.out.println(userid);
             //String candidateId= (String) request.getParameter("data");
             String address=(String) request.getParameter("address");
              String city=(String) request.getParameter("city");
               String email=(String) request.getParameter("email");
                String username=(String) request.getParameter("username");
                 String password=(String) request.getParameter("password");
                  String mobile=(String) request.getParameter("mobile");
                   //String address=(String) request.getParameter("address");
                   System.out.println(city);
                    System.out.println(address);
                    System.out.println(email);
                    
                    //long and=Integer.parseInt(mobile);
                    long and=Long.parseLong(mobile);
              //System.out.println(candidateId);

 if(userid== null)
               {
                 session.invalidate();
                 response.sendRedirect("accessdenied.html");
               }
            else
 {
  UserDetails us= new UserDetails();
                  us.setAddress(address);
                  us.setCity(city);
                  us.setEmail(email);
                 
                  us.setMobile(and);
                  us.setPassword(password);
                  us.setUsername(username);
                  us.setUserid(userid);
        
                  boolean result= UserDao.updateUser(us);
                  if(result== true)
                  {
                      System.out.println("success updated");
                      rd= request.getRequestDispatcher("success.jsp");
                    rd.forward(request, response);
                  }
                  else{
                   System.out.println("not updated");
                      rd= request.getRequestDispatcher("failure.jsp");
                    rd.forward(request, response);
                  }
 }
           
        } catch (SQLException ex) {
            ex.printStackTrace();
            //Logger.getLogger(UpdateUserControllerServlet1.class.getName()).log(Level.SEVERE, null, ex);
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
