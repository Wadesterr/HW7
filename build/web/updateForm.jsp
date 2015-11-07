
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Cars"%>

<% Cars car = (Cars) request.getAttribute("car");%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css" >
        <title>Update A Car</title>
    </head>
    <body>
        <div class="wrap">

            <%@ include file="includes/header.jsp" %>

            <%@ include file="includes/menu.jsp" %>


            <div class="main">
                <h1>Update A Car</h1>

                <form name="updateForm" action="updateCar" method="get">

                    <table>
                        <tr> 
                            <td class="right"> VinID:</td>
                            <td> <input type ="text" name="vinID" value="<%= car.getVinID()%>" readonly /></td>
                        </tr>

                        <tr> 
                            <td class="right"> Make:</td>
                            <td> <input type ="text" name="make" value="<%= car.getMake()%>" /></td>
                        </tr>

                        <tr> 
                            <td class="right"> Model:</td>
                            <td> <input type ="text" name="model" value="<%= car.getModel()%>" /></td>
                        </tr>

                        <tr> 
                            <td class="right"> Year:</td>
                            <td> <input type ="text" name="year" value="<%= car.getYear()%>" /></td>
                        </tr>

                        <tr> 
                            <td class="right"> Color:</td>
                            <td> <input type ="text" name="color" value="<%= car.getColor()%>" /></td>
                        </tr>
                    </table>


                    <br>
                    <input type="reset" name="reset" value="Clear"/>
                    <input type="Submit" name="submit" value="Update"/>

                </form>
            </div>

            <%@ include file="includes/footer.jsp" %>

        </div>
    </body>
</html>
