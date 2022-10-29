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
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
            integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
            crossorigin="anonymous"
            /> 
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
            />
        <link
        <link rel="stylesheet" href="./css/main.css" />
    </head>
    <body>

        <jsp:include page="header.jsp" /> 
        <%  if (request.getAttribute("mess")!=null) {
        %>
        <div style="display: flex; align-items: center; justify-content:center ;height: 80vh">
            <h1>${requestScope.mess}</h1>
        </div>
        <%}  %>

        <div style="margin-bottom: 90vh ; padding-top: 10vh">
            <div class="contain_card"> 

                <c:forEach items="${requestScope.list}" var="l">
                    <div class="main">
                        <div class="card">
                            <div class="card-body"> 
                                <h3>Group Name: ${l.groupName}</h3>  <br>
                                <h3>Group-ID: ${l.groupID}</h3> <br>
                                <div style="display: flex ; justify-content: space-between">
                                    <div class="btn btn-primary" onclick="do_assigntask('${l.groupID}')">Assign Task</div>

                                    <div class="btn btn-danger">
                                        <i onclick="delete_group('${l.groupID}')" class="fa-solid fa-trash "></i> 
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>



            </div>

            <section class="notification">
                <div class="container mt-5">
                    <div class="alert fade alert-simple alert-success alert-dismissible text-left font__family-montserrat font__size-16 font__weight-light brk-library-rendered rendered show">

                        <i class="start-icon far fa-check-circle faa-tada animated"></i>
                        <strong class="font__weight-semibold">New Notification!</strong> 
                        <span class="noti_value">
                            XX
                        </span>
                    </div>
            </section> 
        </div>     <jsp:include page="footer.jsp" /> 
        <script
            src="https://kit.fontawesome.com/3a6c73e27c.js"
            crossorigin="anonymous"
        ></script>
        <script
            src="./js/main.js"
        ></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <!--<script src="https://apps.elfsight.com/p/platform.js" defer></script>-->
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    </body>
</html>


