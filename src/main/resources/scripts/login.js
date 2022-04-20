function validate_details() {
    const regex = new RegExp('^[a-z]{3,10}\@[a-z]{3,10}\.[a-z]{3,6}$');
    let email_send = document.getElementById("email").value;
    let password_send = document.getElementById("password").value;

    if (!regex.test(email_send)) {
        alert("Email not in correct format");
        window.location.href = window.location.pathname;
        return;
    }
    var frm = $('#login_form');
    frm.submit(function (ev) {
        ev.preventDefault();
        /*ev.stopImmediatePropagation();*/
        $.ajax({
            url: "http://localhost:8080/users/validate?email=" + email_send + "&password=" + password_send,
            dataType: 'application/json',
            type: 'POST',/*
            responseType: 'application/json',
            contentType: 'application/json',*/
            headers: {Connection: close},
            complete: function (r) {
                if (r.responseText[0] === "{") {
                    if (JSON.parse(r.responseText).status === 500) {
                        alert("This user does not exist");
                        window.location.href = window.location.pathname;
                    } else {
                        alert("Unknown Error happened; Try again later!");
                        window.location.href = window.location.pathname;
                    }
                } else {
                    alert("Successfully Logged in with User: " + r.responseText);
                    window.location.href = "http://localhost:63342/main/home_page.html";
                }
            }
        });
    })
    ;
}