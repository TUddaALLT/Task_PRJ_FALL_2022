/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 84352
 */
public class Task {

    private int id;
    private String img;
    private String describe;
    private int status;
    private String username;
    private int groupID;

    public Task() {
    }

    public Task(int id, String img, String describe, int status, String username) {
        this.id = id;
        this.img = img;
        this.describe = describe;
        this.status = status;
        this.username = username;
    }

    public Task(int id, String img, String describe, int status, String username, int groupID) {
        this.id = id;
        this.img = img;
        this.describe = describe;
        this.status = status;
        this.username = username;
        this.groupID = groupID;
    }

    public Task(String img, String describe, int status, String username, int groupID) {
        this.img = img;
        this.describe = describe;
        this.status = status;
        this.username = username;
        this.groupID = groupID;

    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
