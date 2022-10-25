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
        <link rel="stylesheet" href="./css/main.css" />


    <div class="elfsight-app-79fd2743-aa52-4244-a15b-26490da4d24c" ></div>
</head>
<body onload="setAlarm('${sessionScope.time}')">
    <jsp:include page="header.jsp" /> 
    <c:if test="${requestScope.tasks.size()!=0}" >
        <div style="    margin-top: 90px;
             display: flex;
             justify-content: center;
             position: fixed;
             margin-left: 20vw;">
            <a class="btn btn-primary" data-bs-toggle="modal" href="#exampleModalToggle" role="button">Search    <i class="fas fa-search"></i></a>
        </div>
    </c:if>


    <div style="padding: 60px 0 75vh 0">
        <div id="ajax" class="contain_card"> 

            <div class="modal fade" id="exampleModalToggle" aria-hidden="true" aria-labelledby="exampleModalToggleLabel" tabindex="-1">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form action="./searchtask" method="get" >
                                <div class="input-group">
                                    <textarea name="describe"  rows="8"  type="search" class="form-control rounded" placeholder="Search Describe" ></textarea> 

                                </div>
                                <div style="margin: 20px 0" class="input-group">
                                    <select name="status" class="form-select form-select-md mb-3" aria-label=".form-select-lg example">
                                        <option selected="" value="0">Status</option>
                                        <option value="1">On-going</option>
                                        <option value="2">End</option>
                                        <option value="3">Start</option>
                                    </select>
                                </div>
                                <input class="btn btn-success" type="submit" value="Search">

                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <c:forEach items="${requestScope.tasks}" var="t">
                <div class="main">
                    <div class="card">
                        <div style=" height: 40vh; ">
                            <img src="<c:url value="files/${t.img}"></c:url>" class="card-img-top" style="height: 100%;  object-fit: cover"/>
                            </div>
                            <div class="card-body">
                            <c:if test = "${t.status == 1}">
                                <h5 class="card-title" style="color: green ;font-weight: bold;">
                                    Status: On-going
                                </h5>
                            </c:if>
                            <c:if test = "${t.status == 2}">
                                <h5 class="card-title" style="color: blue ; font-weight: bold;">
                                    Status: End
                                </h5>
                            </c:if> 
                            <c:if test = "${t.status == 3}">
                                <h5 class="card-title" style="color: red;font-weight: bold;">
                                    Status: Start
                                </h5>
                            </c:if>
                            <c:if test = "${t.groupID != 0}">
                                <p>Task from: ${t.username }<p>
                                </c:if>   
                                <c:if test = "${t.groupID == 0}">
                                <p>Your task<p>
                                </c:if> 
                            <p>Description: ${t.describe}</p>
                            <div class="trash">
                                <c:if test = "${t.groupID != 0 and !(t.username eq sessionScope.login.username)}">
                                    <a onclick="updateTask('${t.id}')" class="btn btn-primary disabled ">Update Task</a>
                                </c:if>  
                                <c:if test = "${t.groupID == 0 or  t.username eq sessionScope.login.username}">
                                    <a onclick="updateTask('${t.id}')" class="btn btn-primary ">Update Task</a>
                                </c:if> 
                                <c:if test = "${t.groupID != 0 and !(t.username eq sessionScope.login.username)}">
                                    <div class="btn btn-primary disabled">
                                        <i onclick="deleteTask('${t.id}')" class="fa-solid fa-trash "></i> 
                                    </div>
                                </c:if>   
                                <c:if test = "${t.groupID == 0 or  t.username eq sessionScope.login.username}">
                                    <div class="btn btn-danger">
                                        <i onclick="deleteTask('${t.id}', '${t.describe}')" class="fa-solid fa-trash "></i> 
                                    </div>
                                </c:if> 
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>


            <c:if test="${requestScope.tasks.size()==0}" >
                <h1 style="color: #00040a">
                    You have not created task
                </h1>
            </c:if>

        </div>
        <section class="notification">
            <div class="container mt-5">
                <div class="alert fade alert-simple alert-success alert-dismissible text-left font__family-montserrat font__size-16 font__btn-primary brk-library-rendered rendered show">

                    <i class="start-icon far fa-check-circle faa-tada animated"></i>
                    <strong class="font__weight-semibold">New Notification!</strong> 
                    <span class="noti_value">
                        XX
                    </span>
                </div>
        </section> 
        <c:if test="${requestScope.tasks.size()!=0}" >
            <div class="contain_card"> 
                <button onclick="loadMore()" class="btn btn-primary">Load more</button>
            </div>  
        </c:if>

    </div>
    <jsp:include page="footer.jsp" /> 
    <script
        src="https://kit.fontawesome.com/3a6c73e27c.js"
        crossorigin="anonymous"
    ></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script
        src="./js/main.js"
    ></script>
    <!--<script src="https://apps.elfsight.com/p/platform.js" defer></script>-->
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</body>
</html>


