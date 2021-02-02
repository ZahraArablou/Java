<%-- 
    Document   : test
    Created on : Jan 4, 2021, 9:46:46 AM
    Author     : heshmat
--%>
<script
    src="https://code.jquery.com/jquery-3.5.1.min.js"
    integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
crossorigin="anonymous"></script>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script
            src="https://code.jquery.com/jquery-3.5.1.min.js"
            integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
        crossorigin="anonymous"></script>
        <script>
            $(document).ready(function(){
           // alert('jQuery is ready and integrated.');
           $("#id_get_time").click(function(){
              // alert('Button clicked..');
              $.ajax({
                  url : 'get_time',
                  success :  function(data){
                     $("#id_time").html(data) ;
                  }
              });
           });
            });
        </script>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ajax test page</h1>
        <button id="id_get_time">Get Server Time</button><br/>
        <p id="id_time"></p>
    </body>
</html>
