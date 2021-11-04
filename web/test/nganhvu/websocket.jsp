<%-- 
    Document   : newjsp
    Created on : Sep 23, 2021, 7:21:10 PM
    Author     : Anh Vu Nguyen {@literal <nganhvu>}
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WS test</title>
    </head>
    <body>
        <div id="tmp-id" m-id="${uid}"></div>
        <form action="#" name="publish">
          <input type="text" name="to"><br>
          <input type="text" name="message"><br>
          <input type="submit" value="Send">
        </form>

        <!-- div with messages -->
        <div id="messages"></div>
        
        <script src="/Javbook/assets/js/common/ws.js"></script>
        
        <script>
            function getBrowser() { 
                if((navigator.userAgent.indexOf("Opera") || navigator.userAgent.indexOf('OPR')) != -1 )
                    return ('Opera');
                else if(navigator.userAgent.indexOf("Chrome") != -1 )
                    return ('Chrome');
                else if(navigator.userAgent.indexOf("Safari") != -1)
                    return ('Safari');
                else if(navigator.userAgent.indexOf("Firefox") != -1 )
                    return ('Firefox');
                else if((navigator.userAgent.indexOf("MSIE") != -1 ) || (!!document.documentMode == true )) //IF IE > 10
                    return ('IE');
                else
                    return ('unknown');
            }

            let socket = new SocketConnector("test");

            document.forms.publish.onsubmit = function() {
                let msg = this.message.value;

                socket.sendTo(this.to.value, msg);
                return false;
            };

            socket.addEvent("message", message => {
              console.log(message)
              let messageElem = document.createElement('div');
              messageElem.textContent = message.data;
              document.getElementById('messages').prepend(messageElem);
            });
        </script>
    </body>
</html>
