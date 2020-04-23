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
import model.Member;

/**
 *
 * @author User
 */
public class DeleteMemberDAO extends DBContext {

    //idMember = idDetail = idContact
    public void deleteMember_DetailByID(int id) {
        String sql = "DELETE FROM [dbo].[Member_Detail]\n"
                + "      WHERE idDetail = ?\n";

        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DeleteMemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteMemberByID(int id) {
        String sql
                = "DELETE FROM [dbo].[Member]\n"
                + "      WHERE id = ?\n";

        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DeleteMemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteTeamCore_Event(int id) {
        String sql
                = "DELETE FROM [dbo].[TeamCore_Event] \n"
                + "      WHERE idMember = ?";

        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DeleteMemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteMember_ContactByID(int id) {
        String sql
                = "DELETE FROM [dbo].[Member_Contact]\n"
                + "      WHERE id = ?\n";

        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DeleteMemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
