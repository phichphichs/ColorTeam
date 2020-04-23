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

/**
 *
 * @author User
 */
public class DeleteEventDAO extends DBContext {

    public void deleteTeamCore_Event(int id) {
        String sql
                = "DELETE FROM [dbo].[TeamCore_Event] \n"
                + "      WHERE idEvent = ?";

        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DeleteMemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteEvent_DetailByID(int id) {
        String sql = "DELETE FROM [dbo].[Event_Detail]\n"
                + "      WHERE idEvent = ?";

        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DeleteMemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteEventByID(int id) {
        String sql = "DELETE FROM [dbo].[Event]\n"
                + "      WHERE id = ?";

        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DeleteMemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
