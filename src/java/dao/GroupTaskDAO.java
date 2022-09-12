/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.GroupTask;

/**
 *
 * @author 84352
 */
public class GroupTaskDAO extends DBContext {

    public void addGroupTask(GroupTask groupTask) {
        String sql = "INSERT INTO [dbo].[GroupTask]\n"
                + "           ([groupID]\n"
                + "           ,[groupOfusername]\n"
                + "           ,[groupName])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, groupTask.getGroupID());
            preparedStatement.setString(2, groupTask.getGroupOfusername());
            preparedStatement.setString(3, groupTask.getGroupName());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
        }
    }

    public ArrayList<GroupTask> getAllGroupTaskByUserName(String username) {
        String sql = "select * from GroupTask "
                + "where GroupTask.groupID in (select AccountGroup.groupID from AccountGroup ) "
                + "and ? in (select AccountGroup.username from AccountGroup )";
        ArrayList<GroupTask> groupTasks = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                groupTasks.add(new GroupTask(resultSet.getInt("groupID"),
                         resultSet.getString("groupOfusername"), resultSet.getString("groupName")));
            }
            return groupTasks;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<GroupTask> getAllGroupTask() {
        String sql = "SELECT [groupID]\n"
                + "      ,[groupOfusername]\n"
                + "      ,[groupName]\n"
                + "  FROM [dbo].[GroupTask]";
        ArrayList<GroupTask> groupTasks = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                groupTasks.add(new GroupTask(resultSet.getInt("groupID"),
                        resultSet.getString("groupOfusername"), resultSet.getString("groupName")));
            }
            return groupTasks;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<GroupTask> getAllCreatedGroupTaskByUsername(String username) {
        String sql = "SELECT [groupID]\n"
                + "      ,[groupOfusername]\n"
                + "      ,[groupName]\n"
                + "  FROM [dbo].[GroupTask] where groupOfusername=?";
        ArrayList<GroupTask> groupTasks = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                groupTasks.add(new GroupTask(resultSet.getInt("groupID"),
                        resultSet.getString("groupOfusername"), resultSet.getString("groupName")));
            }
            return groupTasks;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public GroupTask getGroupTask(int id) {
        String sql = "SELECT [groupID]\n"
                + "      ,[groupOfusername]\n"
                + "      ,[groupName]\n"
                + "  FROM [dbo].[GroupTask] where groupID = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new GroupTask(resultSet.getInt("groupID"),
                        resultSet.getString("groupOfusername"), resultSet.getString("groupName"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
