/**
 * Created by Vlad on 14.04.2015.
 */
$(document).ready(init);

function init() {
    $('#showAll').bind('click', show);
    $('#showAllTaxists').bind('click', showAllTaxist);
}

function showAllTaxist(){

    $.ajax({
        dataType: 'json',
        type: 'GET',
        url: '/showAllTaxists',
        success: function(data) {
            var taxists = data;
            $('#taxistsTable').find("tr:gt(0)").remove();
            taxists.forEach(function(elem){
                $('#taxistsTable').append("<tr><td>" + elem.id + "</td><td>" + elem.firstName + "</td><td>"
                    + elem.secondName + "</td><td>" + elem.phone + "</td><td>");
            });
        },

        error: function (a, b, c) {
            console.log(a + " " + b + " " + c);
        }

    });
}

function show() {
    $.ajax({
        dataType: 'json',
        type: 'GET',
        url: '/showallorders',
        success: function (data) {
            var orders = data;
            $("#orderTable").find("tr:gt(0)").remove();
           //$('#orderTable').find('#data').remove();
           // $('#orderTable').children('tr:not(:first)').remove();
            orders.forEach(function(elem){
                $('#orderTable').append("+<tr id="+'data'+"><td>" + elem.orderId + "</td><td>" + elem.client +
                "</td><td>" + elem.orderSum + "</td><td>"+ elem.orderDate + "</td><td>"
                + elem.addressFrom + "</td><td>"+ elem.addressTo + "</td></tr>");
            });
        },
        error: function (a, b, c) {
            console.log(a + " " + b + " " + c);
        }
    });


}

