<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Car Inventory</title>
        <link href="style.css" rel="stylesheet" type="text/css" >
    </head>
    <body>

        <div class="wrap">

            <%@ include file="includes/header.jsp" %>

            <%@ include file="includes/menu.jsp" %>


            <div class="main">
                <h1>Car Database</h1>

                <a href="read">View All Cars</a>
                <br><br>
                <a href="search.jsp">Search Cars</a>

            </div>

            <%@ include file="includes/footer.jsp" %>

        </div>
    </body>
</html>
