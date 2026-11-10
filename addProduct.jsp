<html>
<head>
<title>Add Product</title>

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

.form-card{
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

input{
    width:100%;
    padding:10px;
    margin-top:5px;
    margin-bottom:15px;
    border:1px solid #ccc;
    border-radius:8px;
    box-sizing:border-box;
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

<div class="form-card">

<h2>Add New Product</h2>

<form action="AddProductServlet" method="post">

<label>Product Name</label>
<input type="text"
name="name"
id="name"
required
autofocus
onkeydown="if(event.key==='Enter'){
event.preventDefault();
document.getElementById('category').focus();
}">

<label>Category</label>
<input type="text"
name="category"
id="category"
required
onkeydown="if(event.key==='Enter'){
event.preventDefault();
document.getElementById('price').focus();
}">

<label>Price</label>
<input type="number"
step="0.01"
name="price"
id="price"
required
onkeydown="if(event.key==='Enter'){
event.preventDefault();
document.getElementById('quantity').focus();
}">

<label>Quantity</label>
<input type="number"
name="quantity"
id="quantity"
required
onkeydown="if(event.key==='Enter'){
this.form.submit();
}">

<button type="submit">
Add Product
</button>

</form>
<a class="back-link" href="dashboard.jsp">
    Back to Dashboard
</a>



</div>

</body>
</html>