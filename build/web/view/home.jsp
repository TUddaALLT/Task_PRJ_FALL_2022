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
        <script src="https://apps.elfsight.com/p/platform.js" defer></script>
    <div class="elfsight-app-79fd2743-aa52-4244-a15b-26490da4d24c" ></div>
</head>
<body>
    <jsp:include page="header.jsp" /> 
    <div style="padding-top: 60px">
        <div id="ajax" class="contain_card"> 
            <form method="get" action="./searchtask">
                <div class="input-group">
                    <input name="describe" type="search" class="form-control rounded" placeholder="Search" aria-label="Search" aria-describedby="search-addon" />
                    <button type="button" type="submit" class="btn btn-outline-primary">search</button>
                </div>
            </form>
            <c:forEach items="${requestScope.tasks}" var="t">
                <div class="main">
                    <div class="card">
                        <div>
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
                                    <div class="btn btn-primary">
                                        <i onclick="deleteTask('${t.id}')" class="fa-solid fa-trash "></i> 
                                    </div>
                                </c:if> 
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>

        </div>
        <div class="contain_card"> 
            <button onclick="loadMore()" class="btn btn-primary">Load more</button>
        </div>
    </div>
    <script
        src="https://kit.fontawesome.com/3a6c73e27c.js"
        crossorigin="anonymous"
    ></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script
        src="./js/main.js"
    ></script>
</body>
</html>


