/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import model.Member;
import model.Member_Contact;
import model.Member_Detail;

/**
 *
 * @author User
 */
public class UpdateMemberDAO extends DBContext {

    //update member- detail - contact
    public void updateMemberByID(Member member) {
        String sql = "UPDATE [dbo].[Member]\n"
                + "   SET \n"
                + "      [name] = ?\n"
                + "      ,[dob] = ?\n"
                + "      ,[gender] = ?\n"
                + "      ,[idMajor] = ?\n"
                + " WHERE id = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            int index = 1;
            stm.setNString(index++, member.getName());
//            stm.setNString(2, member.getPhoto());
            stm.setDate(index++, member.getDob());
            stm.setBoolean(index++, member.isGender());
            stm.setInt(index++, member.getIdMajor());
            stm.setInt(index++, member.getId());
            stm.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateMember_ContactByID(Member_Contact member) {
        String sql = "UPDATE [dbo].[Member_Contact]\n"
                + "   SET \n"
                + "      [idMember] = ?\n"
                + "      ,[nickName] = ?\n"
                + "      ,[facebook] = ?\n"
                + "      ,[address] = ? \n"
                + "	  ,[phone] = ?\n"
                + "      ,[mail] = ?\n"
                + " WHERE id = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, member.getIdMember());
            stm.setNString(2, member.getNickname());
            stm.setNString(3, member.getFacbook());
            stm.setNString(4, member.getAddress());
            stm.setNString(5, member.getPhone());
            stm.setNString(6, member.getEmail());
            stm.setInt(7, member.getId());
            stm.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateMember_DetailByID(Member_Detail member) {
        String sql = "UPDATE [dbo].[Member_Detail]\n"
                + "   SET \n"
                + "      [idMember] = ?\n"
                + "      ,[idRole] = ?\n"
                + "      ,[gen] = ?\n"
                + "      ,[pro] = ?\n"
                + "      ,[con] = ?\n"
                + " WHERE [idDetail] = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, member.getIdMember());
            stm.setInt(2, member.getIdRole());
            stm.setString(3, member.getGen());
            stm.setNString(4, member.getPro());
            stm.setNString(5, member.getCon());
            stm.setInt(6, member.getIdDetail());
            stm.executeUpdate();
        } catch (Exception e) {
        }
    }
    

}
