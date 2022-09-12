<%-- 
   Document   : home
   Created on : Aug 8, 2022, 5:08:32 PM
   Author     : 84352
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <div class="label_add_task">
                Register Group
            </div>
            <div class="label_add_task">
               <h2 style="color: red">${requestScope.mess}</h2>
                              <h2 style="color: red">${requestScope.mes}</h2>

            </div>
           
            <div style="width: 30vw ;margin: auto">
                <form action="./registergroup" method="post">
                <div class="mb-3">
                    <label for="exampleFormControlInput1" class="form-label">ID Group Task</label>        
                    <input class="form-control" required="" name="id" type="number" placeholder="Enter Id Group" aria-label="default input example">
                </div>
                   
                <div><input class="btn btn-success" type="submit" value="Register"></div>
                
            </form>
            </div>
        </div>

        <script
            src="https://kit.fontawesome.com/3a6c73e27c.js"
            crossorigin="anonymous"
        ></script>
    </body>
</html>


