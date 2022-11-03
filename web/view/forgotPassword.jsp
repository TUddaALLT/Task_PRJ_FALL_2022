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
                                        <div >
                                            <div >
                                                <h2>Forgot your password?</h2>
                                                <p>Change your password in three easy steps. This will help you
                                                    to secure your password!</p>
                                                <ol class="list-unstyled">
                                                    <li><span class="text-primary text-medium">1. </span>Enter
                                                        your email address below.</li>
                                                    <li><span class="text-primary text-medium">2. </span>Our
                                                        system will send you an OTP to your email</li>
                                                    <li><span class="text-primary text-medium">3. </span>Enter the OTP on the 
                                                        next page</li>
                                                </ol>
                                            </div>
                                            <form   action="forgotPassword" method="POST" class="checkGmailIsValid">
                                                <div >
                                                    <div class="form-group">
                                                        <label for="email-for-pass">Enter your email address</label> 
                                                        <input    class="form-control GmailIsValid" type="text" name="email" id="email-for-pass"  required="">
                                                        <small class="form-text text-muted">Enter the registered email address . Then we'll
                                                            email a OTP to this address.</small>
                                                         <h4 class="text-uppercase text-center mb-5 isNotValid" style="color: red"></h4>
                                                    </div>
                                                </div>
                                                <input  onclick="checkGmailSMTP()"  style="width: 100% ; margin: 20px 0" type="submit" class="btn btn-info btn-block btn-lg gradient-custom-4 text-body" value="Get New Password"/>
                                            </form>
                                            <button style="width: 100%"  class="btn btn-danger btn-block btn-lg gradient-custom-4 text-body">
                                                <a   href="login" class=" text-body">Back To Login</a>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section></div>
             <jsp:include page="footer.jsp" /> 
        <script
            src="https://kit.fontawesome.com/3a6c73e27c.js"
            crossorigin="anonymous"
        ></script>
        <script
            src="./js/main.js"
        ></script>
    </body>
</html>


