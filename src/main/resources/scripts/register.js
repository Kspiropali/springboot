function onSubmi() {
    // Selecting the input element and get its value
    let user = document.getElementById("password").value;
    // Displaying the value
    prompt("test");
}

function checkAlldetails(){
    let name = document.getElementById("name").value;
    let email = document.getElementById("email").value;
    let dob= document.getElementById("dob").value;
    let password = document.getElementById("password").value;
    let passwordConfirm = document.getElementById("confirm_password").value;

    const regex = new RegExp('^[0-9]{4}\-[0-9]{2}\-[0-9]{2}$');

    if(!regex.test(dob)){
        alert("Dob not in correct format");
        return;
    }

    if(password !== passwordConfirm){
        alert("Passwords do not match");
        return;
    }

    let user = {
        "name": "Bilal",
        "password": "1234",
        "email": "bilal@asd.com",
        "dob" : "2000-01-07"
    }

    $.ajax({
        url: "http://localhost:8080/users/register",
        data: JSON.stringify(user),
        dataType: 'json',
        type: 'POST',
        contentType: 'application/json',
        success: response => console.log(response),
        error: e => console.log(e)
    });
}