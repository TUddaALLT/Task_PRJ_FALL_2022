<%-- 
   Document   : home
   Created on : Aug 8, 2022, 5:08:32 PM
   Author     : 84352
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
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
        <link rel="stylesheet" href="./js/main.js" />
    </head>
    <body>
        <jsp:include page="header.jsp" /> 
        <div class="contain_add">
            <%  if(request.getAttribute("messToUpgrade")==null){ %>
            <div class="label_add_task">
                Create Group
            </div>
            <form action="./creategroup" method="post"  >
                <div class="mb-3">
                    <label for="exampleFormControlInput1" class="form-label">Name</label>        
                    <input class="form-control" required="" name="name" type="text" placeholder="Enter Name" aria-label="default input example">
                </div>
                <div class="mb-3">
                    <label for="exampleFormControlInput1" class="form-label">ID Group</label>        
                    <input class="form-control" required="" name="id" type="number" placeholder="Enter Id Group" aria-label="default input example">
                </div>
                <div class="mb-3">
                    <label for="exampleFormControlInput1" class="form-label">Group Name</label>        
                    <input class="form-control" required="" name="namegroup" type="text" placeholder="Enter Group Name" aria-label="default input example">
                </div>

                <input class="btn btn-success" type="submit" value="Create Group">
            </form>
            <% } else {%>
            <div class="label_add_task" style="color: red ; display: flex
                 ; justify-content: space-between ; width: 50vw
                 ; margin: auto
                 ">
                ${requestScope.messToUpgrade}
                <div>
                    <a  class="btn btn-success btn-block btn-lg gradient-custom-4 text-body d-flex justify-content-center" href="./upgrade">Click to upgrade</a>
                </div>
            </div>

            <% } %>
        </div>

        <script
            src="https://kit.fontawesome.com/3a6c73e27c.js"
            crossorigin="anonymous"
        ></script>
    </body>
</html>


