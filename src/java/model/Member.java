/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author User
 */
public class Member implements Serializable {
    private int id;
    private String name;
    private String photo;
    private Date dob;
    private boolean gender;
    private int idMajor;

    public Member() {
    }

    public Member(int id, String name, String photo, Date dob, boolean gender, int idMajor) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.dob = dob;
        this.gender = gender;
        this.idMajor = idMajor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getIdMajor() {
        return idMajor;
    }

    public void setIdMajor(int idMajor) {
        this.idMajor = idMajor;
    }
    
    
}
