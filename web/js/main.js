
function search(describe, status) {
    console.log(describe);
    var row = document.querySelector("#ajax");
    row.innerHTML = "";
    document.querySelector(".btn_load").style.display = "none";
    document.querySelector(".loader").style.display = "block";
    const myTimeout = setTimeout(() => {
        let amount = document.getElementsByClassName("content_task").length;
        $.ajax({
            url: "/Tasks/searchtask",
            type: "get",
            data: {
                describe: describe,
                status: status
            },
            success: function (data) {
//                var row = document.querySelector("#ajax");
                row.innerHTML = "";
                row.innerHTML += data;
            },
            error: function (xhr) {
                //Do Something to handle error
            }
        });
        document.querySelector(".btn_load").style.display = "flex";
        document.querySelector(".loader").style.display = "none";
    }, 1000);

}
let index = 1;
let checksort = 0;
function sort() {
    if (checksort === 0) {
        loadMoreSort();
        checksort = 1;
    } else {
        window.location = "./home";
        checksort = 0;
    }

}
function loadMoreSort() {
    var row = document.querySelector("#ajax");
    if (index === 1) {
        row.innerHTML = "";
    }
    document.querySelector(".btn_load").style.display = "none";
    document.querySelector(".loader").style.display = "block";
    const myTimeout = setTimeout(() => {

        $.ajax({
            url: "/Tasks/sorttask",
            type: "post",
            data: {
                ex: index
            },
            success: function (data) {
//                var row = document.querySelector("#ajax");

                row.innerHTML += data;
            },
            error: function (xhr) {
                //Do Something to handle error
            }
        });
        index += 4;
        document.querySelector(".btn_load").style.display = "flex";
        document.querySelector(".loader").style.display = "none";
    }, 1000);

}
function deleteTask(id) {
    swal({
        title: "Are you sure?",
        text: "Once deleted, you will not be able to recover this imaginary file!",
        icon: "warning",
        buttons: true,
        dangerMode: true
    })
            .then((willDelete) => {
                if (willDelete) {

                    window.location = "./deletetask?id=" + id;
                } else {
                    swal("Your imaginary file is safe!");
                }
            });
}
function doneTask(e, id, groupID, usernameMake) {
    swal({
        title: "Have you done this task?",
        icon: "warning",
        buttons: true,
        dangerMode: true
    })
            .then((willDelete) => {

                if (willDelete) {
                    $.ajax({
                        url: "/Tasks/tasksuccess",
                        type: "get",
                        data: {
                            id: id,
                            groupID: groupID,
                            usernameMake: usernameMake
                        },
                        success: function (data) {
//                var row = document.querySelector("#ajax");
//                row.innerHTML += data;

                        },
                        error: function (xhr) {
                            //Do Something to handle error
                        }
                    });
                    e.classList.add("disabled");


                } else {
                    swal("You have not done this task");
                }

            });
}
function kick(id, username) {
    swal({
        title: "Are you sure to kick this member?",
        icon: "warning",
        buttons: true,
        dangerMode: true
    })
            .then((willDelete) => {
                if (willDelete) {

                    window.location = "./kickmember?id=" + id + "&username=" + username;
                } else {
                    swal("You do not kick this member");
                }
            });
}
function outGroup(id) {
    swal({
        title: "Are you sure?",
        icon: "warning",
        buttons: true,
        dangerMode: true
    })
            .then((willDelete) => {
                if (willDelete) {

                    window.location = "./outgroup?id=" + id;
                } else {
                    swal("You are in this group");
                }
            });
}
setInterval(notification, 1000);
setInterval(expiredTask, 1000);
function expiredTask() {
    $.ajax({
        url: "/Tasks/taskexpired",
        type: "get",
        data: {
//            ex: ;
        },
        success: function (data) {
            let x = data.split("+^");
            let time = x[0].trim();
            let des = x[1].trim();
            setAlarm(time, des);
        },
        error: function (xhr) {
            //Do Something to handle error
        }
    });
}
function updateTask(id) {

    swal({
        title: "Are you sure update this task?",
        icon: "success",
        buttons: true,
        dangerMode: true
    })
            .then((willDelete) => {
                if (willDelete) {

                    window.location = "./updatetask?id=" + id;
                } else {
                    swal("Your task is not updated");
                }
            });
}
let y = 1;
function open_nav() {
    if (y === 1) {
        document.querySelector(".nav_l").style.top = "76px";
        y = 0;
    } else {
        document.querySelector(".nav_l").style.top = "-276px";
        y = 1;
        s
    }

}
function  delete_group(id) {
    swal({
        title: "Are you sure?",
        text: "Once deleted, you will not be able to recover this group !",
        icon: "warning",
        buttons: true,
        dangerMode: true
    })
            .then((willDelete) => {
                if (willDelete) {
                    window.location = "./deletegroup?id=" + id;
                } else {
                    swal("Your imaginary file is safe!");
                }
            });
}
let x = document.getElementById("username_text").offsetWidth + 180;
document.querySelector(".nav_r").style.width = `${x}px`;
function notification() {
//    let amount = document.getElementsByClassName("card").length;
    $.ajax({
        url: "/Tasks/notification",
        type: "get",
        data: {
//            ex: ;
        },
        success: function (data) {
            var noti_value = document.querySelector(".noti_value");

            let result = data.localeCompare("error\r\n"); // 0 neu loi 
            if (result !== 0) {
                noti_value.innerHTML += data;
                var notification = document.querySelector(".notification");
                notification.style.display = "block";
                const myTimeout = setTimeout(function () {
                    notification.style.display = "none";
                }, 5000);
            }
        },
        error: function (xhr) {
            //Do Something to handle error
        }
    });
}
let n = 1;
function getNotification() {
    if (n === 1) {
        document.querySelector(".open_noti").style.display = "block";
        n = 0;
    } else {
        document.querySelector(".open_noti").style.display = "none";
        n = 1;
    }
    $.ajax({
        url: "/Tasks/notification",
        type: "post",
        data: {
//            ex: ;
        },
        success: function (data) {
            document.querySelector(".noti_list").innerHTML = data;
        },
        error: function (xhr) {
            //Do Something to handle error
        }
    });

}
function loadMore() {
    if (index === 1) {
        document.querySelector(".btn_load").style.display = "none";
        document.querySelector(".loader").style.display = "block";
        const myTimeout = setTimeout(() => {
            let amount = document.getElementsByClassName("content_task").length;
            $.ajax({
                url: "/Tasks/home",
                type: "post",
                data: {
                    ex: amount
                },
                success: function (data) {
                    var row = document.querySelector("#ajax");
                    row.innerHTML += data;
                },
                error: function (xhr) {
                    //Do Something to handle error
                }
            });
            document.querySelector(".btn_load").style.display = "flex";
            document.querySelector(".loader").style.display = "none";
        }, 1000);
    } else {
        loadMoreSort();
    }
}
function setAlarm(time, des) {
    console.log(typeof (time));
    time = time.split(" ");
    des = des.split("*");
    console.log(typeof (time));
    let time_ex = [];
    let des_ex = [];
    console.log(time);
    for (let i = 0; i < time.length; i++) {
        let current = new Date();
        let timeAlarm = new Date(time[i]);
        if (timeAlarm > current) {
            let timeout = timeAlarm.getTime() - current.getTime();
            time_ex.push(timeout);
            des_ex.push(des[i]);
        }
    }

//    time_ex.sort();
    console.log(time_ex);
    for (let i = 0; i < time_ex.length; i++) {
        let re = des_ex[i]
        setTimeout(() => swal({
                title: "Task is expired " + extractContent(des_ex[i]),
                text: "You clicked the button!",
                icon: "error",
                button: "Ok "
            }), time_ex[i]);
    }
}
function extractContent(s) {
    var span = document.createElement('span');
    span.innerHTML = s;
    return span.textContent || span.innerText;
}
;
//preview img
var loadFile = function (event) {
    var output = document.getElementById('output');
    output.src = URL.createObjectURL(event.target.files[0]);
    output.onload = function () {
        URL.revokeObjectURL(output.src) // free memory
    }
};
let css = 0;
function css_z_index() {
    let w = window.innerWidth;
    if (w < 650 && css === 0) {
        document.querySelector('.search_status_mobile').style.display = 'none';
        document.querySelector('.search').style.display = 'none';
        css = 1;
    } else if (w > 650 && css === 1) {
        document.querySelector('.search_status_mobile').style.display = 'block';
        document.querySelector('.search').style.display = 'initial';
        css = 0;
    }
}
function checkGmailSMTP() {
    const form = document.querySelector(".checkGmailIsValid");
    form.addEventListener("submit", function (e) {
        e.preventDefault();
        e.stopPropagation();
        const email = document.querySelector(".GmailIsValid").value;
        var myHeaders = new Headers();
        myHeaders.append("apikey", "E736cUf36mgKoPFIUJbcbkBtYk4kHapk");
        var requestOptions = {
            method: 'GET',
            redirect: 'follow',
            headers: myHeaders
        };
        fetch("https://api.apilayer.com/email_verification/check?email=" + email, requestOptions)
                .then(response => response.text())
                .then(result => {
                    const email = JSON.parse(result);
                    if (email.smtp_check) {
                        form.submit();
                        document.querySelector(".isNotValid").innerHTML = "OTP is sent"
                    } else {
                        document.querySelector(".isNotValid").innerHTML = "Email is not existed to send OTP"
                    }
                })
                .catch(error => console.log('error', error));
    })


}
