/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.NotificationDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import model.Account;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author 84352
 */
public class Utils {

    public static Account getAccountLogin(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        Account accountm = (Account) httpSession.getAttribute("login");
        return accountm;
    }

    public static void notification(HttpServletRequest request, String p1, String p2) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String time_maked = dateFormat.format(date).toString();
        model.Notification notification = new model.Notification(p1,
                Utils.getAccountLogin(request).getUsername(), p2, time_maked);
        NotificationDAO notificationDAO = new NotificationDAO();
        notificationDAO.addNotification(notification);
    }

    public static void sendNotificationToGmail(String from, String to, String des) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("taskmanagerprj2022@gmail.com", "rypqjrhchawkrhoc");
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(to));// change accordingly

            try {
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            } catch (Exception e) {
//                    request.setAttribute("connection", "Mail is not exist");
            }
            message.setSubject("Hello " + to);
            message.setText(from + " Assign you a task. " + "Please go to website to check it");
            // send message
            Transport.send(message);
            System.out.println("ooo");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String enCodePassword(String pass) {

        try {
            // Static getInstance method is called with hashing MD5 
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(pass.getBytes());

            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value 
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
