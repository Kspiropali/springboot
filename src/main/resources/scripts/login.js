function validate_details(){
    const regex = new RegExp('^[a-z]{3,10}\@[a-z]{3,10}\.[a-z]{3,6}$');
    let email_send = document.getElementById("email").value;
    let password_send = document.getElementById("password").value;

    if (!regex.test(email_send)) {
        alert("Email not in correct format");
        return;
    }

    $.ajax({
        url: "http://localhost:8080/users/validate/",
        data: "email=kris@kris.com&password=kristian",
        type: "POST",
        contentType: "application/x-www-form-urlencoded",
        success: response => console.log(response),
        error: e => console.log(e)
    });




    /*<script>

        $(document).ready(function() {
        let email = document.getElementById("email").value;
        let password = document.getElementById("password").value
        $('#submit').click(function() {

        $.ajax({
        url: "http://localhost:8080/users/validate/",
        data: "email="+email+"&password="+password,
        type: "POST",
        contentType: "application/x-www-form-urlencoded",
        success: response => console.log(response),
        error: e => console.log(e)
    });
    });

    });
    </script>*/
}