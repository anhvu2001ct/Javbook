<%-- 
    Document   : test
    Created on : Sep 16, 2021, 9:51:30 PM
    Author     : Anh Vu Nguyen {@literal <nganhvu>}
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <img id="userAvatar" src="/Javbook/assets/img/user/default.png" alt="alt" style="display: block"/>
        <input type="text" id="fileName" />
        <input type="file" id="myFile" />
        <button onclick="sendFile()"> Submit </button>
        <div id="mydiv"></div>
    </body>
    <script src="/Javbook/assets/js/common/query.js"></script>
    <script>
        function sendFile() {
            let query = new QueryUpload("upload/image");
            let name = "avatar" + Date.now() + ".png";
            query.addParam("file", document.getElementById("myFile").files[0]);
            query.addParam("savePath", "profile");
            query.addParam("fileName", name);
            
            query.addEvent("progress", function(e) {
                let percent = e.loaded / e.total * 100;
                console.log('upload process: ' + Math.floor(percent) + '%');
            });
            
            query.addEvent("load", function() {
                window.setTimeout(() => {
                    document.querySelector("#userAvatar").src = "/Javbook/assets/img/profile/" + name;
                    //query2
                }, 4000);
            });
            
            query.send();
        }
    </script>
</html>
