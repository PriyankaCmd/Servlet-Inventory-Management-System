<html>
<head>
<title>Inventory Dashboard</title>

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
<style>
body{
    font-family:'Poppins',sans-serif;
    margin:0;
    background:#f4f6f9;
}

.header{
    background:#2c3e50;
    color:white;
    padding:20px;
    text-align:center;
    font-size:28px;
    font-weight:600;
}

.container{
    width:85%;
    margin:auto;
    margin-top:40px;
}

.card-box{
    display:flex;
    gap:25px;
    justify-content:center;
    flex-wrap:wrap;
}

.card{
    width:220px;
    background:white;
    padding:30px;
    border-radius:12px;
    box-shadow:0 4px 15px rgba(0,0,0,0.15);
    text-align:center;
    transition:0.3s;
}

.card:hover{
    transform:translateY(-6px);
}

.card a{
    text-decoration:none;
    color:#2c3e50;
    font-size:20px;
    font-weight:600;
}

.icon{
    font-size:42px;
    color:#2c3e50;
    margin-bottom:15px;
}
</style>
</head>

<body>

<div class="header">
 Inventory Management Dashboard
</div>

<div class="container">

<div class="card-box">

<div class="card">
<div class="icon">
   <i class="fa-solid fa-plus"></i>
</div>
<a href="addProduct.jsp">Add Product</a>
</div>

<div class="card">
<div class="icon">
   <i class="fa-solid fa-box"></i>
</div>
<a href="ViewProductsServlet">View Products</a>
</div>

<div class="card">
<div class="icon">
   <i class="fa-solid fa-chart-line"></i>
</div>
<a href="LoadSalesPage">Sales</a>
</div>

<div class="card">
<div class="icon">
   <i class="fa-solid fa-rotate"></i>
</div>
    <a href="LoadRestockPage">Restock Product</a>
</div>

<div class="card">
<div class="icon">
   <i class="fa-solid fa-history"></i>
</div>
<a href="ViewSalesServlet">View Sales History</a>
</div>
</div>

</div>

</body>
</html>