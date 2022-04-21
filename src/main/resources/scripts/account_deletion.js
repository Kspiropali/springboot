$(document).ready(function () {

})

function button_clicked(){
    window.location.href = "home_page.html"
}

function delete_account() {

    $.ajax({
        url: "http://localhost:8080/delete/"+$.cookie.get("loggedOn"),
        type: 'POST',
        crossOrigin: true,
        crossDomain: true,
        contentType: 'application/json',
        success: () => {
            alert("account deleted: redirecting");
        },
    });
}