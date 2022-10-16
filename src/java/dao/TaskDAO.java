/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.Query;
import model.Task;

/**
 *
 * @author 84352
 */
public class TaskDAO extends DBContext {

    public void addTask(Task t) {
        String sql;

        sql = "INSERT INTO [dbo].[Tasks]\n"
                + "           ([img]\n"
                + "           ,[describe]\n"
                + "           ,[status]\n"
                + "           ,[taskOfUser]\n"
                + "           ,[groupID]\n"
                + "           ,[time_maked]\n"
                + "           ,[time])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, t.getImg());
            preparedStatement.setString(2, t.getDescribe());
            preparedStatement.setInt(3, t.getStatus());
            preparedStatement.setString(4, t.getUsername());
            preparedStatement.setInt(5, t.getGroupID());
            preparedStatement.setString(6, t.getTime());
            preparedStatement.setString(7, t.getTime_exc());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Task> getTasks(String username) {
        ArrayList<Task> tasks = new ArrayList<>();
        String sql = "SELECT [id]\n"
                + "      ,[img]\n"
                + "      ,[describe]\n"
                + "      ,[status]\n"
                + "      ,[taskOfUser]\n"
                + "      ,[groupID] , time_maked, time\n"
                + "  FROM [dbo].[Tasks]\n"
                + "  where taskOfUser = ? or "
                + "groupID in (select groupID from AccountGroup where username = ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Task task = new Task(resultSet.getInt("id"), resultSet.getString("img"),
                        resultSet.getString("describe"), resultSet.getInt("status"),
                        resultSet.getString("taskOfUser"), resultSet.getInt("groupID"), resultSet.getString("time_maked"), resultSet.getString("time"));

                tasks.add(task);
            }
            return tasks;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Task> getTop2NextTasks(String username, int number) {
        ArrayList<Task> tasks = new ArrayList<>();
        String sql = "SELECT [id]\n"
                + "      ,[img]\n"
                + "      ,[describe]\n"
                + "      ,[status]\n"
                + "      ,[taskOfUser]\n"
                + "      ,[groupID] , time_maked, time\n"
                + "  FROM [dbo].[Tasks]\n" + "  where taskOfUser = ? or "
                + "groupID in (select groupID from AccountGroup where username = ?)"
                + "  order by id \n"
                + "  offset ? rows\n"
                + "  fetch next 1 rows only";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, username);
            preparedStatement.setInt(3, number);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Task task = new Task(resultSet.getInt("id"), resultSet.getString("img"),
                        resultSet.getString("describe"), resultSet.getInt("status"),
                        resultSet.getString("taskOfUser"), resultSet.getInt("groupID"), resultSet.getString("time_maked"), resultSet.getString("time"));
                tasks.add(task);
            }
            return tasks;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Task> searchTop2NextTasks(String describe, String username, int number) {
        ArrayList<Task> tasks = new ArrayList<>();
        String sql = "SELECT			[id]\n"
                + "               ,[img] \n"
                + "               ,[describe] \n"
                + "               ,[status] \n"
                + "               ,[taskOfUser] \n"
                + "               ,[groupID] , time_maked, time\n"
                + "                FROM [dbo].[Tasks]   where [describe] like ? and  taskOfUser = ? or \n"
                + "                groupID in (select groupID from AccountGroup where username = ?)  \n"
                + "                order by id  \n"
                + "                offset ? rows \n"
                + "                fetch next 2 rows only";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + describe + "%");
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, username);
            preparedStatement.setInt(4, number);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Task task = new Task(resultSet.getInt("id"), resultSet.getString("img"),
                        resultSet.getString("describe"), resultSet.getInt("status"),
                        resultSet.getString("taskOfUser"), resultSet.getInt("groupID"), resultSet.getString("time_maked"), resultSet.getString("time"));

                tasks.add(task);
            }
            return tasks;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteTask(int id) {
        String sql = "DELETE FROM [dbo].[Tasks]\n"
                + "      WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
        }
    }

    public ArrayList<Task> getTop2Tasks(String username) {
        ArrayList<Task> tasks = new ArrayList<>();
        String sql = "SELECT TOP (2) [id]\n"
                + "      ,[img]\n"
                + "      ,[describe]\n"
                + "      ,[status]\n"
                + "      ,[taskOfUser]\n"
                + "      ,[groupID] , time_maked, time\n"
                + "  FROM [tasks2022].[dbo].[Tasks]\n"
                + "   where taskOfUser = ? or \n"
                + "               groupID in (select groupID from AccountGroup where username = ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Task task = new Task(resultSet.getInt("id"), resultSet.getString("img"),
                        resultSet.getString("describe"), resultSet.getInt("status"),
                        resultSet.getString("taskOfUser"), resultSet.getInt("groupID"), resultSet.getString("time_maked"), resultSet.getString("time"));

                tasks.add(task);
            }
            return tasks;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateTask(Task task) {
        String sql = " UPDATE [dbo].[Tasks]\n"
                + "   SET \n"
                + "      [describe] =?\n"
                + "      ,[status] = ?\n"
                + "      \n"
                + "      ,[groupID] = ?\n"
                + "      ,[time_maked] = ?\n"
                + "      ,[time] = ?\n"
                + " WHERE id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, task.getDescribe());
            preparedStatement.setInt(2, task.getStatus());
            preparedStatement.setInt(3, task.getGroupID());
            preparedStatement.setString(4, task.getTime());
            preparedStatement.setString(5, task.getTime_exc());
            preparedStatement.setInt(6, task.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
        }
    }

    public ArrayList<Task> searchTasks(String describe, int status, String username) {
        ArrayList<Task> tasks = new ArrayList<>();
        String sql = "SELECT			[id]\n"
                + "               ,[img] \n"
                + "               ,[describe] \n"
                + "               ,[status] \n"
                + "               ,[taskOfUser] \n"
                + "               ,[groupID] ,time_maked, time\n"
                + "                FROM [dbo].[Tasks]   where  ( taskOfUser = ? or \n"
                + "                groupID in (select groupID from AccountGroup where username = ?)   )";
        int paramIndex = 2;
        HashMap<Integer, Object[]> params = new HashMap<>();
        if (!describe.equals("")) {
            sql = sql + "and [describe] like  ? ";
            paramIndex++;
            Object[] param = new Object[2];
            param[0] = String.class.getName();
            param[1] = describe;
            params.put(paramIndex, param);
        }
        if (status != 0) {
            sql = sql + "and [status] =  ? ";
            paramIndex++;
            Object[] param = new Object[2];
            param[0] = Integer.class.getName();
            param[1] = status;
            params.put(paramIndex, param);
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, username);

            for (Map.Entry<Integer, Object[]> entry : params.entrySet()) {
                int index = entry.getKey();
                Object[] value = entry.getValue();
                if (value[0].toString().equals(String.class.getName())) {

                    preparedStatement.setString(index, "%" + value[1].toString() + "%");

                }
                if (value[0].toString().equals(Integer.class.getName())) {

                    preparedStatement.setInt(index, (int) value[1]);

                }

            }

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Task task = new Task(resultSet.getInt("id"), resultSet.getString("img"),
                        resultSet.getString("describe"), resultSet.getInt("status"),
                        resultSet.getString("taskOfUser"), resultSet.getInt("groupID"), resultSet.getString("time_maked"), resultSet.getString("time"));

                tasks.add(task);
            }
            return tasks;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addNotification(String noti, String username) {

        String sql;

        sql = "INSERT INTO [dbo].[Notification]\n"
                + "           ([notification]\n"
                + "           ,[username])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, noti);
            preparedStatement.setString(2, username);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
