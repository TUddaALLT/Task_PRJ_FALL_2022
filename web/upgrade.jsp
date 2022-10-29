<%-- 
    Document   : upgrade
    Created on : Aug 9, 2022, 7:17:04 PM
    Author     : 84352
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html  >
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./css/main.css" />

    </head>
    <body>
        <jsp:include page="header.jsp" /> 

        <div style="display: flex; justify-content: center;align-items: center ;height: 90vh">
            <form action="./upgrade" method="post">
                <input class="btn btn-success" type="submit" value="Pay to upgrade">
            </form>
        </div>
        <script src="./js/main.js">
        </script>     <jsp:include page="footer.jsp" /> 
    </body>
</html>
