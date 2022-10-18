/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

    public  String getAccGr(int idGroup) {
        String sql = "SELECT [username]\n"
                + "      ,[groupID]\n"
                + "  FROM [dbo].[AccountGroup] where [groupID] = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idGroup);
            ResultSet resultSet = preparedStatement.executeQuery();
            String username = "";
            while (resultSet.next()) {
                username += resultSet.getString("username")+" ";
            }
            return username;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
