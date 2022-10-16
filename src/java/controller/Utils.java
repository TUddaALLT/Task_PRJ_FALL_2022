/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import model.Account;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Calendar;

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

    public static void main(String[] args) {

        // creating a date object with specified time.
        Date dateOne = new Date();

        System.out.println("Date initially: "
                + dateOne);

        // Sets the time
        dateOne.setTime(1000);

        // Prints the time
        System.out.println("Date after setting"
                + " the time: "
                + dateOne);
    }
}
