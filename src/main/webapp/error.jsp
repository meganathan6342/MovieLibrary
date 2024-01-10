<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
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
}
#img{
    width: 75vh;
    
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
<img alt="image is loading" src="images/error1.jpeg" id="img">
</div>

<!-- Bootstrap JS and dependencies (optional, but used in some Bootstrap features) -->
    <!-- <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.9/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> -->
    
</div>


</body>
</html>