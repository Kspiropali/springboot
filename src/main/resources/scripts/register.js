function checkAlldetails() {
    let name = document.getElementById("name").value;
    let surname = document.getElementById("surname").value;
    let email = document.getElementById("email").value;
    let dob = document.getElementById("dob").value;
    let password = document.getElementById("password").value;
    let passwordConfirm = document.getElementById("confirm_password").value;

    const dob_regex = new RegExp('^[0-9]{4}\-[0-9]{2}\-[0-9]{2}$');
    /*const pass_regex = new RegExp('((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[\\W]).{6,20})');*/
    const email_regex = new RegExp('^[a-z]{1,}\@[a-z]{1,}\\.[a-z]{1,}$');

    if(name === "" || surname === "" || email === ""){
        alert("Please fill all the field!");
        return;
    }

    if (!email_regex.test(email)) {
        alert("Email not in correct format");
        return;
    }

    if (!dob_regex.test(dob)) {
        alert("Dob not in correct format");
        return;
    }



    /*if(!pass_regex.test(password)){
        alert("Password must have meet pattern requirements:(1 char, 1 number, 1 symbol, min length: 8");
        return;
    }*/

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
            crossDomain: true,
            data: JSON.stringify(user),
            dataType: 'application/json',
            type: 'POST',
            contentType: 'application/json',
        });
    });

    window.location.href = "home_page.html";

}