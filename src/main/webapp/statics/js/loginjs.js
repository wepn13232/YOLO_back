
$(function () {
    $("#form_submit").bind("click", checkUser);
});


function checkUser() {
    $.ajax({
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        type: "post",
        url: "/dologin",
        data: {
            "username": $('#username').val(), "password": $('#password').val()
        },
        async: true,
        dataType:
            "json",
        success: function (data) {
            if (data.lg === "error") {
                $("#spanError").html("账号密码错误！");
            } else if (data.user === "admin") {
                window.location.href = "/admin/index";
            } else {
                window.location.href = "/user/index";
            }
        }

        ,
        error: function () {

        }
        ,
        complete: function () {

        }

    })
}



