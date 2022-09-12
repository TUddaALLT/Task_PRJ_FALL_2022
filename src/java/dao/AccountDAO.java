/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Account;

/**
 *
 * @author 84352
 */
public class AccountDAO extends DBContext {

    public void register(Account acc) {
        String sql = "INSERT INTO [dbo].[account]\n"
                + "           ([username]\n"
                + "           ,[password]\n"
                + "           ,[role])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, acc.getUsername());
            preparedStatement.setString(2, acc.getPassword());
            preparedStatement.setInt(3, acc.getRole());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void upgrade(Account acc) {
        String sql = "UPDATE [dbo].[Account]\n"
                + "   SET role = 1 where username = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, acc.getUsername());  
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Account login(String user, String pass) {
        String sql = "select * from account where username = ? and password= ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, pass);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Account(user, pass, resultSet.getInt("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
