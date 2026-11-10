<h2> inventory Login </h2>
<form action="LoginServlet" method="post">
 Username:
<input type="text" name="username" id="username" autofocus
onkeydown="if(event.key==='Enter'){
event.preventDefault();
document.getElementById('password').focus();
}">
<br><br>
 Password:<input type="password"  name="password" id="password" onkeydown="if(event.key==='Enter'){this.form.submit();}"><br><br>
 <input type="submit" value="Login">
</form>