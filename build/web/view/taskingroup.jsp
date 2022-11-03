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

        <%  if (request.getAttribute("not_ass")!=null) {
        %>
        <div style="display: flex; align-items: center; justify-content:center ;height: 80vh">
            <h1>You have not assigned anything</h1>
        </div>
        <%}  %>
        <div style="margin-bottom: 90vh">
            <c:forEach items="${requestScope.allTasksInGroup}" var="t" varStatus="loop">
                <div class="xx_taskingroup" style="text-align: center; margin-top: 80px ; padding: 0 20vw;">
                    <div class="accordion" id="accordionPanelsStayOpenExample">
                        <div class="accordion-item">
                            <h2 class="accordion-header" id="headingTwo">
                                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseOne${loop.index}" aria-expanded="true" aria-controls="panelsStayOpen-collapseOne${loop.index}">
                                    <div style="padding: 18px 10px 0 10px ; display: flex;justify-content: center" class="badge rounded-pill bg-info text-dark"> ID:${t.id}  |  Describe: ${t.describe}  </div>
                                </button>
                            </h2>
                            <div id="panelsStayOpen-collapseOne${loop.index}" class="accordion-collapse collapse  " aria-labelledby="headingTwo">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th scope="col">Index</th>
                                            <th scope="col">Username</th>
                                            <th scope="col">Completed</th>
                                            <th scope="col">Kick</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${requestScope.usernameCompleted}" var="u" varStatus="loop">
                                            <tr>
                                                <th scope="row">${(loop.index+1)}</th>
                                                <td>${u}</td>
                                                <c:set var = "check" scope = "session" value = "0"/>
                                                <c:forEach items="${requestScope.taskSuccesses}" var="taskSuccesses" varStatus="loop">
                                                    <c:if test = "${u == taskSuccesses.usernameDo && t.id == taskSuccesses.taskID}">
                                                        <td><i style="color: green" class="fa-solid fa-check"></i></td>
                                                            <c:set var = "check" scope = "session" value = "1"/>
                                                        </c:if>
                                                    </c:forEach>
                                                    <c:if test = "${sessionScope.check == 0}">
                                                    <td><i style="color: red" class=" fa-solid fa-x"></i></td>
                                                    </c:if>
                                                <td><button onclick="kick('${groupID}', '${u}')" class="btn btn-primary" type="button">
                                                        <i class="fa-solid fa-person-from-portal"></i> 
                                                        <a>Kick</a>
                                                    </button></td>
                                            </tr> 
                                        </c:forEach>

                                    </tbody>
                                </table>
                            </div>
                        </div> 
                    </div>
                </div>
            </c:forEach>
        </div>     <jsp:include page="footer.jsp" /> 
        <script
            src="https://kit.fontawesome.com/3a6c73e27c.js"
            crossorigin="anonymous"
        ></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script
            src="./js/main.js"
        ></script>

        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    </body>
</html>


