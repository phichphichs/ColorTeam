/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.MembelRoleDetailContact;
import model.Member;
import model.Member_Contact;
import model.Member_Detail;

/**
 *
 * @author User
 */
public class InsertMemberDAO extends DBContext {

    public void InserMember(Member member) {
        String sql = "INSERT INTO [dbo].[Member]\n"
                + "           ([id]\n"
                + "           ,[name]\n"
                + "           ,[photo]\n"
                + "           ,[dob]\n"
                + "           ,[gender]\n"
                + "           ,[idMajor])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            //dien vao dau ?
            statement.setInt(1, member.getId());
            statement.setNString(2, member.getName());
            statement.setNString(3, member.getPhoto());
            statement.setDate(4, member.getDob());
            statement.setBoolean(5, member.isGender());
            statement.setInt(6, member.getIdMajor());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(InsertMemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void InsertDetail(Member_Detail md) {
        String sql = "INSERT INTO [dbo].[Member_Detail]\n"
                + "           ([idDetail]\n"
                + "           ,[idMember]\n"
                + "           ,[idRole]\n"
                + "           ,[gen]\n"
                + "           ,[pro]\n"
                + "           ,[con])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            //dien vao dau ?
            statement.setInt(1, md.getIdDetail());
            statement.setInt(2, md.getIdMember());
            statement.setInt(3, md.getIdRole());
            statement.setString(4, md.getGen());
            statement.setNString(5, md.getPro());
            statement.setNString(6, md.getCon());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(InsertMemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void InsertContact(Member_Contact mc) {
        String sql = "INSERT INTO [dbo].[Member_Contact]\n"
                + "           ([id]\n"
                + "           ,[idMember]\n"
                + "           ,[nickName]\n"
                + "           ,[facebook]\n"
                + "           ,[address]\n"
                + "           ,[phone]\n"
                + "           ,[mail])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            //dien vao dau ?
            statement.setInt(1, mc.getId());
            statement.setInt(2, mc.getIdMember());
            statement.setNString(3, mc.getNickname());
            statement.setNString(4, mc.getFacbook());
            statement.setNString(5, mc.getAddress());
            statement.setNString(6, mc.getPhone());
            statement.setNString(7, mc.getEmail());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(InsertMemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
