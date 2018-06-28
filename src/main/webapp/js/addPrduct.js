
var name_flag=0 ;
var desc_flag=0 ;
var price_flag=0 ;
var quntity_flag=0 ;
var category_flag=0 ;
function validate(event)
{
    event.preventDefault();
    var name = document.getElementById("tProductName").value;
    var description = document.getElementById("tProductDescription").value;
    var price = document.getElementById("tPrice").value;
    var quantity = document.getElementById("tQuantity").value;
    var category = document.getElementById("tCategory").value;

    if (name === "")
    {
        document.getElementById("productNameAlert").innerHTML = "*Required Field";
        name_flag = 1;
    } else {
        document.getElementById("productNameAlert").innerHTML = "";
        name_flag = 0;
    }
    
    if (description === "")
    {
        document.getElementById("productDescriptionAlert").innerHTML = "*Required Field";
        desc_flag = 1;
    } else {
        document.getElementById("productDescriptionAlert").innerHTML = "";
        desc_flag = 0;
    }
    
    if (price === "")
    {
        document.getElementById("priceAlert").innerHTML = "*Required Field";
        price_flag = 1;
    } else {
        document.getElementById("priceAlert").innerHTML = "";
        price_flag = 0;
    }
    
    if (quantity === "")
    {
        document.getElementById("quantityAlert").innerHTML = "*Required Field";
        quntity_flag = 1;
    } else {
        document.getElementById("quantityAlert").innerHTML = "";
        quntity_flag = 0;
    }
    
    
    if (category ==="")
    {
        document.getElementById("categoryAlert").innerHTML = "*Required Field";
        category_flag = 1;
    } else {
        document.getElementById("categoryAlert").innerHTML = "";
        category_flag = 0;
    }
    
    if (name_flag  ===1 || price_flag === 1 || desc_flag ===1 || quntity_flag ===1 || category_flag ===1)
    {
        return false; 
    } else
    {
        document.addProductForm.submit();
    }

}

