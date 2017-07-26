$(document).ready(function(){
    $("#comment").click(function(){
        $("#commentsection").show();
         $('.panel-google-plus-comment > .panel-google-plus-textarea > textarea').on('keyup', function(event) {
        var $comment = $(this).closest('.panel-google-plus-comment');
        
        $comment.find('button[type="submit"]').addClass('disabled');
        if ($(this).val().length >= 1) {
            $comment.find('button[type="submit"]').removeClass('disabled');
        }
   });
   });
   
   $("#cancel").click(function(){
   	$("#commentsection").hide();
   });
});



$(document).ready(function(){
    $("#comment1").click(function(){
        $("#commentsection1").show();
         $('.panel-google-plus-comment > .panel-google-plus-textarea > textarea').on('keyup', function(event) {
        var $comment = $(this).closest('.panel-google-plus-comment');
        
        $comment.find('button[type="submit"]').addClass('disabled');
        if ($(this).val().length >= 1) {
            $comment.find('button[type="submit"]').removeClass('disabled');
        }
   });
   });
   
   $("#cancel1").click(function(){
   	$("#commentsection1").hide();
   });
});



$(document).ready(function(){
    $("#comment2").click(function(){
        $("#commentsection2").show();
         $('.panel-google-plus-comment > .panel-google-plus-textarea > textarea').on('keyup', function(event) {
        var $comment = $(this).closest('.panel-google-plus-comment');
        
        $comment.find('button[type="submit"]').addClass('disabled');
        if ($(this).val().length >= 1) {
            $comment.find('button[type="submit"]').removeClass('disabled');
        }
   });
   });
   
   $("#cancel2").click(function(){
   	$("#commentsection2").hide();
   });
});