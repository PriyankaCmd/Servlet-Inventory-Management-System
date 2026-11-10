<%@ page import="java.util.List,com.inventory.model.Product" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<title>Sell Product</title>

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">

<style>

body{
    font-family:'Poppins',sans-serif;
    background:#f4f6f9;
    display:flex;
    justify-content:center;
    align-items:center;
    height:100vh;
}

.card{
    width:400px;
    background:white;
    padding:30px;
    border-radius:15px;
    box-shadow:0 4px 15px rgba(0,0,0,0.15);
}

h2{
    text-align:center;
    color:#2c3e50;
    margin-bottom:25px;
}

label{
    font-weight:600;
}

input,
select{
    width:100%;
    padding:10px;
    margin-top:5px;
    margin-bottom:15px;
    border:1px solid #ccc;
    border-radius:8px;
    box-sizing:border-box;
    font-family:'Poppins',sans-serif;
}
button{
    width:100%;
    padding:12px;
    background:#2c3e50;
    color:white;
    border:none;
    border-radius:8px;
    cursor:pointer;
    font-size:16px;
}

button:hover{
    background:#34495e;
}

.back-link{
    display:block;
    text-align:center;
    margin-top:15px;
    text-decoration:none;
    color:#2c3e50;
    font-weight:600;
}

</style>
</head>

<body>

<div class="card">

<h2>Sell Product</h2>

<form action="SalesServlet" method="post">

<label>Product</label>
<select name="productId" required>
<%
List<Product> products =
(List<Product>)request.getAttribute("products");

if(products != null){

    for(Product p : products){
%>

<option value="<%=p.getProductId()%>">
    <%=p.getName()%>
</option>

<%
    }
}
%>



</select>
<label>Quantity</label>
<input type="number"
       name="quantity"
       id="quantity"
       required
       onkeydown="if(event.key==='Enter'){
       this.form.submit();
       }">

<button type="submit">
    Record Sale
</button>

</form>

<a class="back-link" href="dashboard.jsp">
    Back to Dashboard
</a>

</div>

</body>
</html>