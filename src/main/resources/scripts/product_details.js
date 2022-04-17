
//let product;
function get_product(){
    console.log(window.location.href)
    alert(window.location.href);
}

    //get productid from webpage link
    //append prodId in below url

    //fetch('http://localhost:8080/products')
    //         .then((response) => response.json())
    //         .then((responseJSON) => {
    //             product = responseJSON;
    //             display_product();
    //
    //
    //         });



//display_product(){
//
//  set product details to html
//  document.getElementByClass('productImage').innerHTML = '<img src="'+product.image+'" class="img-responsive" alt=""/>';
//  price
// }

$(document).ready(function () {
    get_product();
})
