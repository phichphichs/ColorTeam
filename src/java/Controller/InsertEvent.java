/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dal.InsertEventDAO;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Event;
import model.Event_Detail;

/**
 *
 * @author User
 */
public class InsertEvent extends HttpServlet {

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

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

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
        try {
            Login.CheckLogin(request, response);
            processRequest(request, response);

            request.getRequestDispatcher("insertEvent.jsp").forward(request, response);
        } catch (Exception ex) {
            System.err.println(ex);
            response.sendRedirect("error.jsp");
        }
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
        try {
            Login.CheckLogin(request, response);
            
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            //lấy các paramater
            InsertEventDAO dao = new InsertEventDAO();

            String name = request.getParameter("name");
            String stime = request.getParameter("time");
            Date time = (stime == null || stime.equals(""))
                    ? null : Date.valueOf(stime);
            String genre = request.getParameter("genre");
            Event event = new Event(-1, name, genre, time);

            dao.insertEvent(event);

            String purpose = request.getParameter("purpose");
            String content = request.getParameter("content");
            Event_Detail detail = new Event_Detail(-1, event.getId(), purpose, content); //id event = id detail

            dao.addEventDetail(detail);

            response.sendRedirect("updateEvent?idEvent=" + event.getId());

        } catch (Exception ex) {
            System.err.println(ex);
            response.sendRedirect("error.jsp");
        }

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
