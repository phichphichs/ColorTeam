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
public class Member_Contact implements Serializable {
    private int id;
    private int idMember;
    private String nickname;
    private String facbook;
    private String address;
    private String phone;
    private String email;

    public Member_Contact() {
    }

    public Member_Contact(int id, int idMember, String nickname, String facbook, String address, String phone, String email) {
        this.id = id;
        this.idMember = idMember;
        this.nickname = nickname;
        this.facbook = facbook;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMember() {
        return idMember;
    }

    public void setIdMember(int idMember) {
        this.idMember = idMember;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFacbook() {
        return facbook;
    }

    public void setFacbook(String facbook) {
        this.facbook = facbook;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
