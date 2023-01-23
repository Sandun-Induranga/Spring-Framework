/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

const baseUrl = "http://localhost:8080/backend/";

loadAllItems();

$("#btnSave").on("click", function () {
    let formData = $("#itemForm").serialize();

    let json = {
        code: $("#code").val(),
        itemName: $("#itemName").val(),
        qtyOnHand: parseInt($("#qtyOnHand").val()),
        price: $("#price").val()
    };

    if ($(this).text() == "Save") {
        $.ajax({
            url: baseUrl + "item",
            type: "post",
            data: formData,
            dataType: "json",
            success: function (res) {
                loadAllItems();
                alert(res.message);
            },
            error: function (error) {  // When status code equals to 500 then, this method has been invoked
                let parse = JSON.parse(error.responseText);
                alert(parse.message);
            }
        });
    } else {
        $.ajax({
            url: baseUrl + "item",
            method: "put",
            contentType: "application/json",
            data: JSON.stringify(json),
            dataType: "json",
            success: function (res) {
                loadAllItems();
                alert(res.message);
            },
            error: function (error) {  // When status code equals to 500 then, this method has been invoked
                let parse = JSON.parse(error.responseText);
                alert(parse.message);
            }
        });
    }

});

$("#btnAddItem").on("click", function () {
    $("#btnSave").text("Save");
});


function bindEditEvent() {

    $(".customer-edits").on("click", function () {
        var code = $(this).parent().parent().children(":eq(0)").text();

        var name = $(this).parent().parent().children(":eq(1)").text();

        var qty = $(this).parent().parent().children(":eq(3)").text();

        var price = $(this).parent().parent().children(":eq(2)").text();

        setItemTextFields(code, name, price, qty);
        $("#btnSave").text("Update");

    });
}

function bindDeleteEvent() {
    $(".customer-deletes").on("click", function () {

        var code = $(this).parent().parent().children(":eq(0)").text();
        console.log(code)

        $.ajax({
            url: baseUrl + "item?code=" + code.trim(),
            method: "delete",
            dataType: "json",
            success: function (res) {
                loadAllItems();
                alert(res.message);
            },
            error: function (error) {  // When status code equals to 500 then, this method has been invoked
                let parse = JSON.parse(error.responseText);
                alert(parse.message);
            }
        });

    });
}

function setItemTextFields(code, name, price, qty) {
    $("#code").val(code.trim());
    $("#itemName").val(name.trim());
    $("#qtyOnHand").val(qty.trim());
    $("#price").val(price.trim());
}

$("#btnGetAll").on("click", function () {
    loadAllCustomers();
});

function loadAllItems() {
    $.ajax({
        url: baseUrl + "item",
        method: "get",
        dataType: "json",
        success: function (res) {
            $("#body").empty();

            for (let item of res.data) {

                $("#body").append(`<tr><td>` + item.code + `</td><td>` + item.name + `</td><td>` + item.price + `</td><td>` + item.qty + `</td><td><button type="button" class="border border-0 customer-edits"><i class="bi bi-pencil-fill text-success" data-bs-toggle="modal" data-bs-target="#staticBackdrop"></i></button><button class="border border-0 customer-deletes"><i class="bi bi-trash text-danger"></i></button></td></tr>`);
            }
            alert(res.message);
            bindEditEvent();
            bindDeleteEvent();
        },
        error: function (error) {  // When status code equals to 500 then, this method has been invoked
            let parse = JSON.parse(error.responseText);
            alert(parse.message);
        }
    });
}
