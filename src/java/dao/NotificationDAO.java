/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Notification;
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
                + "      ,[username], type, time\n"
                + "  FROM [tasks2022].[dbo].[Notification] where username = ? order by id desc";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String noti = resultSet.getString("notification") + " " + resultSet.getString("type") + " " + resultSet.getString("time");
                return noti;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Notification> getAllNotification(String username) {

        ArrayList<Notification> notifications = new ArrayList<>();
        String sql = "SELECT TOP 7  [notification]\n"
                + "      ,[id]\n"
                + "      ,[username], type, time\n"
                + "  FROM [tasks2022].[dbo].[Notification] where username = ? order by id desc";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Notification notification = new Notification(resultSet.getString("notification"), resultSet.getString("username"),
                        resultSet.getString("type"), resultSet.getString("time"));
                notifications.add(notification);
            }
            return notifications;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addNotification(Notification notification) {

        String sql;

        sql = "INSERT INTO [dbo].[Notification]\n"
                + "           ([notification]\n"
                + "           ,[username]"
                + "           ,type, time  "
                + ")\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, notification.getNotification());
            preparedStatement.setString(2, notification.getUsername());
            preparedStatement.setString(3, notification.getType());
            preparedStatement.setString(4, notification.getTime());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
