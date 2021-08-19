<%--
  Created by IntelliJ IDEA.
  User: 17785
  Date: 2021-08-19
  Time: 2:05 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Loan</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <style>
        h1 {
            text-align:center;

        }

        .btn {

            width: 20%;
        }
    </style>
</head>
<body>
<h1>Loan Records</h1>




<div class="container">
    <h6>The following are the loan records</h6>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Client number</th>
            <th>Client Name</th>
            <th>Loan Amount</th>
            <th>Number of Years</th>
            <th>Loan Type</th>

        </tr>
        </thead>
        <tbody>

        <c:forEach items="${todos}" var="todo">


            <tr>
                <td>${todo.clientno }</td>
                <td>${todo.clientname}</td>
                <td>${todo.loanamount}</td>
                <td>${todo.years}</td>
                <td>${todo.loantype}</td>


                <td>    <a type="button" class="btn btn-primary"
                           href="update-todo?id=${todo.clientno}" >Edit</a> </td>



                <td>    <a type="button" class="btn btn-primary"
                           href="delete-todo?id=${todo.clientno}" >Delete</a> </td>


                <td>    <a type="button" class="btn btn-primary"
                           href="amort-todo?id=${todo.clientno}" >Amortization</a> </td>

            </tr>


        </c:forEach>


        </tbody>
    </table>
    <a class="btn btn-success" href="add-todo">Add</a>
</div>



</body>
</html>

