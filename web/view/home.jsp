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
            href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
            />
        <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
            integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
            crossorigin="anonymous"
            /> 
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.2.2/js/bootstrap.bundle.min.js"
            integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
            crossorigin="anonymous"
            /> 
        <link rel="stylesheet" href="./css/main.css" />
    <div class="elfsight-app-79fd2743-aa52-4244-a15b-26490da4d24c" ></div>

    <style>
        * {
            margin: 0;
        }
        #particles-js {
          background: 
              url("https://haycafe.vn/wp-content/uploads/2021/12/Hinh-anh-dep-Powerpoint.png")
          bottom no-repeat transparent;    background-size: cover;
            position: fixed;
            width: 100%;
            height: 100%;
            top: 0;
            z-index: -1;
        }
        #principal {
            color: rgba(242, 11, 11, 0.219);
        }
    </style>
</head>
<body onload="setAlarm('${sessionScope.time}', '${sessionScope.des}')">
    <main id="principal">
        <jsp:include page="header.jsp" /> 
        <div class="hr1"></div>
        <c:if test="${requestScope.tasks.size()!=0}" >

            <div class="search">
                <input placeholder="Search describe..." type="text" oninput="search(this.value)" 
                       style="padding: 6.5px;
                       border: none;
                       border-radius: 5px;
                       width: 12vw;">

                <i style="    top: 5px;
                   position: relative;
                   font-size: 25px;
                   color: rebeccapurple;
                   right: 35px;" class="fas fa-search"></i>

            </div>
              <div class="adder" style=" margin-top: 20px;
             display: flex;
             justify-content: center;
             ">
            <a class="btn btn-primary" data-bs-toggle="tooltip" data-bs-placement="top" title="Add Task"  href="./add" role="button"><i class="fa-solid fa-plus"></i></a>
        </div>
        <div class="search_status_laptop" >
            <div class="btn-group-vertical">
                <span style="width: 100%; margin-bottom: 10px ;padding: 8px 0"  class="badge rounded-pill bg-info text-dark">Status</span>
                <button type="button" onclick="search('', 3)" class="btn btn-danger">Start</button>
                <button type="button" onclick="search('', 1)" class="btn btn-warning">Going</button>
                <button type="button" onclick="search('', 2)" style="background: green" class="btn">End</button>
                <button  type="button" class="btn btn-primary" onclick="sort()">
                    New
                </button>
            </div>
        </div>
        <div class="search_status_mobile">
            <div class="btn-group  " role="group" aria-label="...">
                <button type="button" onclick="search('', 3)" class="btn btn-danger btn_mobile">Start</button>
                <button type="button" onclick="search('', 1)" class="btn btn-warning btn_mobile">Going</button>
                <button type="button" onclick="search('', 2)" style="background: green" class="btn btn_mobile">End</button>
                 <button  type="button" class="btn btn-primary" onclick="sort()">
                    New
                </button>
            </div>
        </div>

        <div class="badget_intro">
            <h3 style="background: rgb(34,193,195);
                background: white;
                padding: 2px 10px;
                color: #3d99ce;
                border-radius: 5px;">Table Project </h3> 
        </div>
        </c:if>
      

        <div class="tasks" style="padding: 60px 10% 75vh 10%; ">
            <div id="ajax" class="contain_card"> 
                <c:forEach items="${requestScope.tasks}" var="t">
                    <div class="animate__animated animate__flipInX main ">
                        <div class=" content_task ">
                            <div style="height: 25vh;  width: 10vw ">
                                <img src="<c:url value="files/${t.img}"></c:url>" class="card-img-top" style="min-width:154px; height: 100%;border-radius: 15px 0 0 15px; background-repeat: repeat-y;  object-fit: cover"/>
                                </div>
                                <div class="card-body">
                                <c:if test = "${t.status == 1}">
                                    <div class="progress" >
                                        <div class="progress-bar bg-warning" role="progressbar" style="width: 50%;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100">50%</div>
                                    </div>
                                </c:if>
                                <c:if test = "${t.status == 2}"> 
                                    <div class="progress" >
                                        <div class="progress-bar bg-success" role="progressbar" style="width: 100%;" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100">100%</div>
                                    </div>
                                </c:if> 
                                <c:if test = "${t.status == 3}"> 
                                    <div class="progress" >
                                        <div class="progress-bar bg-danger" role="progressbar" style="width: 25%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">25%</div>

                                    </div>
                                </c:if>
                                <c:if test = "${t.groupID != 0}">
                                    <c:if test = "${t.username != sessionScope.login.username}">
                                        <h5>Task from: ${t.username }<h5>
                                            </c:if>
                                            <c:if test = "${t.username == sessionScope.login.username}">
                                                <h5><i class="fa-solid fa-people-group"></i> ${t.groupID} <h5>
                                                    </c:if>             

                                                </c:if>   
                                                <c:if test = "${t.groupID == 0}">
                                                    <i style="color: #785ccd;font-size: 20px;" class="fa-solid fa-user"></i>
                                                </c:if> 
                                                <div style="padding-bottom: 15px"><i style="font-size: 30px;margin-right: 10px ;color:  #ef7575" class="fa-solid fa-book"></i>   ${t.describe}</div>  
                                                <div class="trash">
                                                    <c:if test = "${t.groupID != 0 and !(t.username eq sessionScope.login.username)}">
                                                        <span tabindex="0" data-bs-toggle="tooltip" data-bs-placement="top" title="You can not update">   <a onclick="updateTask('${t.id}')" 
                                                                                                                                                             class="btn btn-primary disabled "

                                                                                                                                                             ><i class="fa-solid fa-pen-nib"></i></a> </span>
                                                            </c:if>  
                                                            <c:if test = "${t.groupID == 0 or  t.username eq sessionScope.login.username}">
                                                        <a onclick="updateTask('${t.id}')" class="btn btn-primary "   data-bs-toggle="tooltip" data-bs-placement="top" title="Update Task" ><i class="fa-solid fa-pen-nib"></i></a>
                                                        </c:if> 


                                                    <c:set var = "check" scope = "session" value = "0"/>
                                                    <c:if test = "${t.groupID != 0 and !(t.username eq sessionScope.login.username)}">
                                                        <c:forEach items="${requestScope.dones}" var="d">
                                                            <c:if test = "${t.id == d}">
                                                                <span tabindex="0" data-bs-toggle="tooltip" data-bs-placement="top" title="Task have been completed"> <a onclick="doneTask(this, '${t.id}', '${t.groupID}', '${t.username}')"    class="btn btn-success done_task disabled" ><i class="fa-solid fa-check"></i></a>
                                                                    <c:set var = "check" scope = "session" value = "1"/> </span>

                                                            </c:if>
                                                        </c:forEach>
                                                        <c:if test = "${sessionScope.check ==0}">
                                                            <a onclick="doneTask(this, '${t.id}', '${t.groupID}', '${t.username}')" data-bs-toggle="tooltip" data-bs-placement="top" title="Complete Task" class="btn btn-success done_task "><i class="fa-solid fa-check"></i></a>
                                                            </c:if>
                                                        </c:if>




                                                    <c:if test = "${t.groupID != 0 and !(t.username eq sessionScope.login.username)}">
                                                        <span tabindex="0" data-bs-toggle="tooltip" data-bs-placement="top" title="You can not delete"> <a class="btn btn-danger disabled">
                                                                <i onclick="deleteTask('${t.id}', '${t.describe}')" class="fa-solid fa-trash "></i> 
                                                            </a> </span>
                                                        </c:if>   
                                                        <c:if test = "${t.groupID == 0 or  t.username eq sessionScope.login.username}">
                                                        <div class="btn btn-danger">
                                                            <i onclick="deleteTask('${t.id}', '${t.describe}')" data-bs-toggle="tooltip" data-bs-placement="top" title="Delete Task" class="fa-solid fa-trash "></i> 
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
                                            <section  class="animate__animated animate__fadeInTopLeft notification">
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
                                                <c:if test="${requestScope.search==null}" >
                                                    <div class="btn_load contain_card "> 
                                                        <button onclick="loadMore()" data-bs-toggle="tooltip" data-bs-placement="top" title="Load More Task" class="btn btn-primary"><i class="fa-solid fa-caret-down"></i></button>
                                                    </div>  
                                                </c:if>
                                            </c:if>
                                            <div class="loader"></div>
                                            </div>
                                            <jsp:include page="footer.jsp" /> 
                                            </main>
                                            <script
                                                src="https://kit.fontawesome.com/3a6c73e27c.js"
                                                crossorigin="anonymous"
                                            ></script>
                                            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
                                            <script
                                                src="./js/main.js"
                                            ></script>

                                            <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>


                                            <!--<script src="https://apps.elfsight.com/p/platform.js" defer></script>-->
                                            <!--backgr-->
                                            <div id="particles-js"></div>
                                            <script src="./js/particles.min.js"></script>
                                            <script>
                                                            particlesJS({
                                                                particles: {
                                                                    number: {
                                                                        value: 185,
                                                                        density: {
                                                                            enable: true,
                                                                            value_area: 800,
                                                                        },
                                                                    },
                                                                    color: {
                                                                        value: "#ffffff",
                                                                    },
                                                                    shape: {
                                                                        type: "circle",
                                                                        stroke: {
                                                                            width: 0,
                                                                            color: "#000000",
                                                                        },
                                                                        polygon: {
                                                                            nb_sides: 5,
                                                                        },
                                                                        image: {
                                                                            src: "img/github.svg",
                                                                            width: 100,
                                                                            height: 100,
                                                                        },
                                                                    },
                                                                    opacity: {
                                                                        value: 0.5,
                                                                        random: false,
                                                                        anim: {
                                                                            enable: false,
                                                                            speed: 1,
                                                                            opacity_min: 0.1,
                                                                            sync: false,
                                                                        },
                                                                    },
                                                                    size: {
                                                                        value: 3,
                                                                        random: true,
                                                                        anim: {
                                                                            enable: false,
                                                                            speed: 20,
                                                                            size_min: 0.1,
                                                                            sync: false,
                                                                        },
                                                                    },
                                                                    line_linked: {
                                                                        enable: true,
                                                                        distance: 150,
                                                                        color: "#ffffff",
                                                                        opacity: 0.4,
                                                                        width: 1,
                                                                    },
                                                                    move: {
                                                                        enable: true,
                                                                        speed: 2.22388442605866,
                                                                        direction: "none",
                                                                        random: false,
                                                                        straight: false,
                                                                        out_mode: "out",
                                                                        bounce: false,
                                                                        attract: {
                                                                            enable: false,
                                                                            rotateX: 600,
                                                                            rotateY: 1200,
                                                                        },
                                                                    },
                                                                },
                                                                interactivity: {
                                                                    detect_on: "canvas",
                                                                    events: {
                                                                        onhover: {
                                                                            enable: false,
                                                                            mode: "repulse",
                                                                        },
                                                                        onclick: {
                                                                            enable: true,
                                                                            mode: "push",
                                                                        },
                                                                        resize: true,
                                                                    },
                                                                    modes: {
                                                                        grab: {
                                                                            distance: 400,
                                                                            line_linked: {
                                                                                opacity: 1,
                                                                            },
                                                                        },
                                                                        bubble: {
                                                                            distance: 400,
                                                                            size: 40,
                                                                            duration: 2,
                                                                            opacity: 8,
                                                                            speed: 1,
                                                                        },
                                                                        repulse: {
                                                                            distance: 200,
                                                                            duration: 0.9,
                                                                        },
                                                                        push: {
                                                                            particles_nb: 4,
                                                                        },
                                                                        remove: {
                                                                            particles_nb: 2,
                                                                        },
                                                                    },
                                                                },
                                                                retina_detect: true,
                                                            });
                                            </script>
                                            </body>
                                            </html>


