<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*,java.util.List,com.inventory.dao.DBConnection,com.inventory.model.Product"%>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
<style>
body {
    font-family: 'Poppins', sans-serif;
    background-color: #f4f6f9;
}

.container {
    width: 80%;
    margin: auto;
    margin-top: 40px;
}

h2 {
    text-align: center;
}

table {
    width: 100%;
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

button {
    padding: 6px 12px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}
button:hover
{
background:#ffffff;
transition:0.3s;
}

table{
    width:100%;
    border-collapse:collapse;
    background:white;
    border-radius:12px;
    overflow:hidden;
    box-shadow:0 4px 15px rgba(0,0,0,0.15);
}
tr:hover{
    background:#eef5ff;
    transition:0.3s;
}
.toolbar{
    display:flex;
    gap:15px;
    align-items:center;
    margin-bottom:20px;
    flex-wrap:wrap;
}

.toolbar input{
    padding:10px;
    border-radius:8px;
    border:1px solid #ccc;
}

.toolbar button{
    background:#2c3e50;
    color:white;
    border:none;
    padding:10px 15px;
    border-radius:8px;
}
.qty-normal{
    background:#edf2f7;
    color:#2c3e50;
    padding:5px 12px;
    border-radius:20px;
    font-weight:600;
}
.qty-danger{
    background:#dc3545;
    color:white;
    padding:5px 10px;
    border-radius:20px;
}
.warning{
    color:#dc3545;
    font-size:12px;
    font-weight:bold;
}
.edit-link{
    color:#0d6efd;
    text-decoration:none;
    font-weight:600;
}

.delete-link{
    color:#dc3545;
    text-decoration:none;
    font-weight:600;
}
.edit-link:hover,
.delete-link:hover{
    opacity:0.8;
}
.product-container{
    display:flex;
    flex-wrap:wrap;
    gap:20px;
    justify-content:center;
    width:100%;
}

.product-card{
    width:280px;
    background:white;
    border-radius:15px;
    padding:20px;
    box-shadow:0 4px 15px rgba(0,0,0,0.15);
    transition:0.3s;
    box-sizing:border-box;
}

.product-card:hover{
    transform:translateY(-5px);
}
.product-card h3{
    text-align:center;
}
.card-buttons{
    display:flex;
    justify-content:space-between;
    margin-top:20px;
}
.in-stock-text{
    color:#2c3e50;
    font-weight:600;
}

.low-stock-text{
    color:#dc3545;
    font-weight:600;
}
.category-badge{
    background:#eef2f7;
    color:#2c3e50;
    padding:5px 12px;
    border-radius:20px;
    font-size:14px;
}

.view-toggle{
    margin-bottom:20px;
}
.back-btn{
    text-decoration:none;
    color:#2c3e50;
    font-size:24px;
    margin-left:20px;
}

.back-btn:hover{
    color:#0d6efd;
}
</style>
</head>
<body>
<a href="dashboard.jsp" class="back-btn">
    <i class="fa-solid fa-arrow-left"></i>
   Dashboard
</a>
<h2> Product List</h2>
<br>
<div class ="toolbar">
<form action="SearchProductServlet" method="get">
    <input type="text"
     name="keyword"
     placeholder="Search by product name/category..." 
value="<%= request.getAttribute("keyword") != null ? request.getAttribute("keyword") : "" %>"    required>
    <input type="submit" value="Search">
</form>
<a href="LowStockServlet">
    <button>Show Low Stock (&lt;2)</button>
</a>

<a href="ViewProductsServlet">
    <button>Show All</button>
</a></div>
<br>
<div class="view-toggle">
<button onclick="showTable()">
    <i class="fa-solid fa-table"></i>
    Table View
</button>

<button onclick="showCards()">
    <i class="fa-solid fa-grip"></i>
    Card View
</button></div>
<div id="tableView">
<table border="1">
<tr>
<th>ID</th>
<th>Name</th>
<th>Category</th>
<th>Price</th>
<th>Quantity</th>
<th><i class="fa-solid fa-pen"></i>Edit</th>
<th><i class="fa-solid fa-trash"></i>Delete</th>
</tr>
<% 
List<Product> list = (List<Product>) 
request.getAttribute("products");
if(list != null){
    for(Product p : list){
%>
<tr>
<td><%= p.getProductId()%></td>
<td><%= p.getName()%></td>
<td><%=p.getCategory()%></td>
<td><%=p.getPrice()%></td>
<td>

<%
if(p.getQuantity() < 2){
%>

<span class="qty-danger">
<%=p.getQuantity()%>
</span>

<br>
<span class="warning">
⚠ Low Stock
</span>

<%
}else{
%>

<span class="qty-normal">
<%=p.getQuantity()%>
</span>

<%
}
%>

</td>
<td> 
<a class='edit-link' href="UpdateProductServlet?id=<%=p.getProductId()%>">Edit</a>
</td>
<td>
<a class="delete-link" href="<%=request.getContextPath()%>/DeleteProductServlet?id=<%=p.getProductId() %>" onclick="return confirm('Are You Sure you want to delete?')">Delete</a></td>
</tr>
<%
}
}
%>
</table>
</div>
<div id="cardView" style="display:none;">
<div class="product-container">
<%

if(list != null){
    for(Product p : list){
%>

<div class="product-card">

    <h3><%=p.getName()%></h3>

    <p>
<span class="category-badge">
    <%=p.getCategory()%>
</span>
</p>

<p><strong>Price:</strong> ₹<%=p.getPrice()%></p>

<p>

<%
if(p.getQuantity() < 2){
%>

<span class="low-stock-text">
⚠ Low Stock (<%=p.getQuantity()%>)
</span>

<%
}else{
%>

<span class="in-stock-text">
In Stock (<%=p.getQuantity()%>)
</span>

<%
}
%>

</p>
    <div class="card-buttons">

<a class="edit-link"
href="UpdateProductServlet?id=<%=p.getProductId()%>">
Edit
</a>

<a class="delete-link"
href="<%=request.getContextPath()%>/DeleteProductServlet?id=<%=p.getProductId()%>"
onclick="return confirm('Delete Product?')">
Delete
</a>

</div>

</div>

<%
    }
}
%>
</div>
</div>
<script>
function showTable(){
    document.getElementById("tableView").style.display="block";
    document.getElementById("cardView").style.display="none";
}

function showCards(){
    document.getElementById("tableView").style.display="none";
    document.getElementById("cardView").style.display="block";
}
</script>
</body>
</html>