function validate_details() {
    const regex = new RegExp('^[a-z]{1,10}\@[a-z]{1,10}\.[a-z]{1,6}$');
    let email_send = document.getElementById("email").value;
    let password_send = document.getElementById("password").value;

    if (!regex.test(email_send)) {
        alert("Email not in correct format");
        window.location.href = window.location.pathname;
        return;
    }
    let frm = $('#login_form');
    frm.submit(function (ev) {
        ev.preventDefault();
        /*ev.stopImmediatePropagation();*/
        $.ajax({
            url: "http://localhost:8080/users/validate?email=" + email_send + "&password=" + password_send,
            dataType: 'application/json',
            crossDomain: true,
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
                    fetch('http://localhost:8080/users/' + r.responseText, {mode: "cors"})
                        .then((response) => response.json())
                        .then((responseJSON) => {
                            if(responseJSON.error === "Internal Server Error"){
                                alert("Wrong password; Try again");
                                window.location.href = window.location.pathname;
                            }
                            alert("Successfully Logged in with User: " + responseJSON.name);
                            $.cookie("loggedOn", responseJSON.id, { expires: 1, httpOnly: true, secure: true, sameSite: "Lax" });
                            $.cookie("loggedName", responseJSON.name, { expires: 1, httpOnly: true, secure: true, sameSite: "Lax" });

                            window.location.href = "home_page.html";
                        });
                }
            }
        });
    });
}