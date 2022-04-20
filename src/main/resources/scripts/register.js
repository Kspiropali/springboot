function checkAlldetails() {
    let name = document.getElementById("name").value;
    let surname = document.getElementById("surname").value;
    let email = document.getElementById("email").value;
    let dob = document.getElementById("dob").value;
    let password = document.getElementById("password").value;
    let passwordConfirm = document.getElementById("confirm_password").value;

    const regex = new RegExp('^[0-9]{4}\-[0-9]{2}\-[0-9]{2}$');

    if (!regex.test(dob)) {
        alert("Dob not in correct format");
        return;
    }

    if (password !== passwordConfirm) {
        alert("Passwords do not match");
        return;
    }

    const user = {
        "name": encodeURIComponent(name),
        "surname": encodeURIComponent(surname),
        "password": encodeURIComponent(password),
        "email": encodeURIComponent(email),
        "dob": encodeURIComponent(dob)
    };

    var frm = $('#register_form');
    frm.submit(function (ev) {
        ev.preventDefault();
        $.ajax({
            url: "http://localhost:8080/users/register/",
            data: JSON.stringify(user),
            dataType: 'application/json',
            type: 'POST',
            contentType: 'application/json',
        });
    });

    window.location.href = "http://localhost:63342/main/home_page.html";

}

