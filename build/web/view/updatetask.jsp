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
                Update Task
            </div>

            <div class="label_add_task">
                <h2 style="color: red">${requestScope.mess}</h2>
            </div>

            <form action="./updatetask" method="post">

                <input type="hidden"  name="groupID" value="${requestScope.task.groupID}">
                <input type="hidden"  name="id" value="${requestScope.task.id}">
                <div class="mb-3">
                    <label for="exampleFormControlTextarea1" class="form-label">Status</label>
                    <select name="status"  class="form-select" aria-label="Default select example"> 
                        <option value="1">On-going</option>
                        <option value="2">End</option>
                        <option value="3">Start</option>
                    </select>
                </div>
                <!--                <div class="mb-3">
                                    <label for="formFile" class="form-label">Image</label>
                                    <input value="${requestScope.task.img}" name="img"  class="form-control" type="file"  aria-label="default input example">
                
                                </div>-->
                <div class="mb-3">
                    <label for="exampleFormControlInput1" class="form-label">Describe</label>        
                    <textarea value="${requestScope.task.describe}" name="describe"  rows="8"  required="" class="form-control" type="text" placeholder="Enter Describe" aria-label="default input example"></textarea>
                </div>
                <div class="mb-3">
                    <label for="exampleFormControlInput1" class="form-label">Time Expired</label>  
                    <input name="alarmTime" type="datetime-local">
                </div>
                <input class="btn btn-success" type="submit" value="Save">

            </form>
        </div>

        <script
            src="https://kit.fontawesome.com/3a6c73e27c.js"
            crossorigin="anonymous"
        ></script>
    </body>
</html>


