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
public class MembelRoleDetailContact implements Serializable{
    Member member;
    Role_Member role;
    Member_Detail detail;
    Member_Contact contact;
    Major major;

    public MembelRoleDetailContact() {
    }

    public MembelRoleDetailContact(Member member, Role_Member role, Member_Detail detail, Member_Contact contact, Major major) {
        this.member = member;
        this.role = role;
        this.detail = detail;
        this.contact = contact;
        this.major = major;
    }

    

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Role_Member getRole() {
        return role;
    }

    public void setRole(Role_Member role) {
        this.role = role;
    }

    public Member_Detail getDetail() {
        return detail;
    }

    public void setDetail(Member_Detail detail) {
        this.detail = detail;
    }

    public Member_Contact getContact() {
        return contact;
    }

    public void setContact(Member_Contact contact) {
        this.contact = contact;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }
    
    
}
