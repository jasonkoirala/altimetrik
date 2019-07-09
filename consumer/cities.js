$(document).ready(function() {
  $("#find").click(function() {
      console.log("hello");
    let origin = $("#origin").val();
    let destination = $("#destination").val();
    
    let url = "http://localhost:8080/api/connected";

    if (!origin || !destination) alert("origin and destination can not be empty");
    else {
      let requestParam = "?origin=" + origin;
      if (destination) {
        requestParam += "&destination=" + destination;
      }
      
      $.get(url + requestParam, function(data, status) {
        console.log(status);
        $("#pathInfo").text(data.message);
    }).fail(function(){
      console.log("error");
      $("#pathInfo").text("Path between these two doesn't exist...");
    });
    
    }
  });
});
