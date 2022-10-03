<%-- 
   Document   : login
   Created on : Aug 9, 2022, 12:49:36 AM
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
                                        <div class="text-center">
                                            <h3>
                                                <i class="fa fa-lock fa-4x"></i>
                                            </h3>
                                            <h2 class="text-center">Enter OTP</h2>
                                            <p class="text-danger ml-1">${requestScope.message} add </p>
                                            <div class="panel-body">
                                                <form id="register-form" action="ValidateOtp" role="form" autocomplete="off"
                                                      class="form" method="post">
                                                    <div class="form-group">
                                                        <div class="input-group">
                                                            <span class="input-group-addon"><i
                                                                    class="glyphicon glyphicon-envelope color-blue"></i></span> 
                                                            <input 
                                                                style="margin: 25px 0; border-radius: 5px"
                                                                id="opt" name="otp" placeholder="Enter OTP"
                                                                class="form-control" type="text" required="required">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <input name="recover-submit"
                                                               class="btn btn-lg btn-primary  "
                                                               value="Reset Password" type="submit">
                                                    </div>
                                                    <input type="hidden" class="hide" name="token" id="token" value="">
                                                </form>
                                            </div>
                                        </div>
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


