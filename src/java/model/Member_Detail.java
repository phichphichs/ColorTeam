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
public class Member_Detail implements Serializable{
    private int idDetail;
    private int idMember;
    private int idRole;
    private String gen;
    private String pro;
    private String con; 

    public Member_Detail() {
    }

    public Member_Detail(int idDetail, int idMember, int idRole, String gen, String pro, String con) {
        this.idDetail = idDetail;
        this.idMember = idMember;
        this.idRole = idRole;
        this.gen = gen;
        this.pro = pro;
        this.con = con;
    }

    public int getIdDetail() {
        return idDetail;
    }

    public void setIdDetail(int idDetail) {
        this.idDetail = idDetail;
    }

    public int getIdMember() {
        return idMember;
    }

    public void setIdMember(int idMember) {
        this.idMember = idMember;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public String getPro() {
        return pro;
    }

    public void setPro(String pro) {
        this.pro = pro;
    }

    public String getCon() {
        return con;
    }

    public void setCon(String con) {
        this.con = con;
    }
    
    
}
