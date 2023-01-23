/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

const baseUrl = "http://localhost:8080/backend/";

loadAllCustomers();

$("#btnSaveCustomer").on("click", function () {
    let formData = $("#customerForm ").serialize();

    let customer = new Customer($("#cusId").val(), $("#cusName").val(), $("#cusAddress").val(), $("#cusSalary").val());

    let json = {
        id: customer.getCusId(),
        name: customer.getCusName(),
        address: customer.getCusAddress(),
        cusSalary: customer.getCusSalary()
    };

    if ($(this).text() == "Save") {
        $.ajax({
            url: baseUrl + "customer",
            type: "post",
            data: formData,
            dataType: "json",
            success: function (res) {
                loadAllCustomers();
                alert(res.message);
            },
            error: function (error) {
                let parse = JSON.parse(error.responseText);
                alert(parse.message);
            }
        });
    } else {
        $.ajax({
            url: baseUrl + "customer",
            method: "put",
            contentType: "application/json",
            data: JSON.stringify(json),
            dataType: "json",
            success: function (res) {
                loadAllCustomers();
                alert(res.message);
            },
            error: function (error) {
                let parse = JSON.parse(error.responseText);
                alert(parse.message);
            }
        });
    }

});

$("#btnAddCustomer").on("click", function () {
    $("#btnSaveCustomer").text("Save");
})


function bindEditEvent() {

    $(".customer-edits").on("click", function () {
        var id = $(this).parent().parent().children(":eq(0)").text();

        var name = $(this).parent().parent().children(":eq(1)").text();

        var address = $(this).parent().parent().children(":eq(2)").text();

        var salary = $(this).parent().parent().children(":eq(3)").text();

        let customer = new Customer(id, name, address, salary);

        setCustomerTextFields(customer);
        $("#btnSaveCustomer").text("Update");

    });
}

function bindDeleteEvent() {
    $(".customer-deletes").on("click", function () {

        var id = $(this).parent().parent().children(":eq(0)").text();
        console.log(id)

        $.ajax({
            url: baseUrl + "customer?cusId=" + id.trim(),
            method: "delete",
            dataType: "json",
            success: function (res) {
                loadAllCustomers();
                alert(res.message);
            },
            error: function (error) {
                let parse = JSON.parse(error.responseText);
                alert(parse.message);
            }
        });

    });
}

function setCustomerTextFields(customer) {
    $("#cusId").val(customer.getCusId().trim());
    $("#cusName").val(customer.getCusName().trim());
    $("#cusAddress").val(customer.getCusAddress().trim());
    $("#cusSalary").val(customer.getCusSalary().trim());
}

$("#btnGetAll").on("click", function () {
    loadAllCustomers();
});

function loadAllCustomers() {
    $.ajax({
        url: baseUrl + "customer",
        type: "get",
        dataType: "json",
        success: function (res) {

            $("#body").empty();

            for (let customer of res.data) {
                $("#body").append(`<tr><td>` + customer.id + `</td><td>` + customer.name + `</td><td>` + customer.address + `</td><td>` + customer.salary + `</td><td><button type="button" class="border border-0 customer-edits"><i class="bi bi-pencil-fill text-success" data-bs-toggle="modal" data-bs-target="#staticBackdrop"></i></button><button class="border border-0 customer-deletes"><i class="bi bi-trash text-danger"></i></button></td></tr>`);
            }

            alert(res.message);
            bindEditEvent();
            bindDeleteEvent();

        },
        error: function (error) {
            let parse = JSON.parse(error.responseText);
            alert(parse.message);
        }
    });
}
