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
import model.Event;
import model.Event_Detail;
import model.Member;

/**
 *
 * @author User
 */
public class UpdateEventDAO extends DBContext {
    //role event theo id member combobox
    //aray list member theo id để chọn core team checkbox

    public void UpdateEvent(Event event) {
        String sql = "UPDATE [dbo].[Event]\n"
                + "   SET \n"
                + "      [name] = ?\n"
                + "      ,[genre] = ?\n"
                + "      ,[time] = ?\n"
                + " WHERE [id] = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setNString(1, event.getName());
            stm.setNString(2, event.getGenre());
            stm.setDate(3, event.getTime());
            stm.setInt(4, event.getId());
            stm.executeUpdate();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(UpdateEventDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void UpdateEventDetail(Event_Detail detail) {
        String sql = "UPDATE [dbo].[Event_Detail]\n"
                + "   SET \n"
                + "      [idEvent] = ?\n"
                + "      ,[purpose] = ?\n"
                + "      ,[content] = ?\n"
                + " WHERE [id] = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, detail.getIdEvent());
            stm.setNString(2, detail.getPurpose());
            stm.setNString(3, detail.getContent());
            stm.setInt(4, detail.getId());
            stm.executeUpdate();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(UpdateEventDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void DeleteMemberByEventToUpdate(Event e) {
        String sql = "DELETE FROM [dbo].[TeamCore_Event]\n"
                + "      WHERE  idEvent = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, e.getId());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UpdateEventDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //update member vao bang theo chuc vu
    public void InsertMemerToUpdate(Event e, int idMember) {
        String sql = "INSERT INTO [dbo].[TeamCore_Event]\n"
                + "           ([idMember]\n"
                + "           \n"
                + "           ,[idEvent])\n"
                + "     VALUES\n"
                + "          (?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idMember);

            ps.setInt(2, e.getId());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UpdateEventDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void UpdateMember(Event e, int idMember) {

        InsertMemerToUpdate(e, idMember);
    }

    //lấy danh sách nhân sự sự kiện
    public ArrayList<Member> getMembersByIdEvent(int id) {
        ArrayList<Member> members = new ArrayList<>();
        String sql = " Select te.idMember, m.name, m.photo \n"
                + "from TeamCore_Event te \n"
                + "join Member m\n"
                + "ON te.idMember = m.id\n"
                + "where te.idEvent = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Member m = new Member();
                m.setId(rs.getInt("idMember"));
                m.setName(rs.getNString("name"));
                m.setPhoto(rs.getString("photo"));
                members.add(m);
            }
        } catch (SQLException e) {
            Logger.getLogger(UpdateEventDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return members;
    }

    //lấy sự kiện bằng id
    public Event getEvent(int id) {
        Event event = new Event();
        String sql = "Select * from Event\n"
                + "where id = " + id;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                event.setId(rs.getInt("id"));
                event.setName(rs.getNString("name"));
                event.setGenre(rs.getNString("genre"));
                event.setTime(rs.getDate("time"));
            }
        } catch (SQLException e) {
            Logger.getLogger(UpdateEventDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return event;
    }

    public Event_Detail getEventDetail(int id) {
        Event_Detail event = new Event_Detail();
        String sql = "Select * from Event_Detail\n"
                + "where idEvent = " + id;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                event.setId(rs.getInt("id"));
                event.setIdEvent(id);
                event.setPurpose(rs.getNString("purpose"));
                event.setContent(rs.getNString("content"));
            }

        } catch (SQLException e) {
            Logger.getLogger(UpdateEventDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return event;
    }

}
