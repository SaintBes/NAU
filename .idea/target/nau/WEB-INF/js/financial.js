/**
 * Created by admssa on 03.06.2015.
 */
function linear() {
    var a = 4594044.23;  //данные, полученные космическим методом функции exel
    var b = 135134.9;
// For IE
  //  var arr = [];
//var returned = '<table class="table table-striped"><tr><td>ID</td><td>Sales</td></tr>';
//    for (var i = 0; i < 25; i++) {
//       arr[arr.length] = "<tr><td>"+(i+1)+"</td><td>"+Math.round(b * (i + 1) + a)+"</td></tr>";
//        returned=returned+arr[i];
//    }
//returned = returned+"</table>";

    var tSpace = document.getElementById("arr");
    var tbl = document.createElement("TABLE");
    tbl.setAttribute("class","table table-striped");
    var tBody = document.createElement("TBODY");

    for (var i = 0; i < 25; i++) {
        var tRow = document.createElement("TR");
            var numCell = document.createElement("TD");
            var dataCell = document.createElement("TD");
        var numText = document.createTextNode(i+1);
           var dataText = document.createTextNode(Math.round(b * (i + 1) + a));

        numCell.appendChild(numText);
        dataCell.appendChild(dataText);

        tRow.appendChild(numCell);
        tRow.appendChild(dataCell);
        tBody.appendChild(tRow);
    }
    tbl.appendChild(tBody);
    //document.body.appendChild(tbl);
   tSpace.appendChild(tbl);



}

function trailMessage() {
    var mess = document.getElementById("mess");
    var block = document.createElement("DIV");
    block.setAttribute("class", "alert alert-info");
var textNode = document.createTextNode("Внимание! Данная версия приложения не предусматривает работу с выбранной функцией.");
   block.appendChild(textNode);
    mess.appendChild(block);

}