<%-- 
    Document   : lostchildren
    Created on : Jun 14, 2018, 3:13:17 PM
    Author     : eslam java
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>lost</title>

        <!-- Google Fonts -->
        <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Raleway:400,100' rel='stylesheet' type='text/css'>

        <!-- Bootstrap -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

        <!-- Font Awesome -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

        <!-- Custom CSS -->
        <link rel="stylesheet" href="css/owl.carousel.css">
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="css/responsive.css">

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->


    </head>
    <body>
        <jsp:include page="Header.jsp"></jsp:include> 

            <h1 style="padding-left:50%;padding-top: 30px;padding-bottom: 20px"> Lost Children</h1>



            <div style="padding-top: 20px;padding-left: 40px" algin="center">
                <table style="width:100%">

                    <tr style="background-color: aquamarine">
                        <th>Image</th>
                        <th>First Name</th>
                        <th>Last Name</th> 
                        <th>Mother Name</th>
                        <th>Gender</th>
                        <th>Lost Date</th>
                        <th>Description</th>
                        <th>Returned</th>
                        <th>Address</th>
                        <td>Age</td>
                        <td>Phone</td>


                    </tr>
                <c:forEach items="${lostChildren}" var="lost" >  

                    <tr>
                        <td><img src="<c:out value="${lost.imageUrl}"/>" style="width: 150px;height: 150px;padding-top: 20px"/></td>
                        <td><c:out value="${lost.firstName}"/></td> 
                        <td>${lost.lastName}</td>
                        <td>${lost.motherName}</td>
                        <td>${lost.gender}</td>
                        <td>${lost.lostDate}</td>
                        <td>${lost.description}</td>
                        <td>${lost.returned}</td>
                        <td>${lost.orginalAddress}</td>
                        <td>${lost.age}</td>
                        <td>${lost.phone}</td>
                    </tr>


                </c:forEach> 
            </table>
        </div>

        <jsp:include page="footer.jsp"></jsp:include> 
    </body>
</html>
