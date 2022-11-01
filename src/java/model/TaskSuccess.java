/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 84352
 */
public class TaskSuccess {

    int taskID;
    int groupID;
    String usernameMake;
    String usernameDo;

    public TaskSuccess() {
    }

    public TaskSuccess(int taskID, int groupID, String usernameMake, String usernameDo) {
        this.taskID = taskID;
        this.groupID = groupID;
        this.usernameMake = usernameMake;
        this.usernameDo = usernameDo;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public String getUsernameMake() {
        return usernameMake;
    }

    public void setUsernameMake(String usernameMake) {
        this.usernameMake = usernameMake;
    }

    public String getUsernameDo() {
        return usernameDo;
    }

    public void setUsernameDo(String usernameDo) {
        this.usernameDo = usernameDo;
    }

}
