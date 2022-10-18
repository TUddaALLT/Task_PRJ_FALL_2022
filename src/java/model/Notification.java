/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 84352
 */
public class Notification {

    String notification;

    String username;

    String type;

    String time;

    public Notification() {
    }

    public Notification(String notification, String username, String type, String time) {
        this.notification = notification;
        this.username = username;
        this.type = type;
        this.time = time;
    }

    public String getNotification() {
        return notification;
    }

    public String getUsername() {
        return username;
    }

    public String getType() {
        return type;
    }

    public String getTime() {
        return time;
    }

}
