/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dal.DeleteEventDAO;
import dal.UpdateEventDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Event;

/**
 *
 * @author User
 */
public class DeleteEvents extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException iFf a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Login.CheckLogin(request, response);
            
            UpdateEventDAO dao = new UpdateEventDAO();
            
            String sid = request.getParameter("id");
            Integer id = (sid == null || sid.equals(""))
                    ? 0 : Integer.parseInt(sid);
            Event event = dao.getEvent(id);
            
            request.setAttribute("event", event);
            request.getRequestDispatcher("deleteEvent.jsp").forward(request, response);
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
            
            processRequest(request, response);
            DeleteEventDAO dao = new DeleteEventDAO();
            String sid = request.getParameter("id");

            Integer id = (sid == null || sid.equals(""))
                    ? 0 : Integer.parseInt(sid);
            String btnDelete = request.getParameter("btnDelete");

            if (btnDelete != null) {
                dao.deleteEvent_DetailByID(id);
                dao.deleteTeamCore_Event(id);
                dao.deleteEventByID(id);
                response.sendRedirect("listEvent");
            }
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
