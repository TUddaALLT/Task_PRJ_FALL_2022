
function deleteTask(id) {
    if (confirm("sure ?")) {
        window.location = "./deletetask?id=" + id;
    }

}
window.onload = function ()
{
    setTimeout(notification, 3000);
};
function updateTask(id) {

    window.location = "./updatetask?id=" + id;

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
let x = document.getElementById("username_text").offsetWidth + 150;
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
            noti_value.innerHTML += data;
            let result = data.localeCompare("error\r\n"); // 0 neu loi 
            if (result !== 0) {
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
        setTimeout(() => alert("Task is expired " + timeout), timeout);
    }
}

