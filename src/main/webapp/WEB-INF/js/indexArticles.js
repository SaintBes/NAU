/**
 * Created by admssa on 02.12.2015.
 */
$(document).ready( function(){

  $('.plitka').fancybox({
      beforeShow   : function() {

          $('.fancybox-placeholder').html($(this.element).html()).show();
          $(this.element).css('width','100%');



      },
      afterClose: function(){
          $('.plitka').css('width','25%');

      }
  })



});