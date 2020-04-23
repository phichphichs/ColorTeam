/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import com.sun.javafx.font.FontConstants;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Account;

/**
 *
 * @author User
 */
public class LoginDAO extends DBContext{
    
    public Account getAccount(String username, String password) {
        String sql = "select id, username from Account where username = ? and password = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Account acc = new Account();
                acc.setId(rs.getInt("id"));
                acc.setUsername(rs.getString("username"));
                return acc;
            }
            
            
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }
}
