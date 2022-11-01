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

        <link rel="stylesheet" href="./css/main.css" />

    </head>
    <body >
        <jsp:include page="header.jsp" /> 
        <div style="background: #ffffff">
            <div  padding-bottom: 84vh class="intro">
                <section >

                    <div class="row  ">
                        <div class="col-md-8">
                            <h1  class="info animate__animated animate__bounce" style="color: black">Task Manager giúp các nhóm đẩy nhanh công việc.</h1>
                            <p class="animate__animated animate__backInLeft" style="color: black" translate="no">Cộng tác, quản lý dự án và đạt đến đỉnh cao năng suất mới. Từ tòa nhà cao tầng đến văn phòng tại nhà, cách thức làm việc của nhóm bạn là duy nhất—hãy hoàn thành tất cả với Task Manager.</p>
                        </div>
                        <div class="col-md-4 animate__animated animate__backInRight">
                            <img  src="//images.ctfassets.net/rz1oowkt5gyp/5QIzYxue6b7raOnVFtMyQs/113acb8633ee8f0c9cb305d3a228823c/hero.png?w=576" alt="" width="465.5" height="602.5" loading="lazy" class="intro_img">
                        </div>
                    </div>
                </section>
            </div>
            <div class="intro_main">
                <div>
                    <div>
                        <hr />
                    </div>
                    <div class="items">
                        <div>
                            <img
                                src="//images.ctfassets.net/rz1oowkt5gyp/2ozLp25HsHeANpiNqAwzGI/d60a017d2f214c28f774b35d03499782/tag.svg"
                                alt=""
                                loading="lazy"
                                class="Picture__Image-sc-1wdxyb4-0 eYmxm"
                                />
                        </div>
                        <div>
                            <div class="intro_main_text">

                                <h3>Xem giá Task Manager</h3>
                                <p translate="no">
                                    Dù nhóm của bạn có 2 người hay 2.000 người, chúng tôi đều có
                                    thể tùy chỉnh Task Manager cho tổ chức của bạn. Khám phá tùy chọn
                                    phù hợp nhất với bạn.
                                </p>
                            </div>
                        </div>
                        <div>
                            <img
                                src="//images.ctfassets.net/rz1oowkt5gyp/6rRWTcHzPKupQ3ZDqBaxu6/aecd045f4b31a92288a85bdb4a9dfe2c/compass.svg"
                                alt=""
                                loading="lazy"
                                />
                        </div>
                        <div>
                            <div class="intro_main_text">
                                <h3>Task Manager là gì?</h3>
                                <p translate="no">
                                    Task Manager là công cụ trực quan hỗ trợ nhóm bạn quản lý mọi loại
                                    dự án, quy trình làm việc hoặc hoạt động theo dõi tác vụ.
                                </p>
                            </div>
                        </div>
                        <div>
                            <img
                                src="//images.ctfassets.net/rz1oowkt5gyp/5AE4nXLOennRxmmUMcgMLM/747e96bdd16cf4113e4ef867bd85fd29/solutions.svg"
                                alt=""
                                loading="lazy"
                                />
                        </div>
                        <div>
                            <div class="intro_main_text">
                                <h3>Khám phá Task Manager Enterprise</h3>
                                <p translate="no">
                                    Công cụ năng suất mà các nhóm yêu thích, được kết hợp với các
                                    tính năng và sự an toàn cần thiết để mở rộng quy mô.
                                </p>
                            </div>
                        </div>
                    </div>
                    <div>
                        <hr />
                    </div>
                </div>

                <div class="intro_main_body" style="color: black">
                    <div>
                        <h2>
                            Không chỉ là công việc. Đó là cách chúng ta làm việc cùng nhau.
                        </h2>
                        <p translate="no">
                            Bắt đầu với bảng Task, danh sách và thẻ. Tùy chỉnh và mở rộng với
                            nhiều tính năng hơn khi hoạt động làm việc nhóm phát triển. Quản lý
                            dự án, sắp xếp tác vụ và tạo tinh thần làm việc nhóm—tất cả ở cùng
                            một nơi.
                        </p>
                    </div>
                    <div>
                        <button class="btn-success"  >
                            <a type="button" href="./login"> Bắt đầu làm việc </a></button></li>

                    </div>
                    <img class="img_intro" width="1200px"  src="https://scontent.fhan2-5.fna.fbcdn.net/v/t1.15752-9/310264300_510135490977621_4765943951569315219_n.png?_nc_cat=107&ccb=1-7&_nc_sid=ae9488&_nc_ohc=QZCE9x1zWnEAX-oba5d&tn=o8Qcd8VVTHs3O0Jt&_nc_ht=scontent.fhan2-5.fna&oh=03_AdTyNKnR7fQKXLhFkWwI8KQmPKr9Q6GKJcTRvjVYjgPadA&oe=63843ECB" alt="alt"/>
                </div>

                <div class="row" style="text-align: center ">
                    <h2 style="margin-bottom: 5vh">How To Use Task Manager? </h2>
                    <div class="col-md-12" style="text-align: left ; padding: 0 10vw ;    font-size: 22px;">
                        <ul>
                            <li style="margin: 5vh 0">Register by gmail,Login and Login with google account, forgot password with gmail</li>
                            <li style="margin: 5vh 0">Account basic can create, update, delete, search, sort task, join in, out, watch member group task, received
                                notification when task is assigned from UPGRADED Account</li>
                            <li style="margin: 5vh 0"> UPGRADED Account can do the same thing as Account basic 
                                and more it can create, delete group, assign task for group, kick member,
                                watch member have done task and have not done task</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp" /> 
        <script
            src="https://kit.fontawesome.com/3a6c73e27c.js"
            crossorigin="anonymous"
        ></script>
        <script
            src="./js/main.js"
        ></script>

    </body>
</html>


