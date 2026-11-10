<%@ page import= "com.inventory.model.Product"%>
<% 
Product p = (Product) 
request.getAttribute("product");
%>
<h2> Update Product </h2>
<form action="UpdateProductServlet" method="post">
<input type= "hidden" name="id" value="<%=p.getProductId()%>"><br><br>
Name:
<input type="text" name="name" value="<%=p.getName()%>" required><br><br>
Category:
<input type="text" name="category" value="<%=p.getCategory()%>"><br><br>
Price:
 <input type="number" name="price"  value="<%= p.getPrice()%>" required><br><br>
Quantity:
<input type="number" name="quantity" value= "<%= p.getQuantity()%>"required><br><br>
<input type= "submit" value="Update Product">
</form>

   