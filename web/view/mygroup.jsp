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
    </head>
    <body>

        <jsp:include page="header.jsp" /> 

        <%  if (request.getAttribute("mess")!=null) {
        %>
        <div style="display: flex; align-items: center; justify-content:center ;height: 80vh">
            <h1>${requestScope.mess}</h1>
        </div>
        <%}  %>
        <div style="margin-bottom: 90vh">
            <c:forEach items="${requestScope.list}" var="l" varStatus="loop">
                <div style="text-align: center; margin-top: 80px">
                    <h3 style="margin: 20px 0"><h3> ${l.groupName}</h3></h3>
                    <p>
                        <a
                            class="btn btn-primary"
                            data-bs-toggle="collapse"
                            href="#info${l.groupID}"
                            role="button"
                            aria-expanded="false"
                            aria-controls="collapseExample"
                            >
                            <i class="fa-solid fa-chalkboard-user"></i> Manager
                        </a>
                        <button
                            class="btn btn-primary"
                            type="button"
                            data-bs-toggle="collapse"
                            data-bs-target="#list_people${l.groupID}"
                            aria-expanded="false"
                            aria-controls="collapseExample"
                            >
                            <i class="fa-solid fa-user-group"></i> Members
                        </button>
                        <button class="btn btn-primary" type="button">
                            <i class="fa-solid fa-person-from-portal"></i> Out group
                        </button>
                    </p>
                    <div style="width: 35%; margin: 0 auto">
                        <div class="collapse" id="list_people${l.groupID}">

                            <h3>Group-ID ${l.groupID} </h3>
                            <c:forEach items="${l.usernames}" var="la">
                                <p>
                                    ${la}
                                </p> 
                            </c:forEach>
                            <!--get list--> 

                        </div>
                        <div class="collapse" id="info${l.groupID}">
                            <h3>Teacher: ${l.groupOfusername}</h3>

                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>     <jsp:include page="footer.jsp" /> 
        <script
            src="https://kit.fontawesome.com/3a6c73e27c.js"
            crossorigin="anonymous"
        ></script>
        <script
            src="./js/main.js"
        ></script>
    </body>
</html>


