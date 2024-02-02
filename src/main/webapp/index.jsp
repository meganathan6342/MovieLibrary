<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOLDFILX</title>
<link rel="stylesheet" type="text/css" href="CSS_Files/index.css">
<link rel="icon" href="images/download.png">
</head>
<body>
<div id="navigation">
<main>
<section id="left">
<i class="fa-solid fa-film fa-5x"></i>
</section>
<section id="mid" style="padding-left: 30px">
<h1>BOLDFILX</h1>
</section>
<section id="right">
<nav>
<a href="contact.html">Contact</a>
<a href="help.html">Help</a>
<a href="about.html">About</a>
 <button id="admin"><a href="adminLogIn.jsp" id="admin">Admin</a></button>
</nav>
</section>
</main>
</div>
<div id="page">
 <form action="userLogIn" method="post">
<table>
<tbody>
<h2><i style="font-family: sans-serif; color: navy;" >Hello User</i></h2>
<tr>
<td>
<button class="button"><i class="fa-brands fa-google"></i>  login with Google</button>
</td>
</tr>
<tr>
<td>
<fieldset>
<legend><h5>OR</h5></legend>
</fieldset>
</td>
</tr>
<tr>
<td><input type="email" name="useremail" required="required" placeholder="Email" class="inp"></td>
</tr>
<tr>
<td><input type="password" name="userpassword" required="required" placeholder="Password" class="inp"></td>
</tr>
<tr>
<td><input type="submit" class="button"></td>
</tr>
</tbody>
</table>
</form>
<% String msg = (String) request.getAttribute("message"); %>
<%if(msg!=null){ %>
<%= msg %>
<%} %>
<fieldset>
<legend><h5>OR</h5></legend>
<button class="button"><a href="userSignUp.jsp" id="signup">New ?</a></button>
</fieldset>
 </div>
 <footer id="footer">
<section id="left" style="padding-left: 50px">
<i class="fa-solid fa-film" style="color: black; line-height: 100px"></i>
</section>
<section id="mid">
<p style="display: inline-block;">2024BOLDFILX</p>
<a href="terms.html">Terms</a>
<a href="privacy.html">Privacy</a>
<a href="cookies.html">Cookies</a>
</section>
<section id="right" style="line-height: 120px;">
<a href="###"><i class="fa-brands fa-youtube fa-2x"></i></a>
<a href="https://www.instagram.com/meganathanak6342/"><i class="fa-brands fa-instagram fa-2x"></i></a>
<a href="###"><i class="fa-brands fa-x-twitter fa-2x"></i></a>
<a href="###"><i class="fa-brands fa-facebook fa-2x"></i></a>
<a href="###"><i class="fa-brands fa-threads fa-2x"></i></a>
</section>
</footer>
 
<script src="https://kit.fontawesome.com/52bd1c8b9d.js" crossorigin="anonymous"></script>
</body>
</html>