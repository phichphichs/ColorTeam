/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Event;
import model.EventInfo;
import model.Event_Detail;
import model.Member;

import model.TeamCore_Event;

/**
 *
 * @author User
 */
public class InsertEventDAO extends DBContext {

    public void insertEvent(Event e) {
        String sql = " INSERT INTO [dbo].[Event]\n"
                + " ([name]\n"
                + ",[genre]\n"
                + ",[time])\n"
                + "VALUES\n"
                + "(?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, e.getName());
            ps.setString(2, e.getGenre());
            ps.setDate(3, e.getTime());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                e.setId(rs.getInt(1));
            }

        } catch (SQLException ex) {
            Logger.getLogger(InsertEventDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //bang teamcore vs event la quan he nhieu nhieu nen chia thanh nhieu bang de insert
    public void addMemberToEvent(Event e, Member m) {
        String sql = "insert into TeamCore_Event(idMember, idEvent) values (?,?,?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, m.getId());

            ps.setInt(2, e.getId());
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(InsertEventDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addEventDetail(Event_Detail detail) {
        String sql = "INSERT INTO [dbo].[Event_Detail]\n"
                + "           ([idEvent]\n"
                + "           ,[purpose]\n"
                + "           ,[content]\n"
                + "           ,[video]\n"
                + "           ,[photo])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, detail.getIdEvent());
            ps.setString(2, detail.getPurpose());
            ps.setString(3, detail.getContent());
            ps.setString(4, detail.getVideo());
            ps.setString(5, detail.getPhoto());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                detail.setId(rs.getInt(1));
            }

        } catch (SQLException ex) {
            Logger.getLogger(InsertEventDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void InsertEvent(Event e, Event_Detail ed) {
        insertEvent(e);
        ed.setIdEvent(e.getId());
        addEventDetail(ed);

    }

    public ArrayList<Member> getMembers() {
        ArrayList<Member> members = new ArrayList<>();
        String sql = "Select * from Member";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Member m = new Member();
                m.setId(rs.getInt("id"));
                m.setName(rs.getString("name"));
                m.setPhoto(rs.getString("photo"));
                members.add(m);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return members;

    }

}
