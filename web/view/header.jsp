<%-- 
    Document   : home
    Created on : Aug 8, 2022, 5:08:32 PM
    Author     : 84352
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Document</title>
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
            />
        <link
            <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
            integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
            crossorigin="anonymous"
            /> 
        <link rel="stylesheet" href="./css/main.css" />
    </head>
    <body>

        <div  class="nav" style="background: #273e5d " >
            <button class="more" onclick="open_nav()"><i class="fa-solid fa-bars"></i></button>
            <div class="nav_l  ">
                <div>
                    <a href="./start">Get Started</a>
                </div>
                <div>
                    <a onclick="setAlarm('${sessionScope.time}')"  href="./home"><i class="fa-solid fa-house-user"></i></a>
                </div>
                <div>
                    <a href="./add">Add Task</a>
                </div>

                <div class="dropdown dropdown_group">
                    <button style="color: white" class="btn btn-block outline dropdown-toggle" type="button" id="dropdownMenu2" data-bs-toggle="dropdown" aria-expanded="false">
                        Group
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
                        <li><button class="dropdown-item" type="button">
                                <a href="./groupcreated">My Group Created</a></button></li>
                        <li><button class="dropdown-item" type="button">
                                <a href="./mygroup">My Group Joined</a></button></li>
                        <li><button class="dropdown-item" type="button">
                                <a href="./creategroup" >Create Group</a></button></li>
                        <li><button class="dropdown-item" type="button">
                                <a href="./registergroup">Register Group</a></button></li> 
                        <li><button class="dropdown-item" type="button">
                                <a href="./upgrade">Upgrade</a></button></li> 

                    </ul>
                </div> 
                <div style="display: none" class="animate__animated animate__fadeInTopRight animate__faster open_noti">
                    <div class="list-group noti_list"> 
                    </div>
                </div>
            </div>
            <div  class="nav_r">

                <div><span style="color: white"   id="username_text">Welcome ${cookie['usernameCookie'].getValue()}</span></div>
                <div class="dropdown dropdown_acc">
                    <button style="color: white" onclick="css_z_index()" class="btn btn-block outline dropdown-toggle" type="button" id="dropdownMenu2" data-bs-toggle="dropdown" aria-expanded="false">
                        Account
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
                        <li><button class="dropdown-item" type="button"> <a href="./register">
                                    Register
                                </a></button></li>
                        <li><button class="dropdown-item" type="button"> <a href="./login">
                                    <i class="fa-solid fa-right-to-bracket"></i></i>Log in
                                </a></button></li>
                        <li><button class="dropdown-item" type="button"> <a href="./logout">
                                    <i class="fa-solid fa-right-from-bracket"></i>Log out
                                </a></button></li> 
                    </ul>
                </div>
            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script
            src="https://kit.fontawesome.com/3a6c73e27c.js"
            crossorigin="anonymous"
        ></script>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js"
                integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js"
                integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy"
        crossorigin="anonymous"></script>
        <script
            src="./js/main.js"
        ></script>
        <div onclick="getNotification()" class="my-btn">
            <div class="my-btn-border"></div>
            <i class="fas fa-bell btn-bell"></i>
        </div>
    </body>
</html>


