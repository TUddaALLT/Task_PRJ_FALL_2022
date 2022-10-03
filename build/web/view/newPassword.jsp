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
                                        <h2 class="text-uppercase text-center mb-5">Change password</h2>
                                        <form action="./newPassword" method="POST">
                                            <div class="form-outline mb-3">
                                                <input   type="password" name="password" required=""   class=" form-control form-control-lg" />
                                                <label class="form-label" for="form3Example4cg">New Password</label>
                                            </div>
                                            <div class="form-outline mb-3">
                                                <input type="password" required="" name="confirm_password" class="form-control form-control-lg" />
                                                <label class="form-label" for="form3Example4cdg">Repeat New Password</label>
                                            </div>
<!--                                            <h4 class="text-uppercase text-center mb-5" style="color: red">${requestScope.mess_er}</h4>
                                            <h4 class="text-uppercase text-center mb-5" style="color: blue">${requestScope.mess}</h4>-->
                                            <div class="d-flex justify-content-center">
                                                <input style="width: 100% ; margin:20px 0 " type="submit" class="btn btn-success btn-block btn-lg gradient-custom-4 text-body" value="Change password"/>
                                            </div>
                                        </form>
                                        <button style="width: 100%"  class="btn btn-danger btn-block btn-lg gradient-custom-4 text-body">
                                            <a   href="register" class=" text-body">You don't have account? Register</a>
                                        </button>
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


