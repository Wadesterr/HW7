
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="style.css" rel="stylesheet" type="text/css" >
    </head>
    
    <% String table = (String) request.getAttribute("table"); %>
    
    <body>
        <h1>Car Inventory</h1>
        
        <%= table %>
        
        <br><br>
        
        <a href ="add"> Add A New Car</a>
        
    </body>
</html>
