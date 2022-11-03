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
                                        <h2 class="text-uppercase text-center mb-5">Login Account</h2>
                                        <form action="./login" method="post" id="form">
                                            <div class="form-outline mb-3">
                                                <input   type="email" name="username" required=""  class=" form-control form-control-lg" />
                                                <label class="form-label" for="form3Example3cg">Your Email</label>
                                            </div>
                                            <div class="form-outline mb-3">
                                                <input   type="password" name="password" required=""   class=" form-control form-control-lg" />
                                                <label class="form-label" for="form3Example4cg">Password</label>
                                            </div> 
                                            <h4 class="text-uppercase text-center mb-5" style="color: red">${requestScope.mess_er}</h4>
                                            <!--captcha-->
                                            <div style="margin-bottom: 10px" class="d-flex justify-content-center">
                                                <div  class="g-recaptcha" data-sitekey="6LcN9dEiAAAAAI1cjh4ox4tSaH3nov884_13fHDJ"></div>
                                            </div>
                                            <div style="margin-bottom: 10px" class="d-flex justify-content-center">
                                                <div style="color: red" class="captcha"></div>
                                            </div>
                                            <!--captcha-->
                                            <div style="width: 100%" class="d-flex justify-content-center">
                                                <input style="width: 100%" type="submit" class="btn btn-info btn-block btn-lg gradient-custom-4 text-body" value="Login"/>
                                            </div>
                                            <div style="width: 100% ;  margin-top: 3em" class="d-flex justify-content-center ">
                                                <a style="width: 100%; " class="btn btn-danger btn-block gg_login btn-lg gradient-custom-4 text-body" 
                                                   href="https://accounts.google.com/o/oauth2/auth?scope=email profile&redirect_uri=http://localhost:9999/Tasks/login&response_type=code
                                                   &client_id=641835329293-5dv586l39j3om29fo4ekshqed1hb2td2.apps.googleusercontent.com&approval_prompt=force">
                                                    <span style="    margin-right: 20px;
                                                          "><i class="fa-brands fa-google"></i> </span>
                                                    Login with Google

                                                </a>
                                            </div>
                                            <p class="text-center text-muted mt-5 mb-0"> <a href="forgotPassword" class="fw-bold text-body"><u style="color: #f3f3f3">Forget password?</u></a></p>
                                        </form>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section></div>     <jsp:include page="footer.jsp" /> 
        <script
            src="https://kit.fontawesome.com/3a6c73e27c.js"
            crossorigin="anonymous"
        ></script>
        <script
            src="./js/main.js"
        ></script>
        <script src="https://www.google.com/recaptcha/api.js" async defer></script>
        <script>
            window.onload = function () {
                const form = document.querySelector("#form");
                form.addEventListener("submit", function (e) {
                    e.preventDefault();
                    const response = grecaptcha.getResponse();
                    if (response) {
                        form.submit();
                    } else {
                        document.querySelector(".captcha").innerHTML = "Check Captcha";
                    }
                })
            }
        </script>
    </body>
</html>


