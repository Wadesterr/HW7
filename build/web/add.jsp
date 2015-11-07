<%-- 
    Document   : add
    Created on : Oct 27, 2015, 11:08:35 AM
    Author     : Wade
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add New Car</title>
        <link href="style.css" rel="stylesheet" type="text/css" >
    </head>
    <body>
        <div class="wrap">

            <%@ include file="includes/header.jsp" %>

            <%@ include file="includes/menu.jsp" %>


            <div class="main">

                <h1>Add New Car</h1>

                <form name="addForm" action="addCar" method="get">
                    <fieldset>
                        <label> Car Make:</label>
                        <input type ="text" name="make" value="" />
                        <br>
                        <label> Car Model:</label>
                        <input type ="text" name="model" value="" />
                        <br>
                        <label> Car Year:</label>
                        <input type ="text" name="year" value="" />
                        <br>
                        <label> Car Color:</label>
                        <input type ="text" name="color" value="" />
                        <br>
                        <input type="submit" name="submit" value="submit"/>

                </form>
            </div>

            <%@ include file="includes/footer.jsp" %>

        </div>
    </body>



</html>
