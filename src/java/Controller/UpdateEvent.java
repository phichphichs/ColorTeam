/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dal.InsertEventDAO;
import dal.UpdateEventDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Event;
import model.Event_Detail;
import model.Member;

/**
 *
 * @author User
 */
public class UpdateEvent extends HttpServlet {

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
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Login.CheckLogin(request, response);

            response.setContentType("text/html; charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            UpdateEventDAO upDAO = new UpdateEventDAO();
            InsertEventDAO inDAO = new InsertEventDAO();
            String idString = request.getParameter("idEvent");
            int idEvent = Integer.parseInt(idString);

            ArrayList<Member> membersEvent = upDAO.getMembersByIdEvent(idEvent);

            Event event = upDAO.getEvent(idEvent);
            Event_Detail detail = upDAO.getEventDetail(idEvent);
            ArrayList<Member> membersAll = inDAO.getMembers();

            ArrayList<Member> notInEvent = new ArrayList<>();
            for (Member member : membersAll) {
                boolean ok = true;
                for (Member now : membersEvent) {
                    if (now.getId() == member.getId()) {
                        ok = false;
                    }
                }
                if (ok) {
                    notInEvent.add(member);
                }
            }

            request.setAttribute("membersEvent", membersEvent);
            request.setAttribute("memberNotInEvent", notInEvent);

            request.setAttribute("membersAll", membersAll);
            request.setAttribute("event", event);
            request.setAttribute("detail", detail);

            request.getRequestDispatcher("updateEvent.jsp").forward(request, response);
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
            
            response.setContentType("text/html; charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            String idString = request.getParameter("idEvent");

            UpdateEventDAO dao = new UpdateEventDAO();

            int idEvent = Integer.parseInt(idString);
            Event event = dao.getEvent(idEvent);

            String name = request.getParameter("name");
            String stime = request.getParameter("time");
            Date time = (stime == null || stime.equals(""))
                    ? null : Date.valueOf(stime);
            String genre = request.getParameter("genre");

            event.setName(name);
            event.setTime(time);
            event.setGenre(genre);

            dao.UpdateEvent(event);

            Event_Detail detail = dao.getEventDetail(event.getId());

            String purpose = request.getParameter("purpose");
            String content = request.getParameter("content");

            detail.setPurpose(purpose);
            detail.setContent(content);

            dao.UpdateEventDetail(detail);
            dao.DeleteMemberByEventToUpdate(event);

            String[] sidMember = request.getParameterValues("idMember");
            if (sidMember != null) {
                for (String m : sidMember) {
                    dao.UpdateMember(event, Integer.parseInt(m));

                }
            }
            response.sendRedirect("updateEvent?idEvent=" + idString);
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
