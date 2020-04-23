/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class MemberDAO extends DBContext {
    //hien thi danh sach member
    //lay ra member - detail - contact by ID

    public Member getMemberById(int id) {
        Member m = new Member();
        String sql = "SELECT * FROM Member WHERE id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                m.setId(rs.getInt("id"));
                m.setDob(rs.getDate("dob"));
                m.setGender(rs.getBoolean("gender"));
                m.setIdMajor(rs.getInt("idMajor"));
                m.setName(rs.getNString("name"));
                m.setPhoto(rs.getNString("photo"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return m;
    }

    public ArrayList<MembelRoleDetailContact> getAllInfoMember() {
        ArrayList<MembelRoleDetailContact> ms = new ArrayList<>();

        String sql = "Select  m.id, m.name, m.photo, m.dob, m.gender, ma.name as nganh,rm.role, md.gen, md.pro, md.con, mc.nickName, mc.address, mc.mail, mc.facebook, mc.phone       \n"
                + "                 from Member m\n"
                + "                left join Major ma\n"
                + "                on m.idMajor = ma.id                \n"
                + "                left join Member_Detail md\n"
                + "                on m.id = md.idMember\n"
                + "				left join Role_Member rm\n"
                + "                on md.idRole = rm.id\n"
                + "                left join Member_Contact mc\n"
                + "                on m.id = mc.idMember ";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MembelRoleDetailContact mrdc = new MembelRoleDetailContact();

                Member m = new Member();
                m.setId(rs.getInt("id"));
                m.setDob(rs.getDate("dob"));
                m.setGender(rs.getBoolean("gender"));
                m.setName(rs.getNString("name"));
                m.setPhoto(rs.getNString("photo"));
                mrdc.setMember(m);

                Major major = new Major();
                major.setId(rs.getInt("id"));
                major.setName(rs.getNString("nganh"));
                mrdc.setMajor(major);

                Role_Member rm = new Role_Member();
                rm.setRole(rs.getNString("role"));
                mrdc.setRole(rm);

                Member_Detail md = new Member_Detail();
                md.setGen(rs.getString("gen"));
                md.setPro(rs.getNString("pro"));
                md.setCon(rs.getNString("con"));
                mrdc.setDetail(md);

                Member_Contact mc = new Member_Contact();
                mc.setAddress(rs.getNString("address"));
                mc.setEmail(rs.getNString("mail"));
                mc.setNickname(rs.getNString("nickName"));
                mc.setPhone(rs.getNString("phone"));
                mc.setFacbook(rs.getNString("facebook"));
                mrdc.setContact(mc);

                ms.add(mrdc);

            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ms;
    }

    public Major getMajorByIdMember(int id) {
        Major rm = new Major();

        String sql = "	Select  m.id, m.name, m.photo, m.dob, m.gender, Major.name\n"
                + "               from Member m\n"
                + "               left join Major\n"
                + "               on m.idMajor = Major.id\n"
                + "               where m.id = " + id;

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                rm.setId(rs.getInt("id"));
                rm.setName(rs.getNString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rm;

    }

    public ArrayList<Major> getMajors() {
        ArrayList<Major> majors = new ArrayList<>();
        String sql = "Select * from Major";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Major m = new Major();
                m.setId(rs.getInt("id"));
                m.setName(rs.getNString("name"));
                majors.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return majors;
    }

    public Role_Member getRole_MemberByIdMember(int id) {
        Role_Member rm = new Role_Member();

        String sql = "Select  *\n"
                + "               from Member_Detail m\n"
                + "               left join Role_Member rm\n"
                + "               on m.idRole = rm.id\n"
                + "               where m.idMember = " + id;

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                rm.setId(rs.getInt("id"));
                rm.setRole(rs.getNString("role"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rm;
    }

    public ArrayList<Role_Member> getRoles() {
        ArrayList<Role_Member> roles = new ArrayList<>();
        String sql = "Select * from Role_Member";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Role_Member m = new Role_Member();
                m.setId(rs.getInt("id"));
                m.setRole(rs.getNString("role"));
                roles.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return roles;
    }

    public Member_Detail getDetailByID(int id) {

        String sql = "Select * from Member_Detail where idDetail = " + id;
        Member_Detail md = new Member_Detail();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                md.setIdDetail(rs.getInt("idDetail"));
                md.setIdMember(rs.getInt("idMember"));
                md.setIdRole(rs.getInt("idRole"));
                md.setGen(rs.getString("gen"));
                md.setPro(rs.getNString("pro"));
                md.setCon(rs.getNString("con"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return md;
    }

    public Member_Contact getContactById(int id) {

        String sql = "Select * from Member_Contact where idMember = " + id;
        Member_Contact mc = new Member_Contact();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                mc.setId(rs.getInt("id"));
                mc.setIdMember(rs.getInt("idMember"));
                mc.setAddress(rs.getNString("address"));
                mc.setEmail(rs.getNString("mail"));
                mc.setNickname(rs.getNString("nickName"));
                mc.setPhone(rs.getNString("phone"));
                mc.setFacbook(rs.getNString("facebook"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mc;
    }

}
