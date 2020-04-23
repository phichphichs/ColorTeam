/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class EventInfo implements Serializable{
    Event event;
    Event_Detail detail;
    
   
    Member member;

    public EventInfo() {
    }

    public EventInfo(Event e, Event_Detail detail, Member member) {
        this.event = e;
        this.detail = detail;
      
        this.member = member;
    }

    
    public Event getEvent() {
        return event;
    }

    public void setEvent(Event e) {
        this.event = e;
    }

    public Event_Detail getDetail() {
        return detail;
    }

    public void setDetail(Event_Detail detail) {
        this.detail = detail;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
    
}
