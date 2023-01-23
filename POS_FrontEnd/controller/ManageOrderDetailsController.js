/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

const baseUrl = "http://localhost:8080/backend/";

function loadAllOrderDetails() {
    $("#tblOrders > tbody").empty();

    $.ajax({
        url: baseUrl + "order_detail",
        type: "get",
        dataType: "json",
        success: function (res) {

            $("#body").empty();

            for (let detail of res.data) {
                $("#body").append(`<tr><td>` + detail.orderId + `</td><td>` + detail.code + `</td><td>` + detail.price + `</td><td>` + detail.qty + `</tr>`);
            }

            alert(res.message);

        },
        error: function (error) {
            let parse = JSON.parse(error.responseText);
            alert(parse.message);
        }
    });
}

loadAllOrderDetails();
