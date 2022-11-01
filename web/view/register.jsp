<%-- 
    Document   : register
    Created on : Aug 8, 2022, 11:57:42 PM
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
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
            integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
            crossorigin="anonymous"
            /> 
        <link rel="stylesheet" href="./css/main.css" />
    </head>
    <body>
        <jsp:include page="header.jsp" /> 

        <div  > 
            <section class="vh-100 bg-image">
                <div class="mask d-flex align-items-center h-100 gradient-custom-3">
                    <div class="container h-100">
                        <div class="row d-flex justify-content-center align-items-center h-100">
                            <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                                <div class="card" style="border-radius: 15px;">
                                    <div class="card-body p-5">
                                        <h2 class="text-uppercase text-center mb-5">Create an account</h2>
                                        <form action="./sendotp" method="get">
                                            <div style="display: flex" class="form-outline mb-3">
                                                <input placeholder="Your email" value="${sessionScope.email}" type="email" name="username" required=""  class=" form-control form-control-lg" />
                                                <div class="d-flex justify-content-center">
                                                    <input type="submit" class="gg_login btn btn-success btn-block btn-lg gradient-custom-4 text-body" value="Send OTP"/>
                                                </div>
                                            </div>
                                        </form>
                                        <form action="./register" method="post">

                                            <div class="form-outline mb-3">
                                                <input placeholder="OTP from your mail" name="otp" type="number" required="" class=" form-control form-control-lg" />

                                            </div>
                                            <div class="form-outline mb-3">
                                                <input  placeholder="Password" type="password" name="password" required=""   class=" form-control form-control-lg" />

                                            </div>
                                            <div class="form-outline mb-3">
                                                <input placeholder="Repeat your password" type="password" required="" name="confirm_password" class="form-control form-control-lg" />

                                            </div>
                                            <h4 class="text-uppercase text-center mb-5" style="color: red">${requestScope.mess_er}</h4>
                                            <h4 class="text-uppercase text-center mb-5" style="color: blue">${requestScope.mess}</h4>
                                            <h4 class="text-uppercase text-center mb-5" style="color: blue">${requestScope.connection}</h4>
                                            <div class="d-flex justify-content-center">
                                                <input type="submit" class="btn gg_login btn-success btn-block btn-lg gradient-custom-4 text-body" value="Register"/>
                                            </div>
                                            <p class="text-center text-muted mt-5 mb-0">Have already an account? <a href="./login"
                                                                                                                    class="fw-bold text-body"><u>Login here</u></a></p>

                                        </form>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section></div>
        <script
            src="https://kit.fontawesome.com/3a6c73e27c.js"
            crossorigin="anonymous"
        ></script>
        <script
            src="./js/main.js"
        ></script>
    </body>
</html>


