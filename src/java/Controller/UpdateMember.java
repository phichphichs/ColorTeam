/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dal.InsertMemberDAO;
import dal.MemberDAO;
import dal.UpdateMemberDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Major;
import model.Member;
import model.Member_Contact;
import model.Member_Detail;
import model.Role_Member;

/**
 *
 * @author User
 */
public class UpdateMember extends HttpServlet {

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
            int id = Integer.parseInt(request.getParameter("idMember"));
            InsertMemberDAO imdao = new InsertMemberDAO();
            
            MemberDAO mdao = new MemberDAO();
            ArrayList<Major> m = mdao.getMajors();
            ArrayList<Role_Member> roles = mdao.getRoles();
            Member member = mdao.getMemberById(id);
            Member_Detail md = mdao.getDetailByID(id);
            Member_Contact contact = mdao.getContactById(id);
            
            request.setAttribute("roles", roles);
            request.setAttribute("majors", m);
            request.setAttribute("member", member);
            request.setAttribute("detail", md);
            request.setAttribute("contact", contact);
            
            request.getRequestDispatcher("update.jsp").forward(request, response);
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
            
            UpdateMemberDAO upDAO = new UpdateMemberDAO();
            //lay thuoc tinh insert vao
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");
            MemberDAO mdao = new MemberDAO();
            ArrayList<Major> m = mdao.getMajors();
            
            String sid = request.getParameter("id");
            int id = Integer.parseInt(sid);
            
            String name = request.getParameter("name");
            
            String sdob = request.getParameter("dob");
            Date dob = (sdob == null || sdob.equals(""))
                    ? null : Date.valueOf(sdob);
            
            String sgender = request.getParameter("gender");
            int gender = Integer.parseInt(sgender);
            
            String smajor = request.getParameter("major");
            int major = Integer.parseInt(smajor);
            
            Member member = new Member(id, name, null, dob, gender == 1, major);
            upDAO.updateMemberByID(member);

            //cho idDetail = idMember
            int idRole = Integer.parseInt(request.getParameter("role"));
            
            String gen = request.getParameter("gen");
            String pro = request.getParameter("pro");
            String con = request.getParameter("con");
            
            Member_Detail md = new Member_Detail(id, id, idRole, gen, pro, con);
            upDAO.updateMember_DetailByID(md);

            //idContact = id member
            String nickname = request.getParameter("nickname");
            String fb = request.getParameter("fb");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            String mail = request.getParameter("mail");
            
            Member_Contact mc = new Member_Contact(id, id, nickname, fb, address, phone, mail);
            upDAO.updateMember_ContactByID(mc);
            
            String btnUpdate = request.getParameter("Update");
            
            if (btnUpdate != null) {
                String msg = "Success";
                HttpSession session = request.getSession();
                session.setAttribute("btnUpdate", btnUpdate);
                response.sendRedirect("updateMember?idMember=" + id + "&msg=" + msg);
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
