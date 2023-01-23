/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

const baseUrl = "http://localhost:8080/backend/";
let cartDB = [];

loadAllCustomerIdsInPurchaseOrder();
loadAllItemCodesInPurchaseOrder();

function loadAllCustomerIdsInPurchaseOrder() {
    $.ajax({
        url: baseUrl + "customer",
        type: "get",
        dataType: "json",
        success: function (res) {
            $("#cmbCustomerId").empty();
            $("#cmbCustomerId").append(`<option disabled selected hidden>Customer ID</option>`);

            for (let customer of res.data) {
                $("#cmbCustomerId").append(`<option>${customer.id}</option>`);
            }

            alert(res.message);
        },
        error: function (error) {
            let parse = JSON.parse(error.responseText);
        }
    });
}

function loadAllItemCodesInPurchaseOrder() {
    $.ajax({
        url: baseUrl + "item",
        type: "get",
        dataType: "json",
        success: function (res) {
            $("#cmbItemCode").empty();
            $("#cmbItemCode").append(`<option disabled selected hidden>Item Code</option>`);

            for (let item of res.data) {
                $("#cmbItemCode").append(`<option>${item.code}</option>`);
            }

            alert(res.message);

        },
        error: function (error) {
            let parse = JSON.parse(error.responseText);
        }
    });
}

$("#cmbCustomerId").change(function () {
    $.ajax({
        url: baseUrl + "order?option=customer&cusId=" + $("#cmbCustomerId").val(),
        method: "get",
        dataType: "json",
        contentType: "application/json",
        success: function (res) {

            $("#cusName").val(res.data.cusName);
            $("#cusAddress").val(res.data.cusAddress);
            $("#cusSalary").val(res.data.cusSalary);

        },
        error: function (error) {
            // let parse = JSON.parse(error.responseText);
            // alert(parse.message);
            console.log(error)
        }
    });
    console.log(baseUrl)
});

$("#cmbItemCode").change(function () {
    $.ajax({
        url: baseUrl + "order?option=item&code=" + $("#cmbItemCode").val(),
        type: "get",
        dataType: "json",
        success: function (res) {

            // var item = searchItem($(this).val());
            var cartItem = searchCartItem($("#cmbItemCode").val());
            $("#item_name").val(res.data.name);
            $("#unitPrice").val(res.data.price);
            if (cartItem != null) {
                $("#qty_OnHand").val(parseInt(res.data.qty) - parseInt(cartItem.qty));
            } else {
                $("#qty_OnHand").val(res.data.qty);
            }
        },
        error: function (error) {
            let parse = JSON.parse(error.responseText);
        }
    });
});

$("#btnAddToCart").on("click", function () {
    addToCart();
});

function addToCart() {
    let code = $("#cmbItemCode").val();
    let name = $("#item_name").val();
    let qtyOnHand = $("#qty_OnHand").val();
    let unitPrice = $("#unitPrice").val();
    let qty = $("#txtQty").val();
    let cartItem = searchCartItem(code);

    if (parseInt(qtyOnHand) < qty) {
        alert("No Stock");
        return false;
    } else if (cartItem == null) {
        var cart = {
            code: code,
            name: name,
            qtyOnHand: qtyOnHand,
            unitPrice: unitPrice,
            qty: qty,
            total: parseFloat(unitPrice) * parseInt(qty)
        }
        cartDB.push(cart);
        // updateItem(cart.code, cart.name, cart.unitPrice, cart.qtyOnHand-cart.qty);
    } else {
        cartItem.qtyOnHand = cartItem.qtyOnHand - parseInt($("#txtQty").val());
        cartItem.qty = parseInt(cartItem.qty) + parseInt($("#txtQty").val());
    }

    loadCart();
    $("#txtQty").val("");
}

function searchCartItem(code) {
    for (let cartItem of cartDB) {
        if (cartItem.code == code) {
            return cartItem;
        }
    }
    return null;
}

// Load Cart
function loadCart() {

    $("#tblCart > tbody").empty();

    for (let cart of cartDB) {
        $("#tblCart > tbody").append(
            `<tr><td>${cart.code}</td><td>${cart.name}</td><td>${cart.unitPrice}</td><td>${cart.qty}</td><td>${cart.total}</td><td><i class="bi bi-pencil-fill text-success me-4 purchase-order-edits"></i><i class="bi bi-trash text-danger purchase-order-deletes"></i></td></tr>`
        );
    }
    setTotal();
}

function setTotal() {
    let total = 0;
    for (let cartItem of cartDB) {
        total += parseFloat(cartItem.total);
    }
    $("#total").val(total);
}

function bindPurchaseEditEvent() {
    $(".purchase-order-edits").on("click", function () {
        var code = $(this).parent().parent().children(":eq(0)").text();
        var cartItem = searchCartItem(code);

        var item = searchItem(code);
        $("#cmbItemCode").val(item.itemCode);
        $("#item_name").val(item.itemName);
        $("#qty_OnHand").val(parseInt(item.qty) - parseInt(cartItem.qty));
        $("#unitPrice").val(item.unitPrice);
        $("#txtQty").val("");
    });
}

function bindPurchaseDeleteEvent() {
    $(".purchase-order-deletes").on("click", function () {
        var code = $(this).parent().parent().children(":eq(0)").text();
        deleteCartObject(code);
        loadCart();
    });
}

function deleteCartObject(code) {
    let cartItem = searchCartItem(code);
    if (cartItem != null) {
        let indexNumber = cartDB.indexOf(cartItem);
        cartDB.splice(indexNumber, 1);
        return true;
    } else {
        return false;
    }
}

$("#dis").on("keyup", function () {
    if ($(this).val() !== "") {
        $("#amount").val(parseFloat($("#totalAmount").val()) - parseFloat($(this).val()));
    } else {
        $("#amount").val($("#totalAmount").val());
    }
});

$("#btnPlaceOrder").on("click", function () {

    let cusId = $("#cmbCustomerId").val();

    let json = {
        cusId: cusId,
        items: cartDB,
        total: $("#total").val()
    };

    $.ajax({
        url: baseUrl + "order",
        method: "post",
        data: JSON.stringify(json),
        dataType: "json",
        success: function (res) {
            alert(res.message);
            console.log(json)
        },
        error: function (error) {
            let parse = JSON.parse(error.responseText);
            alert(parse.message);
        }
    });
});
