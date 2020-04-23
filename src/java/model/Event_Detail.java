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
public class Event_Detail implements Serializable {

    private int id;
    private int idEvent;
    private String purpose;
    private String content;
    private String photo;
    private String video;

    public Event_Detail() {
    }

    public Event_Detail(int id, int idEvent, String purpose, String content, String photo, String video) {
        this.id = id;
        this.idEvent = idEvent;
        this.purpose = purpose;
        this.content = content;
        this.photo = photo;
        this.video = video;
    }

    public Event_Detail(int id, int idEvent, String purpose, String content) {
        this.id = id;
        this.idEvent = idEvent;
        this.purpose = purpose;
        this.content = content;
    }
    
    

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
