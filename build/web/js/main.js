
function deleteTask(id, describe) {
    swal({
        title: "Are you sure?",
        text: "Once deleted, you will not be able to recover this imaginary file!",
        icon: "warning",
        buttons: true,
        dangerMode: true
    })
            .then((willDelete) => {
                if (willDelete) {

                    window.location = "./deletetask?id=" + id + "&describe=" + describe;
                } else {
                    swal("Your imaginary file is safe!");
                }
            });


}

setInterval(notification, 1000);
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
    }

}
function  do_assigntask(groupID) {

    window.location = "./assigntask?groupID=" + groupID;
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
            document.querySelector(".noti_list").innerHTML =  data;
        },
        error: function (xhr) {
            //Do Something to handle error
        }
    });

}
function loadMore() {
    let amount = document.getElementsByClassName("card").length;
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
}


function setAlarm(time) {
    console.log(typeof (time));
    time = time.split(" ");
    console.log(typeof (time));
    let time_ex = [];
    console.log(time);

    for (let i = 0; i < time.length; i++) {
        let current = new Date();
        let timeAlarm = new Date(time[i]);
        if (timeAlarm > current) {
            let timeout = timeAlarm.getTime() - current.getTime();
            time_ex.push(timeout);
        }
    }

    time_ex.sort();
    console.log(time_ex);
    for (const timeout of time_ex) {
        setTimeout(() => swal({
                title: "Task is expired " + time,
                text: "You clicked the button!",
                icon: "error",
                button: "Ok "
            }), timeout);
    }
}
//preview img
var loadFile = function (event) {
    var output = document.getElementById('output');
    output.src = URL.createObjectURL(event.target.files[0]);
    output.onload = function () {
        URL.revokeObjectURL(output.src) // free memory
    }
};
