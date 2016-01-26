/**
 * Created by al1 on 13.04.15.
 */
$(document).ready(function () {

    //$('#div_o').css({height:'50px', width:'50px',float:'left', border:'1px solid red',margin:'20px'});
    //$('#div_t').css({height:'50px', width:'50px',float:'left', background:'red',margin:'20px'});
    //$('#div_th').css({height:'100px', width:'100px',float:'left',border:'1px solid red',margin:'20px',fontWeight:'bold'});
    $('#btn').bind('click', add);

});


function add() {
    var userName = $('#name').val();
    var userPhone = $('#phone').val();
    if (userName == "") {
        alert("Enter your name");
        return false;
    }
    if (userPhone == "") {
        alert("Enter your phone");
        return false;
    }

    $('table').append("<tr><td>" + userName + "</td><td>" + userPhone + "</td></tr>");


}

