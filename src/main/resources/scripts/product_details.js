let product;

function get_product() {
    let id = window.location.href.split("?")[1].split("=")[1];
    console.log(id);

    fetch('http://localhost:8080/products/get/' + id, {mode:"cors"})
        .then((response) => response.json())
        .then((responseJSON) => {
            product = responseJSON;
            display_product();
        });
}


function display_product()
{

    document.getElementById('productImage').innerHTML = '<img src="' +"/images/big/" + product.image + '" class="img" width="500" height="350" alt=""/>';

    document.getElementById('product_name').innerHTML = ' '+ product.name+'\n' +
        '                    <small>     <pre></pre>   </small>\n' +
        '                    <i class="fa fa-star fa-2x text-primary"></i>\n' +
        '                    <i class="fa fa-star fa-2x text-primary"></i>\n' +
        '                    <i class="fa fa-star fa-2x text-primary"></i>\n' +
        '                    <i class="fa fa-star fa-2x text-primary"></i>\n' +
        '                    <i class="fa fa-star fa-2x text-muted"></i>\n' +
        '                    <span class="fa fa-2x">' +
        '                    <h5>(109) Votes</h5></span>\n' +
        '                    <a>800 customer reviews</a>';


    document.getElementById('product_price').innerHTML = '$'+parseInt(product.price)+'\n' +
        '                    <small>*includes tax</small>'

    document.getElementById('myTabContent').innerHTML = '<br/>' +
        '                            <strong>Description</strong>\n' +
        '                            <p>\n' +
        '\n' +product.description+
        '                            </p>';
}

$(document).ready(function () {
    get_product();
})
