/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Event;
import model.EventInfo;
import model.Event_Detail;
import model.Member;
import model.TeamCore_Event;

/**
 *
 * @author User
 */
public class ListEventDAO extends DBContext {
    //lấy ra tất cả các event
    //lấy role_event theo id
    //araylist member to insert or update

    public ArrayList<EventInfo> allInfoEvent() {
        ArrayList<EventInfo> events = new ArrayList<>();

        String sql = "SELECT  e.id, e.name as event, e.genre, e.time, ed.photo, ed.video, ed.purpose, ed.content\n"
                + "                              FROM Event e left join Event_Detail ed\n"
                + "                                ON e.id = ed.idEvent ";

        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                EventInfo edtrm = new EventInfo();

                Event event = new Event();
                event.setId(rs.getInt("id"));
                event.setName(rs.getString("event"));
                event.setGenre(rs.getString("genre"));
                event.setTime(rs.getDate("time"));
                edtrm.setEvent(event);

                Event_Detail detail = new Event_Detail();
                detail.setPhoto(rs.getString("photo"));
                detail.setVideo(rs.getString("video"));
                System.err.print(detail.getVideo());
                detail.setPurpose(rs.getString("purpose"));
                detail.setContent(rs.getString("content"));
                edtrm.setDetail(detail);

                events.add(edtrm);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return events;
    }

}
