$(document).ready(function () {
    setup();
})

let user;

function setup() {


    fetch('http://localhost:8080/users/'+$.cookie.get("loggedOn"))
        .then((response) => response.json())
        .then((responseJSON) => {
            user = responseJSON;

            document.getElementById('firstname_complete').innerHTML = '<label for="firstname_in">First Name</label>\n' +
                '                    <input type="text" id="firstname_in" class="form-control" placeholder="' + user.name + '"/>';

            document.getElementById('lastname_complete').innerHTML = '<label for="lastname_in">Last Name</label>\n' +
                '                    <input type="text" id="lastname_in" class="form-control" placeholder="' + user.surname + ' "/>';

            document.getElementById('email_complete').innerHTML = '<label for="email_in">Email</label>\n' +
                '                <input type="email" class="form-control" id="email_in" placeholder="' + user.email + '"/>';

            document.getElementById('dob_complete').innerHTML = ' <label for="dob_in">Date of Birth</label>\n' +
                '                <input type="text" class="form-control" id="dob_in" placeholder="' + user.dob + '"/>';

            document.getElementById('myTab').innerHTML = '<li class="nav-item">\n' +
                '                        <a class="nav-link active" data-toggle="tab" role="tab"\n' +
                '                           aria-controls="home" aria-selected="false">Profile</a>\n' +
                '                    </li>\n' +
                '                    <a class="nav-link active" data-toggle="tab" href="home_page.html" role="tab"\n' +
                '                       aria-controls="home" aria-selected="false">Home</a>' +
                '                    <a class="nav-link active" data-toggle="tab" href="account_deletion.html" role="tab"\n' +
                '                       aria-controls="home" aria-selected="false">!!DELETE ACCOUNT!!</a>';
        });

}

function validate() {
    const dob_regex = new RegExp('^[0-9]{4}\-[0-9]{2}\-[0-9]{2}$');
    const email_regex = new RegExp('^[a-z]{1,}\@[a-z]{1,}\.[a-z]{1,}$');

    let name = document.getElementById("firstname_in").value;
    let surname = document.getElementById("lastname_in").value;
    let email = document.getElementById("email_in").value;
    let dob = document.getElementById("dob_in").value;
    let password = document.getElementById("old_pass_in").value;
    let new_password = document.getElementById("new_pass_in").value;
    let new_password_Confirm = document.getElementById("new_pass_con_in").value;

    if (name === "" && surname === "" && email === "" && dob === "" && password === "" && new_password === "" && new_password_Confirm === "") {
        alert("All fields are empty; Nothing to Submit!");
        return;
    }

    if (dob !== "") {
        if (!dob_regex.test(dob)) {
            alert("Date of Birth Pattern failed!");
            return;
        }
    } else {
        dob = user.dob;
    }

    if (password !== "") {
        if (password !== user.password) {
            alert("Old password is incorrect!")
            return;
        } else if(new_password !== new_password_Confirm){
            alert("New Password and Confirm do not match!");
            return;
        }
    } else {
        new_password_Confirm = user.password;
    }

    if (email !== "") {
        if (!email_regex.test(email)) {
            alert("Email Pattern failed!");
            return;
        }else if (email === user.email) {
            alert("You can not use the same email");
            return;
        }
    } else {
        email = user.email;
    }

    if (surname === "") {
        surname = user.surname;
    }

    if (name === "") {
        name = user.name;
    }

    console.log("SENDING: " + name + "  " + surname + " " + email + " " + new_password_Confirm + " " + dob);
    let frm = $('#submit_form');
    frm.submit(function (ev) {
            ev.stopImmediatePropagation();
            ev.preventDefault();

            $.ajax({
                url: 'http://localhost:8080/users/update/' + user.id + '?name=' + name + '&surname=' + surname + '&email=' + email + '&password=' + new_password_Confirm + '&dob=' + dob,
                crossDomain: true,
                dataType: 'application/json',
                type: 'PUT',
                contentType: 'application/json',
            });
            window.location.reload();
    });


}