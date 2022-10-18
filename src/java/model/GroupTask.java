/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author 84352
 */
public class GroupTask {

    private int groupID;
    private String groupOfusername;
    private String groupName;
    private String usernames[];

    public String[] getUsernames() {
        return usernames;
    }

    public void setUsernames(String[] usernames) {
        this.usernames = usernames;
    }

    public GroupTask() {
    }

    public GroupTask(int groupID, String groupOfusername, String groupName) {
        this.groupID = groupID;
        this.groupOfusername = groupOfusername;
        this.groupName = groupName;
    }

    public GroupTask(String username, String nameGroup) {
        this.groupOfusername = username;
        this.groupName = nameGroup;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public String getGroupOfusername() {
        return groupOfusername;
    }

    public void setGroupOfusername(String groupOfusername) {
        this.groupOfusername = groupOfusername;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

}
