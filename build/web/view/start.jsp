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
    <body >
        <jsp:include page="header.jsp" /> 
        <div style="background: #ffffff">

            <div  padding-bottom: 85vh class="intro">
                <section >

                    <div class="row  ">
                        <div class="col-md-8">
                            <h1 style="color: black">Task Manager giúp các nhóm đẩy nhanh công việc.</h1>
                            <p style="color: black" translate="no">Cộng tác, quản lý dự án và đạt đến đỉnh cao năng suất mới. Từ tòa nhà cao tầng đến văn phòng tại nhà, cách thức làm việc của nhóm bạn là duy nhất—hãy hoàn thành tất cả với Task Manager.</p>
                        </div>
                        <div class="col-md-4">
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
                    <div style="display: flex ;    margin: 5vh 0;">
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
                            Bắt đầu với bảng Trello, danh sách và thẻ. Tùy chỉnh và mở rộng với
                            nhiều tính năng hơn khi hoạt động làm việc nhóm phát triển. Quản lý
                            dự án, sắp xếp tác vụ và tạo tinh thần làm việc nhóm—tất cả ở cùng
                            một nơi.
                        </p>
                    </div>
                    <div>
                        <button class="btn-success"  >
                            <a type="button" href="./login"> Bắt đầu làm việc </a></button></li>

                    </div>
                    <img width="100%"  src="https://images.ctfassets.net/rz1oowkt5gyp/7pYWhpQ3vnntxoShaImNws/24181e476913df1dacc1690518ee54e7/trello_1_vi.png?w=1200&fm=webp" alt="alt"/>
                </div>
            </div>
            
        </div>
 <jsp:include page="footer.jsp" /> 
        <script
            src="https://kit.fontawesome.com/3a6c73e27c.js"
            crossorigin="anonymous"
        ></script>
        
        
    </body>
</html>


