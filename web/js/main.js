

function deleteTask(id) {

    if (confirm("sure ?")) {
        window.location = "./deletetask?id=" + id;
    }

}
let y = 1;
function open_nav() {
    if (y === 1) {
        document.querySelector(".nav_l").style.top = "76px";
        y = 0;
    } else {
        document.querySelector(".nav_l").style.top = "-276px";
        y=1;
    }

}
function  do_assigntask(groupID) {

    window.location = "./assigntask?groupID=" + groupID;
}
let x = document.getElementById("username_text").offsetWidth + 150;
document.querySelector(".nav_r").style.width = `${x}px`;
//loadmore by ajax

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