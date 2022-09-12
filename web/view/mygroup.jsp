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

        <div>
            <div class="contain_card"> 
                <c:forEach items="${requestScope.list}" var="l">
                    <div class="main">
                        <h3>Teacher: ${l.groupName}</h3>
                        <h3>Group-ID ${l.groupID}</h3>
                        <h3>Username of teacher: ${l.groupOfusername}</h3>
                    </div>
                </c:forEach>
            </div>
        </div>
        <script
            src="https://kit.fontawesome.com/3a6c73e27c.js"
            crossorigin="anonymous"
        ></script>
        <script
            src="./js/main.js"
        ></script>
    </body>
</html>


