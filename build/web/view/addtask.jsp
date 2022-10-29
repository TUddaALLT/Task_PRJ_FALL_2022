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
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
            />
        <link
            <link rel="stylesheet" href="./css/main.css" />
        <link rel="stylesheet" href="./js/main.js" />
        <style>
            * {
                margin: 0;
            }
            #particles-js {
/*                background: url("https://marcbruederlin.github.io/particles.js/img/background.jpg")
                    bottom no-repeat transparent;*/
                background-size: cover;
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
    <body>
        <main id="principal">
            <jsp:include page="header.jsp" /> 
            <div style="color:white " class="contain_add">

                <div class="label_add_task">
                    ADD TASK
                </div>

                <div class="label_add_task">
                    <h2 style="color: red">${requestScope.mess}</h2>
                </div>

                <form action="./add" method="post" enctype="multipart/form-data">

                    <input type="hidden"  name="groupID" value="${requestScope.groupID}">

                    <div class="mb-3">
                        <label for="exampleFormControlTextarea1" class="form-label">Status</label>
                        <select name="status"  class="form-select" aria-label="Default select example"> 
                            <option value="1">On-going</option>
                            <option value="2">End</option>
                            <option value="3">Start</option>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="formFile" class="form-label">Image</label>
                        <input onchange="loadFile(event)" name="img" required="" class="form-control" type="file"  accept="image/png, image/gif, image/jpeg" aria-label="default input example">
                        <img style="width:40vw; margin-top:10px;border-radius: 10px" id="output"/>

                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">Describe</label>        
                        <textarea name="describe"  rows="8"  required="" class="form-control" type="text" placeholder="Enter Describe" aria-label="default input example"></textarea>
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">Time Expired    </label>  
                        <input name="alarmTime" type="datetime-local">
                    </div> 
                    <input class="btn btn-success" type="submit" value="Save">

                </form>
            </div>
            <jsp:include page="footer.jsp" /> 
        </main>
        <script
            src="https://kit.fontawesome.com/3a6c73e27c.js"
            crossorigin="anonymous"
        ></script>
        <div id="particles-js"></div>
        <script src="./js/particles.min.js"></script>
        <script>
                            particlesJS({
                                particles: {
                                    number: {
                                        value: 85,
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


