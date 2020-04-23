/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dal.DeleteMemberDAO;
import dal.InsertMemberDAO;
import dal.MemberDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Major;
import model.MembelRoleDetailContact;
import model.Member;
import model.Member_Contact;
import model.Member_Detail;
import model.Role_Member;

/**
 *
 * @author User
 */
public class DeleteMember extends HttpServlet {

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

            MemberDAO mdao = new MemberDAO();

            String sid = request.getParameter("id");

            Integer id = (sid == null || sid.equals(""))
                    ? 0 : Integer.parseInt(sid);

            Member member = mdao.getMemberById(id);
            Role_Member role = mdao.getRole_MemberByIdMember(id);
            Major major = mdao.getMajorByIdMember(id);
            Member_Contact mc = mdao.getContactById(id);
            Member_Detail md = mdao.getDetailByID(id);

            request.setAttribute("member", member);
            request.setAttribute("role", role);
            request.setAttribute("major", major);
            request.setAttribute("mc", mc);
            request.setAttribute("md", md);

            request.getRequestDispatcher("delete.jsp").forward(request, response);
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
            response.setContentType("text/html; charset=UTF-8");
            String sid = request.getParameter("id");

            Integer id = (sid == null || sid.equals(""))
                    ? -1 : Integer.parseInt(sid);

            DeleteMemberDAO d = new DeleteMemberDAO();

            d.deleteTeamCore_Event(id);
            d.deleteMember_DetailByID(id);
            d.deleteMember_ContactByID(id);
            d.deleteMemberByID(id);

            String btnDelete = request.getParameter("Delete");

            if (btnDelete != null) {
                HttpSession session = request.getSession();
                session.setAttribute("btnDelete", btnDelete);
                response.sendRedirect("list");
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
