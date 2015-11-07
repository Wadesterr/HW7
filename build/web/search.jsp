<%-- 
    Document   : search
    Created on : Nov 6, 2015, 3:04:32 PM
    Author     : Wade
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css" >
        <title>Cars</title>
    </head>

    <body>
        <div class="wrap">

            <%@ include file="includes/header.jsp" %>

            <%@ include file="includes/menu.jsp" %>


            <div class="main">
                <h1>Search Cars</h1>

                <form name="searchForm" action="search" method="get">


                    <input type="text" name="searchVal" value=""/>

                    <br>

                    <input type="submit" name="submit" value="Search"/>


                </form>
            </div>

            <%@ include file="includes/footer.jsp" %>

        </div>
    </body>
</html>
