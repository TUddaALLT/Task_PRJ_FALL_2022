/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Task;

/**
 *
 * @author 84352
 */
public class NotificationDAO extends DBContext {

    public int countNotification(String username) {
        String sql = "SELECT count(*) as count \n"
                + "  FROM [dbo].[Notification] where username = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int num = resultSet.getInt("count");
                return num;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public String getNotification(String username) {
        String sql = "SELECT TOP 1  [notification]\n"
                + "      ,[id]\n"
                + "      ,[username]\n"
                + "  FROM [tasks2022].[dbo].[Notification] where username = ? order by id desc";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String noti = resultSet.getString("notification");
                return noti;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
