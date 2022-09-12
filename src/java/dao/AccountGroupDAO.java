/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;

/**
 *
 * @author 84352
 */
public class AccountGroupDAO extends DBContext {

    public void addAccountGroup(int idGroup, String username) {
        String sql = "INSERT INTO [dbo].[AccountGroup]\n"
                + "           ([username]\n"
                + "           ,[groupID])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setInt(2, idGroup);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
