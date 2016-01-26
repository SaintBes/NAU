/**
 * Created by admssa on 27.04.2015.
 */

$(document).ready(init);

function init(){
    addAllAddress();
    $('#addressTo').bind('click', showAllCars);

}

function showAllCars(){
    var address = $('#addressFrom').value;
    $.ajax({
        dataType:'text',
        type: 'POST',
        url: '/addresTuda',
        data:{accessCode:address},
        success: function(data) {
            var cars = data;
            cars.forEach(function(elem){
                $('#cars').append("<option>" + elem.model + "<option>");
            });
        },
        error: function (a, b, c) {
            alert(a + " " + b + " " + c);
        }
    });

}

function addAllAddress(){
        $.ajax({
            dataType: 'json',
            type: 'GET',
            url: '/showAllAddress',
            success: function(data) {
                var address = data;
                address.forEach(function(elem){
                    $('#addressFrom').append("<option>" + elem.street + "<option>");
                });
            },
            error: function (a, b, c) {
                console.log(a + " " + b + " " + c);
            }
        });
}

$('[data-toggle="tabajax"]').click(function(e) {
    var $this = $(this),
        loadurl = $this.attr('href'),
        targ = $this.attr('data-target');

    $.get(loadurl, function(data) {
        $(targ).html(data);
    });

    $this.tab('show');
    return false;
});