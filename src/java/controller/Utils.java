/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import model.Account;

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

    public String enCodePassword(String pass) {
        return null;
    }

    public String deCodePassword(String pass) {
        return null;
    }
}
