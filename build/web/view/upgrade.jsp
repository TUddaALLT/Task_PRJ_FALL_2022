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
            <div class="loader" >
                <form action="./upgrade" method="post">
                    <input type="submit" value="Pay to upgrade">
                </form>
            </div>
        </div>
        <script src="./js/main.js">
        </script>
    </body>
</html>
