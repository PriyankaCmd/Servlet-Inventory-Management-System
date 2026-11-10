<%@ page import="java.util.List,com.inventory.model.Sale"%>

<html>
<head>
<link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">

<style>
body {
    font-family: 'Poppins', sans-serif;
    background-color: #f4f6f9;
}

table {
    width: 90%;
    margin: auto;
    border-collapse: collapse;
    background: white;
}

th {
    background-color: #2c3e50;
    color: white;
    padding: 10px;
}

td {
    padding: 10px;
    text-align: center;
}

tr:nth-child(even) {
    background-color: #f2f2f2;
}

h2 {
    text-align: center;
}
</style>
</head>

<body>

<h2>Sales History</h2>

<table border="1">

<tr>
    <th>Sale ID</th>
    <th>Product ID</th>
    <th>Quantity Sold</th>
    <th>Sale Date</th>
    <th>Total Amount</th>
    <th>Delete</th>
</tr>

<%
List<Sale> list =
(List<Sale>)request.getAttribute("sales");

if(list != null){

    for(Sale s : list){
%>

<tr>
    <td><%= s.getSaleId() %></td>
    <td><%= s.getProductId() %></td>
    <td><%= s.getQuantitySold() %></td>
    <td><%= s.getSaleDate() %></td>
    <td><%= s.getTotalAmount() %></td>

    <td>
        <form action="DeleteSaleServlet" method="post"
      onsubmit="return confirm('Cancel this sale?');">

    <input type="hidden"
           name="saleId"
           value="<%=s.getSaleId()%>">

    <input type="submit"
           value="Delete">

</form>
</td>
</tr>

<%
    }
}
%>

</table>

<br><br>

<center>
<a href="dashboard.jsp">Back To Dashboard</a>
</center>

</body>
</html>