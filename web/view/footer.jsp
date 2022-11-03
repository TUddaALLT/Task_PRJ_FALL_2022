<%-- 
    Document   : footer
    Created on : Oct 18, 2022, 9:37:56 PM
    Author     : 84352
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head> 
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title> </title>

        <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
            />
        <style media="screen">

            footer {
                /*        position: absolute;
                        bottom: 0;
                        left: 0;
                        right: 0;*/
                background: rgb(113 188 193);
                height: auto;
                width: 100vw;
                padding-top: 40px;
                color: #fff;
            }
            .footer-content {
                display: flex;
                align-items: center;
                justify-content: center;
                flex-direction: column;
                text-align: center;
            }
            .footer-content h3 {
                font-size: 2.1rem;
                font-weight: 500;
                text-transform: capitalize;
                line-height: 3rem;
            }
            .footer-content p {
                max-width: 500px;
                margin: 10px auto;
                line-height: 28px;
                font-size: 14px;
                color: #cacdd2;
            }
            .socials {
                list-style: none;
                display: flex;
                align-items: center;
                justify-content: center;
                margin: 1rem 0 3rem 0;
            }
            .socials li {
                margin: 0 10px;
            }
            .socials a {
                text-decoration: none;
                color: #fff;
                border: 1.1px solid white;
                padding: 15px;
                border-radius: 50%;
            }
            .socials a i {
                font-size: 1.1rem;
                width: 20px;

                transition: color 0.4s ease;
            }
            .socials a:hover i {
                color: aqua;
            }

            .footer-bottom {
                display: flex;
                justify-content: space-around;
                background: rgb(29, 66, 67);
                width: 100vw;
                padding:  20px 20px 0 20px; 
                text-align: center;
            }
            .footer-bottom p {
                float: left;
                font-size: 14px;
                word-spacing: 2px;
                text-transform: capitalize;
            }
            .footer-bottom p a {
                color: #44bae8;
                font-size: 16px;
                text-decoration: none;
            }
            .footer-bottom span {
                text-transform: uppercase;
                opacity: 0.4;
                font-weight: 200;
            }
            .footer-menu {
                float: right;
            }
            .footer-menu ul {
                display: flex;
            }
            .footer-menu ul li {
                padding-right: 10px;
                display: block;
            }
            .footer-menu ul li a {
                color: #cfd2d6;
                text-decoration: none;
            }
            .footer-menu ul li a:hover {
                color: #27bcda;
            }

            @media (max-width: 500px) {
                .footer-menu ul {
                    display: flex;
                    margin-top: 10px;
                    margin-bottom: 20px;
                }
            }
        </style>
    </head>
    <body>
        <footer>
            <div class="footer-content">
                <h3>Task Manager</h3>
                <p style="color: white">
                    Đăng ký và bắt đầu với Task ngay hôm nay. Một thế giới làm việc nhóm
                    hiệu quả đang chờ đợi bạn!
                </p>
                <ul class="socials">
                    <li >
                        <a style="background: #385899"  href="https://www.facebook.com/tudda.allt"><i  class="fa fa-facebook"></i></a>
                    </li>
                    <li>
                        <a style="background: #1ea1f3"  href="#"><i class="fa fa-twitter"></i></a>
                    </li>
                    <li>
                        <a style="background: red" href="#"><i class="fa fa-google-plus"></i></a>
                    </li> 
                </ul>
            </div>
            <div class="footer-bottom">
                <div>Copyright &copy;2022 <a href="#">tuddahe161500@fpt.edu.vn</a></div>
                <div class="footer-menu">
                    <ul class="f-menu">
                        <li><a href="">Home</a></li>
                        <li><a href="">About</a></li>
                        <li><a href="">Contact</a></li>
                        <li><a href="">Blog</a></li>
                    </ul>
                </div>
            </div>
        </footer>
    </body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</html>

