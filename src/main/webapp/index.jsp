<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOLDFILX</title>
<link rel="stylesheet" type="text/css" href="CSS_Files/index.css">
<link rel="icon" href="images/logo.png">
<style>
#bg-image{
	background-image: url("images/bg_img.jpg");
}
</style>
</head>
<body>
<div id="ott">
    <div id="content">
        <div id="left">
            <div id="bg-image"></div>
            <div id="navigation">
                <section id="heading">
                    <h1><i class="fa-solid fa-film"></i> BOLDFILX</h1>
                </section>
                <section id="nav">
                    <section class="nav-items"><a href="contact.html">Contact</a></section>
                    <section class="nav-items"><a href="help.html">Help</a></section>
                    <section class="nav-items"><a href="about.html">About</a></section>
                    <section class="nav-items"> <button><a href="adminLogIn.jsp" id="admin">Admin</a></button></section>
                </section>
                </div>
                <div id="left-content">
                    <h1>Welcome Guys</h1>
                    <p>This is my project, it's been done by me. <br>It has two parts one is admin part another one is user part <br> In admin part they can add, remove or edit a movie, in user part they can only watch the movie</p>
                    <p>I've used tools like core java, j2ee, jdbc, servlet, jsp, mysql, html, css & javascript in Eclipse and Visual Studio Code</p>
                </div>
        </div>

        <div id="right">
            <section>
                <i class="fa-solid fa-film fa-2x"></i>
            </section>
            <section>
                <h1>Get started</h1><br>
            <button><a href="userLogin.jsp">Log in</a></button>
            <button><a href="userSignUp.jsp">Sign up</a></button>
            </section>
            <section>
                <i class="fa-solid fa-film"></i><br>
                <p style="font-size: 13px;">2024 BOLDFILX <i class="fa-regular fa-copyright"></i></p>
            <a href="terms.html">Terms</a> |
            <a href="privacy.html">Privacy</a> |
            <a href="cookies.html">Cookies</a>
            </section>
            
        </div>
    </div>
</div>
<script src="https://kit.fontawesome.com/52bd1c8b9d.js" crossorigin="anonymous"></script>
</body>
</html>