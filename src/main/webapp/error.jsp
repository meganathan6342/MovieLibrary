<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page Not Found</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="icon" href="images/error.png">
<style>
body{
	background-color: rgb(233,233,233);
}
h1{
     text-align: center;
     font-style:  italic;
}
p{
    text-align: center;
}
#container{
    height: 100vh;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    box-shadow: 4px 4px 4px rgb(223,223,223);
}
#img{
    height: 500px;
    width: 750px;
}
</style>
</head>
<body>

<div id="container">

<div id="msg">
<h1>Error 404... :(</h1>
<p><b><i>Please check the URL you might have missed some elements in URL...</i></b></p>
</div>
<div id="img-container">
<img alt="image is loading" src="images/error.jpg" id="img">
</div>

<!-- Bootstrap JS and dependencies (optional, but used in some Bootstrap features) -->
    <!-- <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.9/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> -->
    
</div>


</body>
</html>