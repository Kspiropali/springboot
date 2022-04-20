$(window).load(function () {
    $('#slider').nivoSlider({
        effect: 'random',
        slices: 15,
        boxCols: 8,
        boxRows: 8,
        animSpeed: 500,
        pauseTime: 4000,
        directionNav: false,
        directionNavHide: false,
        controlNav: false,
        captionOpacity: 1
    });
});

let products = [];

function get_products() {
    //Request products from server
    fetch('http://localhost:8080/products')
        .then((response) => response.json())
        .then((responseJSON) => {
            products = responseJSON;
            display_products();

            search_products();
        });
}

function display_products() {
    /*console.log(products);*/

    let half = Math.ceil(products.length / 2);
    let products_left = products.slice(0, half);
    let products_right = products.slice(-half);

    const products_left_content = products_left.map(product => {
        return (
            '<li>\n' +
            '                            <div class="img"><a href="#"><img alt="" src="' +"/images/small/"+ product.image + '"></a></div>\n' +
            '                            <div class="info">\n' +
            '                                <a class="title" href="#">' + product.name + '</a>\n' +
            '                                <p>' + product.description + '</p>\n' +
            '                                <div class="price">\n' +
            '                                    <span class="st">Our price:</span><strong>$' + product.price + '</strong>\n' +
            '                                </div>\n' +
            '                                <div class="actions">\n' +
            '                                    <a href="product_details.html?id='+product.id+'">Details</a>\n' +
            '                                    <a href="#">Add to cart</a>\n' +
            '                                </div>\n' +
            '                            </div>\n' +
            '                        </li>'
        );
    });

    const products_right_content = products_right.map(product => {
        return ('<li>\n' +
            '                            <div class="img"><a href="#"><img alt="" src="' + "/images/small/"+product.image + '"></a></div>\n' +
            '                            <div class="info">\n' +
            '                                <a class="title" href="product_details.html?id='+product.id+'">' + product.name + '</a>\n' +
            '                                <div class="price">\n' +
            '                                    <span class="usual">$' + (product.price + 100) + '</span>&nbsp;\n' +
            '                                    <span class="special">$' + product.price + '</span>\n' +
            '                                </div>\n' +
            '                            </div>\n' +
            '                        </li>');
    });

    //Left list contents
    document.getElementById('products_left').innerHTML = products_left_content.join("");

    //Right list contents
    document.getElementById('products_right').innerHTML = products_right_content.join("");
}

function search_products() {
    const products_autocomplete = products.map(product => {
        return ('<option value="' + product.name + '">')
    })
    document.getElementById('products').innerHTML = products_autocomplete.join("");
}



function on_enter_pressed(){
    let answer, product_name;
    if (event.keyCode === 13) {

        product_name = products.map(product => {
            return (product.name);
        });

        answer = document.getElementById('products_autocomplete').value;
        let id = 1;

        product_name.forEach(product => {
            if (product === answer) {
                window.location.assign("product_details.html?id="+id);
            }else{
                id++;
            }
        })
    }else if(event.keyCode === 8){
        document.getElementById("products_autocomplete").value = " ";
    }
}

$(document).ready(function () {
    if(window.location.href.includes("id")){
        id = window.location.href.split("?")[1].split("=")[1];
        isLogged=true;

        history.pushState(null, document.title, location.href);
        window.addEventListener('popstate', function (event)
        {
            history.pushState(null, document.title, location.href);
        });
    }
    login();
    get_products();
})

function login(){
    if(!isLogged){
        document.getElementById('page_contents').innerHTML = '<li class="selected"><a href="home_page.html">Home</a></li>\n' +
            '                <li><a href="register.html">Register</a></li>\n' +
            '                <li><a href="login.html">Login</a></li>';
        return;
    }


    document.getElementById('page_contents').innerHTML = '<li class="selected"><a href="home_page.html">Home</a></li>\n' +
        '                <li><a href="account_settings.html">Account Settings</a></li>\n' +
        '                <li><a href="#">Logout</a></li>'

    document.getElementById('user_welcome').innerHTML = '<b>  <strong> HI USER > '+id+' < </strong> </b>'
}

let isLogged=false, id;
