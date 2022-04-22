$(document).ready(function () {

})

function button_clicked() {
    window.location.href = "home_page.html"
}

function delete_account() {

    $.ajax({
        url: "http://localhost:8080/users/delete/" + $.cookie.get("loggedOn"),
        type: 'DELETE',
        crossOrigin: true,
        crossDomain: true,
        contentType: 'application/json',
        complete: data => handleCode(data.responseText)
        });
}

function handleCode(code){
    if(code === "200"){
        $.cookie("loggedOn", null);
        $.cookie("loggedName", null);
        window.location.href = "home_page.html";
    }else if(code === "500"){
        $.cookie("loggedOn", null);
        $.cookie("loggedName", null);
        window.location.href = "404_page.html";
    }else{
        alert(code);
    }

}